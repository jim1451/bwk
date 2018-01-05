package com.shixue.app.ui.bean;

import java.util.List;

/**
 * Created by MZ安卓 on 2017/11/14.
 */

public class VipDetailsRresult {
    /**
     * examTypeId : 0
     * vipInfoList : [{"chargeType":1,"examTypeId":1,"examTypeName":"幼儿园","sysDate":"2017-11-14","vipDate":"2019-09-20","vipStatus":1}]
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
         * sysDate : 2017-11-14
         * vipDate : 2019-09-20
         * vipStatus : 1
         */

        private int chargeType;
        private int examTypeId;
        private String examTypeName;
        private String sysDate;
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

        public String getSysDate() {
            return sysDate;
        }

        public void setSysDate(String sysDate) {
            this.sysDate = sysDate;
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
