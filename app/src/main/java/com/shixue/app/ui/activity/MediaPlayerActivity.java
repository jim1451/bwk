package com.shixue.app.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.shixue.app.R;
import com.shixue.app.database.VideoPlayDb;
import com.universalvideoview.UniversalMediaController;
import com.universalvideoview.UniversalVideoView;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * 作者：Jacky
 * 日期：2016-02-19
 */
public class MediaPlayerActivity extends Activity implements UniversalVideoView.VideoViewCallback {

    @Bind(R.id.videoView)
    UniversalVideoView videoView;
    @Bind(R.id.media_controller)
    UniversalMediaController mediaController;
    @Bind(R.id.video_layout)
    FrameLayout videoLayout;

    private String video_path;
    private int video_time;
    private String video_name;
    private int video_id;
    private long startpos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mediaplayer);

        ButterKnife.bind(this);
        parseIntent(getIntent());

        videoView.setMediaController(mediaController);
        videoView.setVideoPath(video_path);
        videoView.requestFocus();
        videoView.setFullscreen(true);
        videoView.setVideoViewCallback(this);
        if (startpos > 0) {
            videoView.seekTo((int) startpos);
        }
        videoView.start();
        mediaController.setTitle(video_name);
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (videoView != null) {
                    VideoPlayDb db = new VideoPlayDb();
                    db.setVideoprogress(0);
                    db.updateAll("sectionid = ?", String.valueOf(video_id));
                    videoView.closePlayer();
                    onBackPressed();
                }
            }
        });

    }


    private void parseIntent(Intent intent) {
        video_path = intent.getExtras().getString("video_path");
        video_name = intent.getExtras().getString("video_name");
        video_id = intent.getExtras().getInt("video_id");
        video_time = intent.getIntExtra("video_time", 0);
//        startpos = intent.getExtras().getLong("video_progress");
        startpos = intent.getExtras().getInt("video_progress");
//        startpos = intent.getLongExtra("startpos", progress);
    }




    @Override
    public void onScaleChange(boolean isFullscreen) {

        if(isFullscreen){

        }else{
            onBackPressed();
        }
    }

    @Override
    public void onPause(MediaPlayer mediaPlayer) {
//        LoggerUtils.logE("暂停播放的进度",""+videoView.getCurrentPosition());
        if (videoView != null) {

            VideoPlayDb db = new VideoPlayDb();
            db.setVideoprogress(videoView.getCurrentPosition());
            db.updateAll("sectionid = ?", String.valueOf(video_id));
            videoView.pause();
        }
    }

    @Override
    public void onStart(MediaPlayer mediaPlayer) {


    }

    @Override
    public void onBufferingStart(MediaPlayer mediaPlayer) {

    }

    @Override
    public void onBufferingEnd(MediaPlayer mediaPlayer) {

    }
}
