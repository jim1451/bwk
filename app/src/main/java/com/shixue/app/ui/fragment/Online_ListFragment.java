package com.shixue.app.ui.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jjs.Jbase.BaseFragment;
import com.jjs.Jutils.RecyclerView.DataHolder;
import com.jjs.Jutils.RecyclerView.LayoutWrapper;
import com.jjs.Jutils.RecyclerView.SingleReAdpt;
import com.jjs.Jutils.RecyclerView.SuperAdapter;
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
 * Created by jjs on 2016-12-01.
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
        DataHolder<OnlineDetailsResult.EvalBean.SectionListBean> dataHolder = (context, holder, bean, position) -> {
            ((TextView) holder.getView(R.id.item_title)).setText(bean.getSectionName());
            ((TextView) holder.getView(R.id.item_time)).setText("时长：" + bean.getTimeLength() + "分钟");
            if (bean.getSectionType() == 0) {
                ((TextView) holder.getView(R.id.item_type)).setText("视频");
            } else if (bean.getSectionType() == 1) {
                ((TextView) holder.getView(R.id.item_type)).setText("资料");
            } else {
                ((TextView) holder.getView(R.id.item_type)).setText("试卷");
            }
            if (result.getCourse().getChargeType() == 0 || bean.getFree() == 1) {
                holder.getView(R.id.item_isFree).setBackgroundResource(R.drawable.shape_line_green);
                ((TextView) holder.getView(R.id.item_isFree)).setTextColor(Color.parseColor("#059b76"));
                ((TextView) holder.getView(R.id.item_isFree)).setText("免费");
            } else {
                holder.getView(R.id.item_isFree).setBackgroundResource(R.drawable.shape_line_orange);
                ((TextView) holder.getView(R.id.item_isFree)).setTextColor(Color.parseColor("#F88437"));
                ((TextView) holder.getView(R.id.item_isFree)).setText("会员");
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
                                                        if (APP.isVip || result.getCourse().getChargeType() == 0 || ((OnlineDetailsResult.EvalBean.SectionListBean) wrapperList.get(position).getData()).getFree() == 1) {
                                                            OnlineDetailsResult.EvalBean.SectionListBean bean = (OnlineDetailsResult.EvalBean.SectionListBean) wrapperList.get(position).getData();
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
                                                                DetailsFragmentAty.goHtmlAty(getActivity(), bean.getSectionName(), bean.getSectionUrl());
                                                            }
                                                        } else {
                                                            HTTPutils.showGOvipDialog(getActivity());
                                                        }

                                                    }
                                                }

                                                @Override
                                                public void onItemLongClick(View view, int position) {

                                                }
                                            }

        );
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
