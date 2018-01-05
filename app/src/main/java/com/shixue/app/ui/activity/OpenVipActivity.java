package com.shixue.app.ui.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jjs.Jbase.BaseActivity;
import com.jjs.Jutils.RecyclerView.BaseReHolder;
import com.jjs.Jutils.RecyclerView.SingleReAdpt;
import com.shixue.app.APP;
import com.shixue.app.ApiService;
import com.shixue.app.R;
import com.shixue.app.RxSubscribe;
import com.shixue.app.ui.bean.PayDealResult;
import com.shixue.app.ui.bean.SysTimeResult;
import com.shixue.app.ui.bean.VipPriceResult;
import com.shixue.app.utils.HTTPutils;
import com.shixue.app.utils.L;
import com.shixue.app.utils.PayUtils;
import com.shixue.app.utils.SweetDialog;
import com.shixue.app.wxapi.WXPayEntryActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * 本页：
 * Created by jjs on 2016-12-28.
 * Email:994462623@qq.com
 */

public class OpenVipActivity extends BaseActivity {
    @Bind(R.id.rv_vipList)
    RecyclerView mRvVipList;
    @Bind(R.id.img_alipay)
    ImageView mImgAlipay;
    @Bind(R.id.linear_alipay)
    LinearLayout mLinearAlipay;
    @Bind(R.id.img_wx)
    ImageView mImgWx;
    @Bind(R.id.linear_wx)
    LinearLayout mLinearWx;
    @Bind(R.id.linear_pay)
    LinearLayout mLinearPay;
    @Bind(R.id.tv_oldData)
    TextView mTvOldData;
    @Bind(R.id.tv_newData)
    TextView mTvNewData;
    @Bind(R.id.tv_payPrice)
    TextView mTvPayPrice;

    int checkType = 0;//选中项目
    List<Integer> vipList;//金额总计
    SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    PayDealResult payDeal;
    String endDate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_vipbuy);
        ButterKnife.bind(this);
        //未开通微信支付，隐藏微信支付功能
        mLinearWx.setVisibility(View.GONE);
        IntentFilter filter = new IntentFilter();
        filter.addAction(WXPayEntryActivity.wxPayResult);
        registerReceiver(broadcastReceiverWechatPay, filter);
        init();
    }


    @Override
    protected void init() {
        setTitle("会员购买");
        SweetDialog progess = new SweetDialog(OpenVipActivity.this, SweetDialog.PROGRESS_TYPE).setTitleText("加载中...");
        progess.show();
        APP.apiService.getVipPrice(APP.projectID)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxSubscribe<VipPriceResult>() {
                    @Override
                    protected void _onNext(VipPriceResult vipPriceResult) {
                        progess.cancel();
                        getVipPriceOK(vipPriceResult);
                        changeData();
                    }

                    @Override
                    protected void _onError(String msg) {
                        progess.cancel();
                     /*   new SweetDialog(OpenVipActivity.this, SweetDialog.WARNING_TYPE)
                                .setTitleText(msg)
                                .setCancelText("返回", sweetDialog -> finish())
                                .setConfirmText("重试", sweetDialog -> init())
                                .show();*/
                    }
                });
        //获取会员信息
        HTTPutils.getVipBean(APP.userInfo.getBody().getUser().getMobile(), APP.projectID, b -> {
            changeData();
        });

    }

    private void getVipPriceOK(VipPriceResult priceResult) {
        vipList = new ArrayList<>();
        vipList.add(priceResult.getProjPrice().getOneMonthMoney());
        vipList.add(priceResult.getProjPrice().getThreeMonthMoney());
        vipList.add(priceResult.getProjPrice().getSixMonthMoney());
        vipList.add(priceResult.getProjPrice().getOneYearMoney());
        mRvVipList.setLayoutManager(new LinearLayoutManager(this));
        SingleReAdpt reAdpt = new SingleReAdpt<Integer>(this, R.layout.recycler_vip_price, vipList) {
            @Override
            protected void BindData(BaseReHolder holder, int position, Integer data) {
                if (position == checkType) {
                    holder.getTV(R.id.item_vip_price).setBackgroundRes(R.drawable.bg_vip_price_stroke);
                } else {
                    holder.getTV(R.id.item_vip_price).setBackgroundRes(R.drawable.dra_isnull);
                }
                switch (position) {
                    case 0:
                        holder.getTV(R.id.item_vip_price).setText("一个月(" + data + "元)");
                        break;
                    case 1:
                        holder.getTV(R.id.item_vip_price).setText("三个月(" + data + "元)");
                        break;
                    case 2:
                        holder.getTV(R.id.item_vip_price).setText("六个月(" + data + "元)");
                        break;
                    case 3:
                        holder.getTV(R.id.item_vip_price).setText("一年(" + data + "元)");
                        break;
                }
            }
        };
        reAdpt.setOnItemClickListener(new SingleReAdpt.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                checkType = position;
                reAdpt.notifyDataSetChanged();
                changeData();
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
        mRvVipList.setAdapter(reAdpt);
        mImgWx.setSelected(false);
        mImgAlipay.setSelected(true);
    }

    private void changeData() {
        if (vipList == null) return;
        APP.apiService.getSysTime("")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxSubscribe<SysTimeResult>() {
                    @Override
                    protected void _onNext(SysTimeResult sysTimeResult) {
                        try {
                            long nowTime = sDateFormat.parse(sysTimeResult.getCurrDate()).getTime();
                            getSysTimeOK(nowTime);
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

    private void getSysTimeOK(long nowTime) {
//        if (APP.isVip && APP.vipBean != null) {
//            mTvOldData.setText("原有效期：" + APP.vipBean.getSlastUpdateDate().split(" ")[0] + " 至 " + APP.vipBean.getSvipDate() + "  共" + APP.vipDay + "天");
//            //到期时间
//            long endLong = getEndDate(APP.vipBean.getVipDate());
//            endDate = sDateFormat.format(endLong);
//            int endDay = (int) ((endLong - nowTime) / 1000 / 60 / 60 / 24);
//            mTvNewData.setText("现有效期：" + APP.vipBean.getSlastUpdateDate().split(" ")[0] + " 至 " + endDate.split(" ")[0] + " 共" + endDay + "天");
//            mTvPayPrice.setText("支付金额：" + vipList.get(checkType) + "元");
//        } else {
//            long endLong = getEndDate(nowTime);
//            endDate = sDateFormat.format(endLong);
//            int endDay = (int) ((endLong - nowTime) / 1000 / 60 / 60 / 24);
//            mTvNewData.setText("现有效期：" + sDateFormat.format(nowTime).split(" ")[0] + " 至 " + endDate.split(" ")[0] + " 共" + endDay + "天");
//            mTvPayPrice.setText("支付金额：" + vipList.get(checkType) + "元");
//        }

    }

    private long getEndDate(long startTime) {
        long endTime = 0;
        switch (checkType) {
            case 0:
                endTime = startTime + 30 * 24 * 60 * 60 * 1000L;
                break;
            case 1:
                endTime = startTime + 90 * 24 * 60 * 60 * 1000L;
                break;
            case 2:
                endTime = startTime + 182 * 24 * 60 * 60 * 1000L;
                break;
            case 3:
                endTime = startTime + 365 * 24 * 60 * 60 * 1000L;
                break;
        }
        return endTime;
    }


    @Override
    protected void onResult(int request, Intent data) {

    }

    String title = "";

    @OnClick({R.id.linear_alipay, R.id.linear_wx, R.id.btn_topay})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.linear_alipay:
                mImgWx.setSelected(false);
                mImgAlipay.setSelected(true);
                break;
            case R.id.linear_wx:
                mImgWx.setSelected(true);
                mImgAlipay.setSelected(false);
                break;
            case R.id.btn_topay:
                if (vipList == null || vipList.size() < 1) return;
                if (!APP.hasNetwork()) {
                    APP.mToast("请检查网络连接");
                    return;
                }
                int payType = 0;//支付方式
                if (mImgAlipay.isSelected()) {
                    L.e("进行支付宝支付");
                    payType = 0;
                } else if (mImgWx.isSelected()) {
                    L.e("进行微信支付");
                    payType = 1;
                }
                SweetDialog progess = new SweetDialog(this, SweetDialog.PROGRESS_TYPE).setTitleText("加载中...");
                progess.show();

                switch (checkType) {
                    case 0:
                        title = "购买" + APP.examInfoBean.getProjectName() + "一个月会员";
                        break;
                    case 1:
                        title = "购买" + APP.examInfoBean.getProjectName() + "三个月会员";
                        break;
                    case 2:
                        title = "购买" + APP.examInfoBean.getProjectName() + "六个月会员";
                        break;
                    case 3:
                        title = "购买" + APP.examInfoBean.getProjectName() + "一年会员";
                        break;
                }
                /**
                 * 金额测试时为0.01
                 */
                APP.apiService.getStartDeal(APP.projectID, APP.userInfo.getBody().getUser().getUserid(), title, vipList.get(checkType), payType, "", "", "")
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new RxSubscribe<PayDealResult>() {
                            @Override
                            protected void _onNext(PayDealResult payDealResult) {
                                payDeal = payDealResult;
                                progess.cancel();
                                if (payDealResult.getPay().getPayType() == 0) {
                                    L.e("支付参数：" + payDealResult.getPay().getCargoName() + "==金额:" + payDealResult.getPay().getPayMoney() + "==id：" + payDealResult.getPay().getOrderNumber());
                                    PayUtils.AliPay(OpenVipActivity.this, APP.NOTIFY_URL, ApiService.ali_APPID, ApiService.ali_APPACCOUNT, ApiService.ali_APPKEY, title, payDealResult.getPay().getPayMoney() + "", payDealResult.getPay().getOrderNumber() + "", "0000");
                                    PayUtils.getAliResult(new PayUtils.onAliResult() {
                                        @Override
                                        public void onResult(String result) {
                                            PaySuccess(result);
                                        }

                                        @Override
                                        public void onError(String msg) {
                                            payError(msg);
                                        }
                                    });
                                } else {
                                   // PayUtils.WxPay(OpenVipActivity.this, title,  "201689874636991111", payDealResult.getPay().getPayMoney() + "", "1111");
                                }
                            }

                            @Override
                            protected void _onError(String msg) {
                                progess.cancel();
                                new SweetDialog(OpenVipActivity.this, SweetDialog.WARNING_TYPE).setTitleText(msg).setConfirmText("确定").show();
                            }
                        });

                break;
        }
    }


    private void PaySuccess(String msg) {
        //支付成功，调用成功方法
        L.e("保存参数：id:" + payDeal.getPay().getOrderNumber() + "==uid:" + APP.userInfo.getBody().getUser().getUserid() + "==money" + payDeal.getPay().getPayMoney() + "==type:" + payDeal.getPay().getPayType() + "==data:" + endDate);
        APP.apiService.setSuccessDeal(payDeal.getPay().getOrderNumber(), APP.userInfo.getBody().getUser().getUserid(), payDeal.getPay().getPayMoney(), payDeal.getPay().getPayType(), endDate)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxSubscribe<PayDealResult>() {
                    @Override
                    protected void _onNext(PayDealResult payDealResult) {
                        new SweetDialog(OpenVipActivity.this, SweetDialog.SUCCESS_TYPE)
                                .setTitleText("购买VIP会员成功!")
                                .setConfirmText("确定", new SweetDialog.OnSweetClick() {
                                    @Override
                                    public void onClick(SweetDialog sweetDialog) {
                                        setResult(ResultOK);
                                        finish();
                                    }
                                }).show();
                    }

                    @Override
                    protected void _onError(String msg) {
                        new SweetDialog(OpenVipActivity.this, SweetDialog.WARNING_TYPE)
                                .setTitleText("付款成功，但服务器加载超时，" + "\n" +
                                        "                请检查网络！")
                                .setConfirmText("重新加载服务器完成购买", new SweetDialog.OnSweetClick() {
                                    @Override
                                    public void onClick(SweetDialog sweetDialog) {
                                        PaySuccess("");
                                    }
                                }).show();
                    }
                });
    }

    private void payError(String msg) {
        //支付失败
        new SweetDialog(this, SweetDialog.WARNING_TYPE).setTitleText(msg).setConfirmText("确定").show();
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        try {
            if (broadcastReceiverWechatPay != null)
                unregisterReceiver(broadcastReceiverWechatPay);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    private BroadcastReceiver broadcastReceiverWechatPay = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            try {
                int code = intent.getIntExtra("code", -1);
                switch (code) {
                    case 0:
                        PaySuccess("支付成功");
                        break;

                    case -1:
                        payError("支付有误！请重试");
                        break;

                    case -2:

                        payError("您取消了支付，请重新付款");
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
}
