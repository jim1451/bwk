package com.shixue.app.ui.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.flyco.dialog.listener.OnBtnClickL;
import com.flyco.dialog.listener.OnOperItemClickL;
import com.flyco.dialog.widget.ActionSheetDialog;
import com.flyco.dialog.widget.NormalDialog;
import com.jjs.Jbase.BaseFragment;
import com.jjs.Jutils.RecyclerView.DataHolder;
import com.jjs.Jutils.RecyclerView.LayoutWrapper;
import com.jjs.Jutils.RecyclerView.SingleReAdpt;
import com.jjs.Jutils.RecyclerView.SuperAdapter;
import com.shixue.app.APP;
import com.shixue.app.R;
import com.shixue.app.database.DownloadService;
import com.shixue.app.database.VideoDb;
import com.shixue.app.database.VideoPlayDb;
import com.shixue.app.ui.activity.DetailsFragmentAty;
import com.shixue.app.ui.activity.LoginAty;
import com.shixue.app.ui.activity.MediaPlayerActivity;
import com.shixue.app.ui.activity.School_Online_DetailsAty;
import com.shixue.app.ui.bean.OnlineDetailsResult;
import com.shixue.app.utils.AppUtils;
import com.shixue.app.utils.FileIoUtils;
import com.shixue.app.utils.HTTPutils;
import com.shixue.app.utils.L;
import com.shixue.app.utils.MD5Utils;
import com.zhy.autolayout.AutoLinearLayout;

import org.litepal.crud.DataSupport;
import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;

import java.io.File;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.aigestudio.downloader.bizs.DLManager;


/**
 * 本页：
 * Created by jjs on 2016-12-02.
 */

public class Online_VideoFragment extends BaseFragment {
    @Bind(R.id.rv_online_video)
    RecyclerView mRvOnlineVideo;
    @Bind(R.id.tv_allDown)
    TextView mTvAllDown;
    @Bind(R.id.tv_allDelete)
    TextView mTvAllDelete;
    @Bind(R.id.ll_bottom)
    AutoLinearLayout mLlBottom;

    OnlineDetailsResult result;
    List<LayoutWrapper> wrapperList;//数据源
    int[] layoutIds = new int[]{R.layout.recycler_item_title, R.layout.recycler_online_down};//布局


    LinkedHashMap<String, ProgressBar> barMap;
    ActionSheetDialog sheetDialog;
    SuperAdapter superAdapter;


    @Override
    protected void onCreat() {
        setContentView(R.layout.fragment_onlinevideo);
    }

    @Override
    protected void init() {
        EventBus.getDefault().register(this);
        AppUtils.getInstance(getActivity());
        barMap = new LinkedHashMap<String, ProgressBar>();
        result = ((School_Online_DetailsAty) getActivity()).result;
        if (result != null && result.getChapterList().size() > 0 && result.getChapterList().get(0).getSectionList().get(0).getSectionType() == 0) {
            mLlBottom.setVisibility(View.VISIBLE);
        } else {
            mLlBottom.setVisibility(View.GONE);
        }

        wrapperList = new ArrayList<>();
        DataHolder<String> titleHolder = (context, holder, item, position) -> ((TextView) holder.getView(R.id.item_title)).setText(item);
        DataHolder<OnlineDetailsResult.EvalBean.SectionListBean> dataHolder = (context, holder, bean, position) -> {
            ((TextView) holder.getView(R.id.item_title)).setText(bean.getSectionName());
            ProgressBar bar = holder.getView(R.id.pb_item_download);
            barMap.put(String.valueOf(bean.getChapterId()) + String.valueOf(bean.getSectionId()), bar);

            if (bean.getTimeLength() < 1) {
                holder.getView(R.id.item_time).setVisibility(View.GONE);
            } else {
                ((TextView) holder.getView(R.id.item_time)).setText("时长：" + bean.getTimeLength() + "分钟");
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
            if (bean.getSectionType() == 0) {
                ((TextView) holder.getView(R.id.item_type)).setText("视频");//tv_hint.setText("视频");
                String videoUrl = bean.getSectionUrl() + ".f20.mp4";
                List<VideoDb> vdb = getData(videoUrl);
                if (vdb != null && vdb.size() > 0) {

                    /**下载状态 1下载中 2暂停 3下载完成**/
                    if (vdb.get(0).getDownloadstatus() == 0 || vdb.get(0).getDownloadstatus() == -1) {
                        holder.getView(R.id.pb_item_download).setVisibility(View.GONE);
                        holder.getView(R.id.btn_item_operate).setVisibility(View.VISIBLE);
                        holder.getView(R.id.tv_item_size).setVisibility(View.GONE);
                        holder.getView(R.id.tv_item_localplay).setVisibility(View.GONE);
                    } else if (vdb.get(0).getDownloadstatus() == 1) {
                        holder.getView(R.id.pb_item_download).setVisibility(View.VISIBLE);
                        holder.getView(R.id.btn_item_operate).setVisibility(View.GONE);
                        holder.getView(R.id.tv_item_size).setVisibility(View.VISIBLE);
                        holder.getView(R.id.tv_item_localplay).setVisibility(View.GONE);
                        if (DownloadService.progressList.size() > 0 && vdb.get(0).getTotalsize() > 0) {
                            int prs = DownloadService.progressList.get(String.valueOf(vdb.get(0).getChapterid()) + String.valueOf(vdb.get(0).getSectionid()));
                            int total = vdb.get(0).getTotalsize();
                            L.e("进度值:" + prs + "---" + total);
                            if (prs > 0) {
                                long progress = ((long) prs * 100) / (long) total;
                                barMap.get(String.valueOf(vdb.get(0).getChapterid()) + String.valueOf(vdb.get(0).getSectionid())).setProgress((int) progress);
                                String size = getDownloadPerSize(prs, total);
                                ((TextView) holder.getView(R.id.tv_item_size)).setText("大小：" + size);
                            }
                        }
                    } else if (vdb.get(0).getDownloadstatus() == 2) {
                        holder.getView(R.id.pb_item_download).setVisibility(View.VISIBLE);
                        holder.getView(R.id.btn_item_operate).setVisibility(View.GONE);
                        holder.getView(R.id.tv_item_size).setVisibility(View.VISIBLE);
                        holder.getView(R.id.tv_item_localplay).setVisibility(View.GONE);
                        ((ProgressBar) holder.getView(R.id.pb_item_download)).setProgress(vdb.get(0).getDownprogress());
                        ((TextView) holder.getView(R.id.tv_item_size)).setText("大小：" + getDownloadPerSize(vdb.get(0).getDownloadsize(), vdb.get(0).getTotalsize()));
                    } else if (vdb.get(0).getDownloadstatus() == 3) {
                        /**本地播放*/
                        holder.getView(R.id.pb_item_download).setVisibility(View.GONE);
                        holder.getView(R.id.btn_item_operate).setVisibility(View.GONE);
                        holder.getView(R.id.tv_item_size).setVisibility(View.GONE);
                        holder.getView(R.id.tv_item_localplay).setVisibility(View.VISIBLE);
                    }
                }

            } else {
                holder.getView(R.id.pb_item_download).setVisibility(View.GONE);
                holder.getView(R.id.btn_item_operate).setVisibility(View.GONE);
                holder.getView(R.id.tv_item_size).setVisibility(View.GONE);
                holder.getView(R.id.tv_item_localplay).setVisibility(View.GONE);
                if (bean.getSectionType() == 1)
                    ((TextView) holder.getView(R.id.item_type)).setText("资料");
                else
                    ((TextView) holder.getView(R.id.item_type)).setText("试卷");

            }
        };
        for (int i = 0; i < result.getChapterList().size(); i++) {
            if (result.getChapterList().size() > 0) {
                wrapperList.add(new LayoutWrapper(layoutIds[0], result.getChapterList().get(i).getChapterName(), titleHolder));
                for (int j = 0; j < result.getChapterList().get(i).getSectionList().size(); j++) {
                    wrapperList.add(new LayoutWrapper(layoutIds[1], result.getChapterList().get(i).getSectionList().get(j), dataHolder));
                    String videoUrl = result.getChapterList().get(i).getSectionList().get(j).getSectionUrl() + ".f20.mp4";
                    List<VideoDb> vdb = getData(videoUrl);

                    if (vdb.size() == 0) {
                        VideoDb videoDb = new VideoDb();
                        videoDb.setVideourl(videoUrl);
                        videoDb.setChapterid(result.getChapterList().get(i).getSectionList().get(j).getChapterId());
                        videoDb.setSectionid(result.getChapterList().get(i).getSectionList().get(j).getSectionId());
                        videoDb.setCourseid(result.getCourse().getCourseId());
                        videoDb.setSectionname("bwk001_" + result.getCourse().getCourseId() + "_" + result.getChapterList().get(i).getSectionList().get(j).getChapterId() + "_" + result.getChapterList().get(i).getSectionList().get(j).getSectionId());
                        videoDb.save();
                    }
                }
            }
        }

        mRvOnlineVideo.setLayoutManager(new LinearLayoutManager(getActivity()));
        superAdapter = new SuperAdapter(getActivity(), layoutIds);
        superAdapter.setData(wrapperList);
        mRvOnlineVideo.setAdapter(superAdapter);
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
                            //下载视频
                            List<VideoDb> vdb = getData(bean.getSectionUrl() + ".f20.mp4");
                            if (vdb.size() > 0) {
                                VideoDb video = vdb.get(0);
                                setAlertView(video, bean, position);
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
        });
    }

    private List<VideoDb> getData(String url) {
        List<VideoDb> videoDbs = DataSupport.where("videourl = ?", url).find(VideoDb.class);
        return videoDbs;

    }


    public String getDownloadPerSize(int finished, int total) {
        DecimalFormat DF = new DecimalFormat("0");
        return DF.format(finished / (1024 * 1024)) + "M/" + DF.format(total / (1024 * 1024)) + "M";
    }


    private void setAlertView(final VideoDb vdb, final OnlineDetailsResult.EvalBean.SectionListBean sections, final int pos) {
        final NormalDialog dialog = new NormalDialog(getActivity());
        getActivity().setTheme(R.style.ActionSheetStyleIOS);
        if (vdb.getDownloadstatus() == 0 || vdb.getDownloadstatus() == -1) {
            /**开始下载*/
            dialog.content("下载本地")//
                    .isTitleShow(false)
                    .contentGravity(Gravity.CENTER)
                    .titleTextSize(18)//
                    .cornerRadius(5)
                    .btnText(new String[]{"取消", "确定"})
                    .btnTextColor(new int[]{AppUtils.getColor(R.color.color333), AppUtils.getColor(R.color.colorRed)});
            dialog.setOnBtnClickL(new OnBtnClickL() {
                                      @Override
                                      public void onBtnClick() {
                                          dialog.dismiss();
                                      }
                                  }, new OnBtnClickL() {
                                      @Override
                                      public void onBtnClick() {
                                          dialog.dismiss();
                                          VideoDb videoDb = new VideoDb();
                                          videoDb.setDownloadstatus(1);
                                          videoDb.updateAll("videourl = ?", vdb.getVideourl());
                                          /**开启下载*/
                                          downloadService();
                                      }
                                  }
            );
            dialog.show();

        } else if (vdb.getDownloadstatus() == 1) {
            /**暂停下载*/
            dialog.content("暂停下载")//
                    .isTitleShow(false)
                    .contentGravity(Gravity.CENTER)
                    .titleTextSize(18)//
                    .cornerRadius(5)
                    .btnText(new String[]{"取消", "确定"})
                    .btnTextColor(new int[]{AppUtils.getColor(R.color.color333), AppUtils.getColor(R.color.colorRed)});
            dialog.setOnBtnClickL(new OnBtnClickL() {
                                      @Override
                                      public void onBtnClick() {
                                          dialog.dismiss();
                                      }
                                  }, new OnBtnClickL() {
                                      @Override
                                      public void onBtnClick() {
                                          dialog.dismiss();
                                          VideoDb videoDb = new VideoDb();
                                          videoDb.setDownloadstatus(2);
                                          videoDb.setDownprogress(barMap.get(String.valueOf(sections.getChapterId()) + String.valueOf(sections.getSectionId())).getProgress());
                                          videoDb.updateAll("videourl = ?", vdb.getVideourl());
                                          EventBus.getDefault().post(vdb.getVideourl(), "stop");
                                      }
                                  }
            );
            dialog.show();

        } else if (vdb.getDownloadstatus() == 2) {
            /**恢复下载*/
            dialog.content("恢复下载")//
                    .isTitleShow(false)
                    .contentGravity(Gravity.CENTER)
                    .titleTextSize(18)//
                    .cornerRadius(5)
                    .btnText(new String[]{"取消", "确定"})
                    .btnTextColor(new int[]{AppUtils.getColor(R.color.color333), AppUtils.getColor(R.color.colorRed)});
            dialog.setOnBtnClickL(new OnBtnClickL() {
                                      @Override
                                      public void onBtnClick() {
                                          dialog.dismiss();
                                      }
                                  }, new OnBtnClickL() {
                                      @Override
                                      public void onBtnClick() {
                                          dialog.dismiss();
                                          VideoDb videoDb = new VideoDb();
                                          videoDb.setDownloadstatus(1);
                                          videoDb.updateAll("videourl = ?", vdb.getVideourl());
                                          /**开启下载*/
                                          downloadService();
                                      }
                                  }
            );
            dialog.show();

        } else {
            /**下载完成*/
            String[] item = {"本地播放", "删除视频"};
            sheetDialog = new ActionSheetDialog(getActivity(), item, null);
            sheetDialog.isTitleShow(false).show();
            sheetDialog.setOnOperItemClickL(new OnOperItemClickL() {
                @Override
                public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {

                    if (position == 0) {
                        //Message msg = Message.obtain();
//                        msg.what = 4;
//                        msg.obj = sections;
//                        handler.sendMessage(msg);
                        File oldfile = new File(FileIoUtils.getDiskCacheDir(getActivity(), "movies").getPath(), MD5Utils.getMd5("bwk001_" + result.getCourse().getCourseId() + "_" + sections.getChapterId() + "_" + sections.getSectionId()) + ".mp4");
                        L.e("播放文件:" + oldfile.getPath());

                        if (oldfile.exists()) {
                            List<VideoPlayDb> videoPlayDbs = DataSupport.where("sectionid = ?", String.valueOf(sections.getSectionId())).find(VideoPlayDb.class);
                            int progress = 0;
                            if (videoPlayDbs.size() > 0) {
                                progress = videoPlayDbs.get(0).getVideoprogress();
                            }
//                        FileEnDecryptManager.getInstance().doDecrypt(oldfile.getPath());
                            Intent intent = new Intent(getActivity(), MediaPlayerActivity.class);
                            intent.putExtra("video_path", oldfile.getPath().toString());
                            intent.putExtra("video_name", sections.getSectionName());
                            intent.putExtra("video_id", sections.getSectionId());
                            intent.putExtra("video_progress", progress);
                            sheetDialog.dismiss();
                            startActivity(intent);

                        }
                    } else {
                        sheetDialog.dismiss();
                        deleteVideo(sections, pos);
                    }
                }
            });
        }

    }

    private void downloadService() {
        List<VideoDb> videoDbs = DataSupport.where("courseid = ?", String.valueOf(result.getCourse().getCourseId())).find(VideoDb.class);
        Intent down = new Intent(getActivity(), DownloadService.class);
        down.putExtra("downloaddata", (Serializable) videoDbs);
        getActivity().startService(down);
    }

    private void deleteVideo(final OnlineDetailsResult.EvalBean.SectionListBean sections, final int pos) {

        final NormalDialog dialog = new NormalDialog(getActivity());
        dialog.content("确定删除本地视频吗?")//
                .isTitleShow(false)
                .contentGravity(Gravity.CENTER)
                .titleTextSize(18)//
                .cornerRadius(5)
                .btnText(new String[]{"取消", "删除"})
                .btnTextColor(new int[]{AppUtils.getColor(R.color.color333), AppUtils.getColor(R.color.colorRed)});
        dialog.setOnBtnClickL(new OnBtnClickL() {
                                  @Override
                                  public void onBtnClick() {
                                      dialog.dismiss();
                                  }
                              }, new OnBtnClickL() {
                                  @Override
                                  public void onBtnClick() {
                                      dialog.dismiss();

                                      DLManager.getInstance(getActivity()).dlCancel(sections.getSectionUrl() + ".f20.mp4");
                                      File oldfile = new File(FileIoUtils.getDiskCacheDir(getActivity(), "movies").getPath(), MD5Utils.getMd5("bwk001_" + result.getCourse().getCourseId() + "_" + sections.getChapterId() + "_" + sections.getSectionId()) + ".mp4");

                                      if (oldfile.exists()) {
                                          oldfile.delete();
                                          L.e("删除本地文件：" + oldfile.exists());
                                      }

                                      VideoDb videoDb = new VideoDb();
                                      videoDb.setDownloadstatus(-1);
                                      videoDb.setDownloadsize(0);
                                      videoDb.updateAll("videourl = ?", sections.getSectionUrl() + ".f20.mp4");
//                                      int result = VideoDb.deleteAll(VideoDb.class, "videourl = ?", sections.getSectionUrl() + ".f20.mp4");
//                                      LoggerUtils.logE("删除数据库的值", "" + result);
//                                      DownloadService.progressList.clear();
//                                      filesizeMap.clear();
//                                      if (result != 0) {
                                      downloadService();
                                      superAdapter.notifyDataSetChanged();

//                                      }
                                  }
                              }
        );

        dialog.show();
    }

    @Override
    protected void onResult(int request, Intent data) {

    }

    /**
     * 描述：全部删除
     * 作者：Jacky
     * 日期：2015/12/24-0024
     */
    @Subscriber(tag = "alldelete")
    void deleteAll(boolean delete) {

        if (delete) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    List<VideoDb> videoDbs = DataSupport.where("courseid = ?", String.valueOf(result.getCourse().getCourseId())).find(VideoDb.class);
                    if (videoDbs.size() == 0) {
                        final NormalDialog dialog = new NormalDialog(getActivity());
                        dialog.content("你还没有下载本节课程哦!")//
                                .btnNum(1)
                                .contentGravity(Gravity.CENTER)
                                .btnText("确认")//
                                .isTitleShow(false)
                                .cornerRadius(5)
                                .btnTextColor(AppUtils.getColor(R.color.colorRed))
                                .show();

                        dialog.setOnBtnClickL(new OnBtnClickL() {
                            @Override
                            public void onBtnClick() {
                                dialog.dismiss();
                            }
                        });
                        return;
                    }
                    sheetDialog = new ActionSheetDialog(getActivity(), new String[]{"确认"}, null);
                    sheetDialog.title("是否删除本节课中的全部视频")

                            .titleTextColor(AppUtils.getColor(R.color.color333))
                            .titleTextSize_SP(14)
                            .layoutAnimation(null)

                            .show();
                    sheetDialog.setOnOperItemClickL(new OnOperItemClickL() {
                        @Override
                        public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                            sheetDialog.dismiss();
                            if (position == 0) {
                                List<VideoDb> videoDbs = DataSupport.where("courseid = ?", String.valueOf(result.getCourse().getCourseId())).find(VideoDb.class);
                                for (int i = 0; i < videoDbs.size(); i++) {
                                    VideoDb videoDb = new VideoDb();
                                    videoDb.setDownloadstatus(-1);
                                    videoDb.setDownloadsize(0);
                                    videoDb.updateAll("videourl = ?", videoDbs.get(i).getVideourl());
                                    DLManager.getInstance(getActivity()).dlCancel(videoDbs.get(i).getVideourl());
                                    File oldfile = new File(FileIoUtils.getDiskCacheDir(getActivity(), "movies").getPath(), MD5Utils.getMd5(videoDbs.get(i).getSectionname()) + ".mp4");
                                    if (oldfile.exists()) {
                                        oldfile.delete();
                                    }
//                                    int result = VideoDb.deleteAll(VideoDb.class, "videourl = ?", videoDbs.get(i).getVideourl());
//                                    LoggerUtils.logE("删除数据库的值", "-----" + result);
                                }
                                superAdapter.notifyDataSetChanged();
                            }
                        }
                    });
                }
            }, 200);

        }
    }

    /**
     * 描述：全部下载
     * 作者：Jacky
     * 日期：2015/12/25-0025
     */
    @Subscriber(tag = "allstart")
    void startAll(boolean start) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                sheetDialog = new ActionSheetDialog(getActivity(), new String[]{"确认"}, null);
                sheetDialog.title("是否下载本节课中的全部视频")
                        .titleTextColor(AppUtils.getColor(R.color.color333))
                        .titleTextSize_SP(14)
                        .layoutAnimation(null)
                        .show();

                sheetDialog.setOnOperItemClickL(new OnOperItemClickL() {
                    @Override
                    public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                        sheetDialog.dismiss();
                        if (position == 0) {
                            EventBus.getDefault().post("全部暂停", "text");
                            List<VideoDb> videoDbs = DataSupport.where("courseid = ?", String.valueOf(result.getCourse().getCourseId())).find(VideoDb.class);
                            if (videoDbs.size() > 0) {
                                for (VideoDb vdb : videoDbs) {
                                    if (vdb.getDownloadstatus() != 3) {
                                        vdb.setDownloadstatus(1);
                                        vdb.updateAll("videourl = ?", vdb.getVideourl());
                                    }

                                }
                                downloadService();
                            }
                        }
                    }
                });
            }
        }, 200);

    }

    /**
     * 描述：全部暂停
     * 作者：Jacky
     * 日期：2015/12/25-0025
     */
    @Subscriber(tag = "allstop")
    void stopAll(boolean stop) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final List<VideoDb> videoDbs = DataSupport.where("courseid = ?", String.valueOf(result.getCourse().getCourseId())).find(VideoDb.class);
                if (videoDbs.size() == 0) {
                    final NormalDialog dialog = new NormalDialog(getActivity());
                    dialog.content("你还没有下载本节课程哦!")//
                            .btnNum(1)
                            .contentGravity(Gravity.CENTER)
                            .btnText("确认")//
                            .isTitleShow(false)
                            .cornerRadius(5)
                            .btnTextColor(AppUtils.getColor(R.color.colorRed))
                            .show();

                    dialog.setOnBtnClickL(new OnBtnClickL() {
                        @Override
                        public void onBtnClick() {
                            dialog.dismiss();
                        }
                    });
                    return;
                }
                sheetDialog = new ActionSheetDialog(getActivity(), new String[]{"确认"}, null);
                sheetDialog.title("是否暂停下载本节课中的全部视频")
                        .titleTextColor(AppUtils.getColor(R.color.color333))
                        .titleTextSize_SP(14)
                        .layoutAnimation(null)
                        .show();
                sheetDialog.setOnOperItemClickL(new OnOperItemClickL() {
                    @Override
                    public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                        sheetDialog.dismiss();
                        if (position == 0) {
                            EventBus.getDefault().post("全部下载", "text");
                            for (VideoDb videoDb : videoDbs) {
                                if (videoDb.getDownloadstatus() != 3) {

//                                    VideoDb vdb = new VideoDb();
//                                    String videoUrl = vdb.getVideourl();
//                                bar.setProgress(bar.getProgress());
                                    videoDb.setDownloadstatus(2);
                                    if (barMap.get(String.valueOf(videoDb.getChapterid()) + String.valueOf(videoDb.getSectionid())) != null) {
                                        videoDb.setDownprogress(barMap.get(String.valueOf(videoDb.getChapterid()) + String.valueOf(videoDb.getSectionid())).getProgress());
                                    }
//                                videoDb.setDownprogress(bar.getProgress());
                                    videoDb.updateAll("videourl = ?", videoDb.getVideourl());
                                }
                            }
                            downloadService();
//
                        }
                    }
                });
            }
        }, 200);

    }

    /**
     * 描述：获取文件总大小
     * 作者：Jacky
     * 日期：2015/12/24-0024
     */
    @Subscriber(tag = "filesize")
    private void updateSize(LinkedHashMap<Integer, Integer> map) {
//        this.filePos = pos;
//        videoDbs = initData(videoUrl);
//        filesizeMap = map;
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i).intValue() > 0) {
                //this.filePos = i;

            }
        }

//        adapter.notifyDataSetChanged();
    }

//    @Subscriber (tag = "downloadfragment")
//    void showView(boolean show){
//        lvChaptersection.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                adapter.notifyDataSetChanged();
//            }
//        }, 200);
//    }


    /**
     * 描述：更新进度条
     * 作者：Jacky
     * 日期：2015/12/24-0024
     */
    @Subscriber(tag = "progress")
    void updateProgress(LinkedHashMap<String, Integer> map) {
//        LoggerUtils.logE("下载进度map",progress.keySet().iterator().next().toString());
//        for(int i = 0;i <progress.size();i++){
//
//            dataMap.put(i, progress);
//            adapter.notifyDataSetChanged();
//        }
//       for(int i = 0;i <map.size();i++){
//           ProgressBar bar = barMap.get(String.valueOf(sections.getChapterId())+String.valueOf(sections.getSectionId()));
//           bar.setProgress(Integer.parseInt((map.get(String.valueOf(sections.getChapterId())+String.valueOf(sections.getSectionId())) * 100) / DownloadService.filesizeMap.get(sections.getChapterId())+String.valueOf(sections.getSectionId())));
//       }
//        adapter.notifyDataSetChanged();
        superAdapter.notifyDataSetChanged();
    }

    /**
     * 描述：暂停下载
     * 作者：Jacky
     * 日期：2015/12/24-0024
     */
    @Subscriber(tag = "stopdown")
    void stopDownload(boolean stop) {
        superAdapter.notifyDataSetChanged();
    }


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    File file = (File) msg.obj;
//                    LoggerUtils.logE("下载完成的文件路径", file.getPath());
//                    FileEnDecryptManager.getInstance().doEncrypt(file.getPath());
                    if (superAdapter != null) {
                        superAdapter.notifyDataSetChanged();
                    }
                    break;
                case 4:
                    OnlineDetailsResult.EvalBean.SectionListBean sections = (OnlineDetailsResult.EvalBean.SectionListBean) msg.obj;
                    File oldfile = new File(FileIoUtils.getDiskCacheDir(getActivity(), "movies").getPath(), MD5Utils.getMd5("bwk001_" + result.getCourse().getCourseId() + "_" + sections.getChapterId() + "_" + sections.getSectionId()) + ".mp4");
                    L.e("播放：" + oldfile.getPath());
                    if (oldfile.exists()) {
                        List<VideoPlayDb> videoPlayDbs = DataSupport.where("sectionid = ?", String.valueOf(sections.getSectionId())).find(VideoPlayDb.class);
                        int progress = 0;
                        if (videoPlayDbs.size() > 0) {
                            progress = videoPlayDbs.get(0).getVideoprogress();
                        }
//                        FileEnDecryptManager.getInstance().doDecrypt(oldfile.getPath());
                        Intent intent = new Intent(getActivity(), MediaPlayerActivity.class);
                        intent.putExtra("video_path", oldfile.getPath().toString());
                        intent.putExtra("video_name", sections.getSectionName());
                        intent.putExtra("video_id", sections.getSectionId());
                        intent.putExtra("video_progress", progress);
                        startActivity(intent);
                    }


                    break;
            }

        }
    };

    /**
     * 下载完成
     */
    @Subscriber(tag = "finish")
    void onFinish(File file) {
        Message msg = Message.obtain();
        msg.obj = file;
        msg.what = 3;
        handler.sendMessage(msg);
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

    @OnClick({R.id.tv_allDown, R.id.tv_allDelete})
    public void onClick(View view) {
        if (APP.isVip) {
            switch (view.getId()) {
                case R.id.tv_allDown:
                    if (mTvAllDown.getText().toString().equals("全部下载")) {
                        mTvAllDown.setText("全部暂停");
                        EventBus.getDefault().post(true, "allstart");
                    } else {
                        mTvAllDown.setText("全部下载");
                        EventBus.getDefault().post(true, "allstop");
                    }
                    break;
                case R.id.tv_allDelete:
                    EventBus.getDefault().post(true, "alldelete");
                    break;
            }
        } else {
            HTTPutils.showGOvipDialog(getActivity());
        }

    }
}
