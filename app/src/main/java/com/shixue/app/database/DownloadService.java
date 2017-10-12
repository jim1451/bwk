package com.shixue.app.database;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.shixue.app.utils.FileIoUtils;
import com.shixue.app.utils.L;
import com.shixue.app.utils.MD5Utils;

import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import cn.aigestudio.downloader.bizs.DLManager;
import cn.aigestudio.downloader.interfaces.IDListener;


/**
 * Created by Jacky Xu on 2015/10/30.
 */
public class DownloadService extends Service {

    List<VideoDb> videoDbs;
    public static HashMap<String, Integer> progressList = new LinkedHashMap<String, Integer>();
    public static HashMap<String, Integer> filesizeMap;
    public int pos;

    @Override
    public void onCreate() {
        super.onCreate();
        EventBus.getDefault().register(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

//        sections = (List<DetailModel.DetailData.SectionsEntity>) intent.getExtras().getSerializable("sections");
        if (intent != null && intent.getExtras() != null) {
            videoDbs = (List<VideoDb>) intent.getExtras().getSerializable("downloaddata");
            filesizeMap = new LinkedHashMap<String, Integer>();
//        downloads = new ArrayList<Download>();
            for (int i = 0; i < videoDbs.size(); i++) {
                VideoDb videoDb = videoDbs.get(i);

                progressList.put(String.valueOf(videoDb.getChapterid()) + String.valueOf(videoDb.getSectionid()), 0);
                filesizeMap.put(String.valueOf(videoDb.getChapterid()) + String.valueOf(videoDb.getSectionid()), 0);
                if (videoDbs.get(i).getDownloadstatus() == 1) {
                    startDownLoad(i, videoDb.getSectionname(), videoDb.getVideourl(), videoDb.getChapterid(), videoDb.getSectionid());
                } else if (videoDbs.get(i).getDownloadstatus() == 2) {
                    DLManager.getInstance(this).dlStop(videoDbs.get(i).getVideourl());

                }
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    void startDownLoad(final int pos, String sectionname, final String videourl, final int chapterid, final int sectionid) {
//        String tmp = sectionname.replaceAll(" ", "");
//        int index = tmp.indexOf("节");
//        final String name = tmp.substring(index + 1, tmp.length());
        DLManager.getInstance(this).setMaxTask(3);
        DLManager.getInstance(this).dlStart(videourl, FileIoUtils.getDiskCacheDir(this, "movies").getPath(), MD5Utils.getMd5(sectionname) + ".mp4", new IDListener() {
            @Override
            public void onPrepare() {

            }

            @Override
            public void onStart(String fileName, String realUrl, int fileLength) {
//                if(videoDbs.get(pos).getTotalsize() <= 0){
                VideoDb videoDb = new VideoDb();
                videoDb.setTotalsize(fileLength);
                videoDb.updateAll("videourl = ?", videourl);
//                }
                filesizeMap.put(String.valueOf(chapterid) + String.valueOf(sectionid), fileLength);

//                EventBus.getDefault().post(filesizeMap, "filesize");
            }

            @Override
            public void onProgress(int progress) {
                L.e("视频下载进度---" + progress);
                progressList.put(String.valueOf(chapterid) + String.valueOf(sectionid), progress);
//                progressList.put(pos, progress);
//                EventBus.getDefault().post(videourl, "updatedb");
                EventBus.getDefault().post(progressList, "progress");
            }

            @Override
            public void onStop(int progress) {
                L.e("视频暂停进度---" + progress);
//                progressList.put(pos,progress);
                VideoDb videoDb = new VideoDb();
                videoDb.setDownloadsize(progress);
                videoDb.updateAll("videourl = ?", videourl);
                EventBus.getDefault().post(true, "stopdown");
            }

            @Override
            public void onFinish(File file) {
                VideoDb videoDb = new VideoDb();
                videoDb.setDownloadstatus(3);
                videoDb.updateAll("videourl = ?", videourl);
                EventBus.getDefault().post(file, "finish");
            }

            @Override
            public void onError(int i, String s) {

            }
        });
    }

//    @Subscriber (tag = "encrypt")
//    void encryptVideo(File[] files){
//        LoggerUtils.logE("要加密的文件","!!!!");
//        for(File file:files){
//            FileEnDecryptManager.getInstance().doEncrypt(file.getPath());
//        }
//    }

    @Subscriber(tag = "stop")
    void stopDown(String data) {
//        VideoDb videoDb = new VideoDb();
//        videoDb.setDownloadstatus(2);
//        String[] split = data.split(";");
//        videoDb.setDownprogress(Integer.valueOf(split[1]));
//        videoDb.updateAll("videourl = ?", split[0]);
        /**暂停下载*/
        DLManager.getInstance(this).dlStop(data);
    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }


}
