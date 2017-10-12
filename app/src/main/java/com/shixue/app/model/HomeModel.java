package com.shixue.app.model;

import android.content.Context;
import android.util.Log;

import com.jjs.Jbase.BaseModel;
import com.jjs.Jutils.ToastUtils;
import com.shixue.app.APP;
import com.shixue.app.RxSubscribe;
import com.shixue.app.contract.HomeContract;
import com.shixue.app.ui.bean.ExamInfoResult;
import com.shixue.app.ui.bean.NewsResult;
import com.shixue.app.utils.HTTPutils;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016-11-23.
 */

public class HomeModel extends BaseModel<HomeContract.View> implements HomeContract.Model {
    public HomeModel(Context context, HomeContract.View view) {
        super(context, view);
    }

    @Override
    public void getExamType() {//获取项目分类
//        HTTPutils.getExamTypeList(new HTTPutils.OnTaskClick() {
//            @Override
//            public void onSuccess(Object o) {
//                mView.showExamType();
//            }
//
//            @Override
//            public void onError(String ex) {
//                mView.showToast(ex);
//            }
//        });

    }

    @Override
    public void getNews(int pageNo) {
        //1.10修改，原有默认全国的，现在省份查询
        // 代理商的 APP.projectID 项目id 固定为1
        APP.apiService.getNews(pageNo, 10, 1, /*APP.ProvinceID*/APP.userInfo.getBody().getUser().getMobile())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxSubscribe<NewsResult>() {
                    @Override
                    protected void _onNext(NewsResult newsResult) {
                        Log.e("news", "获取新闻消息成功");

                        if (newsResult.getNewList().size() > 0) {
                            mView.showNewsList(newsResult.getNewList());
                        } else {
                            mView.getNewsOnError();
                        }
                    }

                    @Override
                    protected void _onError(String msg) {
                        Log.e("news", msg);
                        mView.showToast(msg);
                        mView.getNewsOnError();
                    }
                });
    }

    @Override
    public void getExamInfo(int examID) {//根据项目id 获取项目二级菜单
//        HTTPutils.getExamInfo(examID, new HTTPutils.OnTaskClick<ExamInfoResult.ProjectBean>() {
//            @Override
//            public void onSuccess(ExamInfoResult.ProjectBean projectBean) {
//                mView.getExamInfoOK(projectBean);
//            }
//
//            @Override
//            public void onError(String ex) {
//                mView.showToast(ex);
//            }
//        });
    }
}
