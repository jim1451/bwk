package com.shixue.app.database;

import org.litepal.crud.DataSupport;

import java.io.Serializable;

/**
 * Created by Jacky Xu on 2015/11/6.
 */
public class VideoDb extends DataSupport implements Serializable {

    private long id;

    private int courseid; //课程id

    private int chapterid;

    private int sectionid; //节id

    private String sectionname; //节名称

    private String videourl;//视频地址

    private int downloadstatus; // 1 下载中 2下载暂停 3下载完成

    private int totalsize; //总大小

    private int downloadsize; //已下载大小

    private int downprogress; //下载进度


    public int getChapterid() {
        return chapterid;
    }

    public void setChapterid(int chapterid) {
        this.chapterid = chapterid;
    }

    public int getTotalsize() {
        return totalsize;
    }

    public void setTotalsize(int totalsize) {
        this.totalsize = totalsize;
    }

    public int getDownloadsize() {
        return downloadsize;
    }

    public void setDownloadsize(int downloadsize) {
        this.downloadsize = downloadsize;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }

    public int getDownloadstatus() {
        return downloadstatus;
    }

    public void setDownloadstatus(int downloadstatus) {
        this.downloadstatus = downloadstatus;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public int getSectionid() {
        return sectionid;
    }

    public void setSectionid(int sectionid) {
        this.sectionid = sectionid;
    }

    public String getSectionname() {
        return sectionname;
    }

    public void setSectionname(String sectionname) {
        this.sectionname = sectionname;
    }

    public int getDownprogress() {
        return downprogress;
    }

    public void setDownprogress(int downprogress) {
        this.downprogress = downprogress;
    }

}
