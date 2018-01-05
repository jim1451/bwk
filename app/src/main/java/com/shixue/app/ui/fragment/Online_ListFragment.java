package com.shixue.app.ui.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jjs.Jbase.BaseFragment;
import com.jjs.Jutils.RecyclerView.DataHolder;
import com.jjs.Jutils.RecyclerView.LayoutWrapper;
import com.jjs.Jutils.RecyclerView.SingleReAdpt;
import com.jjs.Jutils.RecyclerView.SuperAdapter;
import com.jjs.Jutils.ToastUtils;
import com.shixue.app.APP;
import com.shixue.app.R;
import com.shixue.app.database.VideoPlayDb;
import com.shixue.app.ui.activity.DetailsFragmentAty;
import com.shixue.app.ui.activity.LoginAty;
import com.shixue.app.ui.activity.MediaPlayerActivity;
import com.shixue.app.ui.activity.School_Online_DetailsAty;
import com.shixue.app.ui.bean.OnlineDetailsResult;
import com.shixue.app.utils.HTTPutils;
import com.shixue.app.utils.NetworkUtils;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * 本页：
 * Created by  on 2016-12-01.
 * 直播课程详情列表
 */

public class Online_ListFragment extends BaseFragment {
    @Bind(R.id.rv_online_list)
    RecyclerView mRvOnlineList;

    OnlineDetailsResult result;
    List<LayoutWrapper> wrapperList;//数据源
    int[] layoutIds = new int[]{R.layout.recycler_item_title, R.layout.recycler_online_list};//布局

    @Override
    protected void onCreat() {
        setContentView(R.layout.fragment_onlinelist);
    }

    @Override
    protected void init() {
        result = ((School_Online_DetailsAty) getActivity()).result;
        wrapperList = new ArrayList<>();
        DataHolder<String> titleHolder = (context, holder, item, position) -> ((TextView) holder.getView(R.id.item_title)).setText(item);
        DataHolder<OnlineDetailsResult.ChapterListBean.SectionListBean> dataHolder = (context, holder, bean, position) -> {
            ((TextView) holder.getView(R.id.item_title)).setText(bean.getSectionName());
            ((TextView) holder.getView(R.id.item_time)).setText("时长：" + bean.getTimeLength() + "分钟");
            if (bean.getSectionType() == 0) {//节类型
                ((TextView) holder.getView(R.id.item_type)).setText("视频");
            } else if (bean.getSectionType() == 1) {
                ((TextView) holder.getView(R.id.item_type)).setText("资料");
            } else {
                ((TextView) holder.getView(R.id.item_type)).setText("试卷");
            }
            Log.e("getChargeType", result.getCourse().getChargeType() + "");
            if (bean.getFree() == 1) {//笔试会员
                holder.getView(R.id.item_isFree).setBackgroundResource(R.drawable.shape_line_orange);
                ((TextView) holder.getView(R.id.item_isFree)).setTextColor(Color.parseColor("#F88437"));
                ((TextView) holder.getView(R.id.item_isFree)).setText("会员");
            } else if (bean.getFree() == 0) {//免费
                holder.getView(R.id.item_isFree).setBackgroundResource(R.drawable.shape_line_green);
                ((TextView) holder.getView(R.id.item_isFree)).setTextColor(Color.parseColor("#059b76"));
                ((TextView) holder.getView(R.id.item_isFree)).setText("免费");
            } else if (bean.getFree() == 2) {//面试
                holder.getView(R.id.item_isFree).setBackgroundResource(R.drawable.shape_line_orange);
                ((TextView) holder.getView(R.id.item_isFree)).setTextColor(Color.parseColor("#F88437"));
                ((TextView) holder.getView(R.id.item_isFree)).setText("面试会员");
            }
        };
        for (int i = 0; i < result.getChapterList().size(); i++) {
            if (result.getChapterList().size() > 0) {
                wrapperList.add(new LayoutWrapper(layoutIds[0], result.getChapterList().get(i).getChapterName(), titleHolder));
                for (int j = 0; j < result.getChapterList().get(i).getSectionList().size(); j++) {
                    wrapperList.add(new LayoutWrapper(layoutIds[1], result.getChapterList().get(i).getSectionList().get(j), dataHolder));
                }
            }
        }
        mRvOnlineList.setLayoutManager(new LinearLayoutManager(getActivity()));
        SuperAdapter superAdapter = new SuperAdapter(getActivity(), layoutIds);
        superAdapter.setData(wrapperList);
        mRvOnlineList.setAdapter(superAdapter);
        superAdapter.setOnItemClickListener(new SingleReAdpt.OnItemClickListener() {
                                                @Override
                                                public void onItemClick(View view, int position) {
                                                    if (wrapperList.get(position).getLayoutId() == layoutIds[1]) {
                                                        if (APP.userInfo == null) {
                                                            goActivity(LoginAty.class);
                                                            return;
                                                        }
                                                        int free = ((OnlineDetailsResult.ChapterListBean.SectionListBean) wrapperList.get(position).getData()).getFree();
                                                        if (free == 0) {//免费
                                                            next(position);
                                                        } else {
                                                            if (APP.singleVip == 0) {//未开通会员
                                                                HTTPutils.showGOvipDialog(getActivity(), "您尚未开通本学段的会员", "开通会员");
                                                            } else if (APP.singleVip == 1) {//开通了一种 会员
                                                                if (APP.SingleVipBean.getVipInfoList().get(0).getChargeType() == free) {//课程会员和开通的会员相对应
                                                                    if (APP.SingleVipBean.getVipInfoList().get(0).getVipStatus() == 2) {//开通的=会员已过期
                                                                        HTTPutils.showGOvipDialog(getActivity(), "本学段的会员已过期", "续费");
                                                                    } else {//未过期
                                                                        next(position);
                                                                    }
                                                                } else {//课程会员与开通的会员不对应
                                                                    HTTPutils.showGOvipDialog(getActivity(), "您尚未开通本学段的会员", "开通会员");
                                                                }

                                                            } else if (APP.singleVip == 2) {//两种会员都开通了
                                                                for (int i = 0; i < APP.SingleVipBean.getVipInfoList().size(); i++) {//遍历取出与之对应的会员
                                                                    if (APP.SingleVipBean.getVipInfoList().get(i).getChargeType() == free) {//判断该课程下的会员是否到期了
                                                                        if (APP.SingleVipBean.getVipInfoList().get(i).getVipStatus() == 2) {//会员过期
                                                                            HTTPutils.showGOvipDialog(getActivity(), "本学段的会员已过期", "续费");
                                                                        } else {
                                                                            next(position);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        Log.e("onItemClick", APP.isVip + "  " + ((OnlineDetailsResult.ChapterListBean.SectionListBean) wrapperList.get(position).getData()).getFree() + "     " + APP.singleVip + "   " + APP.singleVipType + "    ");


                                                    }
                                                }

                                                @Override
                                                public void onItemLongClick(View view, int position) {

                                                }
                                            }

        );
    }

    public void next(int position) {
        OnlineDetailsResult.ChapterListBean.SectionListBean bean = (OnlineDetailsResult.ChapterListBean.SectionListBean) wrapperList.get(position).getData();
        if (bean.getSectionType() == 0) {
            //播放视频
            if (bean.getDefinition() == 0) {
                String gaoqingUrl = bean.getSectionUrl();
                List<VideoPlayDb> videoPlayDbs = DataSupport.where("sectionid = ?", String.valueOf(bean.getSectionId())).find(VideoPlayDb.class);
                if (videoPlayDbs.size() == 0) {
                    VideoPlayDb videoPlayDb = new VideoPlayDb();
                    videoPlayDb.setSectionid(bean.getSectionId());
                    videoPlayDb.setSectionname(bean.getSectionName());
                    videoPlayDb.setVideourl(gaoqingUrl);
                    videoPlayDb.save();
                } else {
                    VideoPlayDb videoPlayDb = new VideoPlayDb();
                    videoPlayDb.setVideourl(gaoqingUrl);
                    videoPlayDb.updateAll("sectionid = ?", String.valueOf(bean.getSectionId()));
                }
                playVideo(gaoqingUrl, bean.getSectionName(), bean.getSectionId());
            } else {
                /**播放视频 获取网络类型*/
                if (NetworkUtils.getInstance(getActivity()).getNetworkType().equals("WIFI")) {
                    /**wifi下视频*/
                    playDialog(true, bean.getSectionUrl(), bean.getSectionName(), bean.getSectionId());
                } else {
                    playDialog(false, bean.getSectionUrl(), bean.getSectionName(), bean.getSectionId());
                }
            }
        } else {
            //打开html页面
            Log.e("goHtmlAty", bean.getSectionName() + "  " + bean.getSectionUrl());
            DetailsFragmentAty.goHtmlAty(getActivity(), bean.getSectionName(), bean.getSectionUrl());
        }

    }

    private void playDialog(boolean isWifi, final String url, final String name, final int sectionId) {
        final Dialog dialog = new Dialog(getActivity(), R.style.RoundDialog);
        dialog.setContentView(R.layout.dialog_choiceplay);
        dialog.setCanceledOnTouchOutside(true);

        TextView tv_hint = (TextView) dialog.findViewById(R.id.tv_dialog_hint);
        TextView tv_gaoqing = (TextView) dialog.findViewById(R.id.tv_gaoqing);
        TextView tv_biaoqing = (TextView) dialog.findViewById(R.id.tv_biaoqing);
        TextView tv_liuchang = (TextView) dialog.findViewById(R.id.tv_liuchang);

        if (isWifi) {
            tv_hint.setVisibility(View.GONE);
        } else {
            tv_hint.setVisibility(View.VISIBLE);
        }
        tv_gaoqing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                /**高清地址*/
                String gaoqingUrl = url + ".f30.mp4";
                List<VideoPlayDb> videoPlayDbs = DataSupport.where("sectionid = ?", String.valueOf(sectionId)).find(VideoPlayDb.class);
                if (videoPlayDbs.size() == 0) {
                    VideoPlayDb videoPlayDb = new VideoPlayDb();
                    videoPlayDb.setSectionid(sectionId);
                    videoPlayDb.setSectionname(name);
                    videoPlayDb.setVideourl(gaoqingUrl);
                    videoPlayDb.save();
                } else {
                    VideoPlayDb videoPlayDb = new VideoPlayDb();
                    videoPlayDb.setVideourl(gaoqingUrl);
                    videoPlayDb.updateAll("sectionid = ?", String.valueOf(sectionId));
                }
                playVideo(gaoqingUrl, name, sectionId);

            }
        });

        tv_biaoqing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                /**标清地址*/
                String biaoqingUrl = url + ".f20.mp4";
                List<VideoPlayDb> videoPlayDbs = DataSupport.where("sectionid = ?", String.valueOf(sectionId)).find(VideoPlayDb.class);
                if (videoPlayDbs.size() == 0) {
                    VideoPlayDb videoPlayDb = new VideoPlayDb();
                    videoPlayDb.setSectionid(sectionId);
                    videoPlayDb.setSectionname(name);
                    videoPlayDb.setVideourl(biaoqingUrl);
                    videoPlayDb.save();
                } else {
                    VideoPlayDb videoPlayDb = new VideoPlayDb();
                    videoPlayDb.setVideourl(biaoqingUrl);
                    videoPlayDb.updateAll("sectionid = ?", String.valueOf(sectionId));
                }
                playVideo(biaoqingUrl, name, sectionId);
            }
        });

        tv_liuchang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                /**流畅地址*/
                String liuchangUrl = url + ".f10.mp4";
                List<VideoPlayDb> videoPlayDbs = DataSupport.where("sectionid = ?", String.valueOf(sectionId)).find(VideoPlayDb.class);
                if (videoPlayDbs.size() == 0) {
                    VideoPlayDb videoPlayDb = new VideoPlayDb();
                    videoPlayDb.setSectionid(sectionId);
                    videoPlayDb.setSectionname(name);
                    videoPlayDb.setVideourl(liuchangUrl);
                    videoPlayDb.setVideoprogress(0);
                    videoPlayDb.save();
                } else {
                    VideoPlayDb videoPlayDb = new VideoPlayDb();
                    videoPlayDb.setVideourl(liuchangUrl);
                    videoPlayDb.updateAll("sectionid = ?", String.valueOf(sectionId));
                }
                playVideo(liuchangUrl, name, sectionId);
            }
        });
        dialog.show();

    }

    /**
     * 播放视频
     *
     * @param videoUrl
     * @param name
     */

    private void playVideo(String videoUrl, String name, int sectionId) {

        List<VideoPlayDb> videoPlayDbs = DataSupport.where("sectionid = ?", String.valueOf(sectionId)).find(VideoPlayDb.class);
        int progress = 0;
        if (videoPlayDbs.size() > 0) {
            progress = videoPlayDbs.get(0).getVideoprogress();
        }
        Intent intent = new Intent(getActivity(), MediaPlayerActivity.class);
        intent.putExtra("video_path", videoUrl.replaceAll("\t", ""));
        intent.putExtra("video_name", name);
        intent.putExtra("video_id", sectionId);
        intent.putExtra("video_progress", progress);
        startActivity(intent);

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
