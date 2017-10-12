package com.shixue.app.contract;

import com.jjs.Jbase.BaseView;
import com.shixue.app.ui.bean.LiveDirectResult;
import com.shixue.app.ui.bean.LiveOnlineResult;

import java.util.List;


/**
 * 本页：
 * Created by jjs on 2016-11-25.
 */

public interface SchoolContract {
    interface View extends BaseView {
        void showDirect(List<LiveDirectResult.LiveDirectBean> directList);

        void showOnline(List<LiveOnlineResult.SubjectListBean> subjList);

    }

    interface Model {
        //项目编号：projectId ,二级分类
        void getDirectList(int projectId, int examType);

        //项目编号：projectId,考试类型id：examTypeId
        void getOnlineList(int examTypeId, int projectId);
    }

}
