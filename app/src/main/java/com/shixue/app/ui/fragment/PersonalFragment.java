package com.shixue.app.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jjs.Jbase.BaseFragment;
import com.jjs.Jutils.RecyclerView.BaseReHolder;
import com.jjs.Jutils.RecyclerView.SingleReAdpt;
import com.shixue.app.APP;
import com.shixue.app.R;
import com.shixue.app.RxSubscribe;
import com.shixue.app.ui.activity.CityAty;
import com.shixue.app.ui.activity.DetailsFragmentAty;
import com.shixue.app.ui.activity.LoginAty;
import com.shixue.app.ui.activity.MainFragmentActivity;
import com.shixue.app.ui.activity.PersonalDetailsAty;
import com.shixue.app.ui.bean.CityResult;
import com.shixue.app.ui.bean.ExamInfoResult;
import com.shixue.app.ui.bean.PersnalItemBean;
import com.shixue.app.utils.HTTPutils;
import com.shixue.app.widget.RoundView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by Administrator on 2016-11-23.
 */

public class PersonalFragment extends BaseFragment {
    @Bind(R.id.img_head)
    RoundView mImgHead;
    @Bind(R.id.tv_name)
    TextView mTvName;
    @Bind(R.id.tv_phone)
    TextView mTvPhone;
    @Bind(R.id.rv_personal)
    RecyclerView mRvPersonal;
    @Bind(R.id.tv_loginOut)
    TextView mTvLoginOut;
    private SingleReAdpt reAdpt;
    List<PersnalItemBean> personalitemList;

    @Override
    protected void onCreat() {
        setContentView(R.layout.fragment_personal);
    }

    @Override
    public void init() {
        personalitemList = new ArrayList<>();
        personalitemList.add(new PersnalItemBean(R.drawable.icon33, "会员中心", "未开通"));
        personalitemList.add(new PersnalItemBean(R.drawable.icon34, "我的城市", "北京-北京"));
        personalitemList.add(new PersnalItemBean(R.drawable.icon35, "考试类别", ""));
        personalitemList.add(new PersnalItemBean(R.drawable.icon40, "邀请好友", ""));
        // personalitemList.add(new PersnalItemBean(R.drawable.icon41, "意见反馈", ""));
        personalitemList.add(new PersnalItemBean(R.drawable.icon42, "关于我们", ""));
        if (APP.userInfo != null) {
            //没有头像字段
            if (APP.userInfo.getBody().getUser().getSex() == 0) {
                mImgHead.setImageResource(R.drawable.ic_man);
            } else {
                mImgHead.setImageResource(R.drawable.ic_woman);
            }
            if (!TextUtils.isEmpty(APP.userInfo.getBody().getUser().getMobile())) {
                mTvPhone.setText(APP.userInfo.getBody().getUser().getMobile());
            }

            if (TextUtils.isEmpty(APP.userInfo.getBody().getUser().getUserName())) {
                mTvName.setText("未设置昵称");
            } else {
                mTvName.setText(APP.userInfo.getBody().getUser().getUserName());
            }
            mTvLoginOut.setVisibility(View.VISIBLE);

            if (APP.provinceBeanList == null || APP.provinceBeanList.size() == 0) {
                APP.apiService.getCityList()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new RxSubscribe<CityResult>() {
                            @Override
                            protected void _onNext(CityResult cityResult) {
                                APP.provinceBeanList = cityResult.getProvList();
                                String address = HTTPutils.getAddressName();
                                if (!address.equals(""))
                                    personalitemList.get(1).setStrRight(address);
                            }

                            @Override
                            protected void _onError(String msg) {

                            }
                        });
            } else {
                String address = HTTPutils.getAddressName();
                if (!address.equals(""))
                    personalitemList.get(1).setStrRight(address);
            }

        } else {
            mTvLoginOut.setVisibility(View.GONE);
        }
        mRvPersonal.setLayoutManager(new LinearLayoutManager(getActivity()));
        reAdpt = new SingleReAdpt<PersnalItemBean>(getActivity(), R.layout.recycler_personal, personalitemList) {
            @Override
            protected void BindData(BaseReHolder holder, int position, PersnalItemBean data) {
                holder.getImgV(R.id.item_img).setSrc(data.getImg());
                holder.getTV(R.id.item_tvLeft).setText(data.getStrLeft());
                holder.getTV(R.id.item_tvRight).setText(data.getStrRight());
                if (position == 0) {
                    holder.getTV(R.id.item_tvLeft).setTextColor("#F88437");
                    holder.getTV(R.id.item_tvRight).setTextColor("#999999");
                }
            }
        };
        reAdpt.setOnItemClickListener(new SingleReAdpt.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                switch (personalitemList.get(position).getStrLeft()) {
                    case "会员中心":
                        //跳转会员
                        if (APP.userInfo == null) {
                            goActivity(LoginAty.class);
                            return;
                        }
                        Intent vipIntent = new Intent(getActivity(), DetailsFragmentAty.class);
                        vipIntent.putExtra("type", "vip");
                        vipIntent.putExtra("name", "会员中心");
                        startActivityForResult(vipIntent, 2);
                        break;
                    case "我的城市":
                        //城市
                        goActivity(CityAty.class, 3);
                        break;
                    case "考试类别":
                        //考试类别
//                        if (APP.examTypeList == null) return;
//                        for (int i = 0; i < APP.examTypeList.size(); i++) {
//                            for (int j = 0; j < APP.examTypeList.get(i).getProjectList().size(); j++) {
//                                if (APP.projectID == APP.examTypeList.get(i).getProjectList().get(j).getProjectId()) {
//                                    String projectName = APP.examTypeList.get(i).getProjectList().get(j).getProjectName();
//                                    if (APP.examInfoBean == null) {
//                                        HTTPutils.getExamInfo(APP.examType, new HTTPutils.OnTaskClick<ExamInfoResult.ProjectBean>() {
//                                            @Override
//                                            public void onSuccess(ExamInfoResult.ProjectBean projectBean) {
//                                                APP.examInfoBean = projectBean;
//                                                HTTPutils.showExamListDialog(getActivity(), projectName, APP.examInfoBean.getExamTypeList(), myDialog -> {
//
//                                                });
//                                            }
//
//                                            @Override
//                                            public void onError(String ex) {
//
//                                            }
//                                        });
//                                    } else {
//                                        HTTPutils.showExamListDialog(getActivity(), projectName, APP.examInfoBean.getExamTypeList(), myDialog -> {
//
//                                        });
//                                    }
                        HTTPutils.showExamListDialog(getActivity(), "在线学教师证", APP.examInfoBean.getExamTypeList(), myDialog -> {

                        });
                        break;
                    case "邀请好友":
                        //邀请有礼
                        Intent shapeIntent = new Intent(getActivity(), DetailsFragmentAty.class);
                        shapeIntent.putExtra("type", "shape");
                        shapeIntent.putExtra("name", "邀请好友");
                        startActivity(shapeIntent);
                        break;
                 /*   case "意见反馈":
                        goActivity(Activity_think.class);
                        break;*/
                    case "关于我们":
                        //关于我们'
                        Intent intent = new Intent(getActivity(), DetailsFragmentAty.class);
                        intent.putExtra("name", "关于我们");
                        intent.putExtra("type", "about");
                        startActivity(intent);
                        break;
                }
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });

        changeExamDir();
        //获取vip信息
        if (APP.userInfo != null) {
            HTTPutils.getVipBean(APP.userInfo.getBody().getUser().getMobile(), APP.projectID, b -> {
                if (APP.isVip) {
                    personalitemList.get(0).setStrRight("剩余(" + APP.vipDay + "天) " + "截至日期:" + APP.vipBean.getSvipDate());
                } else {
                    personalitemList.get(0).setStrRight("未开通");
                }
                reAdpt.notifyDataSetChanged();
            });
        }
        updateCity();
        mRvPersonal.setAdapter(reAdpt);
    }

    public void updateCity() {
        String address = HTTPutils.getAddressName();
        if (!address.equals("")) {
            personalitemList.get(1).setStrRight(address);
            reAdpt.notifyDataSetChanged();
        }
    }

    public void changeExamDir() {
        // if (APP.examInfoBean == null) {
        HTTPutils.getExamInfo(APP.projectID, new HTTPutils.OnTaskClick<ExamInfoResult.ProjectBean>() {
            @Override
            public void onSuccess(ExamInfoResult.ProjectBean examInfoBean) {
                APP.examInfoBean = examInfoBean;
                for (int i = 0; i < APP.examInfoBean.getExamTypeList().size(); i++) {
                    if (APP.examInfoBean.getExamTypeList().get(i).getExamTypeId() == APP.examType) {
                        if (APP.examType == APP.examInfoBean.getExamTypeList().get(i).getExamTypeId()) {
                            APP.examName = APP.examInfoBean.getExamTypeList().get(i).getExamTypeName();
                            personalitemList.get(2).setStrRight(APP.examName);
                            reAdpt.notifyDataSetChanged();
                        }
                    }
                }
            }

            @Override
            public void onError(String ex) {
                APP.mToast(ex);
            }
        });
      /*  } else {
            for (int i = 0; i < APP.examInfoBean.getExamTypeList().size(); i++) {
                if (APP.examInfoBean.getExamTypeList().get(i).getExamTypeId() == APP.examType) {
                    APP.examName = APP.examInfoBean.getExamTypeList().get(i).getExamTypeName();
                    personalitemList.get(2).setStrRight(APP.examName);
                }
            }
        }*/
    }

    @Override
    protected void onResult(int request, Intent data) {
        switch (request) {
            case 1:
                init();
                break;
            case 2:
                init();
                break;
            case 3:
                init();
                ((MainFragmentActivity) getActivity()).updateCity();
                ((HomeFragment) ((MainFragmentActivity) getActivity()).framList.get(0)).init();
                ((FlowFragment) ((MainFragmentActivity) getActivity()).framList.get(1)).init();
                break;
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

    @OnClick({R.id.ll_personal, R.id.tv_loginOut})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_personal:
                //跳转
                if (APP.userInfo == null) {
                    goActivity(LoginAty.class);
                } else {
                    goActivity(PersonalDetailsAty.class, 1);
                }
                break;
            case R.id.tv_loginOut:
                APP.shared.edit().putBoolean("isLogin", false).commit();
                APP.userInfo = null;
               /* APP.examName = "幼儿园";
                APP.examType = 1;
                APP.projectID = 1;
                APP.ProvinceID = 1;
                APP.CityID = 1;*/
                //  APP.projectID=APP.APP_ID;
                //  APP.examType=APP.defaultExamType;
                APP.vipBean = null;
                APP.isVip = false;
                APP.vipDay = 0;
                Intent intent = new Intent(getActivity(), MainFragmentActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                        | Intent.FLAG_ACTIVITY_CLEAR_TASK
                        | Intent.FLAG_ACTIVITY_NEW_TASK);
                getActivity().startActivity(intent);
                goActivity(LoginAty.class);
                break;
        }
    }
}
