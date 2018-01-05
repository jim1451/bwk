package com.shixue.app.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
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
import com.shixue.app.contract.SchoolContract;
import com.shixue.app.model.SchoolModel;
import com.shixue.app.ui.activity.School_DirectDetailsAty;
import com.shixue.app.ui.activity.School_DirectMoreAty;
import com.shixue.app.ui.activity.School_Online_DetailsAty;
import com.shixue.app.ui.bean.LiveDirectResult;
import com.shixue.app.ui.bean.LiveOnlineResult;
import com.shixue.app.utils.L;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Administrator on 2016-11-22.
 */

public class SchoolFragment extends BaseFragment<SchoolModel> implements SchoolContract.View {
    @Bind(R.id.img_direct_left)
    ImageView mImgDirectLeft;
    @Bind(R.id.tv_direct_lefting)
    TextView mTvDirectLefting;
    @Bind(R.id.img_direct_right)
    ImageView mImgDirectRight;
    @Bind(R.id.tv_direct_righting)
    TextView mTvDirectRighting;
    @Bind(R.id.ll_direct)
    AutoLinearLayout mLlDirect;
    @Bind(R.id.rv_online)
    RecyclerView mRvOnline;
    @Bind(R.id.tv_online_Title)
    TextView mTvOnlineTitle;
    @Bind(R.id.rela_direct_Left)
    AutoRelativeLayout mRelaDirectLeft;
    @Bind(R.id.rela_direct_Right)
    AutoRelativeLayout mRelaDirectRight;

    List<LayoutWrapper> wrapperList;//在线课程数据源
    List<LiveDirectResult.LiveCourseListBean> directList;//直播数据源
    SuperAdapter superAdapter;//在线课程适配器
    int[] layoutIds = new int[]{R.layout.recycler_item_title, R.layout.recycler_school_online};//布局
    DataHolder<String> titleHolder;
    DataHolder<LiveOnlineResult.SubjectListBean.LiveOnlineBean> dataHolder;

    @Override
    protected void onCreat() {
        setContentView(R.layout.fragment_school);
    }

    @Override
    protected void init() {
        mModel = new SchoolModel(getActivity(), this);
        mModel.getDirectList(APP.projectID, APP.examType);
        mModel.getOnlineList(APP.projectID, APP.examType);
        titleHolder = (context, holder, item, position) -> {
            TextView view = holder.getView(R.id.item_title);
            view.setText(item);
        };
        dataHolder = (context, holder, item, position) -> {
            Log.e("dataHolder", APP.picUrl + ((LiveOnlineResult.SubjectListBean.LiveOnlineBean) wrapperList.get(position).getData()).getPictureUrl());
            Glide.with(getActivity()).load(APP.picUrl + ((LiveOnlineResult.SubjectListBean.LiveOnlineBean) wrapperList.get(position).getData()).getPictureUrl()).into((ImageView) holder.getView(R.id.item_img));
            ((TextView) holder.getView(R.id.item_title)).setText(((LiveOnlineResult.SubjectListBean.LiveOnlineBean) wrapperList.get(position).getData()).getCourseName());
            ((TextView) holder.getView(R.id.item_msg)).setText(((LiveOnlineResult.SubjectListBean.LiveOnlineBean) wrapperList.get(position).getData()).getOneWord());
            ((TextView) holder.getView(R.id.item_time)).setText(((LiveOnlineResult.SubjectListBean.LiveOnlineBean) wrapperList.get(position).getData()).getCourseCount() + "课时");
            int ChargeType = ((LiveOnlineResult.SubjectListBean.LiveOnlineBean) wrapperList.get(position).getData()).getChargeType();

            if (ChargeType == 0) {//免费
                holder.getView(R.id.item_isVip).setVisibility(View.GONE);
                holder.getView(R.id.item_isFaceVip).setVisibility(View.GONE);
                holder.getView(R.id.item_notVip).setVisibility(View.VISIBLE);
            } else if (ChargeType == 1) {//笔试会员
                holder.getView(R.id.item_isVip).setVisibility(View.VISIBLE);
                holder.getView(R.id.item_notVip).setVisibility(View.GONE);
                holder.getView(R.id.item_isFaceVip).setVisibility(View.GONE);

            } else if (ChargeType == 2) {//面试会员
                holder.getView(R.id.item_isVip).setVisibility(View.GONE);
                holder.getView(R.id.item_notVip).setVisibility(View.GONE);
                holder.getView(R.id.item_isFaceVip).setVisibility(View.VISIBLE);
            }
        };
        wrapperList = new ArrayList<>();
        mRvOnline.setLayoutManager(new LinearLayoutManager(getActivity()));
        // mRvOnline.addItemDecoration(new ReItemDivider(getActivity(), getActivity().getResources().getColor(R.color.colorLine), ReItemDivider.Orientation.VERTICAL));
        superAdapter = new SuperAdapter(getActivity(), layoutIds);
        superAdapter.setOnItemClickListener(new SingleReAdpt.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (wrapperList.get(position).getLayoutId() == layoutIds[1]) {
                    Intent intent = new Intent(getActivity(), School_Online_DetailsAty.class);
                    intent.putExtra("id", ((LiveOnlineResult.SubjectListBean.LiveOnlineBean) wrapperList.get(position).getData()).getCourseId());
                    startActivity(intent);
                }
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
        mRvOnline.setAdapter(superAdapter);

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

    @OnClick({R.id.tv_direct_more, R.id.rela_direct_Left, R.id.rela_direct_Right})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_direct_more:
                //跳转更多直播列表
                goActivity(School_DirectMoreAty.class);
                break;
            case R.id.rela_direct_Left://跳转到直播详情页
                Intent intent0 = new Intent(getActivity(), School_DirectDetailsAty.class);
                intent0.putExtra("bean", directList.get(0));
                startActivity(intent0);
                break;
            case R.id.rela_direct_Right:
                Intent intent1 = new Intent(getActivity(), School_DirectDetailsAty.class);
                intent1.putExtra("bean", directList.get(1));
                startActivity(intent1);
                break;

        }
    }

    @Override
    public void showDirect(List<LiveDirectResult.LiveCourseListBean> dlist) {
        this.directList = dlist;
        if (directList != null && directList.size() > 0) {
            L.e(directList.size() + "个直播");
            mLlDirect.setVisibility(View.VISIBLE);
            if (directList.get(0) != null) {
                mRelaDirectLeft.setVisibility(View.VISIBLE);
                if (directList.get(0).getPictureUrl() != null && directList.get(0).getPictureUrl().length() > 0) {
                    Log.e("picUrl", APP.picUrl + directList.get(0).getPictureUrl());

                    Glide.with(getActivity()).load(APP.picUrl + directList.get(0).getPictureUrl()).into(mImgDirectLeft);
                } else {
                    if (directList.get(0).getPrice() > 0) {
                        //收费
                        Glide.with(getActivity()).load(R.drawable.zhibo_img_vip).into(mImgDirectLeft);
                    } else {
                        //免费
                        Glide.with(getActivity()).load(R.drawable.zhibo_img_free).into(mImgDirectLeft);
                    }
                }
            } else {
                mRelaDirectLeft.setVisibility(View.GONE);
            }
         /*   if (directList.get(i).getEffective() == 1) {
                mTvDirectLefting.setVisibility(View.VISIBLE);
            } else {
                mTvDirectLefting.setVisibility(View.GONE);
            }*/
            if (directList.get(1) != null) {
                mRelaDirectRight.setVisibility(View.VISIBLE);
                if (directList.get(1).getPictureUrl() != null && directList.get(1).getPictureUrl().length() > 0) {
                    Glide.with(getActivity()).load(APP.picUrl + directList.get(1).getPictureUrl()).into(mImgDirectRight);
                } else {
                    if (directList.get(1).getPrice() > 0) {
                        //收费
                        Glide.with(getActivity()).load(R.drawable.zhibo_img_vip).into(mImgDirectRight);
                    } else {
                        //免费
                        Glide.with(getActivity()).load(R.drawable.zhibo_img_free).into(mImgDirectRight);
                    }
                }
            } else {
                mRelaDirectRight.setVisibility(View.GONE);
            }
        } else {
            mLlDirect.setVisibility(View.GONE);
        }

    }

    @Override
    public void showOnline(List<LiveOnlineResult.SubjectListBean> subjList) {
        wrapperList.clear();
        L.e(subjList.size() + "个在线");
        for (int i = 0; i < subjList.size(); i++) {
            if (subjList.get(i).getCourseList() != null) {
                wrapperList.add(new LayoutWrapper(layoutIds[0], subjList.get(i).getSubjectName(), titleHolder));
                for (int j = 0; j < subjList.get(i).getCourseList().size(); j++) {
                    wrapperList.add(new LayoutWrapper(layoutIds[1], subjList.get(i).getCourseList().get(j), dataHolder));
                }
            }
        }
        if (wrapperList.size() > 0) {
            mTvOnlineTitle.setVisibility(View.VISIBLE);
        } else {
            mTvOnlineTitle.setVisibility(View.GONE);
        }
        superAdapter.setData(wrapperList);
    }

    @Override
    public void showToast(String msg) {

    }
}
