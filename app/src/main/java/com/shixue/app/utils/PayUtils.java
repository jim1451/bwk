package com.shixue.app.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;

import com.alipay.sdk.app.PayTask;
import com.shixue.app.ApiService;
import com.shixue.app.wxapi.WeChatUtils;
import com.tencent.mm.sdk.modelpay.PayReq;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class PayUtils {
    public static void AliPay(Activity activity, String url, String appid, String appUser, String privateKey, String title, String money, String orderID, String body) {
        payByAlipay(activity, url, appid, appUser, privateKey, title, money, orderID, body);

    }
    private static void payByAlipay(final Activity activity, String url, String appid, String appUser, String privateKey, String title, String money, String orderID, String body) {
        try {
            String orderInfo = getOrderInfo(url, appid, appUser, title, body, money, orderID);

            String sign = SignUtils.sign(orderInfo, privateKey);
            try {
                sign = URLEncoder.encode(sign, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            final String payInfo = orderInfo + "&sign=\"" + sign + "\"&"
                    + SignUtils.getSignType();
            Runnable payRunnable = new Runnable() {

                @Override
                public void run() {
                    PayTask alipay = new PayTask(activity);
                    Map<String, String> result = alipay.payV2(payInfo, true);


                    PayResult payResult = new PayResult(result);

                    String resultInfo = payResult.getResult();
                    String resultStatus = payResult.getResultStatus();
                    Message msg = new Message();
                    msg.obj = resultStatus;
                    handler.sendMessage(msg);
                    L.e(resultInfo);

                }
            };
            Thread payThread = new Thread(payRunnable);
            payThread.start();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }


    static Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String str = (String) msg.obj;

            if (str.equals("9000")) {
                onAliResult.onResult("支付成功");
            } else {
                if (str.equals("4000")) {
                    onAliResult.onError("订单支付失败，请重试");
                } else if (str.equals("8000")) {
                    onAliResult.onError("正在处理中，支付结果未知（有可能已经支付成功），请查询商户订单列表中订单的支付状态");
                } else if (str.equals("6001")) {
                    onAliResult.onError("您取消了支付，请重新付款");
                } else if (str.equals("6002")) {
                    onAliResult.onError("支付宝网络连接错误，请重新付款");
                } else if (str.equals("6004")) {
                    onAliResult.onError("支付结果未知（有可能已经支付成功），请查询商户订单列表中订单的支付状态");
                } else {
                    onAliResult.onError("支付失败");
                }
            }


        }
    };
    public static String getOrderInfo(String url, String aliID, String aliUser, String title, String body, String price, String orderID) {

        String orderInfo = "partner=" + "\"" + aliID + "\"";

        orderInfo += "&seller_id=" + "\"" + aliUser + "\"";

        orderInfo += "&out_trade_no=" + "\"" + orderID + "\"";

        orderInfo += "&subject=" + "\"" + title + "\"";

        orderInfo += "&body=" + "\"" + body + "\"";

        orderInfo += "&total_fee=" + "\"" + price + "\"";

        orderInfo += "&notify_url=" + "\"" + url + "\"";

        orderInfo += "&service=\"mobile.securitypay.pay\"";

        orderInfo += "&payment_type=\"1\"";

        orderInfo += "&_input_charset=\"utf-8\"";

        orderInfo += "&it_b_pay=\"30m\"";

        orderInfo += "&return_url=\"m.alipay.com\"";


        return orderInfo;
    }

    private static onAliResult onAliResult;

    public static void getAliResult(onAliResult aliResult) {

        onAliResult = aliResult;
    }

    public interface onAliResult {
        void onResult(String result);

        void onError(String msg);
    }



    public static void WxPay(Activity context, String msg, String orderID, String money, String attach) {
        IWXAPI api = WXAPIFactory.createWXAPI(context, ApiService.WC_APP_ID);
        api.registerApp(ApiService.WC_APP_ID);
        GetPrepayIdTask getPrepayId = new GetPrepayIdTask(context, api, msg, orderID, money, attach);
        getPrepayId.execute();
    }
    private static class GetPrepayIdTask extends AsyncTask<Void, Void, Map<String, String>> {
        private Context context;
        private String msg, orderID, money, userID;
        private int userType, payType, orderType;
        private IWXAPI api;
        private String attach;

        public GetPrepayIdTask(Context context, IWXAPI api, String msg, String orderID, String money, String attach) {
            this.context = context;
            this.msg = msg;
            this.orderID = orderID;
            this.money = money;
            this.attach = attach;

            this.api = api;
        }

        private ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            dialog = ProgressDialog.show(context, "提示", "正在获取预支付订单...");
        }

        @Override
        protected void onPostExecute(Map<String, String> result) {
            if (dialog != null) {
                dialog.dismiss();
            }
            genPayReq(api, result);

        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected Map<String, String> doInBackground(Void... params) {


            String url = String.format(ApiService.UNIFIED_ORDER_URL);
            String entity = WeChatUtils.genProductArgs(context, msg, ((int) (Double.parseDouble(money) * 100)) + "", attach, orderID);
            byte[] buf = WeChatUtils.httpPost(url, entity);
            String bb = new String(buf);
            Map<String, String> xml = WeChatUtils.decodeXml(bb);
            return xml;

        }
    }
    private static void genPayReq(IWXAPI api, Map<String, String> result) {
        PayReq req = new PayReq();
        req.appId = ApiService.WC_APP_ID;
        req.partnerId = ApiService.WC_MCH_ID;
        req.prepayId = result.get("prepay_id");
        req.packageValue = "Sign=WXPay";
        req.nonceStr = WeChatUtils.genNonceStr();
        req.timeStamp = String.valueOf(WeChatUtils.genTimeStamp());

        List<NameValuePair> signParams = new LinkedList<>();
        signParams.add(new BasicNameValuePair("appid", req.appId));
        signParams.add(new BasicNameValuePair("noncestr", req.nonceStr));
        signParams.add(new BasicNameValuePair("package", req.packageValue));
        signParams.add(new BasicNameValuePair("partnerid", req.partnerId));
        signParams.add(new BasicNameValuePair("prepayid", req.prepayId));
        signParams.add(new BasicNameValuePair("timestamp", req.timeStamp));

        req.sign = WeChatUtils.genAppSign(signParams);


        api.registerApp(ApiService.WC_APP_ID);
        api.sendReq(req);

    }
}
