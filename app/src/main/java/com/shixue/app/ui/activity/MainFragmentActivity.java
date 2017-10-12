package com.shixue.app.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jjs.Jbase.BaseFragmentActivity;
import com.jjs.Jutils.SysUtils;
import com.jjs.Jutils.ToastUtils;
import com.shixue.app.APP;
import com.shixue.app.ApiService;
import com.shixue.app.R;
import com.shixue.app.RxSubscribe;
import com.shixue.app.contract.MainContract;
import com.shixue.app.model.MainModel;
import com.shixue.app.ui.bean.ExamInfoResult;
import com.shixue.app.ui.bean.VersionResult;
import com.shixue.app.ui.bean.WXshapeResult;
import com.shixue.app.ui.fragment.FlowFragment;
import com.shixue.app.ui.fragment.HomeFragment;
import com.shixue.app.ui.fragment.PersonalFragment;
import com.shixue.app.ui.fragment.PractiseFragment;
import com.shixue.app.ui.fragment.SchoolFragment;
import com.shixue.app.utils.HTTPutils;
import com.shixue.app.utils.L;
import com.shixue.app.utils.MyDialog;
import com.shixue.app.utils.SweetDialog;
import com.shixue.app.utils.WXshpaeDialog;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class MainFragmentActivity extends BaseFragmentActivity implements MainContract.View {

    @Bind(R.id.img_title_examType)
    ImageView mImgTitleExamType;
    @Bind(R.id.tv_title_examType)
    TextView mTvTitleExamType;
    @Bind(R.id.tv_title_examDir)
    TextView mTvTitleExamDir;
    @Bind(R.id.tv_title_city)
    TextView mTvTitleCity;
    @Bind(R.id.rg_main)
    RadioGroup mRgMain;


    MainModel mModel;
    SweetDialog mDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        SysUtils.setSTATUScolor(this, Color.parseColor("#059B76"));
        mDialog = new SweetDialog(this, SweetDialog.PROGRESS_TYPE).setTitleText("正在加载...");
        mDialog.show();

        //判断是否自动登陆
        if (APP.shared.getBoolean("isLogin", false)) {
            login();
        } else {
            init();
        }

    }

    @Override
    protected void init() {
        mModel = new MainModel(this, this);
        mModel.getCity();
        if (APP.userInfo != null) {
            APP.CityID = APP.userInfo.getBody().getUser().getCityId();
            APP.ProvinceID = APP.userInfo.getBody().getUser().getProvinceId();
            APP.projectID = APP.userInfo.getBody().getUser().getProjectId();
            APP.examType = APP.userInfo.getBody().getExamTypeId();
            Log.e("获取考试类型", APP.examType + "");
        }

        //代理商这段代码需注释
//        if (APP.examTypeList == null) {
//            HTTPutils.getExamTypeList(new HTTPutils.OnTaskClick() {//获取分类
//                @Override
//                public void onSuccess(Object o) {
//                    changeExamType();
//                    changeExamDir();
//                    if (mDialog != null)
//                        mDialog.cancel();
//                }
//
//                @Override
//                public void onError(String ex) {
//                    APP.mToast(ex);
//                    if (mDialog != null)
//                        mDialog.cancel();
//                }
//            });
//        } else {
//        changeExamType();
        changeExamDir();//获取代理商项目二级分类
        if (mDialog != null)
            mDialog.cancel();
//        }


        /**
         * 获取微信广告（12.28改为每次登陆弹出广告）
         */
//        if (APP.userInfo != null && APP.isSMSLogin || APP.changeType) {
//            //   if (APP.shared.getBoolean("isFirstShowWX", true) || APP.userInfo != null)
//            L.e("进入查询广告方法：pro:" + APP.projectID + "---provin:" + APP.ProvinceID);
//            APP.apiService.getWXshape(APP.projectID, APP.ProvinceID)
//                    .subscribeOn(Schedulers.newThread())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe(new RxSubscribe<WXshapeResult>() {
//                        @Override
//                        protected void _onNext(WXshapeResult wXshapeResult) {
//                            L.e("广告查询成功");
//                            new WXshpaeDialog(MainFragmentActivity.this).show(wXshapeResult.getOneWord(), wXshapeResult.getWeixinAd(), wXshapeResult.getWeixin());
//                            APP.isSMSLogin = false;
//                        }
//
//                        @Override
//                        protected void _onError(String msg) {
//                            L.e("广告查询失败：" + msg);
//                        }
//                    });
//
//        }
        /**
         * 查询版本更新数据
         */
        Log.e("版本--", APP.projectID + "");
        APP.apiService.getVersion(APP.projectID)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxSubscribe<VersionResult>() {
                    @Override
                    protected void _onNext(VersionResult versionResult) {
                        Log.e("版本", versionResult.getSoftAndroidVersion() + "   " + APP.versionName);
                        if (!versionResult.getSoftAndroidVersion().equals(APP.versionName + "")) {//只要版本不同即进行更新
                            new SweetDialog(MainFragmentActivity.this, SweetDialog.WARNING_TYPE)
                                    .setTitleText("发现新版本")
                                    .setContentText("是否立即前往下载更新")
                                    .setConfirmText("前往下载", sweetDialog -> {
                                        Intent intent = new Intent();
                                        intent.setAction("android.intent.action.VIEW");
                                        Uri content_url = Uri.parse(APP.APPupdataUrl);
                                        intent.setData(content_url);
                                        startActivity(intent);
                                        sweetDialog.cancel();
                                    }).show();

                        }
                    }

                    @Override
                    protected void _onError(String msg) {

                    }
                });

        //首页-流程-课堂-练题-个人
        framList.clear();
        addAllFragment(R.id.fram_main, new HomeFragment(), new FlowFragment(), new SchoolFragment(), new PractiseFragment(), new PersonalFragment());
        mRgMain.setOnCheckedChangeListener((group, checkedId) -> {
            for (int i = 0; i < group.getChildCount(); i++) {
                if (checkedId == group.getChildAt(i).getId()) {
                    showFragment(i);
                    if (i == 0) {
                        mTvTitleCity.setVisibility(View.VISIBLE);
                    } else {
                        mTvTitleCity.setVisibility(View.GONE);
                    }
                    break;
                }
            }
        });
        ((RadioButton) mRgMain.getChildAt(0)).setChecked(true);
    }

    public void login() {
        HTTPutils.login(APP.shared.getString("phone", ""), new HTTPutils.OnTaskClick() {
            @Override
            public void onSuccess(Object o) {
                showToast("登陆成功！" + APP.shared.getString("phone", ""));
                mDialog.dismiss();
                init();
            }

            @Override
            public void onError(String ex) {
                Log.e("onError", ex);
                new MyDialog(MainFragmentActivity.this)
                        .setTypeNOMAL()
                        .setTitleTxt("登陆失败")
                        .setMessageTxt("请检查网络后重试")
                        .setCheckTxt("重试", myDialog -> {
                            login();
                            myDialog.cancel();
                        })
                        .setCancelable(false).show();
            }
        });
    }


    public void changeExamType() {//改变项目类型
        if (APP.APP_ID == 10) {
            Glide.with(MainFragmentActivity.this).load(R.drawable.logo_gdck).into(mImgTitleExamType);
            mTvTitleExamType.setText("广东成人高考");
        } else if (APP.APP_ID == 11) {
            Glide.with(MainFragmentActivity.this).load(R.drawable.logo_gdzk).into(mImgTitleExamType);
            mTvTitleExamType.setText("广东自学考试");
        } else {
            for (int i = 0; i < APP.examTypeList.size(); i++) {
                for (int j = 0; j < APP.examTypeList.get(i).getProjectList().size(); j++) {
                    if (APP.projectID == APP.examTypeList.get(i).getProjectList().get(j).getProjectId()) {
                        Glide.with(MainFragmentActivity.this).load(ApiService.picUrl + APP.examTypeList.get(i).getProjectList().get(j).getProjectPicture()).into(mImgTitleExamType);
                        mTvTitleExamType.setText(APP.examTypeList.get(i).getProjectList().get(j).getProjectName());
                        break;
                    }
                }
            }
        }
    }

    public void changeExamDir() {//获取项目类型二级分类
        HTTPutils.getExamInfo(APP.projectID, new HTTPutils.OnTaskClick<ExamInfoResult.ProjectBean>() {
            @Override
            public void onSuccess(ExamInfoResult.ProjectBean examInfoBean) {


                APP.examInfoBean = examInfoBean;
                setExamTypeName();
            }

            @Override
            public void onError(String ex) {
                APP.mToast(ex);
            }
        });
    }

    public void updateCity() {
        mTvTitleCity.setText(HTTPutils.getAddressName());
    }

    private void setExamTypeName() {
        for (int i = 0; i < APP.examInfoBean.getExamTypeList().size(); i++) {
            if (APP.examInfoBean.getExamTypeList().get(i).getExamTypeId() == APP.examType) {
                if (APP.examType == APP.examInfoBean.getExamTypeList().get(i).getExamTypeId()) {
                    APP.examName = APP.examInfoBean.getExamTypeList().get(i).getExamTypeName();
                    mTvTitleExamDir.setText(APP.examName);
                }
            }
        }
    }


    @Override
    protected void onResult(int request, Intent data) {
        if (request == 1) {
            updateCity();
            ((HomeFragment) framList.get(0)).init();
            ((FlowFragment) framList.get(1)).init();
            ((PersonalFragment) framList.get(4)).updateCity();
        }
    }

    @OnClick({R.id.ll_title_Type, R.id.tv_title_city})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_title_Type:
                //考试方向
                HTTPutils.showExamListDialog(MainFragmentActivity.this, mTvTitleExamType.getText().toString().trim(), APP.examInfoBean.getExamTypeList(), myDialog -> {
                });
                break;
            case R.id.tv_title_city:
                //城市选择
                goActivity(CityAty.class, 1);
                break;
        }
    }

    @Override
    public void getCityOK(String str) {
        mModel.getAddress();
    }

    @Override
    public void getAddressOK(String str) {
        L.e(str);
        mTvTitleCity.setText(str);
        ((PersonalFragment) framList.get(4)).init();
        if (APP.userInfo == null) {
            ((FlowFragment) framList.get(1)).init();
        }
    }

    @Override
    public void showToast(String msg) {
        APP.mToast(msg);
    }


    private long exitiem = 0;
    SweetDialog cancelDialog;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        /*if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - exitiem > 2000) {
                exitiem = System.currentTimeMillis();
                APP.mToast("再按一下退出");
                return true;
            } else {
                System.exit(1);
            }
        }*/
        if (cancelDialog != null && cancelDialog.isShowing()) {
            cancelDialog.cancel();
        } else {
            cancelDialog = new SweetDialog(MainFragmentActivity.this, SweetDialog.WARNING_TYPE);
            cancelDialog.setCancelable(true);
            cancelDialog.setTitleText("真的要离开吗?")
                    .setConfirmText("继续学习")
                    .setCancelText("残忍退出", new SweetDialog.OnSweetClick() {
                        @Override
                        public void onClick(SweetDialog sweetDialog) {
                            System.exit(0);
                        }
                    }).show();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
