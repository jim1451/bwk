package com.shixue.app.mediaplayer;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.shixue.app.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import io.vov.vitamio.utils.StringUtils;

/**
 * Created by Jacky Xu on 2015/10/20.
 * 播放控制器
 */
public class MediaController extends FrameLayout {
    private MediaControllerListener mediaControllerListener;
    private Context context;
    private PopupWindow window;
    private View root;
    private RelativeLayout rootLayout;
    private RelativeLayout topLayout;
    private RelativeLayout bottomLayout;

    private View Anchor;

    private TextView video_name;
    private TextView time_text;
    private ImageButton play_button;
    private TextView mediacontroller_time_current, mediacontroller_time_total;
    private TextView current_time;
    private SeekBar seekBar;

    private boolean download_speed_show = false;
    private boolean isDraging = false;
    private boolean isshow = false;
    private boolean video_time_know = false;
    private long video_total_time = 0;

    private Animation animSlideInTop;
    private Animation animSlideInBottom;
    private Animation animSlideOutTop;
    private Animation animSlideOutBottom;

    public int DEFAULT_SHOW_TIME = 2000;//默认菜单弹出时间
    public int DEFAULT_TIME_REFFRESH = 1000;//默认刷新时间

    public interface MediaControllerListener {
        void start();

        void stop();

        void back();

        void seekTo(long pos);

        boolean isPlaying();

        long getDuration();

        long getCurrentPosition();

    }

    public MediaController(Context context) {
        super(context);
        this.context = context;
        initAnim();
        initView();
    }

    // 初始化动画
    private void initAnim() {
        animSlideOutBottom = AnimationUtils.loadAnimation(context,
                R.anim.slide_out_bottom);
        animSlideOutTop = AnimationUtils.loadAnimation(context,
                R.anim.slide_out_top);
        animSlideInBottom = AnimationUtils.loadAnimation(context,
                R.anim.slide_in_bottom);
        animSlideInTop = AnimationUtils.loadAnimation(context,
                R.anim.slide_in_top);
        animSlideOutBottom.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                rootLayout.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    private void initView() {
        root = LayoutInflater.from(context).inflate(
                R.layout.layout_mediacontroller, this);
        topLayout = (RelativeLayout) root.findViewById(R.id.toplayout);
        bottomLayout = (RelativeLayout) root.findViewById(R.id.bottomlayout);

        window = new PopupWindow(context);
        window.setFocusable(true);
        window.setBackgroundDrawable(null);
        window.setOutsideTouchable(true);
        window.setContentView(root);
        window.setWidth(android.view.ViewGroup.LayoutParams.MATCH_PARENT);
        window.setHeight(android.view.ViewGroup.LayoutParams.MATCH_PARENT);

        rootLayout = (RelativeLayout) root.findViewById(R.id.root);
        rootLayout.setVisibility(View.GONE);

        root.findViewById(R.id.back_button).setOnClickListener(onClickListener);
        video_name = (TextView) root.findViewById(R.id.video_name);
        time_text = (TextView) root.findViewById(R.id.time_text);

        play_button = (ImageButton) root.findViewById(R.id.play_button);
        play_button.setOnClickListener(onClickListener);
        mediacontroller_time_current = (TextView) root
                .findViewById(R.id.time_current);
        mediacontroller_time_total = (TextView) root
                .findViewById(R.id.time_total);
        seekBar = (SeekBar) root.findViewById(R.id.seekbar);
        seekBar.setOnSeekBarChangeListener(onSeekBarChangeListener);
        current_time = (TextView) root.findViewById(R.id.current_time);

        findViewById(R.id.imgbtn_goback).setOnClickListener(onClickListener);
        findViewById(R.id.imgbtn_forward).setOnClickListener(onClickListener);
    }

    public void setVideoName(String name) {
        video_name.setText(name);
    }

    public void setVideoTime(int seconds) {
        if (seconds != 0) {
            video_time_know = true;
            video_total_time = (long) seconds * 1000;
            mediacontroller_time_total.setText(StringUtils
                    .generateTime(video_total_time));
        }
    }

//    public void setDownLoadSpeed(String name) {
//        download_speed.setText(name);
//        if (!download_speed_show) {
//			download_speed.setVisibility(View.VISIBLE);
//            download_speed_show = true;
//        }
//
//    }

    public void setAnchorView(View view) {
        Anchor = view;
        int[] location = new int[2];
        Anchor.getLocationOnScreen(location);
        Rect anchorRect = new Rect(location[0], location[1], location[0]
                + Anchor.getWidth(), location[1] + Anchor.getHeight());
        window.showAtLocation(Anchor, Gravity.NO_GRAVITY, anchorRect.left,
                anchorRect.bottom);
    }

    public void setMediaPlayer(MediaControllerListener mediaControllerListener) {
        this.mediaControllerListener = mediaControllerListener;
        updatePausePlay();
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        int keyCode = event.getKeyCode();
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                release();
                mediaControllerListener.back();
                return true;
        }
        return super.dispatchKeyEvent(event);
    }

    private static final int MSG_SHOW = 1;
    private static final int MSG_HIDE = 2;
    private static final int MSG_UPDATE_PLAY_TIME = 3;
    private static final int MSG_UPDATE_SEEK_BAR = 4;
    private static final int MSG_TIME_TICK = 5;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_SHOW:
                    if (!video_time_know) {
                        video_total_time = mediaControllerListener.getDuration();
                        mediacontroller_time_total.setText(StringUtils
                                .generateTime(video_total_time));
                    }
                    if (!isshow) {
                        bottomLayout.startAnimation(animSlideInTop);
                        topLayout.startAnimation(animSlideInBottom);
                    }
                    isshow = true;
                    updatePausePlay();
                    handler.removeMessages(MSG_HIDE);
                    handler.sendEmptyMessage(MSG_TIME_TICK);
                    handler.sendEmptyMessage(MSG_UPDATE_PLAY_TIME);
                    handler.sendEmptyMessage(MSG_UPDATE_SEEK_BAR);
                    handler.sendEmptyMessageDelayed(MSG_HIDE,
                            DEFAULT_SHOW_TIME);
                    rootLayout.setVisibility(View.VISIBLE);
                    break;
                case MSG_HIDE:
                    isshow = false;
                    isDraging = false;
                    handler.removeMessages(MSG_TIME_TICK);
                    handler.removeMessages(MSG_UPDATE_PLAY_TIME);
                    handler.removeMessages(MSG_UPDATE_SEEK_BAR);
                    bottomLayout.startAnimation(animSlideOutTop);
                    topLayout.startAnimation(animSlideOutBottom);
                    break;
                case MSG_UPDATE_PLAY_TIME:
                    if (!isDraging) {
                        long currentPosition = mediaControllerListener
                                .getCurrentPosition();
                        mediacontroller_time_current.setText(StringUtils
                                .generateTime(currentPosition));
                    }
                    handler.sendEmptyMessageDelayed(MSG_UPDATE_PLAY_TIME,
                           DEFAULT_TIME_REFFRESH);
                    break;
                case MSG_UPDATE_SEEK_BAR:
                    if (!isDraging) {
                        long position = mediaControllerListener
                                .getCurrentPosition();
                        long pos = 1000L * position / video_total_time;
                        seekBar.setProgress((int) pos);
                    }
                    handler.sendEmptyMessageDelayed(MSG_UPDATE_SEEK_BAR,
                           DEFAULT_TIME_REFFRESH);
                    break;
                case MSG_TIME_TICK:

                    time_text.setText(currentTimeString());
                    handler.sendEmptyMessageDelayed(MSG_TIME_TICK,
                            DEFAULT_TIME_REFFRESH);
                    break;
            }
            super.handleMessage(msg);
        }
    };

    public static String currentTimeString() {
        return new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
    }

    public void release() {
        if (window != null) {
            window.dismiss();
            window = null;
        }
        handler.removeMessages(MSG_SHOW);
        handler.removeMessages(MSG_HIDE);
        handler.removeMessages(MSG_UPDATE_PLAY_TIME);
        handler.removeMessages(MSG_UPDATE_SEEK_BAR);
        handler.removeMessages(MSG_TIME_TICK);
    }

    public void show() {
        handler.sendEmptyMessage(MSG_SHOW);
    }

    public void updatePausePlay() {
        if (mediaControllerListener.isPlaying())
            play_button
                    .setImageResource(R.drawable.player_mediacontroller_pause);
        else
            play_button
                    .setImageResource(R.drawable.player_mediacontroller_play);
    }

    private void doPauseResume() {
        if (mediaControllerListener.isPlaying())
            mediaControllerListener.stop();
        else
            mediaControllerListener.start();
        updatePausePlay();
    }

    private OnClickListener onClickListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.play_button:
                    /**播放/暂停*/
                    show();
                    doPauseResume();
                    break;
                case R.id.back_button:
                    /**返回*/
                    if (mediaControllerListener != null) {
                        release();
                        mediaControllerListener.back();
                    }
                    break;
                case R.id.imgbtn_goback:
                    /**回退*/
                    show();
                    long position2 = mediaControllerListener.getCurrentPosition();
                    position2 = position2 - 20000L;
                    mediaControllerListener.seekTo(position2);
                    break;
                case R.id.imgbtn_forward:
                    /**快进*/
                    show();
                    long position = mediaControllerListener.getCurrentPosition();
                    position = position + 20000L;
                    mediaControllerListener.seekTo(position);
                    break;
            }
        }
    };

    private SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        long newposition = 0;

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            mediaControllerListener.seekTo(newposition);
            current_time.setVisibility(View.GONE);
            isDraging = false;
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            isDraging = true;
            mediaControllerListener.stop();
        }

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,
                                      boolean fromUser) {
            if (isDraging) {
                show();
                newposition = (video_total_time * progress) / 1000;
                mediacontroller_time_current.setText(StringUtils
                        .generateTime(newposition));
                current_time.setText(StringUtils.generateTime(newposition));
                current_time.setVisibility(View.VISIBLE);
            }
        }
    };

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (isshow) {
            handler.removeMessages(MSG_HIDE);
            handler.sendEmptyMessageDelayed(MSG_HIDE,
                    DEFAULT_SHOW_TIME);
        } else {
            show();
        }
        return super.onTouchEvent(event);
    }
}
