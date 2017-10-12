package com.shixue.app.ui.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 本页：所有项目列表
 * Created by jjs on 2016-11-26.
 */

public class ExamTypeResult {
    @Override
    public String toString() {
        return "ExamTypeResult{" +
                "projTypeList=" + projTypeList +
                '}';
    }

    private List<ProjTypeListBean> projTypeList;

    public List<ProjTypeListBean> getProjTypeList() {
        return projTypeList;
    }

    public void setProjTypeList(List<ProjTypeListBean> projTypeList) {
        this.projTypeList = projTypeList;
    }

    public static class ProjTypeListBean implements Serializable {
        @Override
        public String toString() {
            return "ProjTypeListBean{" +
                    "projectTypeId=" + projectTypeId +
                    ", projectTypeName='" + projectTypeName + '\'' +
                    ", seq=" + seq +
                    ", projectList=" + projectList +
                    '}';
        }

        /**
         * projectList : [{"projectId":1,"projectName":"教师资格证","projectNo":"xm01","projectPicture":"attached/project/20161108213731.png"},{"projectId":2,"projectName":"成人高考","projectNo":"xm02","projectPicture":"attached/project/20161108213821.png"},{"projectId":3,"projectName":"自学考试","projectNo":"xm03","projectPicture":"attached/project/20161108213847.png"},{"projectId":5,"projectName":"普通话等级证书","projectNo":"xm04","projectPicture":"attached/project/20161108213910.png"},{"projectId":7,"projectName":"研究生考试","projectNo":"xm05","projectPicture":"attached/project/20161108213929.png"},{"projectId":8,"projectName":"会计证","projectNo":"xm06","projectPicture":"attached/project/20161108213944.png"}]
         * projectTypeId : 1
         * projectTypeName : 证书
         * seq : 1
         */

        private int projectTypeId;
        private String projectTypeName;
        private int seq;
        private List<ExamTypeBean> projectList;

        public int getProjectTypeId() {
            return projectTypeId;
        }

        public void setProjectTypeId(int projectTypeId) {
            this.projectTypeId = projectTypeId;
        }

        public String getProjectTypeName() {
            return projectTypeName;
        }

        public void setProjectTypeName(String projectTypeName) {
            this.projectTypeName = projectTypeName;
        }

        public int getSeq() {
            return seq;
        }

        public void setSeq(int seq) {
            this.seq = seq;
        }

        public List<ExamTypeBean> getProjectList() {
            return projectList;
        }

        public void setProjectList(List<ExamTypeBean> projectList) {
            this.projectList = projectList;
        }

        public static class ExamTypeBean implements Serializable {
            @Override
            public String toString() {
                return "ExamTypeBean{" +
                        "projectId=" + projectId +
                        ", projectName='" + projectName + '\'' +
                        ", projectNo='" + projectNo + '\'' +
                        ", projectPicture='" + projectPicture + '\'' +
                        '}';
            }

            /**
             * projectId : 1
             * projectName : 教师资格证
             * projectNo : xm01
             * projectPicture : attached/project/20161108213731.png
             */

            private int projectId;
            private String projectName;
            private String projectNo;
            private String projectPicture;

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

            public String getProjectPicture() {
                return projectPicture;
            }

            public void setProjectPicture(String projectPicture) {
                this.projectPicture = projectPicture;
            }
        }
    }
}
