package com.shixue.app.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jjs.Jbase.BaseFragmentActivity;
import com.jjs.Jutils.SysUtils;
import com.jjs.Jview.JtitleView;
import com.shixue.app.APP;
import com.shixue.app.ApiService;
import com.shixue.app.R;
import com.shixue.app.RxSubscribe;
import com.shixue.app.ui.bean.OnlineDetailsResult;
import com.shixue.app.ui.fragment.Online_DetailsFragment;
import com.shixue.app.ui.fragment.Online_ListFragment;
import com.shixue.app.ui.fragment.Online_VideoFragment;
import com.shixue.app.utils.SweetDialog;

import org.simple.eventbus.EventBus;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * 本页：
 * Created by jjs on 2016-12-01.
 */

public class School_Online_DetailsAty extends BaseFragmentActivity {
    @Bind(R.id.img_head)
    ImageView mImgHead;
    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.tv_isVip)
    TextView mTvIsVip;
    @Bind(R.id.fram_school)
    FrameLayout mFramSchool;
    @Bind(R.id.rg_online)
    RadioGroup mRgOnline;
    @Bind(R.id.title)
    JtitleView mTitle;

    int CourseID = -1;//课程id，用于请求课程详情接口
    public OnlineDetailsResult result;//课程详情数据


    SweetDialog mDialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_online);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        SysUtils.setSTATUScolor(this, Color.parseColor("#059B76"));
        init();
    }

    @Override
    protected void init() {
        mTitle.setTitle("课程详情").setLeftListerner(v -> finish()).start();
        mDialog = new SweetDialog(this, SweetDialog.PROGRESS_TYPE).setTitleText("正在加载...");
        mDialog.show();
        CourseID = getIntent().getIntExtra("id", -1);
        if (CourseID < 0) {
            APP.mToast("课程详情查询失败");
            return;
        }
        getCourseList();
        //查询数据
        ((RadioButton) mRgOnline.getChildAt(0)).setChecked(true);


    }

    private void getCourseList() {//获取在线课程详情

        Log.e("Online_DetailsAty", CourseID + "");
        APP.apiService.getOnlineDetails(CourseID, APP.userInfo.getBody().getUser().getMobile())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxSubscribe<OnlineDetailsResult>() {
                    @Override
                    protected void _onNext(OnlineDetailsResult onlineDetailsResult) {

                        Log.e("Online_DetailsAty", "获取课程详情数据成功！");
                        getCourseListOK(onlineDetailsResult);
                        mDialog.cancel();
                    }

                    @Override
                    protected void _onError(String msg) {
                        APP.mToast(msg);
                    }
                });

    }

    private void getCourseListOK(OnlineDetailsResult result) {
        this.result = result;
        Glide.with(School_Online_DetailsAty.this).load(APP.picUrl + result.getCourse().getPictureUrl()).into(mImgHead);
        if (result.getCourse().getChargeType() == 0) {
            mTvIsVip.setText("免费");
            mTvIsVip.setTextColor(Color.parseColor("#059B76"));
            mTvIsVip.setBackgroundResource(R.drawable.shape_line_notvip);
        } else {
            mTvIsVip.setText("会员");
            mTvIsVip.setTextColor(Color.parseColor("#F88437"));
            mTvIsVip.setBackgroundResource(R.drawable.shape_line_isvip);
        }
        mTvTitle.setText(result.getCourse().getCourseName());
        framList.clear();
        //列表，详情，视频
        addAllFragment(R.id.fram_school, new Online_ListFragment(), new Online_DetailsFragment(), new Online_VideoFragment());
        showFragment(0);
        ((RadioButton) mRgOnline.getChildAt(0)).setChecked(true);
        mRgOnline.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == group.getChildAt(0).getId()) {
                showFragment(0);
            } else if (checkedId == group.getChildAt(1).getId()) {
                showFragment(1);
            } else if (checkedId == group.getChildAt(2).getId()) {
                showFragment(2);
            }

          /*  if (checkedId == group.getChildAt(group.getChildCount() - 1).getId()) {
                tvToEval.setVisibility(View.GONE);
                tvAllDown.setVisibility(View.VISIBLE);
                tvAllDelete.setVisibility(View.VISIBLE);
            } else {
                tvToEval.setVisibility(View.VISIBLE);
                tvAllDown.setVisibility(View.GONE);
                tvAllDelete.setVisibility(View.GONE);
            }*/
        });
    }


    @Override
    protected void onResult(int request, Intent data) {

    }
/*
    @OnClick({tv_toEval, R.id.tv_allDown, R.id.tv_allDelete})
    public void onClick(View view) {
        if (APP.userInfo == null) {
            goActivity(LoginAty.class);
            return;
        }
        //需要会员
        if (!APP.isVip) {
            HTTPutils.getUserISvip(APP.userInfo.getMobile(), APP.projectID, b -> {
                if (b) {
                    checkView(view);
                } else {
                    *//**
     * 弹窗提示开通会员
     *//*
                    HTTPutils.showGOvipDialog(School_Online_DetailsAty.this);
                }
            });
        } else {
            checkView(view);
        }

    }

    private void checkView(View view) {
        switch (view.getId()) {
            case R.id.tv_allDown:
                if (tvAllDown.getText().toString().equals("全部下载")) {
                    tvAllDown.setText("全部暂停");
                    EventBus.getDefault().post(true, "allstart");
                } else {
                    tvAllDown.setText("全部下载");
                    EventBus.getDefault().post(true, "allstop");
                }
                break;
            case R.id.tv_allDelete:
                EventBus.getDefault().post(true, "alldelete");
                break;
        }
    }*/
}
