package com.shixue.app.database;

import org.litepal.crud.DataSupport;

/**
 * Created by Jacky Xu on 2015/11/13.
 */
public class VideoPlayDb extends DataSupport {

    private long id;

//    private int courseid; //课程id

    private int sectionid; //节id

    private String sectionname; //节名称

    private String videourl;//视频地址

    private int videoprogress; //播放进度

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }

    public int getVideoprogress() {
        return videoprogress;
    }

    public void setVideoprogress(int videoprogress) {
        this.videoprogress = videoprogress;
    }
}
