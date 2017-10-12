package com.shixue.app.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jjs.Jbase.BaseFragment;
import com.shixue.app.R;
import com.shixue.app.ui.activity.School_Online_DetailsAty;
import com.shixue.app.ui.bean.OnlineDetailsResult;

import butterknife.Bind;
import butterknife.ButterKnife;



/**
 * 本页：
 * Created by jjs on 2016-12-01.
 */

public class Online_DetailsFragment extends BaseFragment {

    @Bind(R.id.tv_name)
    TextView mTvName;
    @Bind(R.id.tv_type)
    TextView mTvType;
    @Bind(R.id.tv_time)
    TextView mTvTime;
    @Bind(R.id.tv_content)
    TextView mTvContent;

    OnlineDetailsResult result;

    @Override
    protected void onCreat() {
        setContentView(R.layout.fragment_onlinedetails);
    }

    @Override
    protected void init() {
        result = ((School_Online_DetailsAty) getActivity()).result;
        mTvName.setText(result.getCourse().getReplayUsername());//老师
        mTvTime.setText(result.getCourse().getCourseCount() + " 小时");//时间
        mTvContent.setText(result.getCourse().getIntroduce());//说明
        if (result.getCourse().getChargeType() == 0) {
            mTvType.setText("免费课程");//课程说明
        } else {
            mTvType.setText("会员免费");//课程说明
        }
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
