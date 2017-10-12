package com.shixue.app.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jjs.Jbase.BaseFragment;
import com.shixue.app.APP;
import com.shixue.app.ApiService;
import com.shixue.app.R;
import com.shixue.app.utils.AppUtils;
import com.shixue.app.wxapi.WeChatUtils;
import com.tencent.connect.share.QQShare;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;



/**
 * 本页：
 * Created by jjs on 2016-12-06.
 */

public class Personal_shapeFragment extends BaseFragment {
    @Bind(R.id.linear_qq)
    LinearLayout mLinearQq;

    private IWXAPI api;
    private Tencent mTencent;
    private int shareType = QQShare.SHARE_TO_QQ_TYPE_DEFAULT;
    private String title;
    private String description;

    @Override
    protected void onCreat() {
        setContentView(R.layout.fragment_personal_shape);
    }

    @Override
    protected void init() {
        AppUtils.getInstance(getActivity());
        api = WXAPIFactory.createWXAPI(getActivity(), ApiService.WC_APP_ID, false);
        api.registerApp(ApiService.WC_APP_ID);
        setShapeTitle();
        //getShareRequest();
    }

    public void setShapeTitle() {
        title = "和你的小伙伴一起学习吧！";
        description = "安装伴我考APP，免费题库、课件和资源，考证不求人！该页面打开后自动转入苹果和应用宝的相关项目APP安装页";
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

    @OnClick({R.id.linear_session, R.id.linear_timeline, R.id.linear_qq})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.linear_session:
                shareWX(false);
                break;
            case R.id.linear_timeline:
                shareWX(true);
                break;
            case R.id.linear_qq:
                if (!isApkInstalled(getActivity(), "com.tencent.mobileqq")) {
                    AppUtils.showToast("请先安装qq客户端");
                    return;
                }
                mTencent = Tencent.createInstance(ApiService.tencentAppId, getActivity());
                shareQQ();
                break;
        }
    }

    public boolean isApkInstalled(Context context, String packageName) {
        try {
            context.getPackageManager().getApplicationInfo(packageName, PackageManager.GET_UNINSTALLED_PACKAGES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    private void shareWX(boolean isTimeline) {
        //  String text = "http://www.banwokao.com/manager/shareAction!list.action?" + "userId=" + APP.userInfo.getUserid();
        String text = APP.APPupdataUrl;
        // 初始化一个WXTextObject对象
        WXWebpageObject webpage = new WXWebpageObject();
        webpage.webpageUrl = text;

        // 用WXTextObject对象初始化一个WXMediaMessage对象
        WXMediaMessage msg = new WXMediaMessage(webpage);
//                msg.mediaObject = textObj;
        // 发送文本类型的消息时，title字段不起作用
        msg.title = title;
        msg.description = description;
        Bitmap thumb = BitmapFactory.decodeResource(getResources(), R.drawable.share_logo);
        msg.thumbData = WeChatUtils.bmpToByteArray(thumb, true);

        // 构造一个Req
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = "webpage"; // transaction字段用于唯一标识一个请求
        req.message = msg;
        req.scene = isTimeline ? SendMessageToWX.Req.WXSceneTimeline : SendMessageToWX.Req.WXSceneSession;

        // 调用api接口发送数据到微信
        api.sendReq(req);
    }

    IUiListener qqShareListener = new IUiListener() {
        @Override
        public void onCancel() {
            if (shareType != QQShare.SHARE_TO_QQ_TYPE_IMAGE) {

                AppUtils.showToast("onCancel: ");
            }
        }

        @Override
        public void onComplete(Object response) {
            // TODO Auto-generated method stub
            AppUtils.showToast("onComplete: " + response.toString());
        }

        @Override
        public void onError(UiError e) {
            AppUtils.showToast("onError: " + e.errorMessage);
            // TODO Auto-generated method stub
        }
    };

    private void shareQQ() {

     //   String tagUrl = "http://www.banwokao.com/manager/shareAction!list.action?" + "userId=" + APP.userInfo.getUserid();
        String tagUrl=APP.APPupdataUrl;
        final Bundle bundle = new Bundle();
        //这条分享消息被好友点击后的跳转URL。
        bundle.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_DEFAULT);
        bundle.putString(QQShare.SHARE_TO_QQ_TARGET_URL, tagUrl);
        //分享的标题。注：PARAM_TITLE、PARAM_IMAGE_URL、PARAM_SUMMARY不能全为空，最少必须有一个是有值的。
        bundle.putString(QQShare.SHARE_TO_QQ_TITLE, title);
        bundle.putString(QQShare.SHARE_TO_QQ_SUMMARY, description);

        try {
            mLinearQq.post(new Runnable() {
                @Override
                public void run() {
                    if (mTencent != null) {
                        mTencent.shareToQQ(getActivity(), bundle, qqShareListener);
                    }
                }
            });
        } catch (Exception e) {
            AppUtils.showToast("请先安装qq客户端");

        }


    }

}
