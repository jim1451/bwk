package com.shixue.app.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jjs.Jbase.BaseFragment;
import com.shixue.app.APP;
import com.shixue.app.ApiService;
import com.shixue.app.R;

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

    @Override
    protected void onCreat() {
        setContentView(R.layout.fragment_about);
    }

    @Override
    protected void init() {
        RequestParams params = new RequestParams(ApiService.httpUrl + "projectAction!aboutUs.action");
        params.addParameter("projectId", APP.projectID);
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject object = new JSONObject(result);
                    boolean success = object.getBoolean("success");
                    if (success) {
                        mTvMsg.setText("    "+object.getJSONObject("body").getJSONObject("project").getString("aboutUs"));
                    }
                } catch (JSONException e) {
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
        mTvVersionName.setText(APP.versionName);
        SpannableString ss = new SpannableString(mTvCallPhone.getText());
        ss.setSpan(new URLSpan("tel:4000081411"), 23, mTvCallPhone.getText().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mTvCallPhone.setText(ss);
        mTvCallPhone.setMovementMethod(LinkMovementMethod.getInstance());

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
