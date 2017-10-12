package com.shixue.app.contract;

import com.jjs.Jbase.BaseView;
import com.shixue.app.ui.bean.ExamInfoResult;
import com.shixue.app.ui.bean.NewsResult;

import java.util.List;



/**
 * Created by Administrator on 2016-11-23.
 */

public interface HomeContract {
    interface View extends BaseView {
        void showExamType();
        void showNewsList(List<NewsResult.NewsBean> list);
        void getExamInfoOK(ExamInfoResult.ProjectBean examInfoBean);
        void getNewsOnError();
    }

    interface Model {
        void getExamType();
        void getNews(int pageNo);
        void getExamInfo(int examID);
    }
}
