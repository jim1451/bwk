package com.shixue.app.ui.bean;

import java.util.List;


public class ExamInfoResult {
    @Override
    public String toString() {
        return "ExamInfoResult{" +
                "project=" + project +
                '}';
    }

    private ProjectBean project;

    public ProjectBean getProject() {
        return project;
    }

    public void setProject(ProjectBean project) {
        this.project = project;
    }

    public static class ProjectBean {
        @Override
        public String toString() {
            return "ProjectBean{" +
                    "aboutUs='" + aboutUs + '\'' +
                    ", allowAppFee=" + allowAppFee +
                    ", oneMonthMoney=" + oneMonthMoney +
                    ", oneYearMoney=" + oneYearMoney +
                    ", projectAd='" + projectAd + '\'' +
                    ", projectDetail='" + projectDetail + '\'' +
                    ", projectId=" + projectId +
                    ", projectName='" + projectName + '\'' +
                    ", projectNo='" + projectNo + '\'' +
                    ", projectOneword='" + projectOneword + '\'' +
                    ", projectPicture='" + projectPicture + '\'' +
                    ", projectRemark='" + projectRemark + '\'' +
                    ", projectTypeId=" + projectTypeId +
                    ", seq=" + seq +
                    ", sixMonthMoney=" + sixMonthMoney +
                    ", softVersion='" + softVersion + '\'' +
                    ", threeMonthMoney=" + threeMonthMoney +
                    ", examTypeList=" + examTypeList +
                    ", wxIcon='" + wxIcon + '\'' +
                    ", wxRemark='" + wxRemark + '\'' +
                    ", wxcode='" + wxcode + '\'' +
                    '}';
        }

        private String aboutUs;
        private int allowAppFee;
        private int oneMonthMoney;
        private int oneYearMoney;
        private String projectAd;
        private String projectDetail;
        private int projectId;
        private String projectName;
        private String projectNo;
        private String projectOneword;
        private String projectPicture;
        private String projectRemark;
        private int projectTypeId;
        private int seq;
        private int sixMonthMoney;
        private String softVersion;
        private int threeMonthMoney;
        private List<ExamTypeListBean> examTypeList;
        private String wxIcon;
        private String wxRemark;
        private String wxcode;

        public String getWxIcon() {
            return wxIcon;
        }

        public void setWxIcon(String wxIcon) {
            this.wxIcon = wxIcon;
        }

        public String getWxRemark() {
            return wxRemark;
        }

        public void setWxRemark(String wxRemark) {
            this.wxRemark = wxRemark;
        }

        public String getWxcode() {
            return wxcode;
        }

        public void setWxcode(String wxcode) {
            this.wxcode = wxcode;
        }

        public String getAboutUs() {
            return aboutUs;
        }

        public void setAboutUs(String aboutUs) {
            this.aboutUs = aboutUs;
        }

        public int getAllowAppFee() {
            return allowAppFee;
        }

        public void setAllowAppFee(int allowAppFee) {
            this.allowAppFee = allowAppFee;
        }

        public int getOneMonthMoney() {
            return oneMonthMoney;
        }

        public void setOneMonthMoney(int oneMonthMoney) {
            this.oneMonthMoney = oneMonthMoney;
        }

        public int getOneYearMoney() {
            return oneYearMoney;
        }

        public void setOneYearMoney(int oneYearMoney) {
            this.oneYearMoney = oneYearMoney;
        }

        public String getProjectAd() {
            return projectAd;
        }

        public void setProjectAd(String projectAd) {
            this.projectAd = projectAd;
        }

        public String getProjectDetail() {
            return projectDetail;
        }

        public void setProjectDetail(String projectDetail) {
            this.projectDetail = projectDetail;
        }

        public int getProjectId() {
            return projectId;
        }

        public void setProjectId(int projectId) {
            this.projectId = projectId;
        }

        public String getProjectName() {
            return projectName;
        }

        public void setProjectName(String projectName) {
            this.projectName = projectName;
        }

        public String getProjectNo() {
            return projectNo;
        }

        public void setProjectNo(String projectNo) {
            this.projectNo = projectNo;
        }

        public String getProjectOneword() {
            return projectOneword;
        }

        public void setProjectOneword(String projectOneword) {
            this.projectOneword = projectOneword;
        }

        public String getProjectPicture() {
            return projectPicture;
        }

        public void setProjectPicture(String projectPicture) {
            this.projectPicture = projectPicture;
        }

        public String getProjectRemark() {
            return projectRemark;
        }

        public void setProjectRemark(String projectRemark) {
            this.projectRemark = projectRemark;
        }

        public int getProjectTypeId() {
            return projectTypeId;
        }

        public void setProjectTypeId(int projectTypeId) {
            this.projectTypeId = projectTypeId;
        }

        public int getSeq() {
            return seq;
        }

        public void setSeq(int seq) {
            this.seq = seq;
        }

        public int getSixMonthMoney() {
            return sixMonthMoney;
        }

        public void setSixMonthMoney(int sixMonthMoney) {
            this.sixMonthMoney = sixMonthMoney;
        }

        public String getSoftVersion() {
            return softVersion;
        }

        public void setSoftVersion(String softVersion) {
            this.softVersion = softVersion;
        }

        public int getThreeMonthMoney() {
            return threeMonthMoney;
        }

        public void setThreeMonthMoney(int threeMonthMoney) {
            this.threeMonthMoney = threeMonthMoney;
        }

        public List<ExamTypeListBean> getExamTypeList() {
            return examTypeList;
        }

        public void setExamTypeList(List<ExamTypeListBean> examTypeList) {
            this.examTypeList = examTypeList;
        }

        public static class ExamTypeListBean {
            @Override
            public String toString() {
                return "ExamTypeListBean{" +
                        "examTypeId=" + examTypeId +
                        ", examTypeName='" + examTypeName + '\'' +
                        ", interviewCourse='" + interviewCourse + '\'' +
                        ", mandarinExam='" + mandarinExam + '\'' +
                        ", projectId=" + projectId +
                        ", writeCourseone='" + writeCourseone + '\'' +
                        ", writeCoursethree='" + writeCoursethree + '\'' +
                        ", writeCoursetwo='" + writeCoursetwo + '\'' +
                        '}';
            }

            /**
             * examTypeId : 1
             * examTypeName : 幼儿园
             * interviewCourse : 幼儿园.教育教学实践能力
             * mandarinExam : 普通话水平测试
             * projectId : 1
             * writeCourseone : 幼儿园.综合素质
             * writeCoursethree :
             * writeCoursetwo : 幼儿园.保教知识与能力
             */

            private int examTypeId;
            private String examTypeName;
            private String interviewCourse;
            private String mandarinExam;
            private int projectId;
            private String writeCourseone;
            private String writeCoursethree;
            private String writeCoursetwo;

            public int getExamTypeId() {
                return examTypeId;
            }

            public void setExamTypeId(int examTypeId) {
                this.examTypeId = examTypeId;
            }

            public String getExamTypeName() {
                return examTypeName;
            }

            public void setExamTypeName(String examTypeName) {
                this.examTypeName = examTypeName;
            }

            public String getInterviewCourse() {
                return interviewCourse;
            }

            public void setInterviewCourse(String interviewCourse) {
                this.interviewCourse = interviewCourse;
            }

            public String getMandarinExam() {
                return mandarinExam;
            }

            public void setMandarinExam(String mandarinExam) {
                this.mandarinExam = mandarinExam;
            }

            public int getProjectId() {
                return projectId;
            }

            public void setProjectId(int projectId) {
                this.projectId = projectId;
            }

            public String getWriteCourseone() {
                return writeCourseone;
            }

            public void setWriteCourseone(String writeCourseone) {
                this.writeCourseone = writeCourseone;
            }

            public String getWriteCoursethree() {
                return writeCoursethree;
            }

            public void setWriteCoursethree(String writeCoursethree) {
                this.writeCoursethree = writeCoursethree;
            }

            public String getWriteCoursetwo() {
                return writeCoursetwo;
            }

            public void setWriteCoursetwo(String writeCoursetwo) {
                this.writeCoursetwo = writeCoursetwo;
            }
        }
    }
}
