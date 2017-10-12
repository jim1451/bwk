package com.shixue.app.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.jjs.Jbase.BaseActivity;
import com.jjs.Jview.JtitleView;
import com.shixue.app.APP;
import com.shixue.app.R;
import com.shixue.app.contract.PersonalDetailsContract;
import com.shixue.app.model.PersonalDetailsModel;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cz.msebera.android.httpclient.util.TextUtils;


/**
 * 本页：
 * Created by jjs on 2016-11-25.
 */

public class PersonalDetailsAty extends BaseActivity<PersonalDetailsModel> implements PersonalDetailsContract.View {
    @Bind(R.id.title)
    JtitleView mTitle;
    @Bind(R.id.edit_name)
    EditText mEditName;
    @Bind(R.id.edit_email)
    EditText mEditEmail;
    @Bind(R.id.edit_address)
    EditText mEditAddress;
    @Bind(R.id.edit_mobile)
    TextView mEditMobile;
    @Bind(R.id.tv_sex_man)
    TextView mTvSexMan;
    @Bind(R.id.tv_sex_woman)
    TextView mTvSexWoman;

    int sex;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);
        ButterKnife.bind(this);
        init();
    }

    @Override
    protected void init() {
        mModel = new PersonalDetailsModel(this, this);
        setTitle("个人信息");
        if (APP.userInfo != null) {
            if (!TextUtils.isEmpty(APP.userInfo.getBody().getUser().getUserName())) {
                mEditName.setText(APP.userInfo.getBody().getUser().getUserName());
            }
            if (!TextUtils.isEmpty(APP.userInfo.getBody().getUser().getEmail())) {
                mEditEmail.setText(APP.userInfo.getBody().getUser().getEmail());
            }
            if (!TextUtils.isEmpty(APP.userInfo.getBody().getUser().getHomeAddress())) {
                mEditAddress.setText(APP.userInfo.getBody().getUser().getHomeAddress());
            }
            if (!TextUtils.isEmpty(APP.userInfo.getBody().getUser().getMobile())) {
                mEditMobile.setText(APP.userInfo.getBody().getUser().getMobile());
            }
            if (APP.userInfo.getBody().getUser().getSex() == 0) {
                mTvSexMan.setSelected(true);
                sex = 0;
            } else {
                mTvSexWoman.setSelected(true);
                sex = 1;
            }
        }
    }

    @Override
    protected void onResult(int request, Intent data) {

    }

    @Override
    public void showToast(String msg) {
        APP.mToast(msg);
    }

    @Override
    public void saveUserOK() {
        setResult(ResultOK);
        APP.mToast("保存成功");
        finish();
    }


    @OnClick({R.id.tv_sex_man, R.id.tv_sex_woman, R.id.tv_saveUser})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_sex_man:
                mTvSexMan.setSelected(true);
                mTvSexWoman.setSelected(false);
                sex = 0;
                break;
            case R.id.tv_sex_woman:
                mTvSexMan.setSelected(false);
                mTvSexWoman.setSelected(true);
                sex = 1;
                break;
            case R.id.tv_saveUser:
                mModel.saveUserData(mEditName.getText().toString().trim(), sex, mEditEmail.getText().toString().trim(), mEditAddress.getText().toString().trim(), mEditMobile.getText().toString().trim());
                break;
        }
    }
}
