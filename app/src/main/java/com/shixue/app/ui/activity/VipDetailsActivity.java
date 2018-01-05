package com.shixue.app.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jjs.Jbase.BaseActivity;
import com.jjs.Jutils.RecyclerView.BaseReHolder;
import com.jjs.Jutils.RecyclerView.SingleReAdpt;
import com.shixue.app.APP;
import com.shixue.app.R;
import com.shixue.app.ui.bean.VipBean;
import com.shixue.app.utils.HTTPutils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 刘荣芳 on 2017/10/28.
 * Vip详情页
 */

public class VipDetailsActivity extends BaseActivity {
    @Bind(R.id.img_back)
    ImageView imgBack;
    @Bind(R.id.recycler)
    RecyclerView recycler;
    private SingleReAdpt<VipBean.BodyBean.VipInfoListBean> adpt;
    private List<VipBean.BodyBean.VipInfoListBean> mList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vip_details);
        ButterKnife.bind(this);
        init();
    }

    @Override
    protected void init() {
        getVipInfo();


    }

    private void initAdapter() {
        adpt = new SingleReAdpt<VipBean.BodyBean.VipInfoListBean>(VipDetailsActivity.this, R.layout.item_vip_details, mList) {
            @Override
            protected void BindData(BaseReHolder holder, int position, VipBean.BodyBean.VipInfoListBean data) {
                holder.getTextView(R.id.tvTypeName).setText(data.getExamTypeName());
                TextView tvVipType = holder.getTextView(R.id.tvVipType);
                if (data.getChargeType() == 1) {//笔试
                    tvVipType.setText("会员");

                } else if (data.getChargeType() == 2) {//面试
                    tvVipType.setText("面试会员");
                }
                TextView tvStatus = holder.getTextView(R.id.tvVipData);
                if (data.getVipStatus() == 1) {//会员
                    tvStatus.setText(data.getVipDate() + "  截止");
                } else if (data.getVipStatus() == 2) {//过期
                    tvStatus.setText(data.getVipDate() + "  已过期");


                }
            }
        };
        LinearLayoutManager layoutM = new LinearLayoutManager(VipDetailsActivity.this);
        layoutM.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(layoutM);
        recycler.setAdapter(adpt);

    }

    @Override
    protected void onResult(int request, Intent data) {

    }

    @OnClick(R.id.img_back)
    public void onViewClicked() {
        finish();
    }

    //获取用户会员信息
    private void getVipInfo() {
        mList = new ArrayList<>();
        HTTPutils.getVipBean(APP.userInfo.getBody().getUser().getMobile(), 1, new HTTPutils.OnBooleanClick() {
            @Override
            public void onSuccess(boolean b) {
                Log.e("vip详情", APP.vipBean.getBody().getVipInfoList().size() + "");
                for (int i = 0; i < APP.vipBean.getBody().getVipInfoList().size(); i++) {
                    Log.e("vip详情", APP.vipBean.getBody().getVipInfoList().get(i).getExamTypeName() + "");
                    mList.add(APP.vipBean.getBody().getVipInfoList().get(i));
                }
                initAdapter();
            }
        });
    }

}
