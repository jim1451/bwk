package com.shixue.app.model;


import android.content.Context;
import android.util.Log;

import com.jjs.Jbase.BaseModel;
import com.shixue.app.APP;
import com.shixue.app.RxSubscribe;
import com.shixue.app.contract.LoginContract;
import com.shixue.app.ui.bean.GetImgCodeResult;
import com.shixue.app.ui.bean.SmsBean;
import com.shixue.app.utils.HTTPutils;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 作者：JJS
 * 日期：2016-11-19
 * QQ：994462623
 */

public class LoginModel extends BaseModel<LoginContract.View> implements LoginContract.Model {

    public LoginModel(Context context, LoginContract.View view) {
        super(context, view);
    }

    @Override
    public void login(String smsCode, final String phone, int cityID, int provinceID, int examType, String examDirection) {
        if (!APP.isDebug) {
            if (phone.length() != 11) {
                mView.showToast("请输入11位数手机号");
                return;
            }
            if (smsCode.length() != 6) {
                mView.showToast("请输入6位数验证码");
                return;
            }
            if (APP.shared.getLong(phone + "smsTime", 0) != 0 && System.currentTimeMillis() - APP.shared.getLong(phone + "smsTime", 0) > (1000 * 60 * 5)) {//验证码过期的判断
                mView.showToast("验证码已过期,请重新发送");
                return;
            }
            if (!smsCode.equals(APP.shared.getString(phone + "smsCode", ""))) {
                mView.showToast("验证码错误");
                return;
            }
        }
        HTTPutils.login(phone, new HTTPutils.OnTaskClick() {
            @Override
            public void onSuccess(Object o) {
                mView.LoginSuccess("登陆成功");
            }

            @Override
            public void onError(String ex) {
                Log.e("error", ex);

                mView.showToast(ex);
            }
        });
    }


    @Override
    public void sendSMS(final String phone) {

        if (phone.length() != 11) {
            mView.showToast("请输入11位数手机号");
            return;
        }
        APP.apiService.getImgCodeSMS(phone).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new RxSubscribe<GetImgCodeResult.BodyBean>() {
            @Override
            protected void _onNext(GetImgCodeResult.BodyBean bodyBean) {

                APP.apiService.getSMS(phone, bodyBean.getPassword())
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new RxSubscribe<SmsBean>() {
                            @Override
                            protected void _onNext(SmsBean smsBean) {
                                mView.SmsSuccess(smsBean.getPassword());
                                APP.shared.edit().putLong(phone + "smsTime", System.currentTimeMillis()).commit();
                                APP.shared.edit().putString(phone + "smsCode", smsBean.getPassword()).commit();
                            }

                            @Override
                            protected void _onError(String msg) {
                                mView.showToast(msg);
                            }
                        });
            }

            @Override
            protected void _onError(String msg) {

            }
        });


    }
}
