package com.shixue.app.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjs.Jbase.BaseFragment;
import com.shixue.app.R;
import com.shixue.app.ui.bean.OnlineDetailsResult;

import butterknife.Bind;
import butterknife.ButterKnife;



/**
 * 本页：评价已取消
 * Created by jjs on 2016-12-02.
 */

public class Online_EvalFragment extends BaseFragment {


    @Bind(R.id.rv_eval)
    RecyclerView mRvEval;

    OnlineDetailsResult result;

    @Override
    protected void onCreat() {
        setContentView(R.layout.fragment_onlineeval);
    }

    @Override
    protected void init() {
       /* result = ((School_Online_DetailsAty) getActivity()).result;
        mRvEval.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvEval.setAdapter(new SingleReAdpt<OnlineDetailsResult.EvalBean>(getActivity(), R.layout.recycler_online_eval, result.getUserCourseEvalList()) {
            @Override
            protected void BindData(BaseReHolder holder, int position, OnlineDetailsResult.EvalBean data) {
                StringBuffer str = new StringBuffer(data.getUserid() + "");
                str.insert(str.length() / 2, "*");
                holder.getTV(R.id.item_tv_phone).setText(str.toString());
                RatingBar ratingBar = holder.getView(R.id.item_rating);
                ratingBar.setRating(data.getEvalLevel());
                holder.getTV(R.id.item_tv_eval).setText(data.getEvalContent());
                holder.getTV(R.id.item_tv_time).setText(data.getSevalDate());
            }
        });*/
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
