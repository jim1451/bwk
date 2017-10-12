package com.shixue.app.ui.bean;

import java.util.List;

/**
 * 本页：项目步骤
 * Created by jjs on 2016-12-09.
 */

public class StepResult {

    private List<StepTypeListBean> stepTypeList;

    public List<StepTypeListBean> getStepTypeList() {
        return stepTypeList;
    }

    public void setStepTypeList(List<StepTypeListBean> stepTypeList) {
        this.stepTypeList = stepTypeList;
    }

    public static class StepTypeListBean {
        /**
         * projectId : 2
         * projectStepList : [{"currStep":0,"howdoUrl":"attached/projectStep/1.html","invalid":1,"oneWord":"报专科需高中毕业，报本科需专科毕业","projectId":2,"projectStepId":1,"provinceId":1,"ranges":0,"remark":"","seq":10,"stepName":"成人高考报名资格","stepTypeId":6,"stepTypeName":"报考","timeOneword":"外省户籍需提供工作证明及居住证才可报考"},{"currStep":0,"howdoUrl":"attached/projectStep/2.html","invalid":1,"oneWord":"指定时间在官网网上报名、填报意向志愿","projectId":2,"projectStepId":2,"provinceId":1,"ranges":0,"remark":"","seq":20,"stepName":"考试预报名","stepTypeId":6,"stepTypeName":"报考","timeOneword":"去年同期是8月31日至9月6日"},{"currStep":0,"howdoUrl":"attached/projectStep/3.html","invalid":1,"oneWord":"在规定时间到报名点信息确认、拍照及缴费","projectId":2,"projectStepId":3,"provinceId":1,"ranges":0,"remark":"","seq":30,"stepName":"现场确认","stepTypeId":6,"stepTypeName":"报考","timeOneword":"去年同期是9月7-16日"},{"currStep":0,"howdoUrl":"attached/projectStep/7.html","invalid":1,"oneWord":"在规定时间到官网进行填报正式志愿","projectId":2,"projectStepId":7,"provinceId":1,"ranges":0,"remark":"","seq":70,"stepName":"填报正式志愿","stepTypeId":6,"stepTypeName":"报考","timeOneword":"去年同期是11月20-21日"}]
         * seq : 6
         * stepTypeId : 6
         * stepTypeName : 报考
         */

        private int projectId;
        private int seq;
        private int stepTypeId;
        private String stepTypeName;
        private List<ProjectStepListBean> projectStepList;

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

        public int getStepTypeId() {
            return stepTypeId;
        }

        public void setStepTypeId(int stepTypeId) {
            this.stepTypeId = stepTypeId;
        }

        public String getStepTypeName() {
            return stepTypeName;
        }

        public void setStepTypeName(String stepTypeName) {
            this.stepTypeName = stepTypeName;
        }

        public List<ProjectStepListBean> getProjectStepList() {
            return projectStepList;
        }

        public void setProjectStepList(List<ProjectStepListBean> projectStepList) {
            this.projectStepList = projectStepList;
        }

        public static class ProjectStepListBean {
            /**
             * currStep : 0
             * howdoUrl : attached/projectStep/1.html
             * invalid : 1
             * oneWord : 报专科需高中毕业，报本科需专科毕业
             * projectId : 2
             * projectStepId : 1
             * provinceId : 1
             * ranges : 0
             * remark :
             * seq : 10
             * stepName : 成人高考报名资格
             * stepTypeId : 6
             * stepTypeName : 报考
             * timeOneword : 外省户籍需提供工作证明及居住证才可报考
             */

            private int currStep;
            private String howdoUrl;
            private int invalid;
            private String oneWord;
            private int projectId;
            private int projectStepId;
            private int provinceId;
            private int ranges;
            private String remark;
            private int seq;
            private String stepName;
            private int stepTypeId;
            private String stepTypeName;
            private String timeOneword;

            public int getCurrStep() {
                return currStep;
            }

            public void setCurrStep(int currStep) {
                this.currStep = currStep;
            }

            public String getHowdoUrl() {
                return howdoUrl;
            }

            public void setHowdoUrl(String howdoUrl) {
                this.howdoUrl = howdoUrl;
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

            public int getProjectStepId() {
                return projectStepId;
            }

            public void setProjectStepId(int projectStepId) {
                this.projectStepId = projectStepId;
            }

            public int getProvinceId() {
                return provinceId;
            }

            public void setProvinceId(int provinceId) {
                this.provinceId = provinceId;
            }

            public int getRanges() {
                return ranges;
            }

            public void setRanges(int ranges) {
                this.ranges = ranges;
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

            public String getStepName() {
                return stepName;
            }

            public void setStepName(String stepName) {
                this.stepName = stepName;
            }

            public int getStepTypeId() {
                return stepTypeId;
            }

            public void setStepTypeId(int stepTypeId) {
                this.stepTypeId = stepTypeId;
            }

            public String getStepTypeName() {
                return stepTypeName;
            }

            public void setStepTypeName(String stepTypeName) {
                this.stepTypeName = stepTypeName;
            }

            public String getTimeOneword() {
                return timeOneword;
            }

            public void setTimeOneword(String timeOneword) {
                this.timeOneword = timeOneword;
            }
        }
    }
}
