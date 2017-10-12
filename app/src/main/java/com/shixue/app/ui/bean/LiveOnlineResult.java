package com.shixue.app.ui.bean;

import java.util.List;

/**
 * 本页：
 * Created by jjs on 2016-11-25.
 */

public class LiveOnlineResult {


    private List<SubjectListBean> subjectList;

    public List<SubjectListBean> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<SubjectListBean> subjectList) {
        this.subjectList = subjectList;
    }

    public static class SubjectListBean {
        /**
         * courseList : [{"chargeType":1,"courseCount":7,"courseId":125,"courseName":"2016幼儿《综合素质》精品视频课","effective":1,"evalLevel":0,"examSubject":"幼儿园.综合素质","introduce":"    本课程适合中小学教师资格证国考。\r\n    全国最优质的教师资格笔试视频课程。贾老师主讲，知名高校副教授，硕士研究生导师，基础教育研究所所长，华中师范大学教育学博士，多次担任教师资格考试笔试评委。多年来一直从事教师资格考试培训，有着深入的理解和研究。\r\n    本课程针对国考考纲，精心设计教学内容，突出考试重难点，围绕考试动态，政策，命题方向，结合历年真题进行详细讲解。贾老师教学功底深厚，思维缜密，直击考生学习痛点，广大考生对他赞不绝口，享誉湖北各大高校和教师资格培训机构。热切希望考生在学习本课程前试听教师风采和学情分析免费章节，一睹名师风采，了解课程讲解特色。\r\n    \u201c伴我考\u201d深知学习的痛苦，创新教学方式，课程短小，时长不及同类课程三分之一，内容紧凑，精炼，汇聚了老师的心血，目的就是为了减轻考生的学习负担，提升学习效果。\r\n","oneWord":"知名专家授课，精准把握命题动向","pictureUrl":"attached/books/20151228074324.png","projectId":1,"readCount":0,"replayDate":1451145600000,"replayUsername":"潘捷","seq":6690,"useRange":0},{"chargeType":0,"courseCount":0,"courseId":57,"courseName":"2016幼儿《综合素质》复习资料","effective":1,"evalLevel":0,"examSubject":"幼儿园.综合素质","introduce":"        精心整理的全套考前复习资料，包括：改革后教师资格证考试介绍，对考试方式和考试科目有详细的讲解；考试大纲的详细解析，考试目标、内容、要求及试卷结构与题型事例；所有考点的归纳总结，书本当中的常考点和历年考点进行整理；全套历年考试试卷及详细的答案解析。\r\n        伴我考深知考生学习的痛苦，复习资料做的短小精悍，但这背后是聘请名师花更多时间和成本，参考大量资料并提炼和精简，浓缩后的都是精华，减轻考生学习负担，有基础的考生能成倍提升通过率。","oneWord":"大纲详解、考点归纳和历年真题解析","pictureUrl":"attached/books/20151120144409.png","projectId":1,"readCount":0,"replayDate":1443628800000,"replayUsername":"潘捷","seq":4100,"useRange":0}]
         * subjectName : 幼儿园.综合素质
         */

        private String subjectName;
        private List<LiveOnlineBean> courseList;

        public String getSubjectName() {
            return subjectName;
        }

        public void setSubjectName(String subjectName) {
            this.subjectName = subjectName;
        }

        public List<LiveOnlineBean> getCourseList() {
            return courseList;
        }

        public void setCourseList(List<LiveOnlineBean> courseList) {
            this.courseList = courseList;
        }

        public static class LiveOnlineBean {
            /**
             * chargeType : 1
             * courseCount : 7
             * courseId : 125
             * courseName : 2016幼儿《综合素质》精品视频课
             * effective : 1
             * evalLevel : 0
             * examSubject : 幼儿园.综合素质
             * introduce :     本课程适合中小学教师资格证国考。
             全国最优质的教师资格笔试视频课程。贾老师主讲，知名高校副教授，硕士研究生导师，基础教育研究所所长，华中师范大学教育学博士，多次担任教师资格考试笔试评委。多年来一直从事教师资格考试培训，有着深入的理解和研究。
             本课程针对国考考纲，精心设计教学内容，突出考试重难点，围绕考试动态，政策，命题方向，结合历年真题进行详细讲解。贾老师教学功底深厚，思维缜密，直击考生学习痛点，广大考生对他赞不绝口，享誉湖北各大高校和教师资格培训机构。热切希望考生在学习本课程前试听教师风采和学情分析免费章节，一睹名师风采，了解课程讲解特色。
             “伴我考”深知学习的痛苦，创新教学方式，课程短小，时长不及同类课程三分之一，内容紧凑，精炼，汇聚了老师的心血，目的就是为了减轻考生的学习负担，提升学习效果。

             * oneWord : 知名专家授课，精准把握命题动向
             * pictureUrl : attached/books/20151228074324.png
             * projectId : 1
             * readCount : 0
             * replayDate : 1451145600000
             * replayUsername : 潘捷
             * seq : 6690
             * useRange : 0
             */

            private int chargeType;
            private int courseCount;
            private int courseId;
            private String courseName;
            private int effective;
            private int evalLevel;
            private String examSubject;
            private String introduce;
            private String oneWord;
            private String pictureUrl;
            private int projectId;
            private int readCount;
            private long replayDate;
            private String replayUsername;
            private int seq;
            private int useRange;

            public int getChargeType() {
                return chargeType;
            }

            public void setChargeType(int chargeType) {
                this.chargeType = chargeType;
            }

            public int getCourseCount() {
                return courseCount;
            }

            public void setCourseCount(int courseCount) {
                this.courseCount = courseCount;
            }

            public int getCourseId() {
                return courseId;
            }

            public void setCourseId(int courseId) {
                this.courseId = courseId;
            }

            public String getCourseName() {
                return courseName;
            }

            public void setCourseName(String courseName) {
                this.courseName = courseName;
            }

            public int getEffective() {
                return effective;
            }

            public void setEffective(int effective) {
                this.effective = effective;
            }

            public int getEvalLevel() {
                return evalLevel;
            }

            public void setEvalLevel(int evalLevel) {
                this.evalLevel = evalLevel;
            }

            public String getExamSubject() {
                return examSubject;
            }

            public void setExamSubject(String examSubject) {
                this.examSubject = examSubject;
            }

            public String getIntroduce() {
                return introduce;
            }

            public void setIntroduce(String introduce) {
                this.introduce = introduce;
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

            public int getProjectId() {
                return projectId;
            }

            public void setProjectId(int projectId) {
                this.projectId = projectId;
            }

            public int getReadCount() {
                return readCount;
            }

            public void setReadCount(int readCount) {
                this.readCount = readCount;
            }

            public long getReplayDate() {
                return replayDate;
            }

            public void setReplayDate(long replayDate) {
                this.replayDate = replayDate;
            }

            public String getReplayUsername() {
                return replayUsername;
            }

            public void setReplayUsername(String replayUsername) {
                this.replayUsername = replayUsername;
            }

            public int getSeq() {
                return seq;
            }

            public void setSeq(int seq) {
                this.seq = seq;
            }

            public int getUseRange() {
                return useRange;
            }

            public void setUseRange(int useRange) {
                this.useRange = useRange;
            }
        }
    }
}
