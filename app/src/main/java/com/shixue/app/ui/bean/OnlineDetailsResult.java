package com.shixue.app.ui.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 本页：
 * Created by jjs on 2016-12-02.
 */

public class OnlineDetailsResult implements Serializable {


    /**
     * chapterList : [{"chapterId":403,"chapterName":"第六章 考点归纳：教师的文化素养","courseId":51,"description":"第六章 考点归纳：教师的文化素养","sectionList":[{"chapterId":403,"definition":1,"free":0,"sectionId":1110,"sectionName":"第一节  中国历史","sectionType":1,"sectionUrl":"attached/section/1110.html","seq":13300,"testId":0,"timeLength":0},{"chapterId":403,"definition":1,"free":0,"sectionId":1111,"sectionName":"第二节  世界历史","sectionType":1,"sectionUrl":"attached/section/1111.html","seq":13200,"testId":0,"timeLength":0},{"chapterId":403,"definition":1,"free":0,"sectionId":1112,"sectionName":"第三节  中外科技发展史","sectionType":1,"sectionUrl":"attached/section/1112.html","seq":13100,"testId":0,"timeLength":0},{"chapterId":403,"definition":1,"free":0,"sectionId":1114,"sectionName":"第四节  中国文学","sectionType":1,"sectionUrl":"attached/section/1114.html","seq":12900,"testId":0,"timeLength":0},{"chapterId":403,"definition":1,"free":0,"sectionId":1229,"sectionName":"第五节  外国文学史","sectionType":1,"sectionUrl":"attached/section/1229.html","seq":12800,"testId":0,"timeLength":0},{"chapterId":403,"definition":1,"free":0,"sectionId":1230,"sectionName":"第六节  儿童文学","sectionType":1,"sectionUrl":"attached/section/1230.html","seq":12700,"testId":0,"timeLength":0},{"chapterId":403,"definition":1,"free":0,"sectionId":1231,"sectionName":"第七节  艺术鉴赏","sectionType":1,"sectionUrl":"attached/section/1231.html","seq":12310,"testId":1231,"timeLength":0}],"seq":4290}]
     * course : {"chargeType":1,"courseCount":0,"courseId":51,"courseName":"中学《综合素质》复习资料","effective":1,"examSubject":"中学.综合素质","introduce":"        精心整理的全套考前复习资料，包括：改革后教师资格证考试介绍，对考试方式和考试科目有详细的讲解；考试大纲的详细解析，考试目标、内容、要求及试卷结构与题型事例；所有考点的归纳总结，书本当中的常考点和历年考点进行整理；全套历年考试试卷及详细的答案解析。\r\n        伴我考深知考生学习的痛苦，复习资料做的短小精悍，但这背后是聘请名师花更多时间和成本，参考大量资料并提炼和精简，浓缩后的都是精华，减轻考生学习负担，有基础的考生能成倍提升通过率。","oneWord":"大纲详解、考点归纳和历年真题解析","pictureUrl":"attached/books/20151120144153.png","projectId":1,"replayDate":1509724800000,"replayUsername":"赖国荣","seq":4300,"useRange":0}
     * examTypeId : 0
     */

    private CourseBean course;
    private int examTypeId;
    private List<ChapterListBean> chapterList;

    public CourseBean getCourse() {
        return course;
    }

    public void setCourse(CourseBean course) {
        this.course = course;
    }

    public int getExamTypeId() {
        return examTypeId;
    }

    public void setExamTypeId(int examTypeId) {
        this.examTypeId = examTypeId;
    }

    public List<ChapterListBean> getChapterList() {
        return chapterList;
    }

    public void setChapterList(List<ChapterListBean> chapterList) {
        this.chapterList = chapterList;
    }

    public static class CourseBean {
        /**
         * chargeType : 1
         * courseCount : 0
         * courseId : 51
         * courseName : 中学《综合素质》复习资料
         * effective : 1
         * examSubject : 中学.综合素质
         * introduce :         精心整理的全套考前复习资料，包括：改革后教师资格证考试介绍，对考试方式和考试科目有详细的讲解；考试大纲的详细解析，考试目标、内容、要求及试卷结构与题型事例；所有考点的归纳总结，书本当中的常考点和历年考点进行整理；全套历年考试试卷及详细的答案解析。
         * 伴我考深知考生学习的痛苦，复习资料做的短小精悍，但这背后是聘请名师花更多时间和成本，参考大量资料并提炼和精简，浓缩后的都是精华，减轻考生学习负担，有基础的考生能成倍提升通过率。
         * oneWord : 大纲详解、考点归纳和历年真题解析
         * pictureUrl : attached/books/20151120144153.png
         * projectId : 1
         * replayDate : 1509724800000
         * replayUsername : 赖国荣
         * seq : 4300
         * useRange : 0
         */

        private int chargeType;
        private int courseCount;
        private int courseId;
        private String courseName;
        private int effective;
        private String examSubject;
        private String introduce;
        private String oneWord;
        private String pictureUrl;
        private int projectId;
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

    public static class ChapterListBean {
        /**
         * chapterId : 403
         * chapterName : 第六章 考点归纳：教师的文化素养
         * courseId : 51
         * description : 第六章 考点归纳：教师的文化素养
         * sectionList : [{"chapterId":403,"definition":1,"free":0,"sectionId":1110,"sectionName":"第一节  中国历史","sectionType":1,"sectionUrl":"attached/section/1110.html","seq":13300,"testId":0,"timeLength":0},{"chapterId":403,"definition":1,"free":0,"sectionId":1111,"sectionName":"第二节  世界历史","sectionType":1,"sectionUrl":"attached/section/1111.html","seq":13200,"testId":0,"timeLength":0},{"chapterId":403,"definition":1,"free":0,"sectionId":1112,"sectionName":"第三节  中外科技发展史","sectionType":1,"sectionUrl":"attached/section/1112.html","seq":13100,"testId":0,"timeLength":0},{"chapterId":403,"definition":1,"free":0,"sectionId":1114,"sectionName":"第四节  中国文学","sectionType":1,"sectionUrl":"attached/section/1114.html","seq":12900,"testId":0,"timeLength":0},{"chapterId":403,"definition":1,"free":0,"sectionId":1229,"sectionName":"第五节  外国文学史","sectionType":1,"sectionUrl":"attached/section/1229.html","seq":12800,"testId":0,"timeLength":0},{"chapterId":403,"definition":1,"free":0,"sectionId":1230,"sectionName":"第六节  儿童文学","sectionType":1,"sectionUrl":"attached/section/1230.html","seq":12700,"testId":0,"timeLength":0},{"chapterId":403,"definition":1,"free":0,"sectionId":1231,"sectionName":"第七节  艺术鉴赏","sectionType":1,"sectionUrl":"attached/section/1231.html","seq":12310,"testId":1231,"timeLength":0}]
         * seq : 4290
         */

        private int chapterId;
        private String chapterName;
        private int courseId;
        private String description;
        private int seq;
        private List<SectionListBean> sectionList;

        public int getChapterId() {
            return chapterId;
        }

        public void setChapterId(int chapterId) {
            this.chapterId = chapterId;
        }

        public String getChapterName() {
            return chapterName;
        }

        public void setChapterName(String chapterName) {
            this.chapterName = chapterName;
        }

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getSeq() {
            return seq;
        }

        public void setSeq(int seq) {
            this.seq = seq;
        }

        public List<SectionListBean> getSectionList() {
            return sectionList;
        }

        public void setSectionList(List<SectionListBean> sectionList) {
            this.sectionList = sectionList;
        }

        public static class SectionListBean {
            /**
             * chapterId : 403
             * definition : 1
             * free : 0
             * sectionId : 1110
             * sectionName : 第一节  中国历史
             * sectionType : 1
             * sectionUrl : attached/section/1110.html
             * seq : 13300
             * testId : 0
             * timeLength : 0
             */

            private int chapterId;
            private int definition;
            private int free;
            private int sectionId;
            private String sectionName;
            private int sectionType;
            private String sectionUrl;
            private int seq;
            private int testId;
            private int timeLength;

            public int getChapterId() {
                return chapterId;
            }

            public void setChapterId(int chapterId) {
                this.chapterId = chapterId;
            }

            public int getDefinition() {
                return definition;
            }

            public void setDefinition(int definition) {
                this.definition = definition;
            }

            public int getFree() {
                return free;
            }

            public void setFree(int free) {
                this.free = free;
            }

            public int getSectionId() {
                return sectionId;
            }

            public void setSectionId(int sectionId) {
                this.sectionId = sectionId;
            }

            public String getSectionName() {
                return sectionName;
            }

            public void setSectionName(String sectionName) {
                this.sectionName = sectionName;
            }

            public int getSectionType() {
                return sectionType;
            }

            public void setSectionType(int sectionType) {
                this.sectionType = sectionType;
            }

            public String getSectionUrl() {
                return sectionUrl;
            }

            public void setSectionUrl(String sectionUrl) {
                this.sectionUrl = sectionUrl;
            }

            public int getSeq() {
                return seq;
            }

            public void setSeq(int seq) {
                this.seq = seq;
            }

            public int getTestId() {
                return testId;
            }

            public void setTestId(int testId) {
                this.testId = testId;
            }

            public int getTimeLength() {
                return timeLength;
            }

            public void setTimeLength(int timeLength) {
                this.timeLength = timeLength;
            }
        }
    }
}
