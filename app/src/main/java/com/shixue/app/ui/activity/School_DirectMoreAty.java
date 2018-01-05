package com.shixue.app.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bumptech.glide.Glide;
import com.jjs.Jbase.BaseActivity;
import com.jjs.Jutils.RecyclerView.BaseReHolder;
import com.jjs.Jutils.RecyclerView.SingleReAdpt;
import com.shixue.app.APP;
import com.shixue.app.ApiService;
import com.shixue.app.R;
import com.shixue.app.RxSubscribe;
import com.shixue.app.ui.bean.LiveDirectResult;
import com.shixue.app.utils.HTTPutils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * 本页： 直播详情页
 * Created by 刘荣芳 on 2016-12-03.
 */

public class School_DirectMoreAty extends BaseActivity {
    @Bind(R.id.rv_directList)
    RecyclerView mRvDirectList;

    SingleReAdpt mReAdpt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direct_more);
        ButterKnife.bind(this);
        init();
    }

    @Override
    protected void init() {
        setTitle("直播课程");
        //传入用户手机号，传入项目id
        APP.apiService.getLiveDirectList(1, APP.examType)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxSubscribe<LiveDirectResult>() {
                    @Override
                    protected void _onNext(LiveDirectResult liveDirectResult) {
                        getDirectListOK(liveDirectResult.getLiveCourseList());
                    }

                    @Override
                    protected void _onError(String msg) {
                        APP.mToast(msg);
                    }
                });

    }

    private void getDirectListOK(List<LiveDirectResult.LiveCourseListBean> directList) {
        mRvDirectList.setLayoutManager(new LinearLayoutManager(this));
        mReAdpt = new SingleReAdpt<LiveDirectResult.LiveCourseListBean>(this, R.layout.recycler_direct_list, directList) {
            @Override
            protected void BindData(BaseReHolder holder, int position, LiveDirectResult.LiveCourseListBean data) {
                if (data.getPictureUrl() != null && data.getPictureUrl().length() > 0) {
                    Glide.with(School_DirectMoreAty.this).load(APP.picUrl + data.getPictureUrl()).into(holder.getImageView(R.id.item_img));
                } else {
                    if (data.getPrice() > 0) {
                        Glide.with(School_DirectMoreAty.this).load(R.drawable.zhibo_img_vip).into(holder.getImageView(R.id.item_img));

                    } else {
                        Glide.with(School_DirectMoreAty.this).load(R.drawable.zhibo_img_free).into(holder.getImageView(R.id.item_img));

                    }
                }
                holder.getTV(R.id.item_title).setText(data.getLiveCourseName());
                //  holder.getTV(R.id.item_time).setText("时间未设置！！！！！！");取消
                holder.getTV(R.id.item_msg).setText(data.getOneWord());//一句话描述
                if (data.getChargeType() == 0) {//免费
                    holder.getTV(R.id.item_price).setText("免费");

                } else if (data.getChargeType() == 1) {//笔试
                    holder.getTV(R.id.item_price).setText("会员");

                } else if (data.getChargeType() == 2) {//面试
                    holder.getTV(R.id.item_price).setText("面试会员");

                }


             /*   if (data.getEffective() == 1) {
                    holder.getView(R.id.tv_isPlay).setVisibility(View.VISIBLE);
                } else {
                    holder.getView(R.id.tv_isPlay).setVisibility(View.GONE);
                }*/
                if (APP.userInfo != null) {
                    if (data.getPrice() > 0) {
                        HTTPutils.hasRead(APP.userInfo.getBody().getUser().getMobile(), data.getLiveCourseId(), b -> {
                            data.setSign(b);
                            if (b) {
                                holder.getView(R.id.tv_isSign).setVisibility(View.VISIBLE);
                            } else {
                                holder.getView(R.id.tv_isSign).setVisibility(View.GONE);
                            }
                        });
                    } else {
                        data.setSign(false);
                        holder.getView(R.id.tv_isSign).setVisibility(View.GONE);
                    }

                } else {
                    holder.getView(R.id.tv_isSign).setVisibility(View.GONE);
                }
            }
        };
        mReAdpt.setOnItemClickListener(new SingleReAdpt.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(School_DirectMoreAty.this, School_DirectDetailsAty.class);
                intent.putExtra("bean", directList.get(position));
                startActivityForResult(intent, 1);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
        mRvDirectList.setAdapter(mReAdpt);
    }

    @Override
    protected void onResult(int request, Intent data) {
        mReAdpt.notifyDataSetChanged();
    }
}
