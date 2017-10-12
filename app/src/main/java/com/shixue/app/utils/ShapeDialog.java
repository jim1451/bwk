package com.shixue.app.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import com.shixue.app.APP;
import com.shixue.app.ApiService;
import com.shixue.app.R;
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


/**
 * 本页：
 * Created by jjs on 2017-01-16.
 * Email:994462623@qq.com
 */

public class ShapeDialog extends Dialog {
    Context mContext;
    private IWXAPI api;
    private Tencent mTencent;
    private int shareType = QQShare.SHARE_TO_QQ_TYPE_DEFAULT;
    private String title = "和你的小伙伴一起学习吧！";
    private String description = "伴我考APP，免费流程课件和题库，考证不走弯路不求人。";

    public ShapeDialog(Context context) {
        super(context, R.style.Dialog_notBG);
        mContext = context;
        api = WXAPIFactory.createWXAPI(context, ApiService.WC_APP_ID, false);
        api.registerApp(ApiService.WC_APP_ID);
        init();
    }

    View mView;

    public void init() {
        mView = View.inflate(mContext, R.layout.dialog_shape, null);
        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShapeDialog.this.dismiss();
            }
        });
        mView.findViewById(R.id.dialog_wxFriend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //分享微信好友
                shareWX(false);
            }
        });
        mView.findViewById(R.id.dialog_wxMoments).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //分享微信朋友圈
                shareWX(true);
            }
        });
        mView.findViewById(R.id.dialog_qqFriend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //分享QQ好友
                if (!isApkInstalled(mContext, "com.tencent.mobileqq")) {
                    AppUtils.showToast("请先安装qq客户端");
                    return;
                }
                mTencent = Tencent.createInstance(ApiService.tencentAppId, mContext);
                shareQQ();
            }
        });
        ShapeDialog.this.setContentView(mView);
        ShapeDialog.this.show();
        WindowManager windowManager = ((Activity) mContext).getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = ShapeDialog.this.getWindow().getAttributes();
        lp.width = (int) (display.getWidth());
        ShapeDialog.this.getWindow().setAttributes(lp);
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
        Bitmap thumb = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.share_logo);
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
        String tagUrl = APP.APPupdataUrl;
        final Bundle bundle = new Bundle();
        //这条分享消息被好友点击后的跳转URL。
        bundle.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_DEFAULT);
        bundle.putString(QQShare.SHARE_TO_QQ_TARGET_URL, tagUrl);
        //分享的标题。注：PARAM_TITLE、PARAM_IMAGE_URL、PARAM_SUMMARY不能全为空，最少必须有一个是有值的。
        bundle.putString(QQShare.SHARE_TO_QQ_TITLE, title);
        bundle.putString(QQShare.SHARE_TO_QQ_SUMMARY, description);

        try {
            mView.post(new Runnable() {
                @Override
                public void run() {
                    if (mTencent != null) {
                        mTencent.shareToQQ((Activity) mContext, bundle, qqShareListener);
                    }
                }
            });
        } catch (Exception e) {
            AppUtils.showToast("请先安装qq客户端");

        }


    }
}
