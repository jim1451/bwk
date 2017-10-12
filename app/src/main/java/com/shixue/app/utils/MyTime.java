package com.shixue.app.utils;

import android.os.CountDownTimer;
import android.widget.TextView;

/**
 * Created by jjs on 2016/10/4.
 */
public class MyTime extends CountDownTimer {
    TextView showView;

    public MyTime(long millisInFuture, long countDownInterval, TextView TimeView) {
        super(millisInFuture, countDownInterval);
        showView = TimeView;
    }

    @Override
    public void onTick(long l) {
        if (showView != null)
            showView.setText(l / 1000 + "秒");
    }

    @Override
    public void onFinish() {
        if (showView != null) {
            showView.setText("重新获取");
        }
    }
}
