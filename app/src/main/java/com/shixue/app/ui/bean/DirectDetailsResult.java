package com.shixue.app.ui.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 本页：
 * Created by jjs on 2016-12-19.
 */

public class DirectDetailsResult {

    /**
     * liveSectionList : [{"classroomId":10452718,"classroomPassword":"654321","liveCourseId":253,"liveSectionId":43,"liveSectionName":"1月19日十点准时开课","liveSectionUrl":"79661263","minutes":180,"remark":"","seq":430,"sstartTime":"2017-01-19 10:00:00","starttime":1484791200000,"videoPassword":"123456","webPassword":"123456"},{"classroomId":0,"classroomPassword":"","liveCourseId":253,"liveSectionId":44,"liveSectionName":"3月5日七点准时开课","liveSectionUrl":"","minutes":120,"remark":"","seq":440,"sstartTime":"2017-03-05 06:50:00","starttime":1488711000000,"videoPassword":"","webPassword":"0"}]
     * liveServerIp : http://dadeedu.gensee.com/training/site/
     * softAndroidVersion : 0
     * softIosVersion : 0
     */

    private String liveServerIp;
    private int softAndroidVersion;
    private int softIosVersion;
    private List<LiveSectionListBean> liveSectionList;

    @Override
    public String toString() {
        return "DirectDetailsResult{" +
                "liveServerIp='" + liveServerIp + '\'' +
                ", softAndroidVersion=" + softAndroidVersion +
                ", softIosVersion=" + softIosVersion +
                ", liveSectionList=" + liveSectionList +
                '}';
    }

    public String getLiveServerIp() {
        return liveServerIp;
    }

    public void setLiveServerIp(String liveServerIp) {
        this.liveServerIp = liveServerIp;
    }

    public int getSoftAndroidVersion() {
        return softAndroidVersion;
    }

    public void setSoftAndroidVersion(int softAndroidVersion) {
        this.softAndroidVersion = softAndroidVersion;
    }

    public int getSoftIosVersion() {
        return softIosVersion;
    }

    public void setSoftIosVersion(int softIosVersion) {
        this.softIosVersion = softIosVersion;
    }

    public List<LiveSectionListBean> getLiveSectionList() {
        return liveSectionList;
    }

    public void setLiveSectionList(List<LiveSectionListBean> liveSectionList) {
        this.liveSectionList = liveSectionList;
    }

    public static class LiveSectionListBean implements Serializable{
        /**
         * classroomId : 10452718
         * classroomPassword : 654321
         * liveCourseId : 253
         * liveSectionId : 43
         * liveSectionName : 1月19日十点准时开课
         * liveSectionUrl : 79661263
         * minutes : 180
         * remark :
         * seq : 430
         * sstartTime : 2017-01-19 10:00:00
         * starttime : 1484791200000
         * videoPassword : 123456
         * webPassword : 123456
         */

        private int classroomId;
        private String classroomPassword;
        private int liveCourseId;
        private int liveSectionId;
        private String liveSectionName;
        private String liveSectionUrl;
        private int minutes;
        private String remark;
        private int seq;
        private String sstartTime;
        private long starttime;
        private String videoPassword;
        private String webPassword;

        @Override
        public String toString() {
            return "LiveSectionListBean{" +
                    "classroomId=" + classroomId +
                    ", classroomPassword='" + classroomPassword + '\'' +
                    ", liveCourseId=" + liveCourseId +
                    ", liveSectionId=" + liveSectionId +
                    ", liveSectionName='" + liveSectionName + '\'' +
                    ", liveSectionUrl='" + liveSectionUrl + '\'' +
                    ", minutes=" + minutes +
                    ", remark='" + remark + '\'' +
                    ", seq=" + seq +
                    ", sstartTime='" + sstartTime + '\'' +
                    ", starttime=" + starttime +
                    ", videoPassword='" + videoPassword + '\'' +
                    ", webPassword='" + webPassword + '\'' +
                    '}';
        }

        public int getClassroomId() {
            return classroomId;
        }

        public void setClassroomId(int classroomId) {
            this.classroomId = classroomId;
        }

        public String getClassroomPassword() {
            return classroomPassword;
        }

        public void setClassroomPassword(String classroomPassword) {
            this.classroomPassword = classroomPassword;
        }

        public int getLiveCourseId() {
            return liveCourseId;
        }

        public void setLiveCourseId(int liveCourseId) {
            this.liveCourseId = liveCourseId;
        }

        public int getLiveSectionId() {
            return liveSectionId;
        }

        public void setLiveSectionId(int liveSectionId) {
            this.liveSectionId = liveSectionId;
        }

        public String getLiveSectionName() {
            return liveSectionName;
        }

        public void setLiveSectionName(String liveSectionName) {
            this.liveSectionName = liveSectionName;
        }

        public String getLiveSectionUrl() {
            return liveSectionUrl;
        }

        public void setLiveSectionUrl(String liveSectionUrl) {
            this.liveSectionUrl = liveSectionUrl;
        }

        public int getMinutes() {
            return minutes;
        }

        public void setMinutes(int minutes) {
            this.minutes = minutes;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public int getSeq() {
            return seq;
        }

        public void setSeq(int seq) {
            this.seq = seq;
        }

        public String getSstartTime() {
            return sstartTime;
        }

        public void setSstartTime(String sstartTime) {
            this.sstartTime = sstartTime;
        }

        public long getStarttime() {
            return starttime;
        }

        public void setStarttime(long starttime) {
            this.starttime = starttime;
        }

        public String getVideoPassword() {
            return videoPassword;
        }

        public void setVideoPassword(String videoPassword) {
            this.videoPassword = videoPassword;
        }

        public String getWebPassword() {
            return webPassword;
        }

        public void setWebPassword(String webPassword) {
            this.webPassword = webPassword;
        }
    }
}
