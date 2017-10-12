package com.shixue.app.ui.bean;

/**
 * Created by 刘荣芳 on 2017/9/7.
 * 获取图形验证码
 */

public class GetImgCodeResult {

    /**
     * body : {"mobile":"15374363882","password":"9182"}
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
         * mobile : 15374363882
         * password : 9182
         */

        private String mobile;
        private String password;

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
    }
}
