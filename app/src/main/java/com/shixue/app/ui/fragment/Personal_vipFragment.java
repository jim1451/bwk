package com.shixue.app.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jjs.Jbase.BaseFragment;
import com.shixue.app.APP;
import com.shixue.app.ApiService;
import com.shixue.app.R;
import com.shixue.app.utils.HTTPutils;
import com.shixue.app.utils.SweetDialog;
import com.shixue.app.utils.WXshpaeDialog;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;



/**
 * 本页：
 * Created by jjs on 2016-12-06.
 */

public class Personal_vipFragment extends BaseFragment {

    @Bind(R.id.btn_vip)
    Button btnVip;
    @Bind(R.id.tv_vip)
    TextView tvVip;
    @Bind(R.id.et_cdkey)
    EditText etCdkey;
    @Bind(R.id.tv_exchange)
    TextView tvExchange;
    @Bind(R.id.linear_ad)
    LinearLayout linearAd;
    @Bind(R.id.tv_ad)
    TextView tvAd;


    @Override
    protected void onCreat() {
        setContentView(R.layout.fragment_vip);
    }

    @Override
    protected void init() {
        HTTPutils.getVipBean(APP.userInfo.getBody().getUser().getMobile(), APP.projectID, b -> {
            if (APP.isVip) {
                tvVip.setVisibility(View.VISIBLE);
//                tvVip.setText("剩余(" + APP.vipDay + "天) " + "截至日期:" + APP.vipBean.getSvipDate());
                btnVip.setText("会员续期");
            } else {
                btnVip.setText("开通会员");
                tvVip.setVisibility(View.INVISIBLE);
            }
        });

    }


    @OnClick({R.id.btn_vip, R.id.tv_exchange, R.id.linear_ad})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_vip:
                //前往vip充值页面
                new WXshpaeDialog(getActivity()).show("开通会员", APP.examInfoBean.getWxRemark(), APP.examInfoBean.getWxcode());
                // goActivity(OpenVipActivity.class, 1);
                break;
            case R.id.tv_exchange:
                String cdkey = etCdkey.getText().toString();
              /*  if (!TextUtils.isEmpty(cdkey))
                    cdKeyRequest(cdkey);
                else
                    AppUtils.showToast("输入兑换码不能为空！");*/
                if (TextUtils.isEmpty(cdkey)) {
                    APP.mToast("输入兑换码不能为空");
                } else {
                    openCDkey(cdkey);
                }
                break;
            case R.id.linear_ad:
                //弹窗加微信dialog
/**
 * 在请求wx分享数据时，operateType参数为1时，点击不显示弹窗
 */
                /*if (AppMainActivity.operateType == 1) {
                    return;
                }
                DialogUtils.wechatAdDialog(getActivity());*/
                break;
        }
    }

    private void openCDkey(String cdKey) {
        RequestParams params = new RequestParams(ApiService.httpUrl + "payAction!exchangeDay.action");
        params.addParameter("projectId", APP.projectID);
        params.addParameter("userid", APP.userInfo.getBody().getUser().getUserid());
        params.addParameter("exchangeCode", cdKey);
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                HTTPutils.getVipBean(APP.userInfo.getBody().getUser().getMobile(), APP.projectID, new HTTPutils.OnBooleanClick() {
                    @Override
                    public void onSuccess(boolean b) {

                    }
                });
                getActivity().setResult(ResultOK);
                try {
                    JSONObject object = new JSONObject(result);
                    boolean success = object.getBoolean("success");
                    String msg = object.getString("msg");
                    if (success) {
                        HTTPutils.getVipBean(APP.userInfo.getBody().getUser().getMobile(), APP.projectID, b -> {
                            init();
                        });
                        new SweetDialog(getActivity(), SweetDialog.SUCCESS_TYPE)
                                .setContentText(msg)
                                .setConfirmText("确定")
                                .show();
                    } else {
                        new SweetDialog(getActivity(), SweetDialog.WARNING_TYPE)
                                .setContentText(msg)
                                .setConfirmText("确定")
                                .show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                APP.mToast(ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }


    @Override
    protected void onResult(int request, Intent data) {
        if (request == 1) {
            getActivity().setResult(ResultOK);
            //   getActivity().finish();
        }
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
