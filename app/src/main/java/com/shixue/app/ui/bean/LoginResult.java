package com.shixue.app.ui.bean;

/**
 * Created by Administrator on 2016-11-22.
 */

public class LoginResult {

    /**
     * user : {"cityId":7,"cityName":"赣州","email":"gkimlaps@126.com","equipmentType":0,"homeAddress":"江西赣州","mobile":"15374363882","password":"B3BE4BDBE0D4478866F5370EE6C1E38E","projectId":1,"provinceId":1,"provinceName":"江西","regDate":"2015-12-02","registerDate":1449011673000,"sex":1,"userName":"小丽","userid":2507}
     */

    private UserBean user;

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class UserBean {
        /**
         * cityId : 7//城市id
         * cityName : 赣州
         * email : gkimlaps@126.com
         * equipmentType : 0 //设备类型
         * homeAddress : 江西赣州
         * mobile : 15374363882
         * password : B3BE4BDBE0D4478866F5370EE6C1E38E
         * projectId : 1//项目id
         * provinceId : 1//省份id
         * provinceName : 江西
         * regDate : 2015-12-02
         * registerDate : 1449011673000
         * sex : 1
         * userName : 小丽
         * userid : 2507
         */

        private int cityId;
        private String cityName;
        private String email;
        private int equipmentType;
        private String homeAddress;
        private String mobile;
        private String password;
        private int projectId;
        private int provinceId;
        private String provinceName;
        private String regDate;
        private long registerDate;
        private int sex;
        private String userName;
        private int userid;

        public int getCityId() {
            return cityId;
        }

        public void setCityId(int cityId) {
            this.cityId = cityId;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
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

        public String getProvinceName() {
            return provinceName;
        }

        public void setProvinceName(String provinceName) {
            this.provinceName = provinceName;
        }

        public String getRegDate() {
            return regDate;
        }

        public void setRegDate(String regDate) {
            this.regDate = regDate;
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
