package com.shixue.app.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;

import com.jjs.Jbase.BaseActivity;
import com.shixue.app.APP;
import com.shixue.app.R;


/**
 * 本页：启动页面
 * Created by jjs on 2016-11-29.
 */

public class StartAty extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setFullscreen(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        init();
    }

    @Override
    protected void init() {
        new Handler().postDelayed(() -> {
           /* if (APP.shared.getBoolean("isFirst", true)) {
                //是否是第一次启动
                goActivity(WelcomeAty.class);
                finish();
            } else {
                goActivity(MainFragmentActivity.class);
                finish();
            }*/
            // 在这里需要判断用户是否已经登陆（若未登陆则跳到登陆界面）
            if (APP.shared.getBoolean("isLogin", false)) {
                goActivity(MainFragmentActivity.class);

            } else {
                goActivity(LoginAty.class);
            }
            finish();
        }, 1000);
        DisplayMetrics dm2 = getResources().getDisplayMetrics();
        APP.windowWidth = dm2.heightPixels;
        APP.windowHeight = dm2.widthPixels;

    }

    @Override
    protected void onResult(int request, Intent data) {

    }
}
