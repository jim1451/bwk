package com.shixue.app.ui.bean;

import java.util.List;

/**
 * 本页：
 * Created by jjs on 2016-12-07.
 */

public class PractiseTestListResult {


    private List<TestListBean> testList;

    public List<TestListBean> getTestList() {
        return testList;
    }

    public void setTestList(List<TestListBean> testList) {
        this.testList = testList;
    }

    public static class TestListBean {
        /**
         * chargeType : 0
         * invalid : 1
         * oneWord : 章节练习
         * seq : 28690
         * testCount : 14
         * testId : 2877
         * testName : 第五节 会计准则体系
         */

        private int chargeType;
        private int invalid;
        private String oneWord;
        private int seq;
        private int testCount;
        private int testId;
        private String testName;
        private String testUrl;

        public String getTestUrl() {
            return testUrl;
        }

        public void setTestUrl(String testUrl) {
            this.testUrl = testUrl;
        }

        public int getChargeType() {
            return chargeType;
        }

        public void setChargeType(int chargeType) {
            this.chargeType = chargeType;
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

        public int getTestId() {
            return testId;
        }

        public void setTestId(int testId) {
            this.testId = testId;
        }

        public String getTestName() {
            return testName;
        }

        public void setTestName(String testName) {
            this.testName = testName;
        }
    }
}
