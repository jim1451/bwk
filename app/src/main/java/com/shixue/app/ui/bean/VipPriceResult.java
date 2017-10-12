package com.shixue.app.ui.bean;

/**
 * 本页：会员购买金额
 * Created by jjs on 2016-12-28.
 * Email:994462623@qq.com
 */

public class VipPriceResult {

    /**
     * projPrice : {"oneMonthMoney":45,"oneYearMoney":448,"projectId":1,"projectName":"教师资格证","sixMonthMoney":238,"threeMonthMoney":128}
     * softAndroidVersion : 0
     * softIosVersion : 0
     */

    private ProjPriceBean projPrice;
    private int softAndroidVersion;
    private int softIosVersion;

    public ProjPriceBean getProjPrice() {
        return projPrice;
    }

    public void setProjPrice(ProjPriceBean projPrice) {
        this.projPrice = projPrice;
    }

    public int getSoftAndroidVersion() {
        return softAndroidVersion;
    }

    public void setSoftAndroidVersion(int softAndroidVersion) {
        this.softAndroidVersion = softAndroidVersion;
    }

    public int getSoftIosVersion() {
        return softIosVersion;
    }

    public void setSoftIosVersion(int softIosVersion) {
        this.softIosVersion = softIosVersion;
    }

    public static class ProjPriceBean {
        @Override
        public String toString() {
            return "ProjPriceBean{" +
                    "oneMonthMoney=" + oneMonthMoney +
                    ", oneYearMoney=" + oneYearMoney +
                    ", projectId=" + projectId +
                    ", projectName='" + projectName + '\'' +
                    ", sixMonthMoney=" + sixMonthMoney +
                    ", threeMonthMoney=" + threeMonthMoney +
                    '}';
        }

        /**
         * oneMonthMoney : 45
         * oneYearMoney : 448
         * projectId : 1
         * projectName : 教师资格证
         * sixMonthMoney : 238
         * threeMonthMoney : 128
         */


        private int oneMonthMoney;
        private int oneYearMoney;
        private int projectId;
        private String projectName;
        private int sixMonthMoney;
        private int threeMonthMoney;

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

        public int getSixMonthMoney() {
            return sixMonthMoney;
        }

        public void setSixMonthMoney(int sixMonthMoney) {
            this.sixMonthMoney = sixMonthMoney;
        }

        public int getThreeMonthMoney() {
            return threeMonthMoney;
        }

        public void setThreeMonthMoney(int threeMonthMoney) {
            this.threeMonthMoney = threeMonthMoney;
        }
    }

    @Override
    public String toString() {
        return "VipPriceResult{" +
                "projPrice=" + projPrice +
                ", softAndroidVersion=" + softAndroidVersion +
                ", softIosVersion=" + softIosVersion +
                '}';
    }
}
