package com.shixue.app.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jjs.Jbase.BaseActivity;
import com.jjs.Jutils.RecyclerView.BaseReHolder;
import com.jjs.Jutils.RecyclerView.SingleReAdpt;
import com.shixue.app.APP;
import com.shixue.app.ApiService;
import com.shixue.app.R;
import com.shixue.app.RxSubscribe;
import com.shixue.app.ui.bean.DirectDetailsResult;
import com.shixue.app.ui.bean.LiveDirectResult;
import com.shixue.app.ui.bean.SingleVipResult;
import com.shixue.app.ui.bean.SysTimeResult;
import com.shixue.app.utils.HTTPutils;
import com.shixue.app.utils.L;
import com.shixue.app.utils.WXshpaeDialog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * 本页：
 * Created by jjs on 2016-12-01.
 * 直播详情页
 */

public class School_DirectDetailsAty extends BaseActivity {
    @Bind(R.id.img_topBG)
    ImageView mImgTopBG;
    @Bind(R.id.tv_toVideo)
    TextView mTvToVideo;
    @Bind(R.id.rBtn_details)
    RadioButton mRBtnDetails;
    @Bind(R.id.rBtn_list)
    RadioButton mRBtnList;
    @Bind(R.id.tv_course)
    TextView mTvCourse;
    //  @Bind(R.id.tv_teacher)
    //   TextView mTvTeacher;
    @Bind(R.id.ll_details)
    LinearLayout mLlDetails;
    @Bind(R.id.rv_list)
    RecyclerView mRvList;
    @Bind(R.id.tv_price)
    TextView mTvPrice;
    @Bind(R.id.tv_toSign)
    TextView mTvToSign;
    @Bind(R.id.ll_price)
    LinearLayout mLiPrice;
    @Bind(R.id.ll_top_toSign)
    LinearLayout mLiTopToSign;

    /**
     * 讲师介绍取消
     */
    LiveDirectResult.LiveCourseListBean mDirectBean;//直播详情
    DirectDetailsResult directDetailsResult;//节列表详情
    SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    int isPlayType = -1;
    long nowTime;
    boolean hasRead = true;//是否报名能够阅读
    private int vipStatus = 0;// 0 不是会员 1 是会员 2 会员已过期
    private int chargeType = 0;
    private boolean isRechange = false;//是否需要续费Vip

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direct_details);
        ButterKnife.bind(this);
        mDirectBean = (LiveDirectResult.LiveCourseListBean) getIntent().getSerializableExtra("bean");
        chargeType = mDirectBean.getChargeType();
        checkIsVip();
    }

    //先获取判断是不是Vip会员
    private void checkIsVip() {
        APP.apiService.getSingleVipResult("1", APP.userInfo.getBody().getUser().getMobile(), APP.examType + "").subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new RxSubscribe<SingleVipResult>() {
            @Override
            protected void _onNext(SingleVipResult singleVipResult) {
                if (chargeType == 0) {//免费
                    hasRead = true;
                } else {//会员
                    if (APP.singleVip == 0) {//未开通会员
                        hasRead = false;
                    } else if (APP.singleVip == 1) {//开通了一种 会员
                        if (APP.SingleVipBean.getVipInfoList().get(0).getChargeType() == chargeType) {//课程会员和开通的会员相对应
                            if (APP.SingleVipBean.getVipInfoList().get(0).getVipStatus() == 2) {//开通的=会员已过期
                                isRechange = true;//续费
                            } else {//未过期
                                hasRead = true;
                            }
                        } else {//课程会员与开通的会员不对应
                            hasRead = false;
                        }

                    } else if (APP.singleVip == 2) {//两种会员都开通了
                        for (int i = 0; i < APP.SingleVipBean.getVipInfoList().size(); i++) {//遍历取出与之对应的会员
                            if (APP.SingleVipBean.getVipInfoList().get(i).getChargeType() == chargeType) {//判断该课程下的会员是否到期了
                                if (APP.SingleVipBean.getVipInfoList().get(i).getVipStatus() == 2) {//会员过期
                                    isRechange = true;
                                } else {
                                    hasRead = true;
                                }
                            }
                        }
                    }


                }


                if (singleVipResult.getVipInfoList() == null || singleVipResult.getVipInfoList().size() == 0) {//未开通会员
                    hasRead = false;
                } else if (singleVipResult.getVipInfoList().size() == 1) {//只开通了其中的一种 会员
                    vipStatus = singleVipResult.getVipInfoList().get(0).getVipStatus();
                    if (chargeType == singleVipResult.getVipInfoList().get(0).getChargeType()) {
                        hasRead = true;
                    } else {
                        hasRead = false;
                    }
                } else if (singleVipResult.getVipInfoList().size() == 2) {//两种会员都开通了
                    hasRead = true;


                }
                if (chargeType == 0) {//课程为免费 都可以进行光看
                    hasRead = true;
                }
                Log.e("hasRead", hasRead + " " + chargeType);
                init();
            }

            @Override
            protected void _onError(String msg) {
                Log.e("checkIsVip", "获取单个Vip会员详情失败");
            }
        });

    }


    @Override
    protected void init() {
        setTitle("直播详情");
        if (mDirectBean == null) return;
        if (mDirectBean.getPrice() > 0) {
            mTvPrice.setText("￥" + mDirectBean.getPrice());
        } else {
            mTvPrice.setText("免费");
        }
        setCheck(1);
        if (mDirectBean.getPictureUrl() != null && mDirectBean.getPictureUrl().length() > 0) {
            Glide.with(School_DirectDetailsAty.this).load(APP.picUrl + mDirectBean.getPictureUrl()).into(mImgTopBG);
        } else {
            if (mDirectBean.getPrice() > 0) {
                Glide.with(School_DirectDetailsAty.this).load(R.drawable.zhibo_img_vip).into(mImgTopBG);

            } else {
                Glide.with(School_DirectDetailsAty.this).load(R.drawable.zhibo_img_free).into(mImgTopBG);

            }
        }
        mTvCourse.setText(mDirectBean.getIntroduce());
        // mTvTeacher.setText("数据为空！！！！！！取消");
        //是否正在直播
      /*  if (mDirectBean.getEffective() == 1) {
            mTvToVideo.setVisibility(View.VISIBLE);
        } else {
            mTvToVideo.setVisibility(View.GONE);
        }*/
        ///需要调接口再次判断是否报名了
        if (APP.userInfo == null) {//还未报名
            Log.e("School_DirectDetailsAty", "1111");
            mLiTopToSign.setVisibility(View.VISIBLE);
            mTvToVideo.setVisibility(View.GONE);
            mLiPrice.setVisibility(View.GONE);
            APP.apiService.getDirectDetails(mDirectBean.getLiveCourseId(), APP.userInfo.getBody().getUser().getMobile())
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new RxSubscribe<DirectDetailsResult>() {
                        @Override
                        protected void _onNext(DirectDetailsResult directDetailsResult) {
                            APP.apiService.getSysTime("")
                                    .subscribeOn(Schedulers.newThread())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribe(new RxSubscribe<SysTimeResult>() {
                                        @Override
                                        protected void _onNext(SysTimeResult sysTimeResult) {

                                            try {
                                                Date date = sDateFormat.parse(sysTimeResult.getCurrDate());
                                                nowTime = date.getTime();
                                                showDetailsList(directDetailsResult);
                                            } catch (ParseException e) {
                                                e.printStackTrace();
                                                APP.mToast("当前时间获取失败");
                                            }

                                        }

                                        @Override
                                        protected void _onError(String msg) {
                                            APP.mToast(msg);
                                        }
                                    });

                        }

                        @Override
                        protected void _onError(String msg) {
                            APP.mToast(msg);
                        }
                    });
        } else {
            Log.e("School_DirectDetailsAty", APP.userInfo.getBody().getUser().getMobile());
            if (mDirectBean.getPrice() <= 0) {//费用小于0
                Log.e("School_DirectDetailsAty", "2222");
                hasRead = true;
                APP.apiService.getDirectDetails(mDirectBean.getLiveCourseId(), APP.userInfo.getBody().getUser().getMobile())
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new RxSubscribe<DirectDetailsResult>() {
                            @Override
                            protected void _onNext(DirectDetailsResult directDetailsResult) {
                                APP.apiService.getSysTime("")
                                        .subscribeOn(Schedulers.newThread())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribe(new RxSubscribe<SysTimeResult>() {
                                            @Override
                                            protected void _onNext(SysTimeResult sysTimeResult) {
                                                try {
                                                    Date date = sDateFormat.parse(sysTimeResult.getCurrDate());
                                                    nowTime = date.getTime();
                                                    L.e(sysTimeResult.toString());
                                                    L.e("nowTime:" + date.getTime());
                                                    showDetailsList(directDetailsResult);
                                                } catch (ParseException e) {
                                                    e.printStackTrace();
                                                    APP.mToast("当前时间获取失败" +
                                                            "");
                                                }

                                            }

                                            @Override
                                            protected void _onError(String msg) {
                                                APP.mToast(msg);
                                            }
                                        });

                            }

                            @Override
                            protected void _onError(String msg) {
                                APP.mToast(msg);
                            }
                        });
            } else {
                APP.apiService.getDirectDetails(mDirectBean.getLiveCourseId(), APP.userInfo.getBody().getUser().getMobile())
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new RxSubscribe<DirectDetailsResult>() {
                            @Override
                            protected void _onNext(DirectDetailsResult directDetailsResult) {
                                APP.apiService.getSysTime("")
                                        .subscribeOn(Schedulers.newThread())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribe(new RxSubscribe<SysTimeResult>() {
                                            @Override
                                            protected void _onNext(SysTimeResult sysTimeResult) {
                                                try {
                                                    Date date = sDateFormat.parse(sysTimeResult.getCurrDate());
                                                    nowTime = date.getTime();
                                                    L.e(sysTimeResult.toString());
                                                    L.e("nowTime:" + date.getTime());
                                                    showDetailsList(directDetailsResult);
                                                } catch (ParseException e) {
                                                    e.printStackTrace();
                                                    APP.mToast("当前时间获取失败" +
                                                            "");
                                                }

                                            }

                                            @Override
                                            protected void _onError(String msg) {
                                                APP.mToast(msg);
                                            }
                                        });

                            }

                            @Override
                            protected void _onError(String msg) {
                                APP.mToast(msg);
                            }
                        });

            }
        }


    }

    private void showDetailsList(DirectDetailsResult directDetailsResult) {
        this.directDetailsResult = directDetailsResult;
        for (int i = 0; i < directDetailsResult.getLiveSectionList().size(); i++) {
            if (nowTime > directDetailsResult.getLiveSectionList().get(i).getStarttime() && nowTime < directDetailsResult.getLiveSectionList().get(i).getStarttime() + directDetailsResult.getLiveSectionList().get(i).getMinutes() * 60 * 1000) {
                isPlayType = i;
            }
        }
        if (!hasRead) {
            mLiTopToSign.setVisibility(View.VISIBLE);
            mTvToVideo.setVisibility(View.GONE);
            mLiPrice.setVisibility(View.GONE);
        } else if (isPlayType > -1) {
            mLiTopToSign.setVisibility(View.GONE);
            mTvToVideo.setVisibility(View.VISIBLE);
            mLiPrice.setVisibility(View.GONE);
        } else {
            mLiTopToSign.setVisibility(View.GONE);
            mTvToVideo.setVisibility(View.GONE);
            mLiPrice.setVisibility(View.GONE);
        }
        mRvList.setLayoutManager(new LinearLayoutManager(School_DirectDetailsAty.this));
        SingleReAdpt reAdpt = new SingleReAdpt<DirectDetailsResult.LiveSectionListBean>(School_DirectDetailsAty.this, R.layout.recycler_direct_details, directDetailsResult.getLiveSectionList()) {
            @Override
            protected void BindData(BaseReHolder holder, int position, DirectDetailsResult.LiveSectionListBean data) {
                holder.getTV(R.id.item_tv_title).setText(data.getLiveSectionName());
                holder.getTV(R.id.item_tv_time).setText(sDateFormat.format(data.getStarttime()) + " 开始，时长" + data.getMinutes() + "分钟");

               /* if (data.getIspaid() == 0) {
                    //不收费

                } else {
                    //收费
                }*/
             /*   if (nowTime > 9999999999L) {
                    nowTime = (nowTime / 1000);
                }
                if (data.getStarttime() > 9999999999L) {
                    data.setStarttime(data.getStarttime() / 1000);
                }*/
                L.e("nowTime:" + nowTime + "---开始时间:" + data.getStarttime() + "---时长：" + (data.getMinutes()) + "---结束：" + (data.getStarttime() + data.getMinutes() * 60 * 1000));
                if (nowTime < data.getStarttime()) {
                    //未开始
                    holder.getView(R.id.tv_videoNostart).setVisibility(View.VISIBLE);//未开始
                    holder.getView(R.id.tv_videoIng).setVisibility(View.GONE);//直播中
                    holder.getView(R.id.tv_videoEnd).setVisibility(View.GONE);//已结束
                    holder.getView(R.id.tv_ReStart).setVisibility(View.GONE);//录播
                } else if (nowTime > data.getStarttime() && nowTime < data.getStarttime() + data.getMinutes() * 60 * 1000) {
                    //直播中
                    holder.getView(R.id.tv_videoNostart).setVisibility(View.GONE);//未开始
                    holder.getView(R.id.tv_videoIng).setVisibility(View.VISIBLE);//直播中
                    holder.getView(R.id.tv_videoEnd).setVisibility(View.GONE);//已结束
                    holder.getView(R.id.tv_ReStart).setVisibility(View.GONE);//录播
                    isPlayType = position;
                } else if (nowTime > data.getStarttime() + data.getMinutes() * 60 * 1000) {
                    //已结束
                    holder.getView(R.id.tv_videoNostart).setVisibility(View.GONE);//未开始
                    holder.getView(R.id.tv_videoIng).setVisibility(View.GONE);//直播中
                    holder.getView(R.id.tv_videoEnd).setVisibility(View.VISIBLE);//已结束
                    holder.getView(R.id.tv_ReStart).setVisibility(View.GONE);//录播
                    if (!TextUtils.isEmpty(data.getLiveSectionUrl())) {
                        //存在录播
                        holder.getView(R.id.tv_videoNostart).setVisibility(View.GONE);//未开始
                        holder.getView(R.id.tv_videoIng).setVisibility(View.GONE);//直播中
                        holder.getView(R.id.tv_videoEnd).setVisibility(View.GONE);//已结束
                        holder.getView(R.id.tv_ReStart).setVisibility(View.VISIBLE);//录播
                    }
                }
            }
        };

        reAdpt.setOnItemClickListener(new SingleReAdpt.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // goActivity(VideoAty.class, 1);
                changeCheck(position, nowTime);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
        mRvList.setAdapter(reAdpt);
        if (isPlayType > -1) {
            mRvList.scrollToPosition(isPlayType);
        }

    }

    private void changeCheck(int position, long nowTime) {
        if (directDetailsResult == null || directDetailsResult.getLiveSectionList().size() < 1)
            return;

        if (APP.userInfo == null) {
            goActivity(LoginAty.class);
            return;
        }
        next(position);
    }

    private void next(int position) {
        if (hasRead) {//改为是否为会员
            if (!TextUtils.isEmpty(directDetailsResult.getLiveSectionList().get(position).getLiveSectionUrl())) {//录播
                Intent goClass = new Intent(School_DirectDetailsAty.this, VideoAtyRecord.class);
                goClass.putExtra("bean", directDetailsResult.getLiveSectionList().get(position));
                startActivity(goClass);
            } else {
                Intent goClass = new Intent(School_DirectDetailsAty.this, VideoAty.class);
                goClass.putExtra("bean", directDetailsResult.getLiveSectionList().get(position));
                startActivityForResult(goClass, 1);
            }

        } else {
            //弹窗提示
            if (isRechange) {//续费
                HTTPutils.showGOvipDialog(School_DirectDetailsAty.this, "本学段的会员已过期", "续费");
            } else {
                HTTPutils.showGOvipDialog(School_DirectDetailsAty.this, "您尚未开通本学段的会员", "开通会员");
            }
            //            new WXshpaeDialog(School_DirectDetailsAty.this).show("报名方式", mDirectBean.getSignMsg(), mDirectBean.getWeixin());
        }
    }

    private void setCheck(int position) {
        if (position == 0) {
            mRBtnDetails.setChecked(true);
            mLlDetails.setVisibility(View.VISIBLE);
            mRvList.setVisibility(View.GONE);
        } else {
            mRBtnList.setChecked(true);
            mRvList.setVisibility(View.VISIBLE);
            mLlDetails.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onResult(int request, Intent data) {
        switch (request) {
            case 1:
                L.e("触发播放重置");
                VideoAty.isMax = true;
                VideoAty.isShowVide = false;
                VideoAty.seekNum = 0;
                break;
        }
    }

    @OnClick({R.id.tv_toVideo, R.id.rBtn_details, R.id.rBtn_list, R.id.tv_toSign, R.id.ll_top_toSign})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_toVideo:
                L.e("type:" + isPlayType + "==timeP:" + nowTime);
                if (isPlayType < 0 || nowTime < 1) return;
                changeCheck(isPlayType, nowTime);
                break;
            case R.id.rBtn_details://详情
                setCheck(0);
                break;
            case R.id.rBtn_list://课程表
                setCheck(1);
                break;
            case R.id.tv_toSign:
                if (APP.userInfo == null) {
                    goActivity(LoginAty.class);
                    return;
                }
//                new WXshpaeDialog(School_DirectDetailsAty.this).show("报名方式", mDirectBean.getSignMsg(), mDirectBean.getWeixin());
                HTTPutils.showGOvipDialog(School_DirectDetailsAty.this, "您尚未开通本学段的会员", "开通会员");
                break;
            case R.id.ll_top_toSign:
                if (APP.userInfo == null) {
                    goActivity(LoginAty.class);
                    return;
                }
//                new WXshpaeDialog(School_DirectDetailsAty.this).show("报名方式", mDirectBean.getSignMsg(), mDirectBean.getWeixin());
                HTTPutils.showGOvipDialog(School_DirectDetailsAty.this, "您尚未开通本学段的会员", "开通会员");
                break;
        }
    }
}
