package com.shixue.app.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jjs.Jbase.BaseActivity;
import com.jjs.Jutils.RecyclerView.DataHolder;
import com.jjs.Jutils.RecyclerView.LayoutWrapper;
import com.jjs.Jutils.RecyclerView.ReItemDivider;
import com.jjs.Jutils.RecyclerView.SingleReAdpt;
import com.jjs.Jutils.RecyclerView.SuperAdapter;
import com.shixue.app.APP;
import com.shixue.app.ApiService;
import com.shixue.app.R;
import com.shixue.app.ui.bean.ExamInfoResult;
import com.shixue.app.ui.bean.ExamTypeResult;
import com.shixue.app.utils.HTTPutils;
import com.shixue.app.utils.MyDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;



/**
 * 本页：
 * Created by jjs on 2016-11-25.
 */

public class ExamTypeMoreAty extends BaseActivity {
    @Bind(R.id.rv_examtype_more)
    RecyclerView mRvExamtypeMore;

    List<LayoutWrapper> wrapperList;//数据源
    int oneCheck;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examtype_more);
        ButterKnife.bind(this);
        init();
    }

    @Override
    protected void init() {
        setTitle("所有项目");
        if (APP.examTypeList != null && APP.examTypeList.size() > 0) {
            shwoExmTypeMore();
        } else {
            HTTPutils.getExamTypeList(new HTTPutils.OnTaskClick() {
                @Override
                public void onSuccess(Object o) {
                    shwoExmTypeMore();
                }

                @Override
                public void onError(String ex) {
                    APP.mToast(ex);
                }
            });
        }
    }

    private void shwoExmTypeMore() {
        DataHolder<String> titleHolder = (context, holder, item, position) -> {
            TextView view = holder.getView(R.id.item_title);
            view.setText(item);
        };
        DataHolder<ExamTypeResult.ProjTypeListBean.ExamTypeBean> dataHolder = (context, holder, item, position) -> {
            TextView view = holder.getView(R.id.item_name);
            view.setText(item.getProjectName());
            ImageView img = holder.getView(R.id.item_img);
            Glide.with(ExamTypeMoreAty.this).load(APP.picUrl + ((ExamTypeResult.ProjTypeListBean.ExamTypeBean) wrapperList.get(position).getData()).getProjectPicture()).into(img);

            if (APP.projectID == ((ExamTypeResult.ProjTypeListBean.ExamTypeBean) wrapperList.get(position).getData()).getProjectId()) {
                holder.getView(R.id.item_check).setVisibility(View.VISIBLE);
            } else {
                holder.getView(R.id.item_check).setVisibility(View.GONE);
            }
        };
        int[] layoutIds = new int[]{R.layout.recycler_item_title, R.layout.recycler_home_examtype};
        wrapperList = new ArrayList<>();
        for (int i = 0; i < APP.examTypeList.size(); i++) {
            if (APP.examTypeList.get(i).getProjectList().size() > 0) {
                wrapperList.add(new LayoutWrapper(layoutIds[0], 4, APP.examTypeList.get(i).getProjectTypeName(), titleHolder));
                for (int j = 0; j < APP.examTypeList.get(i).getProjectList().size(); j++) {
                    wrapperList.add(new LayoutWrapper(layoutIds[1], 1, APP.examTypeList.get(i).getProjectList().get(j), dataHolder));
                }
            }
        }
        GridLayoutManager manager = new GridLayoutManager(this, 4);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return wrapperList.get(position).getSpanSize();
            }
        });
        mRvExamtypeMore.setLayoutManager(manager);
         mRvExamtypeMore.addItemDecoration(new ReItemDivider(ExamTypeMoreAty.this, ExamTypeMoreAty.this.getResources().getColor(R.color.colorLine), ReItemDivider.Orientation.VERTICAL));
        SuperAdapter superAdapter = new SuperAdapter(this, layoutIds);
        mRvExamtypeMore.setAdapter(superAdapter);
        superAdapter.setData(wrapperList);
        superAdapter.setOnItemClickListener(new SingleReAdpt.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                oneCheck = position;
                if (APP.userInfo == null) {
                    goActivity(LoginAty.class);
                    return;
                }
                if (wrapperList.get(position).getLayoutId() == layoutIds[1]) {
                    ExamTypeResult.ProjTypeListBean.ExamTypeBean bean = ((ExamTypeResult.ProjTypeListBean.ExamTypeBean) wrapperList.get(position).getData());
                    new MyDialog(ExamTypeMoreAty.this)
                            .setTypeNOMAL()
                            .setTitleTxt(bean.getProjectName())
                            .setMessageTxt("确定切换\"" + bean.getProjectName() + "\"这个项目？切换后平台整体内容都会跟着更换")
                            .setCheckTxt("启用项目", myDialog -> {
                                getExamInfo(bean.getProjectId());
                                myDialog.cancel();
                            })
                            .setCancelable(false).show();
                }
            }


            @Override
            public void onItemLongClick(View view, int position) {

            }
        });

    }

    public void getExamInfo(int examID) {
        HTTPutils.getExamInfo(examID, new HTTPutils.OnTaskClick<ExamInfoResult.ProjectBean>() {
            @Override
            public void onSuccess(ExamInfoResult.ProjectBean projectBean) {
                HTTPutils.showExamListDialog(ExamTypeMoreAty.this, ((ExamTypeResult.ProjTypeListBean.ExamTypeBean) wrapperList.get(oneCheck).getData()).getProjectName(), projectBean.getExamTypeList(), myDialog -> {
                    APP.examInfoBean = projectBean;
                });

            }

            @Override
            public void onError(String ex) {
                APP.mToast(ex);
            }
        });
    }

    @Override
    protected void onResult(int request, Intent data) {

    }

}
