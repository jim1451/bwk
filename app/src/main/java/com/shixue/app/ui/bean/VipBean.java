package com.shixue.app.ui.bean;

import java.util.List;

/**
 * 本页：
 * Created by jjs on 2016-12-06.
 */

public class VipBean {


    /**
     * body : {"examTypeId":0,"vipInfoList":[{"chargeType":1,"examTypeId":1,"examTypeName":"幼儿园","vipDate":"2018-10-20","vipStatus":1}]}
     * errorCode : -1
     * msg : 获取数据成功
     * success : true
     */

    private BodyBean body;
    private String errorCode;
    private String msg;
    private boolean success;

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class BodyBean {
        /**
         * examTypeId : 0
         * vipInfoList : [{"chargeType":1,"examTypeId":1,"examTypeName":"幼儿园","vipDate":"2018-10-20","vipStatus":1}]
         */

        private int examTypeId;
        private List<VipInfoListBean> vipInfoList;

        public int getExamTypeId() {
            return examTypeId;
        }

        public void setExamTypeId(int examTypeId) {
            this.examTypeId = examTypeId;
        }

        public List<VipInfoListBean> getVipInfoList() {
            return vipInfoList;
        }

        public void setVipInfoList(List<VipInfoListBean> vipInfoList) {
            this.vipInfoList = vipInfoList;
        }

        public static class VipInfoListBean {
            /**
             * chargeType : 1
             * examTypeId : 1
             * examTypeName : 幼儿园
             * vipDate : 2018-10-20
             * vipStatus : 1
             */

            private int chargeType;
            private int examTypeId;
            private String examTypeName;
            private String vipDate;
            private int vipStatus;

            public int getChargeType() {
                return chargeType;
            }

            public void setChargeType(int chargeType) {
                this.chargeType = chargeType;
            }

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

            public String getVipDate() {
                return vipDate;
            }

            public void setVipDate(String vipDate) {
                this.vipDate = vipDate;
            }

            public int getVipStatus() {
                return vipStatus;
            }

            public void setVipStatus(int vipStatus) {
                this.vipStatus = vipStatus;
            }
        }
    }
}
