package com.shixue.app.ui.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 本页：
 * Created by jjs on 2016-11-25.
 */

public class LiveDirectResult {
    @Override
    public String toString() {
        return "LiveDirectResult{" +
                "liveCourseList=" + liveCourseList +
                '}';
    }

    private List<LiveDirectBean> liveCourseList;

    public List<LiveDirectBean> getLiveCourseList() {
        return liveCourseList;
    }

    public void setLiveCourseList(List<LiveDirectBean> liveCourseList) {
        this.liveCourseList = liveCourseList;
    }

    public static class LiveDirectBean implements Serializable {
        @Override
        public String toString() {
            return "LiveDirectBean{" +
                    "isSign=" + isSign +
                    ", effective=" + effective +
                    ", examTypeId=" + examTypeId +
                    ", introduce='" + introduce + '\'' +
                    ", introduceUrl='" + introduceUrl + '\'' +
                    ", liveCourseId=" + liveCourseId +
                    ", liveCourseName='" + liveCourseName + '\'' +
                    ", oneWord='" + oneWord + '\'' +
                    ", pictureUrl='" + pictureUrl + '\'' +
                    ", price=" + price +
                    ", projectId=" + projectId +
                    ", seq=" + seq +
                    ", signMsg='" + signMsg + '\'' +
                    ", weixin='" + weixin + '\'' +
                    '}';
        }

        /**
         * effective : 1(0无效1有效)
         * examTypeId : 1
         * introduce : 名师精讲，轻松取证
         * introduceUrl : attached/liveCourse/250.html
         * liveCourseId : 250
         * liveCourseName : 《教师资格证——幼儿园》直播课
         * oneWord : 名师精讲，轻松取证
         * pictureUrl : attached/liveCourse/20161214123338.jpg
         * price : 0
         * projectId : 1
         * seq : 2500
         * signMsg : 名师精讲，轻松取证
         * weixin :
         */

        private boolean isSign; //是否能看直播。还是int比较好
        private int effective;
        private int examTypeId;
        private String introduce;
        private String introduceUrl;
        private int liveCourseId;
        private String liveCourseName;
        private String oneWord;
        private String pictureUrl;
        private int price;
        private int projectId;
        private int seq;
        private String signMsg;
        private String weixin;

        public boolean isSign() {
            return isSign;
        }

        public void setSign(boolean sign) {
            isSign = sign;
        }

        public int getEffective() {
            return effective;
        }

        public void setEffective(int effective) {
            this.effective = effective;
        }

        public int getExamTypeId() {
            return examTypeId;
        }

        public void setExamTypeId(int examTypeId) {
            this.examTypeId = examTypeId;
        }

        public String getIntroduce() {
            return introduce;
        }

        public void setIntroduce(String introduce) {
            this.introduce = introduce;
        }

        public String getIntroduceUrl() {
            return introduceUrl;
        }

        public void setIntroduceUrl(String introduceUrl) {
            this.introduceUrl = introduceUrl;
        }

        public int getLiveCourseId() {
            return liveCourseId;
        }

        public void setLiveCourseId(int liveCourseId) {
            this.liveCourseId = liveCourseId;
        }

        public String getLiveCourseName() {
            return liveCourseName;
        }

        public void setLiveCourseName(String liveCourseName) {
            this.liveCourseName = liveCourseName;
        }

        public String getOneWord() {
            return oneWord;
        }

        public void setOneWord(String oneWord) {
            this.oneWord = oneWord;
        }

        public String getPictureUrl() {
            return pictureUrl;
        }

        public void setPictureUrl(String pictureUrl) {
            this.pictureUrl = pictureUrl;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getProjectId() {
            return projectId;
        }

        public void setProjectId(int projectId) {
            this.projectId = projectId;
        }

        public int getSeq() {
            return seq;
        }

        public void setSeq(int seq) {
            this.seq = seq;
        }

        public String getSignMsg() {
            return signMsg;
        }

        public void setSignMsg(String signMsg) {
            this.signMsg = signMsg;
        }

        public String getWeixin() {
            return weixin;
        }

        public void setWeixin(String weixin) {
            this.weixin = weixin;
        }
    }
}
