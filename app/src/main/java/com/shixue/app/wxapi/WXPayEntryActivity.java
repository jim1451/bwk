package com.shixue.app.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

import com.shixue.app.APP;
import com.shixue.app.ApiService;


public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {

    public static String wxPayResult = APP.APPpackge + ".action_wechat_pay_result";

    private IWXAPI api;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        api = WXAPIFactory.createWXAPI(this, ApiService.WC_APP_ID);
        api.handleIntent(getIntent(), this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq req) {
    }

    @Override
    public void onResp(BaseResp resp) {
        Intent intent = new Intent();
        intent.setAction(WXPayEntryActivity.wxPayResult);
        intent.putExtra("code", resp.errCode);
        sendBroadcast(intent);
        finish();
    }
}