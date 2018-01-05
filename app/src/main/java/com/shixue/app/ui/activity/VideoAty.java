package com.shixue.app.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.gensee.chat.gif.SpanResource;
import com.gensee.common.GenseeConfig;
import com.gensee.common.ServiceType;
import com.gensee.entity.ChatMsg;
import com.gensee.entity.DocInfo;
import com.gensee.entity.InitParam;
import com.gensee.entity.PingEntity;
import com.gensee.entity.QAMsg;
import com.gensee.entity.UserInfo;
import com.gensee.entity.VodObject;
import com.gensee.holder.chat.ExpressionResource;
import com.gensee.media.VODPlayer;
import com.gensee.player.OnChatListener;
import com.gensee.player.OnPlayListener;
import com.gensee.player.Player;
import com.gensee.taskret.AbsTaskRet;
import com.gensee.view.ChatEditText;
import com.gensee.view.GSDocViewGx;
import com.gensee.view.GSVideoView;
import com.gensee.view.MyTextViewEx;
import com.gensee.vod.VodSite;
import com.jjs.Jbase.BaseActivity;
import com.jjs.Jutils.RecyclerView.BaseReHolder;
import com.jjs.Jutils.RecyclerView.SingleReAdpt;
import com.shixue.app.APP;
import com.shixue.app.R;
import com.shixue.app.ui.bean.DirectDetailsResult;
import com.shixue.app.ui.bean.IconBean;
import com.shixue.app.ui.bean.VideoMessageBean;
import com.shixue.app.utils.L;
import com.shixue.app.utils.SweetDialog;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 本页：
 * Created by jjs on 2016-12-21.
 * Email:994462623@qq.com
 */

public class VideoAty extends BaseActivity {
    @Bind(R.id.Top_video)
    GSVideoView mTopVideo;
    @Bind(R.id.Top_doc)
    GSDocViewGx mTopDoc;
    @Bind(R.id.small_video)
    GSVideoView mSmallVideo;
    @Bind(R.id.small_doc)
    GSDocViewGx mSmallDoc;
    @Bind(R.id.tv_caching)
    TextView mTvCaching;

    @Bind(R.id.max_video)
    GSVideoView mMaxVideo;
    @Bind(R.id.max_doc)
    GSDocViewGx mMaxDoc;
    @Bind(R.id.bottom_video)
    GSVideoView mBottomVideo;
    @Bind(R.id.bottom_doc)
    GSDocViewGx mBottomDoc;
    @Bind(R.id.rela_max)
    AutoRelativeLayout mRelaMax;//最大所有布局
    @Bind(R.id.rela_min)
    AutoLinearLayout mRelaMin;//最小布局
    @Bind(R.id.tv_people)
    TextView mTvPeople;//在线人数
    @Bind(R.id.tv_pause)
    TextView mTvPause;//暂停提示
    @Bind(R.id.tv_sendMsg)
    TextView mTvSendMsg;//发送
    @Bind(R.id.rv_message)
    RecyclerView mRvMessage;//显示
    @Bind(R.id.edit_message)
    ChatEditText mEditMessage;
    @Bind(R.id.seek_min)
    SeekBar mSeekMin;
    @Bind(R.id.seek_max)
    SeekBar mSeekMax;

    @Bind(R.id.rela_top)
    AutoRelativeLayout mRelaTop;
    @Bind(R.id.rela_maxShow)
    AutoRelativeLayout mRelaMaxShow;

    SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
    List<VideoMessageBean> msgList;//消息列表
    SingleReAdpt mReAdpt;//消息适配器
    List<IconBean> iconList = new ArrayList<>();//聊天图标
    int keyboardHeight;//键盘高度
    boolean isFirst = true;

    VodSite vodSite;
    VODPlayer vodPlayer;
    String vodID = "";//录播id
    static int seekNum;//播放进度
    List<ChatMsg> vodMsgList = new ArrayList<>();


    Player player;
    static boolean isShowVide = false;//设置主屏是否显示video
    SweetDialog progess;//弹窗提示
    boolean isMute;//是否可以聊天(这个是在聊天监听里的)
    static boolean isMax = false;//是否最大化显示
    DirectDetailsResult.LiveSectionListBean mSectionBean;//节数据
    boolean isVod = false;//是否是录播
    boolean isShowBtn;//是否显示按钮


    @Bind(R.id.img_change)
    ImageView mImgChange;
    @Bind(R.id.tv_max)
    ImageView mTvMax;
    @Bind(R.id.img_max_change)
    ImageView mImgMaxChange;
    @Bind(R.id.tv_min)
    ImageView mTvMin;

    long moveTime = 0;//触摸图像移动的时间
    @Bind(R.id.top_back)
    ImageView mTopBack;
    @Bind(R.id.max_back)
    ImageView mMaxBack;
    @Bind(R.id.rela_topShowBtn)
    AutoRelativeLayout mRelaTopShowBtn;
    @Bind(R.id.rela_maxShowBtn)
    AutoRelativeLayout mRelaMaxShowBtn;
    @Bind(R.id.rv_icon)
    RecyclerView mRvIcon;
    @Bind(R.id.ll_send)
    AutoLinearLayout mLlSend;
    @Bind(R.id.rela_msgALL)
    AutoRelativeLayout mRelaMsgALL;
    InputMethodManager imm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (isMax) {
            setFullscreen(true);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gensee_video);
        ButterKnife.bind(this);
        setOnBackListener(() -> {
            if (isMax) {
                isMax = false;
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            } else {
                setResult(999);
                finish();
            }
        });
        mTopBack.setOnClickListener(v -> {
            setResult(999);
            finish();
        });
        mMaxBack.setOnClickListener(v -> {
            isMax = false;
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        });
        /**
         * 控件监听
         */

        mRelaTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isShowBtn = isShowBtn ? false : true;
                changeView();

            }
        });
        mRelaMaxShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isShowBtn = isShowBtn ? false : true;
                changeView();
            }
        });
        mRelaTop.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP:
                        //抬起
                        break;
                    case MotionEvent.ACTION_DOWN:
                        //按下
                        break;
                    case MotionEvent.ACTION_MOVE:
                        //移动
                        break;
                }
                return false;
            }
        });
        progess = new SweetDialog(VideoAty.this, SweetDialog.PROGRESS_TYPE).setTitleText("加载中...");
        progess.show();
        //获取节数据
        mSectionBean = (DirectDetailsResult.LiveSectionListBean) getIntent().getSerializableExtra("bean");
        if (!TextUtils.isEmpty(mSectionBean.getLiveSectionUrl())) {
            isVod = true;
            mSeekMin.setVisibility(View.VISIBLE);
            mSeekMax.setVisibility(View.VISIBLE);
            mRelaMsgALL.setVisibility(View.GONE);
        } else {
            isVod = false;
            mSeekMin.setVisibility(View.GONE);
            mSeekMax.setVisibility(View.GONE);
        }
        if (isVod) {
            //如果是录播
            initVod();
        } else {
            //如果不是录播
            initPlayer();
        }

        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

    }

    public void initVod() {

        vodSite = new VodSite(VideoAty.this);
        vodSite.setVodListener(new VodSite.OnVodListener() {
            @Override
            public void onChatHistory(String s, List<ChatMsg> list, int i, boolean b) {
                //只能列表获取

           /*     for (int i1 = 0; i1 < list.size(); i1++) {
                    vodMsgList.add(list.get(i1));
                }*/
                if (b) {
                    vodSite.getChatHistory(s, i + 1);
                }
              /*  Message message = new Message();
                message.what = 20;
                vodHandler.sendMessage(message);*/
            }

            @Override
            public void onQaHistory(String s, List<QAMsg> list, int i, boolean b) {

            }

            @Override
            public void onVodErr(int i) {
                L.e("vodSite错误：" + i);
                Message message = new Message();
                message.what = 1;
                message.arg1 = i;
                vodHandler.sendMessage(message);
            }

            @Override
            public void onVodObject(String s) {
                //得到点播id，用来下载和播放
                vodID = s;
                Message message = new Message();
                message.what = 0;
                vodHandler.sendMessage(message);

            }

            @Override
            public void onVodDetail(VodObject vodObject) {

            }
        });
        InitParam param = new InitParam();
        param.setDomain("dadeedu.gensee.com");
        param.setNumber(mSectionBean.getLiveSectionUrl() + "");
        param.setVodPwd(mSectionBean.getVideoPassword() + "");
        param.setServiceType(ServiceType.TRAINING);//服务器类型。固定
        param.setNickName(APP.userInfo.getBody().getUser().getSex() + APP.userInfo.getBody().getUser().getUserName());
        vodSite.getVodObject(param);
        //聊天消息
       /* mRvMessage.setLayoutManager(new LinearLayoutManager(this));
        mReAdpt = new SingleReAdpt<ChatMsg>(VideoAty.this, R.layout.recycler_video_vodmsg, vodMsgList) {
            @Override
            protected void BindData(BaseReHolder holder, int position, ChatMsg data) {
                //设置聊天内容
                ((MyTextViewEx) holder.getView(R.id.item_rich_message)).setRichText(data.getRichText());
                String sex = "0";
                if (data.getSender().length() > 0) {
                    sex = data.getSender().substring(0, 1);
                }

                //设置性别头像
                if (sex.equals("0")) {
                    holder.getImgV(R.id.item_img_sex).setSrc(R.drawable.ic_man);
                } else {
                    holder.getImgV(R.id.item_img_sex).setSrc(R.drawable.ic_woman);
                }
                //设置用户名
                holder.getTV(R.id.item_tv_name).setText(data.getSender().substring(1) + "(" + format.format(new Date(data.getTimeStamp())) + ")：");
            }
        };
        mRvMessage.setAdapter(mReAdpt);*/
    }

    Handler vodHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    //加入成功
                    startVodPlayer();
                    if (progess != null) {
                        progess.cancel();
                    }
                    break;
                case 1:
                    showtitleDialog(-4, msg.arg1);
                    if (progess != null) {
                        progess.cancel();
                    }
                    break;
                case 10:
                    //播放进度
                    mSeekMin.setProgress(seekNum);
                    mSeekMax.setProgress(seekNum);
                    if (seekNum == mSeekMax.getMax()) {
                        seekNum = 0;
                    }
                    break;
                case 20:
                    //聊天消息
                    //  mReAdpt.setData(vodMsgList);
                    break;

            }
        }
    };


    public void startVodPlayer() {
        //播放
        GenseeConfig.isNeedChatMsg = true;
        vodPlayer = new VODPlayer();
        changeView();
        mSeekMin.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekNum = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                vodPlayer.seekTo(seekNum);
            }
        });
        mSeekMax.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekNum = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                vodPlayer.seekTo(seekNum);
            }
        });
        vodSite.getChatHistory(vodID, 1);
        vodPlayer.play(vodID, new VODPlayer.OnVodPlayListener() {
            @Override
            public void onInit(int i, boolean b, int i1, List<DocInfo> list) {
                mSeekMin.setMax(i1);
                mSeekMax.setMax(i1);
                if (seekNum != 0) {
                    vodPlayer.seekTo(seekNum);
                }
            }

            @Override
            public void onPlayStop() {

            }

            @Override
            public void onPlayPause() {

            }

            @Override
            public void onPlayResume() {

            }

            @Override
            public void onPosition(int i) {
                //播放进度
                Message message = new Message();
                message.what = 10;
                seekNum = i;
                vodHandler.sendMessage(message);
            }

            @Override
            public void onVideoSize(int i, int i1, int i2) {

            }

            @Override
            public void onPageSize(int i, int i1, int i2) {

            }

            @Override
            public void onSeek(int i) {
            }

            @Override
            public void onAudioLevel(int i) {

            }

            @Override
            public void onCaching(boolean b) {

            }

            @Override
            public void onVideoStart() {

            }

            @Override
            public void onChat(List<ChatMsg> list) {
                //聊天消息回调
             /*   L.e("消息");
                if (list != null)
                    L.e("vod消息回调：" + list.size());
                vodMsgList = list;
                Message message = new Message();
                message.what = 20;
                vodHandler.sendMessage(message);*/
            }

            @Override
            public void onDocInfo(List<DocInfo> list) {

            }

            @Override
            public void onError(int i) {
                L.e("错误：" + i);
            }
        }, "", false);
        // getIconList();
    }

    public void getIconList() {
        ExpressionResource.initExpressionResource(this);
        //获取聊天图片
        Map<String, Drawable> iconMap = SpanResource.getBrowMap(VideoAty.this);
        //聊天图片放置于list集合中
        for (Map.Entry<String, Drawable> entry : iconMap.entrySet()) {
            iconList.add(new IconBean(entry.getKey(), entry.getValue()));
        }
        //设置显示控件
        mRvIcon.setLayoutManager(new GridLayoutManager(this, 6));
        SingleReAdpt reAdpt = new SingleReAdpt<IconBean>(this, R.layout.recycler_icon, iconList) {
            @Override
            protected void BindData(BaseReHolder holder, int position, IconBean data) {
                ((ImageView) holder.getView(R.id.item_img_icon)).setImageDrawable(data.getIcon());
            }
        };
        reAdpt.setOnItemClickListener(new SingleReAdpt.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                mEditMessage.insertAvatar(iconList.get(position).getKey(), 0);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
        mRvIcon.setAdapter(reAdpt);
      /*  AutoRelativeLayout decorView = (AutoRelativeLayout) findViewById(R.id.rootview);
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Rect r = new Rect();
                getWindow().getDecorView().getWindowVisibleDisplayFrame(r);
                keyboardHeight = Math.abs(APP.windowHeight - (r.bottom - r.top));
                L.e("软键盘高度：" + keyboardHeight);
                LinearLayout.LayoutParams params = new AutoLinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, keyboardHeight);
                mRvIcon.setLayoutParams(params);
                isFirst = false;
                if (keyboardHeight < APP.windowHeight / 3 && mRvIcon.getVisibility() != View.VISIBLE) {
                    mLlShowSend.setVisibility(View.VISIBLE);
                    mLlSend.setVisibility(View.GONE);
                }
                decorView.getViewTreeObserver()
                        .removeGlobalOnLayoutListener(this);
              *//*
                if (keyboardHeight > keyboard && mRvIcon.getVisibility() != View.VISIBLE) {
                    mLlShowSend.setVisibility(View.VISIBLE);
                    mLlSend.setVisibility(View.GONE);
                    keyboardHeight = keyboard;
                }*//*

            }
        });*/
        mEditMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRvIcon.setVisibility(View.GONE);
            }
        });
        mEditMessage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() < 1) {
                    mTvSendMsg.setBackgroundResource(R.drawable.shape_bg_sendfalse);
                } else {
                    mTvSendMsg.setBackgroundResource(R.drawable.shape_bg_sendtrue);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    public void initPlayer() {
        getIconList();
        msgList = new ArrayList<>();
        //设置显示参数
        player = new Player();
        changeView();
        //  mTopVideo.setRenderMode(GSVideoView.RenderMode.RM_FILL_CENTER_CROP);//裁剪显示图像
        mTopDoc.showAdaptView();//等比拉伸文档
        //设置参数
        InitParam param = new InitParam();
        param.setDomain("dadeedu.gensee.com");//站点。固定
        param.setServiceType(ServiceType.TRAINING);//服务器类型。固定
        param.setNumber(mSectionBean.getClassroomId() + "");//直播视频的id
        param.setJoinPwd(mSectionBean.getClassroomPassword() + "");//直播进入口令 //加入直播并设置监听

        param.setNickName(APP.userInfo.getBody().getUser().getSex() + APP.userInfo.getBody().getUser().getUserName());//用户名
        param.setUserId(Long.parseLong(APP.userInfo.getBody().getUser().getMobile()));//通过这个设置用户标识，与本地用户数据进行关联，显示头像等数据
        //聊天消息列表显示
        mRvMessage.setLayoutManager(new LinearLayoutManager(VideoAty.this));
        mReAdpt = new SingleReAdpt<VideoMessageBean>(VideoAty.this, R.layout.recycler_video_message, msgList) {
            @Override
            protected void BindData(BaseReHolder holder, int position, VideoMessageBean data) {
                //设置聊天内容
                ((MyTextViewEx) holder.getView(R.id.item_rich_message)).setRichText(data.getRichText());
                String sex = "0";
                if (data.getName().length() > 0) {
                    sex = data.getName().substring(0, 1);
                }

                L.e("姓名：" + data.getName() + "-=-性别：" + sex);
                //设置性别头像
                if (sex.equals("0")) {
                    holder.getImgV(R.id.item_img_sex).setSrc(R.drawable.ic_man);
                } else {
                    holder.getImgV(R.id.item_img_sex).setSrc(R.drawable.ic_woman);
                }
                //设置用户名
                holder.getTV(R.id.item_tv_name).setText(data.getName().substring(1) + "：");
            }
        };
        mRvMessage.setAdapter(mReAdpt);
        //聊天监听
        player.setOnChatListener(new OnChatListener() {
            @Override
            public void onChatWithPerson(long l, String s, int i, String s1, String s2, int i1) {
                //私聊通知
            }

            @Override
            public void onChatWithPublic(long l, String s, int i, String s1, String s2, int i1) {
                //公聊通知
                L("id:" + l + "==用户名：" + s + "==Role：" + "==纯文本：" + s1 + "==富文本：" + s2 + "==聊天id：" + i1);
                Message message = new Message();
                message.what = 100;
                message.obj = new VideoMessageBean(l, s, s1, s2, i1);
                mHandler.sendMessage(message);
            }

            @Override
            public void onMute(boolean b) {
                //聊天权限通知
                isMute = b;
            }

            @Override
            public void onRoomMute(boolean b) {

            }

            @Override
            public void onReconnection() {

            }

            @Override
            public void onPublish(boolean b) {

            }
        });
        L.e("加入参数：userID:" + param.getUserId() + "--NickName:" + param.getNickName() + "--Domain:" + param.getDomain() + "--Number:" + param.getNumber() + "--JoinPwd:" + param.getJoinPwd());
        //加入监听
        player.join(VideoAty.this, param, new OnPlayListener() {
            @Override
            public void onJoin(int i) {
                L("第1个：" + i);
                Message message = new Message();
                message.what = -2;
                message.arg1 = i;
                mHandler.sendMessage(message);
            }

            @Override
            public void onUserJoin(UserInfo userInfo) {
                L("第2个：" + userInfo.getName());
                //用户加入监听
                L("用户id：" + userInfo.getUserId());
            }

            @Override
            public void onUserLeave(UserInfo userInfo) {
                L("第3个：" + userInfo.getName());
            }

            @Override
            public void onUserUpdate(UserInfo userInfo) {
                L("第4个：" + userInfo.getName());
            }

            @Override
            public void onRosterTotal(int i) {
                L("第5个：" + i);
                //在线人数回调（需要老师端勾选）
                Message message = new Message();
                message.what = 4;
                message.arg1 = i;//在线人数
                mHandler.sendMessage(message);
            }

            @Override
            public void onReconnecting() {
                L("第6个：");
            }

            @Override
            public void onLeave(int i) {
                L("第7个：" + i);
                //退出直播间
                Message message = new Message();
                message.what = -3;
                message.arg1 = i;
                mHandler.sendMessage(message);
            }

            @Override
            public void onCaching(boolean b) {
                L("第8个：" + b);
                //缓冲监听（true进入缓冲，false缓冲完成）
                Message message = new Message();
                message.what = 2;
                if (b) {
                    message.arg1 = 0;
                } else {
                    message.arg1 = 1;
                }
                mHandler.sendMessage(message);

            }

            @Override
            public void onErr(int i) {
                L("第9个：" + i);
                Message message = new Message();
                message.what = -1;
                message.arg1 = i;
                mHandler.sendMessage(message);
            }

            @Override
            public void onDocSwitch(int i, String s) {
                L("第10个：" + i + s);
            }

            @Override
            public void onVideoBegin() {
                L("第11个：");
                //视频开始播放
                Message message = new Message();
                message.what = 0;
                mHandler.sendMessage(message);
            }

            @Override
            public void onVideoEnd() {
                L("第12个：");
                //视频停止播放
                //清除最后的图像画面
                mTopVideo.renderDefault();
            }

            @Override
            public void onVideoSize(int i, int i1, boolean b) {
                L("第13个：" + i + "==" + i1 + "==" + b);
                //获取图像的宽高，bool无效参数
            }

            @Override
            public void onAudioLevel(int i) {
                //返回音量值（0~100）回调以10为单位间隔，用户显示音频大小（progess）
            }

            @Override
            public void onPublish(boolean b) {
                L("第15个：" + b);
                //直播状态通知（true直播中，false直播暂停）
                Message message = new Message();
                message.what = 3;
                if (b) {
                    message.arg1 = 0;
                } else {
                    message.arg1 = 1;
                }
                mHandler.sendMessage(message);

            }

            @Override
            public void onSubject(String s) {
                L("第16个：" + s);
            }

            @Override
            public void onPageSize(int i, int i1, int i2) {
                L("第17个：" + i);
            }

            @Override
            public void onPublicMsg(long l, String s) {
                L("第18个：");
                //直播间广播（l一直为0，s为内容）
                Message message = new Message();
                message.what = 5;
                message.obj = s;
                mHandler.sendMessage(message);

            }

            @Override
            public void onLiveText(String s, String s1) {
                L("第19个：");
            }

            @Override
            public void onRollcall(int i) {
                L("第20个：");
            }

            @Override
            public void onLottery(int i, String s) {
                L("第21个：");
            }

            @Override
            public void onFileShare(int i, String s, String s1) {
                L("第22个：");
            }

            @Override
            public void onFileShareDl(int i, String s, String s1) {
                L("第23个：");
            }

            @Override
            public void onInvite(int i, boolean b) {
                L("第24个：");
            }

            @Override
            public void onMicNotify(int i) {
                L("第25个：");
            }

            @Override
            public void onScreenStatus(boolean b) {
                L("第26个：");
            }

            @Override
            public void onModuleFocus(int i) {
                L("第27个：");
                //观看端布局变更，由教师端操作
                Message message = new Message();
                message.what = 1;
                message.arg1 = i;
                mHandler.sendMessage(message);

            }

            @Override
            public void onIdcList(List<PingEntity> list) {
                L("第28个：");
                player.setIdcId(list.get(0).getId(), new AbsTaskRet() {
                    @Override
                    public void onTaskRet(Object o, String s) {
                        L(s);
                    }
                });
                for (int i = 0; i < list.size(); i++) {
                    L(list.get(i).getName());
                }
            }
        });
    }

    public void showtitleDialog(int type, int error) {
        String title = "";
        switch (type) {
            case -4:
                //录播vodSite出错
                switch (error) {
                    case -201:
                        title = "没有调用getVodObject";
                        break;
                    case 14:
                        title = "初始化失败";
                        break;
                    case 15:
                        title = "编号不存在或视频不存在";
                        break;
                    case 16:
                        title = "加入密码错误";
                        break;
                    case 17:
                        title = "账号或密码错误";
                        break;
                    case 18:
                        title = "此视频不支持移动设备";
                        break;
                    case -100:
                        title = "domain不正确";
                        break;
                    case -101:
                        title = "加入超时";
                        break;
                    case -102:
                        title = "未知错误";
                        break;
                    case -103:
                        title = "domain不可用";
                        break;
                    case -104:
                        title = "无网络";
                        break;
                    case -105:
                        title = "视频已过期";
                        break;
                    case -106:
                        title = "sevice服务不正确";
                        break;
                    case -107:
                        title = "参数错误";
                        break;
                    case -108:
                        title = "认证失败";
                        break;
                }
                break;
            case -3:
                switch (error) {
                    //退出直播回调
                    case 0x01:
                        //正常退出
                        break;
                    case 0x02:
                        //被踢
                        title = "被管理员请出直播";
                        break;
                    case 0x03:
                        //超时退出
                        title = "连接服务器超时";
                        break;
                    case 0x04:
                        //直播间关闭
                        title = "直播间已关闭";
                        break;
                    case 0x05:
                        //未知原因退出
                        title = "发生未知错误，请重试";
                        break;
                    case 0x0e:
                        //相同用户id登陆被挤出
                        title = "账号在其他地方登陆";
                        break;
                }
                break;
            case -2:
                switch (error) {
                    //加入回调
                    case 0x06:
                        //正常
                        break;
                    case 0x06 + 1:
                        //正在加入
                        break;
                    case 0x06 + 2:
                        //正在加入
                        title = "连接失败";
                        break;
                    case 0x06 + 3:
                        //正在加入
                        title = "连接服务器超时";
                        break;
                    case 0x06 + 4:
                        //正在加入
                        title = "连接服务器失败";
                        break;
                    case 0x06 + 5:
                        //正在加入
                        title = "直播间还未开启直播";
                        break;
                    case 0x06 + 6:
                        //正在加入
                        title = "直播间人数已满";
                        break;
                    case 0x10:
                        title = "用户已在其他客户端加入";
                        break;
                    case 0x11:
                        title = "无权加入";
                        break;
                }
                break;
            case -1:
                switch (error) {
                    //错误回调
                    case 0:
                        title = "直播间不存在";
                        break;
                    case 3:
                        title = "直播ID不正确";
                        break;
                    case 4:
                        title = "加入口令错误";
                        break;
                    case 5:
                        title = "用户名或密码错误";
                        break;
                    case 6:
                        title = "直播未开始或直播过期";
                        break;
                    case 7:
                        title = "此直播只支持web端";
                        break;
                    case 8:
                        title = "直播间不可用";
                        break;
                    case 11:
                        title = "直播过期";
                        break;
                    case 12:
                        title = "权限不足";
                        break;
                    case 13:
                        title = "直播未开始";
                        break;
                    case -1:
                        title = "响应的数据格式不正确，请检查网络或参数";
                        break;
                    case -100:
                        title = "domain不正确";
                        break;
                    case -101:
                        title = "连接超时";
                        break;
                    case -102:
                        title = "未知错误";
                        break;
                    case -103:
                        title = "站点不可用";
                        break;
                    case -104:
                        title = "无网络";
                        break;
                    case -106:
                        title = "service服务错误";
                        break;
                    case -107:
                        title = "参数错误";
                        break;
                    case -108:
                        title = "第三方认证失败";
                        break;
                    case -109:
                        title = "无法连接，请检查网络";
                        break;
                }
                break;
        }
        if (!title.equals("")) {
            new SweetDialog(VideoAty.this, SweetDialog.WARNING_TYPE)
                    .setTitleText(title)
                    .setConfirmText("退出", sweetDialog -> {
                        sweetDialog.cancel();
                        finish();
                    }).show();
        }
        if (progess != null) {
            progess.cancel();
        }
    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case -3:
                    //退出直播间回调
                    showtitleDialog(msg.what, msg.arg1);
                    break;
                case -2:
                    //加入直播间回调
                    showtitleDialog(msg.what, msg.arg1);
                    break;
                case -1:
                    //错误回调
                    showtitleDialog(msg.what, msg.arg1);
                    break;
                case 0:
                    //视频开始播放
                    if (progess != null) {
                        progess.cancel();
                    }
                    break;
                case 1:
                    //教师端布局改变通知
                    switch (msg.arg1) {
                        case 0:
                            //文档为主
                            isShowVide = false;
                            isMax = false;
                            changeView();
                            break;
                        case 1:
                            //视频最大化
                            isShowVide = true;
                            isMax = true;
                            changeView();
                            break;
                        case 2:
                            //文档最大化
                            isShowVide = false;
                            isMax = true;
                            changeView();
                            break;
                        case 3:
                            //视频为主
                            isShowVide = true;
                            isMax = false;
                            changeView();
                            break;

                    }
                    break;
                case 2:
                    //缓冲回调
                    if (msg.arg1 == 0) {
                        //正在缓冲
                        mTvCaching.setVisibility(View.VISIBLE);
                    } else {
                        //缓冲完成
                        mTvCaching.setVisibility(View.GONE);
                    }
                    break;
                case 3:
                    //暂停直播回调
                    if (msg.arg1 == 0) {
                        //正在直播
                        mTvPause.setVisibility(View.GONE);
                    } else {
                        //暂停直播
                        mTvPause.setVisibility(View.VISIBLE);
                    }
                    break;
                case 4:
                    //在线人数回调，需老师端勾选
                    int people = msg.arg1;
                    if (people > 0 && mTvPeople.getVisibility() == View.GONE) {
                        mTvPeople.setText(people + "");
                        mTvPeople.setVisibility(View.VISIBLE);
                    } else {
                        mTvPeople.setVisibility(View.GONE);
                    }
                    break;
                case 5:
                    //直播间广播（l一直为0，s为内容）
                    String broadcase = (String) msg.obj;

                    break;
                case 100:
                    //公聊消息通知
                    VideoMessageBean messageBean = (VideoMessageBean) msg.obj;
                    msgList.add(messageBean);
                    mReAdpt.setData(msgList);
                    mRvMessage.smoothScrollToPosition(mReAdpt.getItemCount() - 1);
                    L.e("请求刷新适配器：" + messageBean.getName() + "----内容：" + messageBean.getChatText());
                    break;
            }
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        //暂停视频和音频播放
        if (player != null) {
            player.audioSet(true);
            player.videoSet(true);
        }
        if (vodPlayer != null) {
            vodPlayer.pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        //重新打开视频和音频播放
        if (player != null) {
            player.audioSet(false);
            player.videoSet(false);
        }
        if (vodPlayer != null) {
            vodPlayer.resume();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        L.e("onDestroy");
        if (player != null) {
            player.leave();//退出直播间
            player.release(VideoAty.this);//释放播放器资源
        }
        if (vodPlayer != null) {
            vodPlayer.release();
            //    VodSite.release();
        }
        isMax = false;

    }

    public void L(String str) {
        Log.e("回调！！！！", str);
    }

    @Override
    protected void init() {

    }

    @Override
    protected void onResult(int request, Intent data) {

    }

    Handler changeHandle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //点击的时候触发，移动的时候更新触发时间
            //获得当前时间与触碰时间的差值
            long min = System.currentTimeMillis() - (moveTime + 2000);
            L.e("差值时间：" + min + "-----ABS:" + Math.abs(min));
            if (min >= 0) {
                //如果差值大于设定值（表示达到要求），隐藏图标
                isShowBtn = false;
                changeView();
                isSendChange = false;
            } else {
                //否则重新计算差值发送handle
                changeHandle.sendMessageDelayed(new Message(), Math.abs(min));
                //    changeHandle.sendMessageAtTime(new Message(), Math.abs(min));
            }
        }
    };

    boolean isSendChange = false;//是否发送了状态改变handle

    private void changeView() {
        if (isVod && vodPlayer == null || !isVod && player == null) return;

        if (isShowBtn) {
            mRelaTopShowBtn.setVisibility(View.VISIBLE);
            mRelaMaxShowBtn.setVisibility(View.VISIBLE);
      /*      if (isVod) {
                mSeekMin.setVisibility(View.VISIBLE);
                mSeekMax.setVisibility(View.VISIBLE);
            }
            mImgChange.setVisibility(View.VISIBLE);
            mTvMax.setVisibility(View.VISIBLE);

            mImgMaxChange.setVisibility(View.VISIBLE);
            mTvMin.setVisibility(View.VISIBLE);*/
            //点击的时候触发，移动的时候更新触发时间
            moveTime = System.currentTimeMillis();
            if (!isSendChange) {
                isSendChange = true;
                changeHandle.sendMessage(new Message());
            }

        } else {
           /* if (isVod) {
                mSeekMin.setVisibility(View.GONE);
                mSeekMax.setVisibility(View.GONE);
            }
            mImgChange.setVisibility(View.GONE);
            mTvMax.setVisibility(View.GONE);

            mImgMaxChange.setVisibility(View.GONE);
            mTvMin.setVisibility(View.GONE);*/
            mRelaTopShowBtn.setVisibility(View.GONE);
            mRelaMaxShowBtn.setVisibility(View.GONE);
        }
        if (isMax) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav
                            // bar
                            | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                            | View.SYSTEM_UI_FLAG_IMMERSIVE);


            mRelaMin.setVisibility(View.GONE);
            mTopDoc.setVisibility(View.GONE);
            mTopVideo.setVisibility(View.GONE);
            mSmallDoc.setVisibility(View.GONE);
            mSmallVideo.setVisibility(View.GONE);
            mRelaMax.setVisibility(View.VISIBLE);
            if (isShowVide) {
                mMaxVideo.setVisibility(View.VISIBLE);
                mBottomDoc.setVisibility(View.VISIBLE);
                mBottomDoc.setZOrderOnTop(true);
                mMaxDoc.setVisibility(View.GONE);
                mBottomVideo.setVisibility(View.GONE);
                //
                if (isVod) {
                    vodPlayer.setGSVideoView(mMaxVideo);
                    vodPlayer.setGSDocViewGx(mBottomDoc);
                 /*   mSeekMin.setVisibility(View.GONE);
                    mSeekMax.setVisibility(View.VISIBLE);*/
                } else {
                    player.setGSVideoView(mMaxVideo);
                    player.setGSDocViewGx(mBottomDoc);
                }

            } else {
                mMaxVideo.setVisibility(View.GONE);
                mMaxDoc.setVisibility(View.VISIBLE);
                mBottomVideo.setVisibility(View.VISIBLE);
                mBottomDoc.setVisibility(View.GONE);
                mBottomVideo.setZOrderOnTop(true);
                //
                if (isVod) {
                    vodPlayer.setGSVideoView(mBottomVideo);
                    vodPlayer.setGSDocViewGx(mMaxDoc);
                 /*   mSeekMin.setVisibility(View.GONE);
                    mSeekMax.setVisibility(View.VISIBLE);*/
                } else {
                    player.setGSVideoView(mBottomVideo);
                    player.setGSDocViewGx(mMaxDoc);
                }
            }
        } else {
            mRelaMin.setVisibility(View.VISIBLE);
            mRelaMax.setVisibility(View.GONE);
            if (isShowVide) {
                mTopVideo.setVisibility(View.VISIBLE);
                mSmallDoc.setVisibility(View.VISIBLE);
                mTopDoc.setVisibility(View.GONE);
                mSmallVideo.setVisibility(View.GONE);
                if (isVod) {
                    vodPlayer.setGSVideoView(mTopVideo);
                    vodPlayer.setGSDocViewGx(mSmallDoc);
                /*    mSeekMin.setVisibility(View.VISIBLE);
                    mSeekMax.setVisibility(View.GONE);*/
                } else {
                    player.setGSVideoView(mTopVideo);
                    player.setGSDocViewGx(mSmallDoc);
                }
            } else {
                mTopVideo.setVisibility(View.GONE);
                mSmallDoc.setVisibility(View.GONE);
                mTopDoc.setVisibility(View.VISIBLE);
                mSmallVideo.setVisibility(View.VISIBLE);
                if (isVod) {
                    vodPlayer.setGSVideoView(mSmallVideo);
                    vodPlayer.setGSDocViewGx(mTopDoc);
                /*    mSeekMin.setVisibility(View.VISIBLE);
                    mSeekMax.setVisibility(View.GONE);*/
                } else {
                    player.setGSVideoView(mSmallVideo);
                    player.setGSDocViewGx(mTopDoc);
                }

            }
        }

    }

    @OnClick({R.id.img_change, R.id.tv_max, R.id.img_max_change, R.id.tv_min, R.id.tv_sendMsg, R.id.img_open_icon})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_change:
                isShowVide = isShowVide == true ? false : true;
                changeView();
                break;
            case R.id.tv_max:
                isMax = true;
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//横屏设置
                //   changeView();
                break;
            case R.id.img_max_change:
                isShowVide = isShowVide == true ? false : true;
                changeView();
                break;
            case R.id.tv_min:
                isMax = false;
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//竖屏设置
                // changeView();
                break;
            case R.id.tv_sendMsg:
                //发送消息
                if (mEditMessage.getText().toString().trim().equals("")) {
                    APP.mToast("不能发送空消息");
                    return;
                }
                if (isMute) {
                    APP.mToast("您被禁言，暂时无法发送消息");
                    return;
                }
                if (player == null) {
                    APP.mToast("非直播视频不能发送消息！");
                    return;
                }
                player.chatToPublic(mEditMessage.getChatText(), mEditMessage.getRichText(), null);//发送公聊消息
                //手动添加自己的聊天消息显示
                if (player == null || player.getSelfInfo() == null) return;
                VideoMessageBean messageBean = new VideoMessageBean(player.getSelfInfo().getUserId(), player.getSelfInfo().getName(), mEditMessage.getChatText(), mEditMessage.getRichText(), player.getSelfInfo().getChatId());
                msgList.add(messageBean);
                mReAdpt.setData(msgList);
                mRvMessage.smoothScrollToPosition(mReAdpt.getItemCount() - 1);
                //清空消息
                mEditMessage.setText("");
                //关闭软键盘
                imm.hideSoftInputFromWindow(mEditMessage.getWindowToken(), 0);
                break;

           /* case R.id.tv_showSend:
                //打开输入框
                mLlSend.setVisibility(View.VISIBLE);
                mLlShowSend.setVisibility(View.GONE);
                mRvIcon.setVisibility(View.GONE);
                mEditMessage.requestFocus();
                //mRvMessage.smoothScrollToPosition(mReAdpt.getItemCount() - 1);
                InputMethodManager imm2 = (InputMethodManager) mEditMessage.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm2.toggleSoftInput(0, InputMethodManager.SHOW_FORCED);
                break;*/
            case R.id.img_open_icon:
                //打开图标选择框
                L.e("触法图片选择：" + iconList.size());
                imm.hideSoftInputFromWindow(mEditMessage.getWindowToken(), 0);
                mRvIcon.setVisibility(View.VISIBLE);
                break;
        }
    }


}