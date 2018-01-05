package com.shixue.app.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jjs.Jbase.BaseActivity;
import com.jjs.Jutils.RecyclerView.BaseReHolder;
import com.jjs.Jutils.RecyclerView.SingleReAdpt;
import com.shixue.app.APP;
import com.shixue.app.ApiService;
import com.shixue.app.R;
import com.shixue.app.RxSubscribe;
import com.shixue.app.ui.bean.PractiseTestListResult;
import com.shixue.app.ui.bean.PractiseTitleListResult;
import com.shixue.app.utils.HTTPutils;
import com.shixue.app.utils.SweetDialog;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * 本页：
 * Created by jjs on 2016-12-15.
 */

public class PractiseTestAty extends BaseActivity {
    @Bind(R.id.img_pic)
    ImageView mImgPic;
    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.tv_msg)
    TextView mTvMsg;
    @Bind(R.id.tv_isFree)
    TextView mTvIsFree;
    @Bind(R.id.tv_isVip)
    TextView mTvIsVip;
    @Bind(R.id.tv_size)
    TextView mTvSize;
    @Bind(R.id.rg_practiseType)
    RadioGroup mRgPractiseType;
    @Bind(R.id.rv_testList)
    RecyclerView mRvTestList;

    PractiseTitleListResult.SubjectListBean.LibraryListBean titleBean;//标题数据
    PractiseTestListResult testResult;//节参数
    private int exerciseType = 0;//用于判断练题模式
    SweetDialog progess;
    SingleReAdpt reAdpt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practise_test);
        ButterKnife.bind(this);
        init();
    }

    private PractiseTestListResult mPractiseTestListResult;

    @Override
    protected void init() {
        setTitle("题库详情");
        titleBean = (PractiseTitleListResult.SubjectListBean.LibraryListBean) getIntent().getSerializableExtra("bean");
        if (titleBean == null) return;
        progess = new SweetDialog(PractiseTestAty.this, SweetDialog.PROGRESS_TYPE).setTitleText("加载中...");
        progess.show();
        Glide.with(PractiseTestAty.this).load(APP.picUrl + titleBean.getPictureUrl()).into(mImgPic);
        mTvTitle.setText(titleBean.getTestLibraryName());
        mTvMsg.setText(titleBean.getOneWord());
        mTvSize.setText(titleBean.getTestCount() + "张试卷");
        if (titleBean.getChargeType() == 0) {
            mTvIsFree.setVisibility(View.VISIBLE);
        } else {
            mTvIsVip.setVisibility(View.VISIBLE);
        }
        //请求节数据
        APP.apiService.getPractiseTestList(titleBean.getTestLibraryId(), APP.userInfo.getBody().getUser().getMobile())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxSubscribe<PractiseTestListResult>() {
                    @Override
                    protected void _onNext(PractiseTestListResult practiseTestListResult) {
                        mPractiseTestListResult = practiseTestListResult;
                        showTestList(practiseTestListResult);
                        progess.cancel();

                    }

                    @Override
                    protected void _onError(String msg) {
                        APP.mToast(msg);
                        progess.cancel();
                    }
                });
        ((RadioButton) mRgPractiseType.getChildAt(0)).setChecked(true);
        mRgPractiseType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (group.getChildAt(0).getId() == checkedId) {
                    //第一个
                    exerciseType = 0;
                } else if (group.getChildAt(1).getId() == checkedId) {
                    //第二个
                    exerciseType = 1;
                } else if (group.getChildAt(2).getId() == checkedId) {
                    //第三个
                    exerciseType = 2;
                }
            }
        });
    }


    private void showTestList(PractiseTestListResult result) {
        mRvTestList.setLayoutManager(new LinearLayoutManager(PractiseTestAty.this));
        reAdpt = new SingleReAdpt<PractiseTestListResult.TestListBean>(PractiseTestAty.this, R.layout.recycler_practise_test, result.getTestList()) {
            @Override
            protected void BindData(BaseReHolder holder, int position, PractiseTestListResult.TestListBean data) {
                holder.getTV(R.id.item_tv_title).setText(data.getTestName());
                holder.getTV(R.id.item_tv_msg).setText(data.getOneWord());
                if (APP.userInfo == null) {
                    holder.getTV(R.id.item_tv_size).setText("0/" + data.getTestCount());
                } else {
                    holder.getTV(R.id.item_tv_size).setText(APP.shared.getInt(APP.userInfo.getBody().getUser().getUserid() + "-" + data.getTestId(), 0) + "/" + data.getTestCount());
                }
                if (data.getChargeType() == 0) {
                    holder.getView(R.id.item_tv_isFree).setVisibility(View.VISIBLE);
                    holder.getView(R.id.item_tv_isVip).setVisibility(View.GONE);
                    holder.getView(R.id.item_tv_isVipFace).setVisibility(View.GONE);
                } else if (data.getChargeType() == 1) {//笔试
                    holder.getView(R.id.item_tv_isFree).setVisibility(View.GONE);
                    holder.getView(R.id.item_tv_isVip).setVisibility(View.VISIBLE);
                    holder.getView(R.id.item_tv_isVipFace).setVisibility(View.GONE);

                } else if (data.getChargeType() == 2) {//面试
                    holder.getView(R.id.item_tv_isFree).setVisibility(View.GONE);
                    holder.getView(R.id.item_tv_isVip).setVisibility(View.GONE);
                    holder.getView(R.id.item_tv_isVipFace).setVisibility(View.VISIBLE);
                }
            }
        };
        reAdpt.setOnItemClickListener(new SingleReAdpt.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (APP.userInfo == null) {
                    goActivity(LoginAty.class);
                    return;
                }
                int ChargeType = result.getTestList().get(position).getChargeType();
                // 不是免费&& 开通的会员要和节的会员类型一致&& 没开通全部的VIP
                if (ChargeType == 0) {//该课程为免费
                    next(result, position);
                } else {//会员
                    if (APP.singleVip == 0) {//未开通会员
                        HTTPutils.showGOvipDialog(PractiseTestAty.this, "您尚未开通本学段的会员", "开通会员");
                    } else if (APP.singleVip == 1) {//开通了一种 会员
                        if (APP.SingleVipBean.getVipInfoList().get(0).getChargeType() == ChargeType) {//课程会员和开通的会员相对应
                            if (APP.SingleVipBean.getVipInfoList().get(0).getVipStatus() == 2) {//开通的=会员已过期
                                HTTPutils.showGOvipDialog(PractiseTestAty.this, "本学段的会员已过期", "续费");
                            } else {//未过期
                                next(result, position);
                            }
                        } else {//课程会员与开通的会员不对应
                            HTTPutils.showGOvipDialog(PractiseTestAty.this, "您尚未开通本学段的会员", "开通会员");
                        }

                    } else if (APP.singleVip == 2) {//两种会员都开通了
                        for (int i = 0; i < APP.SingleVipBean.getVipInfoList().size(); i++) {//遍历取出与之对应的会员
                            if (APP.SingleVipBean.getVipInfoList().get(i).getChargeType() == ChargeType) {//判断该课程下的会员是否到期了
                                if (APP.SingleVipBean.getVipInfoList().get(i).getVipStatus() == 2) {//会员过期
                                    HTTPutils.showGOvipDialog(PractiseTestAty.this, "本学段的会员已过期", "续费");
                                } else {
                                    next(result, position);
                                }
                            }
                        }
                    }

                }
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
        mRvTestList.setAdapter(reAdpt);
    }

    private void next(PractiseTestListResult result, int position) {

        if (exerciseType == 2) {//真题模拟
            /**
             * html地址好乱
             */
            DetailsFragmentAty.goHtmlAty(PractiseTestAty.this, result.getTestList().get(position).getTestName(), APP.picUrl + result.getTestList().get(position).getTestUrl());

            Log.e("html地址好乱",APP.picUrl + result.getTestList().get(position).getTestUrl());

        } else {
            Intent intent = new Intent(PractiseTestAty.this, Practise_DetailsAty.class);
            intent.putExtra("testId", result.getTestList().get(position).getTestId());//试卷id
            intent.putExtra("ExType", exerciseType);//做题类型
            startActivityForResult(intent, 1);
        }

    }

    @Override
    protected void onResult(int request, Intent data) {
        reAdpt.notifyDataSetChanged();
    }
}
