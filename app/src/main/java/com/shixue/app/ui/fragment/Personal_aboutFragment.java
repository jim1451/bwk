package com.shixue.app.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.jjs.Jbase.BaseFragment;
import com.shixue.app.APP;
import com.shixue.app.ApiService;
import com.shixue.app.R;
import com.shixue.app.ui.bean.AboutUsResult;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * 本页：
 * Created by jjs on 2016-11-28.
 */

public class Personal_aboutFragment extends BaseFragment {
    @Bind(R.id.tv_versionName)
    TextView mTvVersionName;
    @Bind(R.id.tv_callPhone)
    TextView mTvCallPhone;
    @Bind(R.id.tv_msg)
    TextView mTvMsg;
    @Bind(R.id.imgLogos)
    ImageView imgLogos;
    private AboutUsResult aboutUsResult;

    @Override
    protected void onCreat() {
        setContentView(R.layout.fragment_about);
    }

    @Override
    protected void init() {
        if (APP.userInfo == null) {
            return;
        }
        RequestParams params = new RequestParams(ApiService.httpUrl + "projectAction!aboutUs.action");
        params.addParameter("mobile", APP.userInfo.getBody().getUser().getMobile());
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject object = new JSONObject(result);
                    boolean success = object.getBoolean("success");
                    if (success) {
                        Gson gson = new Gson();
                        aboutUsResult = gson.fromJson(result, AboutUsResult.class);
                       mTvMsg.setText("    " + aboutUsResult.getBody().getAgent().getAboutUs());

                       // mTvMsg.setText("测试！！！！！！！！！！");
                     //   Glide.with(getActivity()).load(APP.picUrl + aboutUsResult.getBody().getAgent().getAgentIcon()).into(imgLogos);
                        Log.e("Personal_aboutFragment", aboutUsResult.getBody().getAgent().getAgentName());
                    }
                } catch (JSONException e) {
                    Log.e("Personal_aboutFragment", "解析异常");
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
        mTvCallPhone.setText("版本：" + APP.versionName);
//        mTvCallPhone.setMovementMethod(LinkMovementMethod.getInstance());
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
