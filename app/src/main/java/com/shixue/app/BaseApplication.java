package com.shixue.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.support.annotation.ColorInt;
import android.support.multidex.MultiDexApplication;
import android.view.Display;
import android.view.WindowManager;

import com.jjs.Jview.J;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 本页：
 * Created by jjs on 2017-03-18.
 * Email:994462623@qq.com
 */

public class BaseApplication extends MultiDexApplication {
    private static Context APPcontext;
    public static String TFpath;//内存地址根目录
    public static int versionCode;//版本号
    public static String versionName;//版本说明
    public static int windowWidth, windowHeight;//手机宽高

    @Override
    public void onCreate() {
        super.onCreate();
        APPcontext = getApplicationContext();
        getTFpath();

    }

    /**
     * 传入重新启动的Activity
     *
     * @param StartActivity
     */
    public void initAPPerror(Class StartActivity) {
        UEHandler ueHandler = new UEHandler(this, StartActivity);
        Thread.setDefaultUncaughtExceptionHandler(ueHandler);
    }

    public class UEHandler implements Thread.UncaughtExceptionHandler {
        BaseApplication app;
        Class mClass;

        public UEHandler(BaseApplication app, Class mClass) {
            this.app = app;
            this.mClass = mClass;
        }

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            Intent intent = new Intent(app, mClass);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                    | Intent.FLAG_ACTIVITY_CLEAR_TASK
                    | Intent.FLAG_ACTIVITY_NEW_TASK);
            app.startActivity(intent);
            android.os.Process.killProcess(android.os.Process.myPid());
        }
    }

    /**
     * Retrofit配置信息
     */
    public Retrofit initRetrofit(String httpUrl) {
        //此为okhttp配置，还有其他配置，retrofit会创建一个默认配置。所以可以可选是否新建一个
        //TigerHttpConfig.connectTimeOut：设置全局请求的连接超时时间，默认为15s
        //TigerHttpConfig.cacheSize：设置全局请求的缓存大小，默认为10M
        //TigerHttpConfig.cacheDirectory：设置全局请求的缓存存储路径，默认为系统给应用分配的缓存路径
        //TigerHttpConfig.isWrapperResult：设置全局请求结果是否对结果进行了封装，默认为true
        //TigerHttpConfig.wrapperJsonResult：设置全局请求结果的结构类型，在isWrapperResult为true时才起作用
        //WrapperJson主要自定义设置全局请求结果的结构类型：

        // 1.WrapperJson.code_name：设置请求成功与否的状态码字段，默认为：flag

        // 2.WrapperJson.result_name：设置请求成功后结果字段，默认为：result

        //  3.WrapperJson.error_name：设置请求失败后的错误信息字段(仅在请求失败时才有值)，默认为：error

        //  4.WrapperJson.code_error_value：设置请求失败的状态码值，当请求状态码与此值相等时代表请求失败
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)//设置全局请求的连接超时时间，默认为15s
                .readTimeout(15, TimeUnit.SECONDS)//设置全局请求的数据读取超时时间，默认为30s
                .build();
        //Retrofit的配置
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(httpUrl)//设置基础域名。网络请求由此拼接
                .addConverterFactory(GsonConverterFactory.create())//设置json返回消息的解析库（这里使用gson）
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//此在与RxJava联用时才使用
                .client(client)//配置okhttp配置。可无（为空时，retrofit会使用默认配置）
                .build();
        //初始化请求地址api
        return retrofit;
    }

    /**
     * 标题栏配置信息
     */
    public void initTitleColor(String color) {
        J.BuilderTitleView().setTitleColor(Color.parseColor(color)).setShow(false, false, false, false).build();
    }

    public void initTitleColor(@ColorInt int color) {
        J.BuilderTitleView().setTitleColor(color).setShow(false, false, false, false).build();
    }

    /**
     * 判断内存卡是否存在,并获得根目录
     */
    public void getTFpath() {
        boolean sdCardExist = Environment.getExternalStorageState()
                .equals(android.os.Environment.MEDIA_MOUNTED);
        if (sdCardExist) {
            TFpath = Environment.getExternalStorageDirectory().getPath();//获取跟目录
        } else {
            TFpath = Environment.getDataDirectory().getPath();//获取data的根目录  由于data的是android 里的一个非常重的目录，所以一般

        }
    }

    /**
     * 查询包名程序是否安装到手机
     */
    public static boolean isMobile_spExist(String pakage) {
        PackageManager manager = APPcontext.getPackageManager();
        List<PackageInfo> pkgList = manager.getInstalledPackages(0);
        for (int i = 0; i < pkgList.size(); i++) {
            PackageInfo pI = pkgList.get(i);
            if (pI.packageName.equalsIgnoreCase(pakage))
                return true;
        }
        return false;
    }

    /**
     * 获取指定包名的版本号与版本说明
     */
    private static void initPakegeInfo(String PACKAGE_NAME) {
        PackageManager packagemanager = APPcontext.getPackageManager();
        try {
            PackageInfo info = packagemanager.getPackageInfo(PACKAGE_NAME, 0);
            versionCode = info.versionCode;
            versionName = info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void getWindowInfo(Activity activity) {
        WindowManager m = activity.getWindowManager();
        Display d = m.getDefaultDisplay();
        windowWidth = d.getWidth();
        windowHeight = d.getHeight();
    }

    /**
     * 判断有无网络
     */
    public static boolean hasNetwork() {
        // 获取网络管理器
        ConnectivityManager connmanager = (ConnectivityManager) APPcontext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        // 获取网络状态
        NetworkInfo info = connmanager.getActiveNetworkInfo();
        // 如果为空。表示没有网络
        if (info == null) {
            return false;
        }
        return true;

    }
}
