package com.shixue.app.ui.bean;

/**
 * 本页：
 * Created by jjs on 2016-12-28.
 * Email:994462623@qq.com
 */

public class PayDealResult {

    /**
     * pay : {"bank":"中国建设银行","cardNum":"software8899","cargoName":"购买教师资格证会员","orderNumber":"","payDate":1482933177771,"payMoney":88,"payRecordId":12438,"payStatus":0,"payType":0,"payer":"赖国荣","projectId":1,"userMobile":"15374363882","userName":"小丽","userid":2507}
     * softAndroidVersion : 0
     * softIosVersion : 0
     */

    private PayBean pay;
    private int softAndroidVersion;
    private int softIosVersion;

    public PayBean getPay() {
        return pay;
    }

    public void setPay(PayBean pay) {
        this.pay = pay;
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

    public static class PayBean {
        /**
         * bank : 中国建设银行
         * cardNum : software8899
         * cargoName : 购买教师资格证会员
         * orderNumber :
         * payDate : 1482933177771
         * payMoney : 88
         * payRecordId : 12438
         * payStatus : 0
         * payType : 0
         * payer : 赖国荣
         * projectId : 1
         * userMobile : 15374363882
         * userName : 小丽
         * userid : 2507
         */

        private String bank;
        private String cardNum;
        private String cargoName;
        private String orderNumber;
        private long payDate;
        private double payMoney;
        private int payRecordId;
        private int payStatus;
        private int payType;
        private String payer;
        private int projectId;
        private String userMobile;
        private String userName;
        private int userid;

        @Override
        public String toString() {
            return "PayBean{" +
                    "bank='" + bank + '\'' +
                    ", cardNum='" + cardNum + '\'' +
                    ", cargoName='" + cargoName + '\'' +
                    ", orderNumber='" + orderNumber + '\'' +
                    ", payDate=" + payDate +
                    ", payMoney=" + payMoney +
                    ", payRecordId=" + payRecordId +
                    ", payStatus=" + payStatus +
                    ", payType=" + payType +
                    ", payer='" + payer + '\'' +
                    ", projectId=" + projectId +
                    ", userMobile='" + userMobile + '\'' +
                    ", userName='" + userName + '\'' +
                    ", userid=" + userid +
                    '}';
        }

        public String getBank() {
            return bank;
        }

        public void setBank(String bank) {
            this.bank = bank;
        }

        public String getCardNum() {
            return cardNum;
        }

        public void setCardNum(String cardNum) {
            this.cardNum = cardNum;
        }

        public String getCargoName() {
            return cargoName;
        }

        public void setCargoName(String cargoName) {
            this.cargoName = cargoName;
        }

        public String getOrderNumber() {
            return orderNumber;
        }

        public void setOrderNumber(String orderNumber) {
            this.orderNumber = orderNumber;
        }

        public long getPayDate() {
            return payDate;
        }

        public void setPayDate(long payDate) {
            this.payDate = payDate;
        }

        public double getPayMoney() {
            return payMoney;
        }

        public void setPayMoney(double payMoney) {
            this.payMoney = payMoney;
        }

        public int getPayRecordId() {
            return payRecordId;
        }

        public void setPayRecordId(int payRecordId) {
            this.payRecordId = payRecordId;
        }

        public int getPayStatus() {
            return payStatus;
        }

        public void setPayStatus(int payStatus) {
            this.payStatus = payStatus;
        }

        public int getPayType() {
            return payType;
        }

        public void setPayType(int payType) {
            this.payType = payType;
        }

        public String getPayer() {
            return payer;
        }

        public void setPayer(String payer) {
            this.payer = payer;
        }

        public int getProjectId() {
            return projectId;
        }

        public void setProjectId(int projectId) {
            this.projectId = projectId;
        }

        public String getUserMobile() {
            return userMobile;
        }

        public void setUserMobile(String userMobile) {
            this.userMobile = userMobile;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }
    }

    @Override
    public String toString() {
        return "PayDealResult{" +
                "pay=" + pay +
                ", softAndroidVersion=" + softAndroidVersion +
                ", softIosVersion=" + softIosVersion +
                '}';
    }
}
