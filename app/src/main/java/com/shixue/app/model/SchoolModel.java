package com.shixue.app.model;

import android.content.Context;
import android.util.Log;

import com.jjs.Jbase.BaseModel;
import com.shixue.app.APP;
import com.shixue.app.RxSubscribe;
import com.shixue.app.contract.SchoolContract;
import com.shixue.app.ui.bean.LiveDirectResult;
import com.shixue.app.ui.bean.LiveOnlineResult;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 本页：
  */

public class SchoolModel extends BaseModel<SchoolContract.View> implements SchoolContract.Model {

    public SchoolModel(Context context, SchoolContract.View view) {
        super(context, view);
    }

    @Override
    public void getDirectList(int projectId, int examType) {//获取直播列表
        Log.e("SchoolModel", examType + "");

        APP.apiService.getLiveDirectList(1, examType)//代理商projectId固定为1 examType 考试类型
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxSubscribe<LiveDirectResult>() {
                    @Override
                    protected void _onNext(LiveDirectResult liveDirectResult) {
                        mView.showDirect(liveDirectResult.getLiveCourseList());
                    }

                    @Override
                    protected void _onError(String msg) {
                        mView.showToast(msg);
                    }
                });

    }

    @Override
    public void getOnlineList(int projectId, int examTypeId) {
        APP.apiService.getLiveOnlineList(1, examTypeId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxSubscribe<LiveOnlineResult>() {
                    @Override
                    protected void _onNext(LiveOnlineResult liveOnlineResult) {
                        mView.showOnline(liveOnlineResult.getSubjectList());
                    }

                    @Override
                    protected void _onError(String msg) {
                        mView.showToast(msg);
                    }
                });
    }
}
