package com.shixue.app.ui.bean;

/**
 * Created by MZ安卓 on 2017/11/30.
 */

public class VersionBean {
    /**
     * examTypeId : 0
     * user : {"agentId":1,"cityId":1,"email":"gkimlaps@126.com","equipmentModel":"HW-A8","equipmentType":0,"homeAddress":"2222","mobile":"15374363882","password":"1234","projectId":0,"provinceId":1,"registerDate":1510974685000,"sex":1,"softVersion":"3.3","systemVersion":"4.2","userName":"小丽","userid":51}
     */

    private int examTypeId;
    private UserBean user;

    public int getExamTypeId() {
        return examTypeId;
    }

    public void setExamTypeId(int examTypeId) {
        this.examTypeId = examTypeId;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class UserBean {
        /**
         * agentId : 1
         * cityId : 1
         * email : gkimlaps@126.com
         * equipmentModel : HW-A8
         * equipmentType : 0
         * homeAddress : 2222
         * mobile : 15374363882
         * password : 1234
         * projectId : 0
         * provinceId : 1
         * registerDate : 1510974685000
         * sex : 1
         * softVersion : 3.3
         * systemVersion : 4.2
         * userName : 小丽
         * userid : 51
         */

        private int agentId;
        private int cityId;
        private String email;
        private String equipmentModel;
        private int equipmentType;
        private String homeAddress;
        private String mobile;
        private String password;
        private int projectId;
        private int provinceId;
        private long registerDate;
        private int sex;
        private String softVersion;
        private String systemVersion;
        private String userName;
        private int userid;

        public int getAgentId() {
            return agentId;
        }

        public void setAgentId(int agentId) {
            this.agentId = agentId;
        }

        public int getCityId() {
            return cityId;
        }

        public void setCityId(int cityId) {
            this.cityId = cityId;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getEquipmentModel() {
            return equipmentModel;
        }

        public void setEquipmentModel(String equipmentModel) {
            this.equipmentModel = equipmentModel;
        }

        public int getEquipmentType() {
            return equipmentType;
        }

        public void setEquipmentType(int equipmentType) {
            this.equipmentType = equipmentType;
        }

        public String getHomeAddress() {
            return homeAddress;
        }

        public void setHomeAddress(String homeAddress) {
            this.homeAddress = homeAddress;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getProjectId() {
            return projectId;
        }

        public void setProjectId(int projectId) {
            this.projectId = projectId;
        }

        public int getProvinceId() {
            return provinceId;
        }

        public void setProvinceId(int provinceId) {
            this.provinceId = provinceId;
        }

        public long getRegisterDate() {
            return registerDate;
        }

        public void setRegisterDate(long registerDate) {
            this.registerDate = registerDate;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getSoftVersion() {
            return softVersion;
        }

        public void setSoftVersion(String softVersion) {
            this.softVersion = softVersion;
        }

        public String getSystemVersion() {
            return systemVersion;
        }

        public void setSystemVersion(String systemVersion) {
            this.systemVersion = systemVersion;
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
}
