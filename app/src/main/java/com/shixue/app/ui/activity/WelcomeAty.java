package com.shixue.app.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.jjs.Jbase.BaseActivity;
import com.jjs.Jview.JviewPager;
import com.shixue.app.APP;
import com.shixue.app.R;
import com.shixue.app.contract.WelcomeContract;
import com.shixue.app.model.WelcomeModel;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 作者：刘荣芳
 * QQ：3236037401
 */

public class WelcomeAty extends BaseActivity<WelcomeModel> implements WelcomeContract.View {

    @Bind(R.id.jvp)
    JviewPager jvp;
    @Bind(R.id.tv_toLogin)
    TextView tvToLogin;

    int[] wels = new int[]{R.drawable.pic_welpager1, R.drawable.pic_welpager2, R.drawable.pic_welpager3};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setFullscreen(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        init();
        APP.getWindowInfo(this);
    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        mModel.getWindowDisplay();
    }

    @Override
    protected void init() {
        mModel = new WelcomeModel(this, this);

        mModel.addPagerImages(jvp, wels);
        jvp.setOnPagerChangeListener((position, positionOffset, positionOffsetPixels) -> {
            if (position == wels.length - 1) {
                tvToLogin.setVisibility(View.VISIBLE);
            } else {
                tvToLogin.setVisibility(View.GONE);
            }
        });
    }


    @Override
    protected void onResult(int request, Intent data) {

    }

    @OnClick(R.id.tv_toLogin)
    public void onClick() {
        APP.shared.edit().putBoolean("isFirst", false).commit();
        goActivity(MainFragmentActivity.class);
        finish();
    }

}
