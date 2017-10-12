package com.shixue.app.ui.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 本页：
 * Created by jjs on 2016-12-07.
 */

public class PractiseTitleListResult {

    private List<SubjectListBean> subjectList;

    public List<SubjectListBean> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<SubjectListBean> subjectList) {
        this.subjectList = subjectList;
    }

    public static class SubjectListBean {
        /**
         * libraryList : [{"chargeType":0,"examSubject":"幼儿园.综合素质","invalid":1,"oneWord":"幼儿园综合素质题库","projectId":1,"seq":90,"testCount":1,"testLibraryId":9,"testLibraryName":"幼儿园综合素质题库"}]
         * subjectName : 幼儿园.综合素质
         */

        private String subjectName;
        private List<LibraryListBean> libraryList;

        public String getSubjectName() {
            return subjectName;
        }

        public void setSubjectName(String subjectName) {
            this.subjectName = subjectName;
        }

        public List<LibraryListBean> getLibraryList() {
            return libraryList;
        }

        public void setLibraryList(List<LibraryListBean> libraryList) {
            this.libraryList = libraryList;
        }

        public static class LibraryListBean implements Serializable {
            /**
             * chargeType : 0
             * examSubject : 幼儿园.综合素质
             * invalid : 1
             * oneWord : 幼儿园综合素质题库
             * projectId : 1
             * seq : 90
             * testCount : 1
             * testLibraryId : 9
             * testLibraryName : 幼儿园综合素质题库
             * pictureUrl:"" //图片
             */

            private int chargeType;  //0免费1收费
            private String examSubject;
            private int invalid;
            private String oneWord;
            private int projectId;
            private int seq;
            private int testCount;
            private int testLibraryId;
            private String testLibraryName;
            private String pictureUrl;

            public String getPictureUrl() {
                return pictureUrl;
            }

            public void setPictureUrl(String pictureUrl) {
                this.pictureUrl = pictureUrl;
            }

            public int getChargeType() {
                return chargeType;
            }

            public void setChargeType(int chargeType) {
                this.chargeType = chargeType;
            }

            public String getExamSubject() {
                return examSubject;
            }

            public void setExamSubject(String examSubject) {
                this.examSubject = examSubject;
            }

            public int getInvalid() {
                return invalid;
            }

            public void setInvalid(int invalid) {
                this.invalid = invalid;
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

            public int getSeq() {
                return seq;
            }

            public void setSeq(int seq) {
                this.seq = seq;
            }

            public int getTestCount() {
                return testCount;
            }

            public void setTestCount(int testCount) {
                this.testCount = testCount;
            }

            public int getTestLibraryId() {
                return testLibraryId;
            }

            public void setTestLibraryId(int testLibraryId) {
                this.testLibraryId = testLibraryId;
            }

            public String getTestLibraryName() {
                return testLibraryName;
            }

            public void setTestLibraryName(String testLibraryName) {
                this.testLibraryName = testLibraryName;
            }
        }
    }
}
