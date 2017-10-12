package com.shixue.app;


import android.util.Log;

import com.shixue.app.ui.bean.RxResult;

import rx.Subscriber;

/**
 * Created by Administrator on 2016/10/19.
 */
public abstract class RxSubscribe<T> extends Subscriber<RxResult<T>> {


    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        // L.e("走了错误方法");
        if (!APP.hasNetwork()) {
            _onError("网络不可用");
        } else if (e instanceof Exception) {
            Log.e("eee", "数据错误");
            _onError(e.getMessage());
        } else {
            _onError("没有加载到数据哦");
        }
    }

    @Override
    public void onNext(RxResult<T> result) {
        Log.e("eee---", result.toString());
        if (result.isSuccess()) {
            _onNext(result.getBody());
        } else {
            _onError(result.getMsg());
        }
    }

    protected abstract void _onNext(T t);

    protected abstract void _onError(String msg);
}
