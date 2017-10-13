package com.shixue.app.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jjs.Jbase.BaseFragment;
import com.jjs.Jutils.RecyclerView.DataHolder;
import com.jjs.Jutils.RecyclerView.LayoutWrapper;
import com.jjs.Jutils.RecyclerView.SingleReAdpt;
import com.jjs.Jutils.RecyclerView.SuperAdapter;
import com.shixue.app.APP;
import com.shixue.app.ApiService;
import com.shixue.app.R;
import com.shixue.app.RxSubscribe;
import com.shixue.app.ui.activity.PractiseTestAty;
import com.shixue.app.ui.bean.PractiseTitleListResult;
import com.shixue.app.utils.L;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 练题页面
 * Created by Administrator on 2016-11-23.
 */

public class PractiseFragment extends BaseFragment {
    @Bind(R.id.rv_practise)
    RecyclerView mRvPractise;

    List<LayoutWrapper> wrapperList;//数据源
    SuperAdapter superAdapter;//适配器
    int[] layoutIds = new int[]{R.layout.recycler_item_title, R.layout.recycler_practise_list};//多布局适配器
    DataHolder<String> titleHolder;
    DataHolder<PractiseTitleListResult.SubjectListBean.LibraryListBean> dataHolder;


    @Override
    protected void onCreat() {
        setContentView(R.layout.fragment_practise);
    }

    @Override
    protected void init() {

        /**
         * 请求试题数据（题库）
         *
         */
        APP.apiService.getPractiseTitleList(1, APP.examType)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxSubscribe<PractiseTitleListResult>() {
                    @Override
                    protected void _onNext(PractiseTitleListResult practiseTitleListResult) {
                        getPractiseListOK(practiseTitleListResult);
                    }

                    @Override
                    protected void _onError(String msg) {
                        APP.mToast(msg);
                    }
                });
       /* APP.apiService.getPractiseTitleList(8, 26)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxSubscribe<PractiseTitleListResult>() {
                    @Override
                    protected void _onNext(PractiseTitleListResult practiseTitleListResult) {
                        getPractiseListOK(practiseTitleListResult);
                    }

                    @Override
                    protected void _onError(String msg) {
                        APP.mToast(msg);
                    }
                });*/
    }

    private void getPractiseListOK(PractiseTitleListResult result) {
        L.e(result.getSubjectList().size() + "个试卷类型");
        mRvPractise.setLayoutManager(new LinearLayoutManager(getActivity()));
        titleHolder = (context, holder, item, position) -> {
            TextView view = holder.getView(R.id.item_title);
            view.setText(item);
        };
        dataHolder = (context, holder, item, position) -> {
            ((TextView) holder.getView(R.id.item_tv_title)).setText(item.getTestLibraryName());
            ((TextView) holder.getView(R.id.item_tv_msg)).setText(item.getOneWord());
            ((TextView) holder.getView(R.id.item_tv_size)).setText(item.getTestCount() + "张试卷");
            Glide.with(getActivity()).load(ApiService.picUrl + item.getPictureUrl()).into((ImageView) holder.getView(R.id.item_img));
            if (item.getChargeType() == 0) {
                holder.getView(R.id.item_tv_isFree).setVisibility(View.VISIBLE);
                holder.getView(R.id.item_tv_isVip).setVisibility(View.GONE);
            } else {
                holder.getView(R.id.item_tv_isFree).setVisibility(View.GONE);
                holder.getView(R.id.item_tv_isVip).setVisibility(View.VISIBLE);
            }


        };
        wrapperList = new ArrayList<>();
        for (int i = 0; i < result.getSubjectList().size(); i++) {
            wrapperList.add(new LayoutWrapper(layoutIds[0], result.getSubjectList().get(i).getSubjectName(), titleHolder));
            if (result.getSubjectList().get(i).getLibraryList() != null) {
                for (int j = 0; j < result.getSubjectList().get(i).getLibraryList().size(); j++) {
                    wrapperList.add(new LayoutWrapper(layoutIds[1], result.getSubjectList().get(i).getLibraryList().get(j), dataHolder));
                }
            }
        }
        superAdapter = new SuperAdapter(getActivity(), layoutIds);
        superAdapter.setOnItemClickListener(new SingleReAdpt.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (layoutIds[1] == wrapperList.get(position).getLayoutId()) {
                    Intent intent = new Intent(getActivity(), PractiseTestAty.class);
                    intent.putExtra("bean", (PractiseTitleListResult.SubjectListBean.LibraryListBean) wrapperList.get(position).getData());
                    startActivity(intent);
                }
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
        mRvPractise.setAdapter(superAdapter);
        superAdapter.setData(wrapperList);

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
