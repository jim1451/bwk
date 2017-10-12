package com.shixue.app.ui.bean;

/**
 * 本页：
 * Created by jjs on 2016-12-08.
 */

public class UserInfoBean {
    /**
     * body : {"examTypeId":0,"softAndroidVersion":"3","softIosVersion":"3.1.2","user":{"agentId":2,"cityId":1,"cityName":"南昌","email":"gkimlaps@126.com","equipmentModel":"","equipmentType":0,"homeAddress":"江西赣州","mobile":"15374363882","password":"1234","projectId":0,"provinceId":1,"provinceName":"江西","registerDate":1505895069000,"sex":1,"softVersion":"","systemVersion":"","userName":"小丽","userid":1}}
     */

    private BodyBean body;

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public static class BodyBean {
        /**
         * examTypeId : 0
         * softAndroidVersion : 3
         * softIosVersion : 3.1.2
         * user : {"agentId":2,"cityId":1,"cityName":"南昌","email":"gkimlaps@126.com","equipmentModel":"","equipmentType":0,"homeAddress":"江西赣州","mobile":"15374363882","password":"1234","projectId":0,"provinceId":1,"provinceName":"江西","registerDate":1505895069000,"sex":1,"softVersion":"","systemVersion":"","userName":"小丽","userid":1}
         */

        private int examTypeId;
        private String softAndroidVersion;
        private String softIosVersion;
        private UserBean user;

        public int getExamTypeId() {
            return examTypeId;
        }

        public void setExamTypeId(int examTypeId) {
            this.examTypeId = examTypeId;
        }

        public String getSoftAndroidVersion() {
            return softAndroidVersion;
        }

        public void setSoftAndroidVersion(String softAndroidVersion) {
            this.softAndroidVersion = softAndroidVersion;
        }

        public String getSoftIosVersion() {
            return softIosVersion;
        }

        public void setSoftIosVersion(String softIosVersion) {
            this.softIosVersion = softIosVersion;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * agentId : 2
             * cityId : 1
             * cityName : 南昌
             * email : gkimlaps@126.com
             * equipmentModel :
             * equipmentType : 0
             * homeAddress : 江西赣州
             * mobile : 15374363882
             * password : 1234
             * projectId : 0
             * provinceId : 1
             * provinceName : 江西
             * registerDate : 1505895069000
             * sex : 1
             * softVersion :
             * systemVersion :
             * userName : 小丽
             * userid : 1
             */

            private int agentId;
            private int cityId;
            private String cityName;
            private String email;
            private String equipmentModel;
            private int equipmentType;
            private String homeAddress;
            private String mobile;
            private String password;
            private int projectId;
            private int provinceId;
            private String provinceName;
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

            public String getProvinceName() {
                return provinceName;
            }

            public void setProvinceName(String provinceName) {
                this.provinceName = provinceName;
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

//    /**
//     * cityId : 7
//     * cityName : 赣州
//     * email : gkimlaps@126.com
//     * equipmentType : 0
//     * examTypeId : 26
//     * homeAddress : 江西赣州
//     * mobile : 15374363882
//     * password : B3BE4BDBE0D4478866F5370EE6C1E38E
//     * projectId : 8
//     * provinceId : 1
//     * provinceName : 江西
//     * regDate : 2015-12-02
//     * registerDate : 1449011673000
//     * sex : 1
//     * userName : 小丽
//     * userid : 2507
//     */
//
//    private boolean isFirst;//是否是注册
//    private int cityId;
//    private String cityName;
//    private String email;
//    private int equipmentType;
//    private int examTypeId;
//    private String homeAddress;
//    private String mobile;
//    private String password;
//    private int projectId;
//    private int provinceId;
//    private String provinceName;
//    private String regDate;
//    private long registerDate;
//    private int sex;
//    private String userName;
//    private int userid;
//
//    public boolean isFirst() {
//        return isFirst;
//    }
//
//    public void setFirst(boolean first) {
//        isFirst = first;
//    }
//
//    public int getCityId() {
//        return cityId;
//    }
//
//    public void setCityId(int cityId) {
//        this.cityId = cityId;
//    }
//
//    public String getCityName() {
//        return cityName;
//    }
//
//    public void setCityName(String cityName) {
//        this.cityName = cityName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public int getEquipmentType() {
//        return equipmentType;
//    }
//
//    public void setEquipmentType(int equipmentType) {
//        this.equipmentType = equipmentType;
//    }
//
//    public int getExamTypeId() {
//        return examTypeId;
//    }
//
//    public void setExamTypeId(int examTypeId) {
//        this.examTypeId = examTypeId;
//    }
//
//    public String getHomeAddress() {
//        return homeAddress;
//    }
//
//    public void setHomeAddress(String homeAddress) {
//        this.homeAddress = homeAddress;
//    }
//
//    public String getMobile() {
//        return mobile;
//    }
//
//    public void setMobile(String mobile) {
//        this.mobile = mobile;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public int getProjectId() {
//        return projectId;
//    }
//
//    public void setProjectId(int projectId) {
//        this.projectId = projectId;
//    }
//
//    public int getProvinceId() {
//        return provinceId;
//    }
//
//    public void setProvinceId(int provinceId) {
//        this.provinceId = provinceId;
//    }
//
//    public String getProvinceName() {
//        return provinceName;
//    }
//
//    public void setProvinceName(String provinceName) {
//        this.provinceName = provinceName;
//    }
//
//    public String getRegDate() {
//        return regDate;
//    }
//
//    public void setRegDate(String regDate) {
//        this.regDate = regDate;
//    }
//
//    public long getRegisterDate() {
//        return registerDate;
//    }
//
//    public void setRegisterDate(long registerDate) {
//        this.registerDate = registerDate;
//    }
//
//    public int getSex() {
//        return sex;
//    }
//
//    public void setSex(int sex) {
//        this.sex = sex;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public int getUserid() {
//        return userid;
//    }
//
//    public void setUserid(int userid) {
//        this.userid = userid;
//    }


}


