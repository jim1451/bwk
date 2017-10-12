package com.shixue.app.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.jjs.Jbase.BaseActivity;
import com.shixue.app.APP;
import com.shixue.app.R;
import com.shixue.app.contract.LoginContract;
import com.shixue.app.model.LoginModel;
import com.shixue.app.utils.MyTime;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 作者：JJS
 * 日期：2016-11-19
 * QQ：994462623
 * 需要完善APPlication中的 城市和区域id，考试类型和考试方向四种
 */

public class LoginAty extends BaseActivity<LoginModel> implements LoginContract.View {
    @Bind(R.id.edit_phone)
    EditText mEditPhone;
    @Bind(R.id.edit_smsCode)
    EditText mEditSmsCode;
    @Bind(R.id.tv_getSms)
    TextView mTvGetSms;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        init();
    }

    @Override
    protected void init() {
        mModel = new LoginModel(this, this);
        mEditPhone.setText(APP.shared.getString("phone", ""));

    }

    @Override
    protected void onResult(int request, Intent data) {

    }


    @Override
    public void LoginSuccess(String msg) {
        APP.mToast("登陆成功");
        APP.isSMSLogin = true;
        //保存登陆相关信息
        APP.shared.edit().putBoolean("isLogin", true).putString("phone", APP.userInfo.getBody().getUser().getMobile()).commit();
        Intent intent = new Intent(this, MainFragmentActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP//可以关闭它所跳到的界面之外已经开启的activity
                | Intent.FLAG_ACTIVITY_CLEAR_TASK
                | Intent.FLAG_ACTIVITY_NEW_TASK);//设置activity成为历史堆栈上新任务的开始
        startActivity(intent);
        finish();
    }

    @Override
    public void SmsSuccess(String password) {
        APP.mToast("获取验证码成功");
        new MyTime(60000, 1000, mTvGetSms).start();
    }

    @Override
    public void showToast(String msg) {
        APP.mToast(msg);
    }

    @OnClick({R.id.img_back, R.id.tv_getSms, R.id.tv_login, R.id.tv_Agreement})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.tv_getSms:
                if (!mTvGetSms.getText().toString().trim().equals("重新获取") && !mTvGetSms.getText().toString().trim().equals("获取验证码")) {
                    return;
                }
                mModel.sendSMS(mEditPhone.getText().toString().trim());
                break;
            case R.id.tv_login:
                mModel.login(mEditSmsCode.getText().toString().trim(), mEditPhone.getText().toString().trim(), APP.CityID, APP.APP_ID, APP.examType, APP.examName);
                break;
            case R.id.tv_Agreement:
                //协议内容。
                DetailsFragmentAty.goHtmlAty(this, "伴我考客服协议", "serviceAgreement.html");
                break;
            case R.id.tv_try://试用



                break;

        }
    }

}
