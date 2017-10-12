package com.shixue.app.utils;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.jjs.Jutils.RecyclerView.BaseReHolder;
import com.jjs.Jutils.RecyclerView.ReItemDivider;
import com.jjs.Jutils.RecyclerView.SingleReAdpt;
import com.shixue.app.APP;
import com.shixue.app.R;
import com.shixue.app.RxSubscribe;
import com.shixue.app.ui.activity.DetailsFragmentAty;
import com.shixue.app.ui.activity.MainFragmentActivity;
import com.shixue.app.ui.bean.ExamInfoResult;
import com.shixue.app.ui.bean.ExamTypeResult;
import com.shixue.app.ui.bean.GetImgCodeResult;
import com.shixue.app.ui.bean.UserInfoBean;
import com.shixue.app.ui.bean.VipBean;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.shixue.app.ApiService.httpUrl;

/**
 * 本页：
 * Created by jjs on 2016-11-30.
 */

public class HTTPutils {
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public interface OnBooleanClick {
        void onSuccess(boolean b);
    }

    public static String getAddressName() {
        if (APP.provinceBeanList == null) {
            //APP.mToast("城市信息获取失败");
            return "";
        }
        String cityName = "";
        for (int i = 0; i < APP.provinceBeanList.size(); i++) {
            if (APP.provinceBeanList.get(i).getProvinceId() == APP.ProvinceID) {
                //包含
                cityName = APP.provinceBeanList.get(i).getProvinceName();
                for (int j = 0; j < APP.provinceBeanList.get(i).getCityList().size(); j++) {
                    if (APP.provinceBeanList.get(i).getCityList().get(j).getCityId() == APP.CityID) {
                        cityName += " - " + APP.provinceBeanList.get(i).getCityList().get(j).getCityName();
                    }
                }
            }
        }
        return cityName;
    }

    /**
     * 切换用户项目
     */
    public static void updateProject(String mobile, int projectId, int examTypeId, OnTaskClick taskClick) {
        RequestParams params = new RequestParams(httpUrl + "projectAction!changeProject.action");
        params.addParameter("mobile", mobile);
        params.addParameter("projectId", projectId);
        params.addParameter("examTypeId", examTypeId);
        params.addParameter("webchat", 0);
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                L.e(result);
                try {
                    JSONObject object = new JSONObject(result);
                    boolean success = object.getBoolean("success");
                    if (success) {
                        login(mobile, new OnTaskClick() {
                            @Override
                            public void onSuccess(Object o) {
                                taskClick.onSuccess("");
                            }

                            @Override
                            public void onError(String ex) {
                                taskClick.onError("");
                            }
                        });
                    } else {
                        taskClick.onError("");
                    }
                } catch (JSONException e) {


                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                taskClick.onError("");
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }

    /**
     * 登陆方法
     */
    public static void login(String mobile, OnTaskClick taskClick) {
        RequestParams params = new RequestParams(httpUrl + "loginAction!login.action");
        params.addParameter("webchat", 0);
        params.addParameter("systemVersion", android.os.Build.VERSION.RELEASE);
        params.addParameter("equipmentModel", android.os.Build.MODEL);
        params.addParameter("softVersion", APP.versionName);
        params.addParameter("equipmentType", 0);//设备类型。0安卓
        params.addParameter("password", "1234");//密码？？
        params.addParameter("projectId", "1");//代理商版本所有项目id （APP.projectID）都是固定的为1
//        params.addParameter("provinceId", APP.ProvinceID);
//        params.addParameter("cityId", APP.CityID);
//        params.addParameter("examTypeId", APP.examType);
//        params.addParameter("examDirection", APP.examName);
        params.addParameter("mobile", mobile);
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject object = new JSONObject(result);
                    boolean success = object.getBoolean("success");
                    if (success) {
                        APP.userInfo = new Gson().fromJson(object.getJSONObject("body").toString(), UserInfoBean.class);
                        Log.e("onError", APP.userInfo + "---");
//                        APP.examType = APP.userInfo.getBody().getExamTypeId();
                        APP.projectID = APP.userInfo.getBody().getUser().getProjectId();
                        APP.CityID = APP.userInfo.getBody().getUser().getCityId();
                        APP.ProvinceID = APP.userInfo.getBody().getUser().getProvinceId();
                        APP.shared.edit().putInt("ProvinceID", APP.userInfo.getBody().getUser().getProvinceId()).commit();
                        APP.shared.edit().putInt("CityID", APP.userInfo.getBody().getUser().getCityId()).commit();
                        APP.shared.edit().putInt("projectID", APP.userInfo.getBody().getUser().getProjectId()).commit();
                        APP.shared.edit().putInt("examType", APP.userInfo.getBody().getExamTypeId()).commit();
                        APP.shared.edit().putBoolean("isLogin", true).putString("phone", APP.userInfo.getBody().getUser().getMobile()).commit();
                        APP.shared.edit().remove(APP.userInfo.getBody().getUser().getMobile() + "smsCode").remove(APP.userInfo.getBody().getUser().getMobile() + "smsTime").commit();
                        taskClick.onSuccess("");
                    } else {
                        taskClick.onError(object.getString("msg"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    L.e("登陆错误");
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                taskClick.onError(ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }

    /**
     * 版本更新获取 图像验证码
     */
//    public static void getImgCode(String mobile, OnTaskClick taskClick) {
//        RequestParams params = new RequestParams(httpUrl + "loginAction!randCode.action");
//        params.addParameter("mobile", mobile);
//        x.http().post(params, new Callback.CacheCallback<String>() {
//            @Override
//            public boolean onCache(String result) {
//                return false;
//            }
//
//            @Override
//            public void onSuccess(String result) {
//                Log.e("result",result);
//                try {
//                    JSONObject jsonObject = new JSONObject(result);
//                    boolean success = jsonObject.getBoolean("success");
//                    if (success) {
//                        APP.imgCodeResult = new Gson().fromJson(jsonObject.getJSONObject("body").toString(), GetImgCodeResult.class);
//                        taskClick.onSuccess(result);
//                    } else {
//
//                        taskClick.onError(jsonObject.getString("msg"));
//
//                    }
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//            }
//
//            @Override
//            public void onError(Throwable ex, boolean isOnCallback) {
//                taskClick.onError(ex.getMessage());
//
//            }
//
//            @Override
//            public void onCancelled(CancelledException cex) {
//
//            }
//
//            @Override
//            public void onFinished() {
//
//            }
//        });
//
//
//    }


    /**
     * 保存用户信息
     */
    public static void updateUser(String mobile, String userName, int sex, String email, String homeAddress, OnTaskClick taskClick) {
        RequestParams params = new RequestParams(httpUrl + "loginAction!modifyUser.action");
        params.addParameter("mobile", mobile);
        params.addParameter("userName", userName);
        params.addParameter("sex", sex);
        params.addParameter("email", email);
        params.addParameter("homeAddress", homeAddress);
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject object = new JSONObject(result);
                    boolean success = object.getBoolean("success");
                    if (success) {
                        APP.userInfo = new Gson().fromJson(object.getJSONObject("body").getJSONObject("user").toString(), UserInfoBean.class);
                        taskClick.onSuccess("");

                    } else {
                        taskClick.onError(object.getString("msg") + "");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                taskClick.onError(ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }

    /**
     * 保存用户城市信息
     */
    public static void updateCity(String mobile, int provinceId, int cityId, OnTaskClick taskClick) {
        RequestParams params = new RequestParams(httpUrl + "loginAction!modifyUserCity.action");
        params.addParameter("mobile", mobile);
        params.addParameter("provinceId", provinceId);
        params.addParameter("cityId", cityId);
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject object = new JSONObject(result);
                    boolean success = object.getBoolean("success");
                    if (success) {
                        APP.userInfo = new Gson().fromJson(object.getJSONObject("body").getJSONObject("user").toString(), UserInfoBean.class);
                        taskClick.onSuccess("");
                    } else {
                        taskClick.onError(object.getString("msg") + "");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                taskClick.onError(ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

  /*  public static void getExamName(OnTaskClick<String> taskClick) {
        if (APP.examInfoBean == null) {
            getExamInfo(APP.examType, new OnTaskClick<ExamInfoResult.ExamInfoBean>() {
                @Override
                public void onSuccess(ExamInfoResult.ExamInfoBean examInfoBean) {
                    APP.examInfoBean = examInfoBean;
                    for (int i = 0; i < APP.examInfoBean.getExamTypeList().size(); i++) {
                        if (APP.examType == APP.examInfoBean.getExamTypeList().get(i).getExamTypeId()) {
                            APP.examName = APP.examInfoBean.getExamTypeList().get(i).getExamTypeName();
                            taskClick.onSuccess(APP.examName);
                        }
                    }
                }

                @Override
                public void onError(String ex) {
                    taskClick.onError(ex);
                }
            });
        } else {
            for (int i = 0; i < APP.examInfoBean.getExamTypeList().size(); i++) {
                if (APP.examType == APP.examInfoBean.getExamTypeList().get(i).getExamTypeId()) {
                    APP.examName = APP.examInfoBean.getExamTypeList().get(i).getExamTypeName();
                    taskClick.onSuccess(APP.examName);
                }
            }
        }
    }*/

    /**
     * 根据省份获取微信广告（用户id里面的省份）
     */
    /*public static void getwxNews(int userId, OnTaskClick<WXnewsBean> taskClick) {
        RequestParams params = new RequestParams("http://int.banwokao.com:8080/shixue/services/userInfo/popupContent");
        params.addParameter("userId", userId);
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject object = new JSONObject(result);
                    WXnewsBean xnewsBean = new Gson().fromJson(object.getJSONObject("data").getJSONObject("data").toString(), WXnewsBean.class);
                    taskClick.onSuccess(xnewsBean);
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
    }*/
    public static void getUserISvip(String mobile, int projectID, OnBooleanClick booleanClick) {
        if (APP.isVip == false || APP.vipBean == null || APP.vipDay == 0) {
            getVipBean(mobile, projectID, b -> booleanClick.onSuccess(b));
        } else {
            booleanClick.onSuccess(true);
        }
    }

    /**
     * 获取用户会员信息
     */
    public static void getVipBean(String mobile, int projectId, OnBooleanClick booleanClick) {
        RequestParams params = new RequestParams(httpUrl + "loginAction!vipInfo.action");
        params.addParameter("mobile", mobile);
        params.addParameter("projectId", projectId);
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                L.e(result);
                try {
                    JSONObject object = new JSONObject(result);
                    boolean success = object.getBoolean("success");
                    if (success) {
                        APP.vipBean = new Gson().fromJson(object.getJSONObject("body").getJSONObject("userProject").toString(), VipBean.class);

                        try {
                            long dateVip = format.parse(APP.vipBean.getSvipDate()).getTime();
                            long dateThis = format.parse(APP.vipBean.getSysDate()).getTime();//当前系统时间
                            long date = dateVip - dateThis;//计算到期时间和当前时间的差值

                            if (date > 0) {
                                //如果vip大于现在时间，说明vip有效
                                int vipday = (int) (date / 1000 / 60 / 60 / 24);//计算会员的剩余天数
                                APP.vipDay = vipday;
                                APP.isVip = true;
                                booleanClick.onSuccess(true);
                            } else {
                                APP.vipBean = null;
                                APP.vipDay = 0;
                                APP.isVip = false;
                                booleanClick.onSuccess(false);
                            }

                        } catch (ParseException e) {
                            e.printStackTrace();
                            APP.vipBean = null;
                            APP.vipDay = 0;
                            APP.isVip = false;
                            booleanClick.onSuccess(false);
                        }

                    } else {
                        APP.vipBean = null;
                        APP.isVip = false;
                        APP.vipDay = 0;
                        booleanClick.onSuccess(false);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                APP.mToast("会员信息获取失败");
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    /**
     * 是否能听课
     */
    public static void hasRead(String mobile, int liveCourseId, OnBooleanClick click) {
        RequestParams params = new RequestParams(httpUrl + "liveCourseAction!openCourse.action");
        params.addParameter("mobile", mobile);
        params.addParameter("liveCourseId", liveCourseId);
        x.http().post(params, new Callback.CommonCallback<JSONObject>() {
            @Override
            public void onSuccess(JSONObject result) {
                try {
                    click.onSuccess(result.getBoolean("success"));
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
    }

    public static void getExamTypeList(OnTaskClick taskClick) {
        APP.apiService.getExamTypeList()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxSubscribe<ExamTypeResult>() {
                    @Override
                    protected void _onNext(ExamTypeResult examTypeResult) {
                        APP.examTypeList = examTypeResult.getProjTypeList();
                        taskClick.onSuccess(null);
                    }

                    @Override
                    protected void _onError(String msg) {
                        taskClick.onError(msg);
                    }
                });
    }

    public static void getExamInfo(int examID, OnTaskClick<ExamInfoResult.ProjectBean> taskClick) {
        if (APP.examTypeList == null) {
            getExamTypeList(new OnTaskClick<List<ExamTypeResult.ProjTypeListBean>>() {
                @Override
                public void onSuccess(List<ExamTypeResult.ProjTypeListBean> projTypeListBeen) {
                    getExamInfo1(examID, taskClick);
                }

                @Override
                public void onError(String ex) {

                }
            });
        } else {
            getExamInfo1(examID, taskClick);
        }
    }

    private static void getExamInfo1(int examID, OnTaskClick taskClick) {
        APP.apiService.getExamTypeInfo(examID)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxSubscribe<ExamInfoResult>() {
                    @Override
                    protected void _onNext(ExamInfoResult examInfoResult) {
                        taskClick.onSuccess(examInfoResult.getProject());
                    }

                    @Override
                    protected void _onError(String msg) {
                        taskClick.onError(msg);
                    }
                });
    }

    public static void showGOvipDialog(Context context) {
        new SweetDialog(context, SweetDialog.WARNING_TYPE)
                .setTitleText("请先开通会员")
                .setConfirmText("开通会员", new SweetDialog.OnSweetClick() {
                    @Override
                    public void onClick(SweetDialog sweetDialog) {
                        // Intent intent = new Intent(context, OpenVipActivity.class);
                        // context.startActivity(intent);
                        Intent vipIntent = new Intent(context, DetailsFragmentAty.class);
                        vipIntent.putExtra("type", "vip");
                        vipIntent.putExtra("name", "会员中心");
                        context.startActivity(vipIntent);
                    }
                })
                .setCancelText("取消")
                .show();
    }

    static int twoCheck = 0;

    public static void showExamListDialog(Context context, String title, List<ExamInfoResult.ProjectBean.ExamTypeListBean> list,
                                          MyDialog.OnCheckListener checkListener) {
        if (list == null || list.size() < 1) {
            Log.e("myDialog__", "未弹出");

            return;
        }
        Log.e("myDialog__", "已弹出");
        if (list.get(0).getProjectId() == APP.projectID) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getProjectId() == APP.projectID) {
                    if (list.get(i).getExamTypeId() == APP.examType) {
                        twoCheck = i;
                        break;
                    }
                } else {
                    break;
                }
            }

        } else {
            twoCheck = 0;
        }
        new MyDialog(context)
                .setTypeLIST()
                .setTitleTxt(title)
                .setCancelable(false)
                .setRvListData(rv -> {
                    rv.setLayoutManager(new LinearLayoutManager(context));
                    SingleReAdpt reAdpt = new SingleReAdpt<ExamInfoResult.ProjectBean.ExamTypeListBean>(context, R.layout.recycler_item_list, list) {
                        @Override
                        protected void BindData(BaseReHolder holder, int position1, ExamInfoResult.ProjectBean.ExamTypeListBean data) {
                            if (position1 == twoCheck) {
                                holder.getImgV(R.id.item_check).setSrc(R.drawable.icon06);
                            } else {
                                holder.getImgV(R.id.item_check).setSrc(R.drawable.icon05);
                            }
                            holder.getTV(R.id.item_name).setText(data.getExamTypeName());
                        }
                    };
                    reAdpt.setOnItemClickListener(new SingleReAdpt.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view1, int position1) {
                            twoCheck = position1;
                            reAdpt.notifyDataSetChanged();
                        }

                        @Override
                        public void onItemLongClick(View view1, int position1) {

                        }
                    });
                    rv.addItemDecoration(new ReItemDivider(context, context.getResources().getColor(R.color.colorLine), ReItemDivider.Orientation.VERTICAL));
                    rv.setAdapter(reAdpt);
                }).setCheckTxt("确定", (myDialog) -> {

            L.e("刚触发");
            checkListener.OnCheck(myDialog);
            L.e(APP.projectID + "-----" + APP.examInfoBean.getProjectId());
            if (APP.projectID != APP.examInfoBean.getProjectId()) {
                APP.changeType = true;
            } else {
                APP.changeType = false;
            }
            APP.projectID = APP.examInfoBean.getProjectId();
            APP.examType = APP.examInfoBean.getExamTypeList().get(twoCheck).getExamTypeId();
            APP.examName = APP.examInfoBean.getExamTypeList().get(twoCheck).getExamTypeName();
            APP.shared.edit().putInt("projectID", APP.examInfoBean.getProjectId()).commit();
            APP.shared.edit().putInt("examType", APP.examInfoBean.getExamTypeList().get(twoCheck).getExamTypeId()).commit();
            APP.shared.edit().putString("examName", APP.examInfoBean.getExamTypeList().get(twoCheck).getExamTypeName()).commit();
            L.e("点击了确定");
            if (APP.userInfo != null) {
                updateProject(APP.userInfo.getBody().getUser().getMobile(), APP.projectID, APP.examType, new OnTaskClick() {
                    @Override
                    public void onSuccess(Object o) {
                        L.e("触发更新");
                        Intent intent = new Intent(context, MainFragmentActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                                | Intent.FLAG_ACTIVITY_CLEAR_TASK
                                | Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        myDialog.cancel();
                        APP.mToast("项目已启动");
                    }

                    @Override
                    public void onError(String ex) {
                        APP.mToast("错误请重试");
                    }
                });
            } else {
                Intent intent = new Intent(context, MainFragmentActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                        | Intent.FLAG_ACTIVITY_CLEAR_TASK
                        | Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                myDialog.cancel();
                APP.mToast("项目已启动");
            }
        }).show();
    }


    public interface OnTaskClick<T> {
        void onSuccess(T t);

        void onError(String ex);
    }
}
