package com.shixue.app.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jjs.Jbase.BaseFragment;
import com.jjs.Jutils.RecyclerView.BaseReHolder;
import com.jjs.Jutils.RecyclerView.SingleReAdpt;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.shixue.app.APP;
import com.shixue.app.ApiService;
import com.shixue.app.R;
import com.shixue.app.RxSubscribe;
import com.shixue.app.contract.HomeContract;
import com.shixue.app.model.HomeModel;
import com.shixue.app.ui.activity.DetailsFragmentAty;
import com.shixue.app.ui.bean.AboutUsResult2;
import com.shixue.app.ui.bean.ExamInfoResult;
import com.shixue.app.ui.bean.ExamTypeResult;
import com.shixue.app.ui.bean.NewsResult;
import com.shixue.app.ui.bean.VersionBean;
import com.shixue.app.utils.SweetDialog;
import com.shixue.app.utils.WXshpaeDialog;
import com.shixue.app.widget.MyScrollview;
import com.zhy.autolayout.AutoLinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by Administrator on 2016-11-22.
 */

public class HomeFragment extends BaseFragment<HomeModel> implements HomeContract.View {
    @Bind(R.id.rv_examType)
    RecyclerView mRvExamType;
    @Bind(R.id.rv_notice)
    RecyclerView mRvNotice;
    @Bind(R.id.ll_home_top_more)
    AutoLinearLayout mLlHomeTopMore;
    @Bind(R.id.img_home_top_gdck)
    ImageView mImgHomeTopGdck;
    @Bind(R.id.img_home_top_gdzk)
    ImageView mImgHomeTopGdzk;

    List<NewsResult.NewsBean> newsList = new ArrayList<>();
    int pageNo = 1;
    SingleReAdpt newsAdpt;
    boolean isLoadingMore = true;
    @Bind(R.id.scroll)
    MyScrollview mScroll;
    List<ExamTypeResult.ProjTypeListBean.ExamTypeBean> HomeExamShowList = new ArrayList<>();//首页显示项目
    SingleReAdpt examReAdpt;
    int oneCheck = 0;//一级选中
    SweetDialog progess;
    @Bind(R.id.smartRefresh)
    SmartRefreshLayout smartRefresh;


    @Override
    protected void onCreat() {
        setContentView(R.layout.fragment_home);

    }

    @Override
    public void init() {
        smartRefresh.setEnableLoadmore(false);
        smartRefresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                smartRefresh.finishRefresh(2000);
                init();
            }
        });
        mModel = new HomeModel(getActivity(), this);
//        if (APP.APP_ID == 10) {
//            //广东成人高考
//            mLlHomeTopMore.setVisibility(View.GONE);
//            mImgHomeTopGdck.setVisibility(View.VISIBLE);
//            mImgHomeTopGdzk.setVisibility(View.GONE);
//        } else if (APP.APP_ID == 11) {
//            //广东自学考试
//            mLlHomeTopMore.setVisibility(View.GONE);
//            mImgHomeTopGdck.setVisibility(View.GONE);
//            mImgHomeTopGdzk.setVisibility(View.VISIBLE);
//        } else {//代理商
        mLlHomeTopMore.setVisibility(View.VISIBLE);
        mImgHomeTopGdck.setVisibility(View.GONE);
        mImgHomeTopGdzk.setVisibility(View.VISIBLE);
        //更换首页广告方法、
        if (APP.userInfo != null) {
            APP.apiService.getAboutUsResult(APP.userInfo.getBody().getUser().getMobile()).subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread()).subscribe(new RxSubscribe<AboutUsResult2>() {
                @Override
                protected void _onNext(AboutUsResult2 aboutUsResult2) {
                    Glide.with(getActivity()).load(APP.picUrl + aboutUsResult2.getAgent().getAgentIcon()).placeholder(R.drawable.home_teach_img).into(mImgHomeTopGdzk);
                }

                @Override
                protected void _onError(String msg) {

                }
            });
        }
        //修改用户版本
        if (APP.userInfo != null) {
            APP.apiService.getUpdataVersionbean(APP.userInfo.getBody().getUser().getMobile(), 0, android.os.Build.MODEL, android.os.Build.VERSION.RELEASE, APP.versionName).subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread()).subscribe(new RxSubscribe<VersionBean>() {
                @Override
                protected void _onNext(VersionBean versionBean) {
                    Log.e("VersionBean", "更新版本成功");
                }

                @Override
                protected void _onError(String msg) {

                }
            });
        }


//        }
        /**
         * 获取首页项目列表
         * */
//        mRvExamType.setLayoutManager(new GridLayoutManager(getActivity(), 4));
//        examReAdpt = new SingleReAdpt<ExamTypeResult.ProjTypeListBean.ExamTypeBean>(getActivity(), R.layout.recycler_home_examtype, HomeExamShowList) {
//            @Override
//            protected void BindData(BaseReHolder holder, int position, ExamTypeResult.ProjTypeListBean.ExamTypeBean data) {
//                if (position == HomeExamShowList.size() - 1) {
//                    holder.getImgV(R.id.item_img).setSrc(R.drawable.home_icon_suoyou);
//                    holder.getTV(R.id.item_name).setText("所有");
//                } else {
//                    Glide.with(getActivity()).load(ApiService.picUrl + data.getProjectPicture()).into(holder.getImageView(R.id.item_img));
//                    holder.getTV(R.id.item_name).setText(data.getProjectName());
//                }
//                if (APP.projectID == HomeExamShowList.get(position).getProjectId()) {
//                    holder.getImgV(R.id.item_check).setVisible(BaseReHolder.V.VISIBLE);
//                } else {
//                    holder.getImgV(R.id.item_check).setVisible(BaseReHolder.V.GONE);
//                }
//            }
//        };
//        examReAdpt.setOnItemClickListener(new SingleReAdpt.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//
//                if (position == HomeExamShowList.size() - 1) {
//                    //跳转页面
//                    goActivity(ExamTypeMoreAty.class);
//                } else {
//                    if (APP.userInfo == null) {
//                        goActivity(LoginAty.class);
//                        return;
//                    }
//                    oneCheck = position;
//                    //弹窗提示
//                    MyDialog dialog = new MyDialog(getActivity());
//                    dialog.setTypeNOMAL()
//                            .setTitleTxt(HomeExamShowList.get(position).getProjectName())
//                            .setMessageTxt("确定切换\"" + HomeExamShowList.get(position).getProjectName() + "\"这个项目？切换后平台整体内容都会跟着更换")
//                            .setCheckTxt("启用项目", myDialog -> {
//
//                                mModel.getExamInfo(HomeExamShowList.get(position).getProjectId());
//                                progess = new SweetDialog(getActivity(), SweetDialog.PROGRESS_TYPE).setTitleText("加载中...");
//                                progess.show();
//
//
//                                myDialog.cancel();
//                            })
//                            .setCancelable(false).show();
//                }
//            }
//
//            @Override
//            public void onItemLongClick(View view, int position) {
//
//            }
//        });
//        mRvExamType.addItemDecoration(new ReItemDivider(getActivity(), getActivity().getResources().getColor(R.color.colorLine), ReItemDivider.Orientation.VERTICAL));
//        mRvExamType.setAdapter(examReAdpt);
//        if (APP.examTypeList == null) {
//            mModel.getExamType();
//        } else {
//            showExamType();
//        }

        //新闻
        newsAdpt = new SingleReAdpt<NewsResult.NewsBean>(getActivity(), R.layout.recycler_home_news, newsList) {
            @Override
            protected void BindData(BaseReHolder holder, int position, NewsResult.NewsBean data) {

                if (newsList.get(position).getWeixinRemark() != null && newsList.get(position).getWeixinRemark().length() > 0 && newsList.get(position).getWeixinCode() != null && newsList.get(position).getWeixinCode().length() > 0) {
                    Glide.with(getActivity()).load(R.drawable.huodong_img_weixin).into(holder.getImageView(R.id.item_img));
                } else {
//                    .placeholder(R.drawable.huodong_img_kecheng)
                    Glide.with(getActivity()).load(APP.picUrl + data.getImageUrl()).placeholder(R.drawable.huodong_img_kecheng).into(holder.getImageView(R.id.item_img));
                    Log.e("newsAdpt", APP.picUrl + data.getImageUrl());

                }
                holder.getTV(R.id.item_title).setText(data.getMsgName());
                holder.getTV(R.id.item_msg).setText(data.getOneWord());
            }
        };
        newsAdpt.setOnItemClickListener(new SingleReAdpt.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (newsList.get(position).getWeixinRemark() != null && newsList.get(position).getWeixinRemark().length() > 0 && newsList.get(position).getWeixinCode() != null && newsList.get(position).getWeixinCode().length() > 0) {
                    new WXshpaeDialog(getActivity()).show(newsList.get(position).getOneWord(), newsList.get(position).getWeixinRemark(), newsList.get(position).getWeixinCode());
                } else {

                    Log.e("newsList", newsList.get(position).getOneWord() + "   " + newsList.get(position).getMsgContentUrl());
                    DetailsFragmentAty.goHtmlAty(getActivity(), newsList.get(position).getOneWord(), newsList.get(position).getMsgContentUrl());
                }
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });

        mRvNotice.setLayoutManager(new LinearLayoutManager(getActivity()));
        //  mRvNotice.addItemDecoration(new ReItemDivider(getActivity(), getActivity().getResources().getColor(R.color.colorLine), ReItemDivider.Orientation.VERTICAL).setMargin(85, 0, 0, 0));
        mRvNotice.setAdapter(newsAdpt);
        mModel.getNews(pageNo);
        mScroll.setScrollEndListener(() -> {
            pageNo++;
            mModel.getNews(pageNo);
        });
    }

    @Override
    public void showExamType() {
//        HomeExamShowList.clear();
//        for (int i = 0; i < APP.examTypeList.size(); i++) {
//            for (int j = 0; j < APP.examTypeList.get(i).getProjectList().size(); j++) {
//                if (HomeExamShowList.size() == 7) break;
//                HomeExamShowList.add(APP.examTypeList.get(i).getProjectList().get(j));
//            }
//        }
//        HomeExamShowList.add(new ExamTypeResult.ProjTypeListBean.ExamTypeBean());
//        examReAdpt.setData(HomeExamShowList);
    }

    @Override
    public void showNewsList(List<NewsResult.NewsBean> list) {//显示新闻消息列表

        if (pageNo == 1) {
            newsList = list;
        } else {
            for (int i = 0; i < list.size(); i++) {
                newsList.add(list.get(i));
            }
        }
        newsAdpt.setData(newsList);
        isLoadingMore = true;
    }

    @Override
    public void getExamInfoOK(ExamInfoResult.ProjectBean examInfoBean) {//获得启动列表成功,框弹出失败不走这里

//        Log.e("myDialog__", "getExamInfoOK111");
//        if (progess != null) {
//            progess.cancel();
//        }
//        HTTPutils.showExamListDialog(getActivity(), HomeExamShowList.get(oneCheck).getProjectName(), examInfoBean.getExamTypeList(), myDialog -> {
//            Log.e("myDialog__", "getExamInfoOK222");
//
//            APP.examInfoBean = examInfoBean;
//        });

    }

    @Override
    public void getNewsOnError() {
        pageNo--;
    }

    @Override
    public void showToast(String msg) {
        if (progess != null) {
            progess.cancel();
        }
        Log.e("error", msg);
        APP.mToast(msg);
    }

    @Override
    protected void onResult(int request, Intent data) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
