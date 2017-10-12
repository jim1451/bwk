package com.shixue.app.ui.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shixue.app.R;
import com.shixue.app.mediaplayer.MediaController;
import com.shixue.app.mediaplayer.VideoService;
import com.shixue.app.mediaplayer.VideoView;
import com.shixue.app.utils.AppUtils;
import com.shixue.app.utils.L;
import com.shixue.app.utils.NetworkUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.CenterLayout;


/**
 * Created by Jacky Xu on 2015/10/20.
 * 播放视频
 */
public class VideoActivity extends Activity implements VideoView.SurfaceCallback,
        VideoService.PlayerListener {

    @Bind(R.id.videoView)
    VideoView videoView;
    @Bind(R.id.video_root)
    CenterLayout videoRoot;
    @Bind(R.id.loading_message)
    TextView loadingMessage;
    @Bind(R.id.loading)
    LinearLayout loading;
    private boolean created = false;
    private boolean surfaceCreated = false;// surface是否被创建
    private boolean serviceConnected = false;// service绑定状态

    private String video_path;
    private int video_time;
    private String video_name;
    private int video_id;
    private long startpos;
    private boolean Ishwcoder;

    private VideoService videoService;


    private MediaController mediaController;

    private static final int OPEN_FILE = 0;
    private static final int OPEN_START = 1;
    private static final int OPEN_SUCCESS = 2;
    private static final int OPEN_FAILED = 3;
    private static final int HW_FAILED = 4;
    private static final int BUFFER_START = 5;
    private static final int BUFFER_PROGRESS = 6;
    private static final int BUFFER_COMPLETE = 7;
    private static final int SEEK_START = 8;
    private static final int SEEK_COMPLETE = 9;

    public int DEFAULT_BUF_SIZE = 512 * 1024;//缓冲内存大小
    public boolean DEFAULT_DEINTERLACE = false;//是否启用逐行扫描
    public float DEFAULT_STEREO_VOLUME = 1.0f;//音量大小

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            videoService = ((VideoService.LocalBinder) service).getService();
            serviceConnected = true;
            if (surfaceCreated) {
                handler.sendEmptyMessage(OPEN_FILE);
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            serviceConnected = false;
            videoService = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!LibsChecker.checkVitamioLibs(this))
            return;
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);
        parseIntent(getIntent());
        NetworkUtils.getInstance(this);
        getWindow().setBackgroundDrawable(null);
        videoView.initialize(this, this, true);
        created = true;


    }

    private void parseIntent(Intent intent) {
        video_path = intent.getExtras().getString("video_path");
        video_name = intent.getExtras().getString("video_name");
        video_id = intent.getExtras().getInt("video_id");
        video_time = intent.getIntExtra("video_time", 0);
        int progress = intent.getExtras().getInt("video_progress");
        startpos = intent.getLongExtra("startpos", progress);
        Ishwcoder = intent.getBooleanExtra("hwcoder", false);
//        network = intent.getBooleanExtra("network", true);
    }


    // Hander
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case OPEN_FILE:
                    L.e("OPEN_FILE");
                    videoService.setPlayerListener(VideoActivity.this);
                    if (videoView != null)
                        videoService.setDisplay(videoView.getHolder());
                    if (!videoService.isInitialized()) {
                        videoService.initialize(VideoActivity.this, video_path, video_id,
                                startpos, Ishwcoder);
                    }
                    break;
                case OPEN_START:
                    L.e("OPEN_START");
                    setVideoLoadingLayoutMessage(getResources().getString(
                            R.string.player_loading));
                    setVideoLoadingLayoutVisibility(View.VISIBLE);
                    break;
                case OPEN_SUCCESS:
                    L.e("OPEN_SUCCESS");
                    loadPlayerConfig();
                    setVideoLoadingLayoutVisibility(View.GONE);
                    videoService.start();
                    if (mediaController == null) {
                        attachMediaController();
                    }
                    break;
                case OPEN_FAILED:
                    L.e("OPEN_FAILED");
                    Exit(AppUtils.getString(R.string.player_path_error));
                    break;
                case BUFFER_START:
                    L.e("BUFFER_START");
                    setVideoLoadingLayoutVisibility(View.VISIBLE);
                    handler.sendEmptyMessageDelayed(BUFFER_PROGRESS, 1000);
                    if (mediaController != null) {
                        mediaController.updatePausePlay();
                    }
                    break;
                case BUFFER_PROGRESS:
                    L.e("BUFFER_PROGRESS");
                    if (videoService.getBufferProgress() >= 100) {
                        setVideoLoadingLayoutVisibility(View.GONE);
                    } else {
                        loadingMessage.setText("已加载 "
                                + (int) (videoService.getBufferProgress()) + "%");
                        handler.sendEmptyMessageDelayed(BUFFER_PROGRESS, 1000);
                        stopPlayer();
                    }
                    break;
                case BUFFER_COMPLETE:
                    L.e("BUFFER_COMPLETE");
                    setVideoLoadingLayoutVisibility(View.GONE);
                    handler.removeMessages(BUFFER_PROGRESS);
                    if (mediaController != null) {
                        mediaController.updatePausePlay();
                    }
                    break;
                case HW_FAILED:
                    L.e("HW_FAILED");
                    if (videoService != null) {
                        Ishwcoder = false;
                        videoView.initialize(VideoActivity.this,
                                VideoActivity.this, Ishwcoder);
                    }
                    break;
                case SEEK_START:
                    L.e("SEEK_START");
                    if (!NetworkUtils.isConnected()) {
                        setVideoLoadingLayoutMessage(AppUtils.getString(R.string.player_loading));
                        setVideoLoadingLayoutVisibility(View.VISIBLE);
                    } else {

                        startPlayer();
                    }
                    break;
                case SEEK_COMPLETE:
                    L.e("SEEK_COMPLETE");
                    setVideoLoadingLayoutVisibility(View.GONE);
                    startPlayer();
                    break;
            }
        }

        ;
    };


    private void Exit(String message) {
        if (message != null) {
            AppUtils.showToast(message);
        }

        VideoActivity.this.finish();
    }

    private boolean isInitialized() {
        return (created && videoService != null && videoService.isInitialized());
    }

    private void loadPlayerConfig() {
        if (!isInitialized())
            return;
        videoService.setBuffer(DEFAULT_BUF_SIZE);
        videoService.setVideoQuality(MediaPlayer.VIDEOQUALITY_MEDIUM);
        videoService.setDeinterlace(DEFAULT_DEINTERLACE);
        videoService.setVolume(DEFAULT_STEREO_VOLUME,
                DEFAULT_STEREO_VOLUME);
        if (videoView != null && isInitialized())
            setVideoLayout();
    }

    private void setVideoLayout() {
        videoView.setVideoLayout(videoService.getVideoWidth(),
                videoService.getVideoHeight(),
                videoService.getVideoAspectRatio());
    }

    @Override
    public void onStart() {
        super.onStart();
        if (!serviceConnected) {
            Intent serviceIntent = new Intent(this, VideoService.class);
            serviceIntent.putExtra("isHWCoder", Ishwcoder);
            bindService(serviceIntent, serviceConnection,
                    Context.BIND_AUTO_CREATE);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mediaController != null) {
            mediaController.show();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (!created)
            return;

        if (isInitialized()) {
            if (videoService != null && videoService.isPlaying()) {
                stopPlayer();
                startpos = videoService.getCurrentPosition();
            }
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (!created)
            return;

        if (isInitialized()) {
            if (videoService != null && videoService.isPlaying()) {
                stopPlayer();
                startpos = videoService.getCurrentPosition();
            }
        }
    }

    @Override
    public void onDestroy() {
        if (serviceConnected) {
            unbindService(serviceConnection);
        }
        super.onDestroy();
        if (isInitialized() && !videoService.isPlaying())
            release();
        if (mediaController != null)
            mediaController.release();
    }

    private void release() {
        if (videoService != null) {
            videoService.release();
            videoService.releaseContext();
        }
    }

    private void stopPlayer() {
        if (isInitialized()) {
            videoService.stop();
        }
    }

    private void startPlayer() {
        if (isInitialized()) {
            videoService.start();
//            if (NetworkUtils.isConnected()) {
//                mediaControllerListener.getCurrentPosition();
//                mediaControllerListener.seekTo(ConfUtils.currentPos);
//                videoService.seekTo(ConfUtils.currentPos);
//                videoService.start();

//            } else {

//                AppUtils.showToast(AppUtils.getString(R.string.player_network_eror));
//            }
        }
    }

    /**
     * videoservice 监听
     */
    @Override
    public void onHWRenderFailed() {
        handler.sendEmptyMessage(HW_FAILED);

    }

    @Override
    public void onVideoSizeChanged(int width, int height) {
        if (videoService != null) {
            setVideoLayout();
        }
    }

    @Override
    public void onOpenStart() {
        handler.sendEmptyMessage(OPEN_START);
    }

    @Override
    public void onOpenSuccess() {
        handler.sendEmptyMessage(OPEN_SUCCESS);
    }

    @Override
    public void onOpenFailed() {
        handler.sendEmptyMessage(OPEN_FAILED);
    }

    @Override
    public void onBufferStart() {
        handler.sendEmptyMessage(BUFFER_START);
        stopPlayer();
    }

    @Override
    public void onBufferComplete() {
        handler.sendEmptyMessage(BUFFER_COMPLETE);
        if (videoService != null && (!videoService.isPlaying()))
            startPlayer();

    }

    @Override
    public void onDownloadRateChanged(int kbPerSec) {
        // 下载速度监听
//        if (isInitialized() && videoService.isPlaying()
//                && mediaController != null) {
//            mediaController
//                    .setDownLoadSpeed(String.format("%d KB/s", kbPerSec));
//        }
    }

    @Override
    public void onPlaybackComplete() {
        Exit(AppUtils.getString(R.string.player_complete));
    }

    @Override
    public void onNetWorkError() {
//        AppUtils.showToast("player_network_eror");
//        if (!NetworkUtils.isConnected()) {
//            AppUtils.showToast(AppUtils.getString(R.string.player_network_eror));
//            if (isInitialized() && videoService.isPlaying()) {
//                stopPlayer();
//            }
//            if (mediaController != null) {
//                mediaController.show();
//            }
//        }
    }

    @Override
    public void onSeekComplete() {
        handler.sendEmptyMessage(SEEK_COMPLETE);
    }

    /**
     * surface 监听
     */
    @Override
    public void onSurfaceCreated(SurfaceHolder holder) {
        surfaceCreated = true;
        if (serviceConnected)
            handler.sendEmptyMessage(OPEN_FILE);
    }

    @Override
    public void onSurfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        if (videoService != null) {
            setVideoLayout();
        }
    }

    @Override
    public void onSurfaceDestroyed(SurfaceHolder holder) {
        if (videoService != null && videoService.isInitialized()) {
            if (videoService.isPlaying()) {
                videoService.stop();
            }
        }
    }

    // 设置是否显示进度条
    private void setVideoLoadingLayoutVisibility(int visibility) {
        loading.setVisibility(visibility);
    }

    // 设置进度提示
    private void setVideoLoadingLayoutMessage(String message) {
        loadingMessage.setText(message);
    }

    private void attachMediaController() {
        mediaController = new MediaController(this);
        mediaController.setMediaPlayer(mediaControllerListener);
        mediaController.setAnchorView(videoView.getRootView());
        mediaController.setVideoName(video_name);
        mediaController.setVideoTime(video_time);
        mediaController.show();
    }

    private MediaController.MediaControllerListener mediaControllerListener = new MediaController.MediaControllerListener() {

        @Override
        public void stop() {
            if (isInitialized()) {
                stopPlayer();
            }
        }

        @Override
        public void start() {
            if (isInitialized()) {
                startPlayer();
            }
        }

        @Override
        public void seekTo(long pos) {
            if (isInitialized())
                handler.sendEmptyMessage(SEEK_START);
            videoService.seekTo(pos);
        }

        @Override
        public boolean isPlaying() {
            if (isInitialized()) {
                return videoService.isPlaying();
            }
            return false;
        }

        @Override
        public long getDuration() {
            if (isInitialized()) {
                return videoService.getDuration();
            }
            return 0;
        }

        @Override
        public long getCurrentPosition() {
            if (isInitialized()) {
                return videoService.getCurrentPosition();
            }
            return 0;
        }

        @Override
        public void back() {
            Exit(null);
        }
    };
}
