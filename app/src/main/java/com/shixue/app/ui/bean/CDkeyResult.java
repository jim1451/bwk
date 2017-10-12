package com.shixue.app.ui.bean;

/**
 * 本页：
 * Created by jjs on 2017-01-16.
 * Email:994462623@qq.com
 */

public class CDkeyResult {

    /**
     * softAndroidVersion : 0
     * softIosVersion : 0
     * userProject : {"lastUpdateDate":1484530014000,"projectId":1,"slastUpdateDate":"2017-01-16 09:26:54","svipDate":"2017-01-16","sysDate":"2017-01-16","userProjectId":104907,"userid":2507,"vipDate":1484496000000,"webchat":0}
     */

    private int softAndroidVersion;
    private int softIosVersion;
    private UserProjectBean userProject;

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

    public UserProjectBean getUserProject() {
        return userProject;
    }

    public void setUserProject(UserProjectBean userProject) {
        this.userProject = userProject;
    }

    public static class UserProjectBean {
        /**
         * lastUpdateDate : 1484530014000
         * projectId : 1
         * slastUpdateDate : 2017-01-16 09:26:54
         * svipDate : 2017-01-16
         * sysDate : 2017-01-16
         * userProjectId : 104907
         * userid : 2507
         * vipDate : 1484496000000
         * webchat : 0
         */

        private long lastUpdateDate;
        private int projectId;
        private String slastUpdateDate;
        private String svipDate;
        private String sysDate;
        private int userProjectId;
        private int userid;
        private long vipDate;
        private int webchat;

        public long getLastUpdateDate() {
            return lastUpdateDate;
        }

        public void setLastUpdateDate(long lastUpdateDate) {
            this.lastUpdateDate = lastUpdateDate;
        }

        public int getProjectId() {
            return projectId;
        }

        public void setProjectId(int projectId) {
            this.projectId = projectId;
        }

        public String getSlastUpdateDate() {
            return slastUpdateDate;
        }

        public void setSlastUpdateDate(String slastUpdateDate) {
            this.slastUpdateDate = slastUpdateDate;
        }

        public String getSvipDate() {
            return svipDate;
        }

        public void setSvipDate(String svipDate) {
            this.svipDate = svipDate;
        }

        public String getSysDate() {
            return sysDate;
        }

        public void setSysDate(String sysDate) {
            this.sysDate = sysDate;
        }

        public int getUserProjectId() {
            return userProjectId;
        }

        public void setUserProjectId(int userProjectId) {
            this.userProjectId = userProjectId;
        }

        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }

        public long getVipDate() {
            return vipDate;
        }

        public void setVipDate(long vipDate) {
            this.vipDate = vipDate;
        }

        public int getWebchat() {
            return webchat;
        }

        public void setWebchat(int webchat) {
            this.webchat = webchat;
        }
    }
}
