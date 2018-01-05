package com.shixue.app.ui.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 本页：
 * Created by jjs on 2016-11-25.
 */

public class LiveDirectResult implements Serializable{

    /**
     * examTypeId : 0
     * liveCourseList : [{"chargeType":2,"effective":1,"examTypeId":1,"introduce":"    本课程适合幼儿园教师资格考试证国考。\r\n    全国最优质的教师资格笔试视频课程，杨老师主讲，华中师范大学硕士研究生，某儿童数字化学习研究中心培训主任，高级培训讲师，长期从事幼儿数字化教学内容研发及教师培训工作，对保教知识有深入的研究，出版了十几本幼儿保教专著。\r\n    本课程围绕考试大纲，分析历年真题题型，精心设计教学方案，注重将幼儿实际生活融入知识考点中，紧扣应试思维理念，以全新的教学方式演绎考试的重难点。\r\n    杨老师教学形式活泼，教态自然大方，言语清晰，教学逻辑缜密，着重应试技巧指导，深受考生欢迎喜欢。热切希望考生先一睹老师风采和学情分析，对本课程有一个全面的了解。\r\n    \u201c伴我考\u201d深知考生学习的痛苦，为了让学习痛苦短暂一些，老师费尽心血，将课程从三十小时压缩到六小时，课程短小，内容精炼。","introduceUrl":"attached/liveCourse/123.html","liveCourseId":123,"liveCourseName":"2016幼儿《保教知识与能力》精品视频课","oneWord":"名师精心设计，直击考试要点","pictureUrl":"attached/books/20151228162415.png","price":90,"projectId":1,"seq":6490,"signMsg":"","weixin":"","wxIcon":""}]
     */

    private int examTypeId;
    private List<LiveCourseListBean> liveCourseList;

    public int getExamTypeId() {
        return examTypeId;
    }

    public void setExamTypeId(int examTypeId) {
        this.examTypeId = examTypeId;
    }

    public List<LiveCourseListBean> getLiveCourseList() {
        return liveCourseList;
    }

    public void setLiveCourseList(List<LiveCourseListBean> liveCourseList) {
        this.liveCourseList = liveCourseList;
    }

    public static class LiveCourseListBean implements Serializable{
        /**
         * chargeType : 2
         * effective : 1
         * examTypeId : 1
         * introduce :     本课程适合幼儿园教师资格考试证国考。
         * 全国最优质的教师资格笔试视频课程，杨老师主讲，华中师范大学硕士研究生，某儿童数字化学习研究中心培训主任，高级培训讲师，长期从事幼儿数字化教学内容研发及教师培训工作，对保教知识有深入的研究，出版了十几本幼儿保教专著。
         * 本课程围绕考试大纲，分析历年真题题型，精心设计教学方案，注重将幼儿实际生活融入知识考点中，紧扣应试思维理念，以全新的教学方式演绎考试的重难点。
         * 杨老师教学形式活泼，教态自然大方，言语清晰，教学逻辑缜密，着重应试技巧指导，深受考生欢迎喜欢。热切希望考生先一睹老师风采和学情分析，对本课程有一个全面的了解。
         * “伴我考”深知考生学习的痛苦，为了让学习痛苦短暂一些，老师费尽心血，将课程从三十小时压缩到六小时，课程短小，内容精炼。
         * introduceUrl : attached/liveCourse/123.html
         * liveCourseId : 123
         * liveCourseName : 2016幼儿《保教知识与能力》精品视频课
         * oneWord : 名师精心设计，直击考试要点
         * pictureUrl : attached/books/20151228162415.png
         * price : 90
         * projectId : 1
         * seq : 6490
         * signMsg :
         * weixin :
         * wxIcon :
         */
        private boolean isSign; //是否能看直播。还是int比较好
        private int chargeType;
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
        private String wxIcon;

        public boolean isSign() {
            return isSign;
        }

        public void setSign(boolean sign) {
            isSign = sign;
        }

        public int getChargeType() {
            return chargeType;
        }

        public void setChargeType(int chargeType) {
            this.chargeType = chargeType;
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

        public String getWxIcon() {
            return wxIcon;
        }

        public void setWxIcon(String wxIcon) {
            this.wxIcon = wxIcon;
        }
    }
}
