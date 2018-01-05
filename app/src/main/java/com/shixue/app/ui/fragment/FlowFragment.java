package com.shixue.app.ui.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjs.Jbase.BaseFragment;
import com.jjs.Jutils.RecyclerView.BaseReHolder;
import com.jjs.Jutils.RecyclerView.SingleReAdpt;
import com.shixue.app.APP;
import com.shixue.app.ApiService;
import com.shixue.app.R;
import com.shixue.app.RxSubscribe;
import com.shixue.app.ui.activity.DetailsFragmentAty;
import com.shixue.app.ui.bean.StepResult;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by Administrator on 2016-11-22.
 */

public class FlowFragment extends BaseFragment {
    @Bind(R.id.rv_flowType)
    RecyclerView mRvFlowType;
    @Bind(R.id.rv_flowDetails)
    RecyclerView mRvFlowDetails;

    StepResult mResult;
    int checkType = 0;
    SingleReAdpt detailsAdpt;

    @Override
    protected void onCreat() {
        setContentView(R.layout.fragment_flow);
    }

    @Override
    public void init() {
        Log.e("FlowFragment", APP.projectID + "  " + APP.ProvinceID);

        if (APP.userInfo == null || APP.userInfo.getBody() == null) {
            return;
        }
        APP.apiService.getStepList(APP.userInfo.getBody().getUser().getMobile(), 1, APP.ProvinceID)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxSubscribe<StepResult>() {
                    @Override
                    protected void _onNext(StepResult stepResult) {
                        mResult = stepResult;
                        update();
                    }

                    @Override
                    protected void _onError(String msg) {
                        Log.e("FlowFragment", msg);
                    }
                });

    }

    public void update() {
        List<StepResult.StepTypeListBean> titleList = new ArrayList<>();
        if (mResult.getStepTypeList().size() > 0) {
            for (int i = 0; i < mResult.getStepTypeList().size(); i++) {
                if (mResult.getStepTypeList().get(i).getProjectStepList() != null && mResult.getStepTypeList().get(i).getProjectStepList().size() > 0) {
                    titleList.add(mResult.getStepTypeList().get(i));
                }
            }
            mRvFlowType.setLayoutManager(new GridLayoutManager(getActivity(), titleList.size()));
            SingleReAdpt reAdpt = new SingleReAdpt<StepResult.StepTypeListBean>(getActivity(), R.layout.recycler_flow_title, titleList) {
                @Override
                protected void BindData(BaseReHolder holder, int position, StepResult.StepTypeListBean data) {
                    if (position == checkType) {
                        holder.getTV(R.id.item_tv_left).setBackgroundColor("#26bd78");
                        holder.getTV(R.id.item_tv_right).setBackgroundColor("#26bd78");
                        holder.getTV(R.id.item_tv_type).setSelected(true);
                        holder.getTV(R.id.item_tv_title).setTextColor("#059b76");
                        holder.getRootView().setBackgroundColor(Color.WHITE);
                    } else {
                        holder.getTV(R.id.item_tv_left).setBackgroundColor("#b8c2d0");
                        holder.getTV(R.id.item_tv_right).setBackgroundColor("#b8c2d0");
                        holder.getView(R.id.item_tv_type).setSelected(false);
                        holder.getTV(R.id.item_tv_title).setTextColor("#333333");
                        holder.getRootView().setBackgroundColor(Color.parseColor("#E9F1F7"));
                    }
                    String ABCD = "";
                    switch (position) {
                        case 0:
                            ABCD = "A";
                            break;
                        case 1:
                            ABCD = "B";
                            break;
                        case 2:
                            ABCD = "C";
                            break;
                        case 3:
                            ABCD = "D";
                            break;
                        case 4:
                            ABCD = "E";
                            break;
                        case 5:
                            ABCD = "F";
                            break;
                        case 6:
                            ABCD = "G";
                            break;
                        case 7:
                            ABCD = "H";
                            break;
                    }
                    holder.getTV(R.id.item_tv_type).setText(ABCD);
                    holder.getTV(R.id.item_tv_title).setText(data.getStepTypeName());
                }
            };
            reAdpt.setOnItemClickListener(new SingleReAdpt.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    checkType = position;
                    reAdpt.notifyDataSetChanged();
                    detailsAdpt.setData(titleList.get(checkType).getProjectStepList());
                }

                @Override
                public void onItemLongClick(View view, int position) {

                }
            });
            mRvFlowType.setAdapter(reAdpt);

            mRvFlowDetails.setLayoutManager(new LinearLayoutManager(getActivity()));
            detailsAdpt = new SingleReAdpt<StepResult.StepTypeListBean.ProjectStepListBean>(getActivity(), R.layout.recycler_flow_list, titleList.get(checkType).getProjectStepList()) {
                @Override
                protected void BindData(BaseReHolder holder, int position, StepResult.StepTypeListBean.ProjectStepListBean data) {
                    holder.getTV(R.id.item_tv_title).setText(data.getStepName());
                    holder.getTV(R.id.item_tv_msg).setText(data.getOneWord());
                }
            };
            detailsAdpt.setOnItemClickListener(new SingleReAdpt.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    Log.e("流程：", APP.picUrl + titleList.get(checkType).getProjectStepList().get(position).getHowdoUrl());
                    DetailsFragmentAty.goHtmlAty(getActivity(), titleList.get(checkType).getProjectStepList().get(position).getStepName(),  APP.htmlUrl + titleList.get(checkType).getProjectStepList().get(position).getHowdoUrl());
                }

                @Override
                public void onItemLongClick(View view, int position) {

                }
            });
            mRvFlowDetails.setAdapter(detailsAdpt);
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
