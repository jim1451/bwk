package com.shixue.app.utils;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;

import java.io.File;

/**
 * Created by Jacky Xu on 2015/9/22.
 * 文件操作类
 */
public class FileIoUtils {

    private static final String APP_ROOTPATH = "banwokao";
    private static final String CACHE_PATH = "/cache/";
    private static final String DOWNLOAD_PATH = "/download/chengkao/";

    /**
     * 判断SDK是否已挂
     **/
    public static boolean isSDCardAvaliable() {
        File sdcFile = null;
        boolean sdCardExist = Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);
        if (sdCardExist) {
            sdcFile = Environment.getExternalStorageDirectory();
            if (sdcFile == null)
                return false;
        }
        /** 获得sd文件路径 **/
        String sdcPath = Environment.getExternalStorageDirectory().getPath();
        StatFs statfs = new StatFs(sdcPath);
        long blocSize = statfs.getBlockSize();
        long availaBlock = statfs.getAvailableBlocks();
        long freesize = (blocSize * availaBlock) / (1024 * 1024);
        if (freesize >= 4) {
            return true;
        }
        return false;
    }


    public static File getDownloadDir(Context context, String uniqueName) {

        String cachePath = "";
        try {
            if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                    || !Environment.isExternalStorageRemovable()) {
//                if(context.getExternalCacheDir() != null)
//                    cachePath = context.getExternalFilesDir(Environment.DIRECTORY_MOVIES).getPath();
//                else {
//                    StringBuilder sb = new StringBuilder();
//                    sb.append(Environment.getExternalStorageDirectory().getPath()).append("/Android/data/").append(context.getPackageName())
//                            .append("/cache/").append(File.separator).toString();
//                    cachePath = sb.toString();
//                }
                cachePath = getdownloadDir().getPath();
            } else {
                cachePath = context.getFilesDir().getPath();
            }
        } catch (Exception e) {
            cachePath = getdownloadDir().getPath();
        }
        L.e("apk下载路径---" + cachePath);
        return new File(cachePath + File.separator + uniqueName);

    }

    public static File getDiskCacheDir(Context context, String uniqueName) {
        String cachePath = "";
        try {
            if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                    || !Environment.isExternalStorageRemovable()) {
//                if(context.getExternalCacheDir() != null)
//                    cachePath = context.getExternalFilesDir(Environment.DIRECTORY_MOVIES).getPath();
//                else {
//                    StringBuilder sb = new StringBuilder();
//                    sb.append(Environment.getExternalStorageDirectory().getPath()).append("/Android/data/").append(context.getPackageName())
//                            .append("/cache/").append(File.separator).toString();
//                    cachePath = sb.toString();
//                }
                cachePath = getVideocacheDir().getPath();
            } else {
                cachePath = context.getCacheDir().getPath();
            }
        } catch (Exception e) {
            cachePath = getVideocacheDir().getPath();
        }
        L.e("视频缓存路径---" + cachePath);
        return new File(cachePath + File.separator + uniqueName);
    }

    /***
     * 获取根目录
     *
     * @return
     */
    public static File getRootDir() {
        File root = Environment.getExternalStorageDirectory();
        if (root.canWrite()) {
            File f = new File(root, APP_ROOTPATH);
            if (!f.exists()) {
                f.mkdir();
            }
            return f;

        } else {
            return null;
        }
    }


    /***
     * 获取cache目录
     *
     * @return
     */
    public static File getCacheDir() {
        File root = getRootDir();
        if (root != null) {
            File f = new File(root, "/cache/json/");
            if (!f.exists()) {
                f.mkdir();
            }
            return f;

        } else {
            return null;
        }
    }


    /***
     * 下载安装包路径
     *
     * @return
     */
    public static File getdownloadDir() {
        File root = getRootDir();
        if (root != null) {
            File folder = new File(root, DOWNLOAD_PATH);
            if (!folder.exists()) {
                folder.mkdir();
            }
            return folder;
        } else {
            return null;
        }
    }

    /**
     * 获取视频缓存目录
     *
     * @return
     */

    public static File getVideocacheDir() {
        File root = getRootDir();
        if (root != null) {
            File folder = new File(root, CACHE_PATH);
            if (!folder.exists()) {
                folder.mkdir();
            }
            return folder;
        } else {
            return null;
        }
    }


    public static File getVideoFile(String name) {

        File root = getVideocacheDir();
        if (root != null) {
            File file = new File(root, name);
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (Exception e) {
                // TODO: handle exception
            }

            return file;

        } else {
            return null;
        }
    }

    /**
     * 文件是否存在
     *
     * @param file
     * @return
     */
    public static boolean isExist(File file) {
        return file.exists();
    }


}
