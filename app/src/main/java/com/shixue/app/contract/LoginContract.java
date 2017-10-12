package com.shixue.app.contract;

import com.jjs.Jbase.BaseView;

/**
 * 作者：JJS
 * 日期：2016-11-19
 * QQ：994462623
 */

public interface LoginContract {
    interface View extends BaseView {
        void LoginSuccess(String msg);
        void SmsSuccess(String password);
    }
    interface Model {
        void login(String smsCode,String phone, int cityID, int provinceID, int examType, String examDirection);

        void sendSMS(String phone);
    }
}
