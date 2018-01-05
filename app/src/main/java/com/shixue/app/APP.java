package com.shixue.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.gensee.vod.VodSite;
import com.google.gson.Gson;
import com.jjs.Jbase.BaseActivity;
import com.jjs.Jview.J;
import com.orhanobut.logger.Logger;
import com.shixue.app.ui.activity.StartAty;
import com.shixue.app.ui.bean.CityResult;
import com.shixue.app.ui.bean.ExamInfoResult;
import com.shixue.app.ui.bean.ExamTypeResult;
import com.shixue.app.ui.bean.GetImgCodeResult;
import com.shixue.app.ui.bean.SingleVipResult;
import com.shixue.app.ui.bean.UserInfoBean;
import com.shixue.app.ui.bean.VipBean;
import com.shixue.app.ui.bean.httpBean;

import org.litepal.LitePalApplication;
import org.xutils.x;

import java.util.List;

import retrofit2.Retrofit;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * 作者：JJS
 * 日期：2016-11-18
 * QQ：994462623
 */

public class APP extends BaseApplication {
    //APP初始数据
    public static boolean isDebug = true;

    String APPtype = "伴我考教师证";
    public static String APPpackge = "com.shixue.online.app";


    public static int APP_ID;//项目编号(后期会发布多个版本，根据名字不同分别对应不同的项目编号)
    public static int defaultExamType;//默认子菜单
    public static int projectID = 1;//考试类型(取id参数)（默认考试类型与项目编号是对应的）（1教师资格证，2成人高考，3自学考试，5普通话等级证书，7研究生考试，8会计证）
    public static int examType = 1;//考试方向（默认考试方向与项目编号对应）（二级菜单）
    private String updataHTTP = "http://sj.qq.com/myapp/detail.htm?apkName=";
    public static String APPupdataUrl = "";//APP下载地址（应用宝）(需要添加数据！！！！！！！！)
    public static boolean changeType = false;
    public static boolean isTry = false;//用于判断是不是试用
    public static String picUrl = "http://119.29.194.199/sxkj/";
    public static String htmlUrl = "http://119.29.194.199/sxkj/";
    public static String NOTIFY_URL = "http://www.banwokao.com/manager/";
    //单例模式
    public static Gson gson;
    public static LocationClient baiduClient = null;
    public static int versionCode;//版本号
    public static String versionName;//版本说明
    public static int windowWidth, windowHeight;//手机宽高
    public static String TFpath;//内存地址根目录
    public static ApiService apiService;
    public static Context APPcontext;
    public static SharedPreferences shared;//简单存储
    private String loggerTitle = "";//log标题
    //APP数据
    public static boolean isSMSLogin = false;
    public static VipBean vipBean;//用户vip数据，有vip才有数据，无vip时为null
    public static SingleVipResult SingleVipBean;
    public static int singleVip = 0;//判断单个考试类型Vip  0未开通 1 开通了其中一种会员 2 两种会员都开通
    public static int singleVipType = 0;

    public static boolean isVip = false;//是否是vip
    public static int vipType;//用于判断是哪种类型的Vip
    public static int vipDay = 0;//vip剩余天数
    public static int ProvinceID = 2;//省份（默认广东）
    public static int CityID = 128;//城市(默认广州)
    public static String examName = "";//考试方向（默认考试方向与项目编号对应）（二级菜单）
    public static List<ExamTypeResult.ProjTypeListBean> examTypeList;//所有项目列表
    public static ExamInfoResult.ProjectBean examInfoBean;//单个项目详细信息
    public static UserInfoBean userInfo;//用户信息
    public static List<CityResult.ProvListBean> provinceBeanList;//省份城市列表
    public static String password = "1234";
    public static GetImgCodeResult imgCodeResult;
    public static int vipStatus = 1;//判断当前考试类型是否过期

    @Override
    public void onCreate() {
        super.onCreate();
        APPcontext = getApplicationContext();
        VodSite.init(getApplicationContext(), null);
        init();
        //第三方初始化
        initOther();
        LitePalApplication.initialize(this);
        x.Ext.init(this);
        getApi();
    }

    public static boolean hasNetwork() {
        // 获取网络管理器
        ConnectivityManager connmanager = (ConnectivityManager) APPcontext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        // 获取网络状态
        NetworkInfo info = connmanager.getActiveNetworkInfo();
        // 如果为空。表示没有网络
        if (info == null) {
            mToast("无网络,请检查后重试");
            return false;
        }
        return true;

    }

    private void updateDefaultDATE(String logName, int appID, int projecID, int examTypeID) {//更新基础默认数据
        loggerTitle = logName;
        APP_ID = appID;
        if (!APP.shared.getBoolean("isLogin", false)) {
            projectID = APP.shared.getInt("projectID", projecID);
            examType = APP.shared.getInt("examType", examTypeID);//考试类型id 最小值为1
            if (examType == 0) {
                examType = 1;
            }
        }
        // projectID = projecID;
        // examType = examTypeID;
        defaultExamType = examTypeID;
        APPupdataUrl = updataHTTP + APPpackge;
    }

    private void initOther() {
        switch (APPtype) {
            case "伴我考教师证":
                updateDefaultDATE("伴我考教师证", 1, 1, 1);//com.shixue.app
                break;
            case "伴我考成考":
                updateDefaultDATE("伴我考成考", 2, 2, 10);//banwokao.ck.app
                break;
            case "伴我考自考":
                updateDefaultDATE("伴我考自考", 3, 3, 13);//banwokao.zk.app
                break;
            case "伴我考普通话":
                updateDefaultDATE("伴我考普通话", 5, 5, 24);//banwokao.pth.app
                break;
            case "会计从业基础":
                updateDefaultDATE("会计从业基础", 8, 8, 26);//banwokao.kjcy.app
                break;
            case "会计初级职称":
                updateDefaultDATE("会计初级职称", 9, 9, 27);//banwokao.kjcj.app
                break;
            case "广东成人高考":
                updateDefaultDATE("研究生考试", 10, 10, 29);//banwokao.guangdong.chengkao
                break;
            case "广东自学考试":
                updateDefaultDATE("研究生考试", 11, 11, 32);//banwokao.guangdong.zikao
                break;

        }


        Logger.init("伴我考-" + loggerTitle);
        gson = new Gson();

        initBaiduMap();
        BaseActivity.APPcolor = Color.parseColor("#059B76");
    }


    private void init() {
        initShared(APPtype);
        if (!APP.isDebug) {
            initAPPerror(StartAty.class);
        }
        initPakegeInfo(APPpackge);
        Retrofit retrofit = initRetrofit(ApiService.httpUrl);
        apiService = retrofit.create(ApiService.class);
        J.BuilderTitleView().setShow(false, true, false, false).setTitleColor("#059B76").setCenterData(18, Color.WHITE).setRightTxtData("确定", 14, Color.WHITE).setImageRes(R.drawable.icon10, R.drawable.icon18).build();
    }

    private void initBaiduMap() {
        baiduClient = new LocationClient(getApplicationContext());
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
        int span = 1001;
        option.setScanSpan(span);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);//可选，默认false,设置是否使用gps
        option.setLocationNotify(true);//可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);//可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤gps仿真结果，默认需要
        baiduClient.setLocOption(option);
    }

    private void initShared(String str) {
        shared = getSharedPreferences(str, MODE_PRIVATE);
    }


    /**
     * 获取指定包名的版本号与版本说明
     */
    private static void initPakegeInfo(String packgeName) {
        PackageManager packagemanager = APPcontext.getPackageManager();
        try {
            PackageInfo info = packagemanager.getPackageInfo(packgeName, 0);

            versionCode = info.versionCode;//手机当前安装的版本号
            versionName = info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 单例吐司
     */
    private static Toast toast;

    public static void mToast(String msg) {
        showToast(msg);
    }

    public static void mToast(int strings) {
        showToast(APPcontext.getResources().getString(strings));
    }

    private static void showToast(String msg) {
        if (toast == null) {
            toast = Toast.makeText(APPcontext, msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg);
            toast.setDuration(Toast.LENGTH_SHORT);
        }
        toast.show();
    }

    //获取所有地址域名
    private void getApi() {
        APP.apiService.getHttpServer("").subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxSubscribe<httpBean>() {
                    @Override
                    protected void _onNext(httpBean httpBean) {
                        APP.picUrl = httpBean.getAttachPrefixUrl();
                        APP.htmlUrl = httpBean.getAttachPrefixUrl();
                        APP.NOTIFY_URL = httpBean.getAttachPrefixUrl();
                    }

                    @Override
                    protected void _onError(String msg) {

                    }
                });
    }
}
