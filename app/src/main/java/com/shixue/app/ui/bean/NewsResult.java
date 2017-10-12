package com.shixue.app.ui.bean;

import java.util.List;

/**
 * Created by Administrator on 2016-11-23.
 */

public class NewsResult {
    @Override
    public String toString() {
        return "NewsResult{" +
                "newList=" + newList +
                '}';
    }

    private List<NewsBean> newList;

    public List<NewsBean> getNewList() {
        return newList;
    }

    public void setNewList(List<NewsBean> newList) {
        this.newList = newList;
    }

    public static class NewsBean {

        @Override
        public String toString() {
            return "NewsBean{" +
                    "imageUrl='" + imageUrl + '\'' +
                    ", msgContentUrl='" + msgContentUrl + '\'' +
                    ", msgName='" + msgName + '\'' +
                    ", newMsgId=" + newMsgId +
                    ", newType=" + newType +
                    ", oneWord='" + oneWord + '\'' +
                    ", projectId=" + projectId +
                    ", provinceId='" + provinceId + '\'' +
                    ", provinceName='" + provinceName + '\'' +
                    ", pubDate='" + pubDate + '\'' +
                    ", useRange=" + useRange +
                    ", weixinCode='" + weixinCode + '\'' +
                    ", weixinRemark='" + weixinRemark + '\'' +
                    '}';
        }

        /**
         * imageUrl : attached/news/discount.png
         * msgContentUrl : attached/news/216.html
         * msgName : 教育部关于2016年下半年教师资格考试考务事项通知
         * newMsgId : 216
         * newType : 0
         * oneWord : 教育部关于2016年下半年教师资格考试考务事项通知
         * projectId : 1
         * provinceId : 0
         * provinceName :
         * pubDate : 2016-08-18
         * useRange : 0
         * weixinCode :
         * weixinRemark :
         */

        private String imageUrl;
        private String msgContentUrl;
        private String msgName;
        private int newMsgId;
        private int newType;
        private String oneWord;
        private int projectId;
        private String provinceId;
        private String provinceName;
        private String pubDate;
        private int useRange;
        private String weixinCode;
        private String weixinRemark;

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getMsgContentUrl() {
            return msgContentUrl;
        }

        public void setMsgContentUrl(String msgContentUrl) {
            this.msgContentUrl = msgContentUrl;
        }

        public String getMsgName() {
            return msgName;
        }

        public void setMsgName(String msgName) {
            this.msgName = msgName;
        }

        public int getNewMsgId() {
            return newMsgId;
        }

        public void setNewMsgId(int newMsgId) {
            this.newMsgId = newMsgId;
        }

        public int getNewType() {
            return newType;
        }

        public void setNewType(int newType) {
            this.newType = newType;
        }

        public String getOneWord() {
            return oneWord;
        }

        public void setOneWord(String oneWord) {
            this.oneWord = oneWord;
        }

        public int getProjectId() {
            return projectId;
        }

        public void setProjectId(int projectId) {
            this.projectId = projectId;
        }

        public String getProvinceId() {
            return provinceId;
        }

        public void setProvinceId(String provinceId) {
            this.provinceId = provinceId;
        }

        public String getProvinceName() {
            return provinceName;
        }

        public void setProvinceName(String provinceName) {
            this.provinceName = provinceName;
        }

        public String getPubDate() {
            return pubDate;
        }

        public void setPubDate(String pubDate) {
            this.pubDate = pubDate;
        }

        public int getUseRange() {
            return useRange;
        }

        public void setUseRange(int useRange) {
            this.useRange = useRange;
        }

        public String getWeixinCode() {
            return weixinCode;
        }

        public void setWeixinCode(String weixinCode) {
            this.weixinCode = weixinCode;
        }

        public String getWeixinRemark() {
            return weixinRemark;
        }

        public void setWeixinRemark(String weixinRemark) {
            this.weixinRemark = weixinRemark;
        }
    }
}
