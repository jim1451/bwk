package com.shixue.app.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.widget.Toast;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2015/5/15.
 */
public class AppUtils {


    public static Activity context;
    static AppUtils appUtils;

    public static AppUtils getInstance(Activity activity){
        if(null == appUtils){
            appUtils = new AppUtils(activity);
        }

        return  appUtils;
    }
    public AppUtils(Activity activity){
        this.context = activity;
    }
    //检查版本
    public static boolean oldVersion(){
       if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN )
       {
           return true;
       }
       else
       {
           return false;
       }
    }

    /**
     * 获取屏幕宽度
     */
    public static int getScreenWidth() {
        DisplayMetrics dm = new DisplayMetrics();
        dm = context.getResources().getDisplayMetrics();
        int width = dm.widthPixels;
        return width;
    }

    /**
     * 获取屏幕高度
     */
    public static int getScreenHeight() {
        DisplayMetrics dm = new DisplayMetrics();
        dm = context.getResources().getDisplayMetrics();
        int height = dm.heightPixels;
        return height;
    }


    /**
     *获取系统版本
     *
     * @return
     */
    public static String getSystemVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    public static String getMobileMode(){
        return Build.MODEL;
    }

    /**
     * px转换成dip工具
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(pxValue / scale + 0.5f);
    }

    /**
     * dip转px工具
     *
     * @param context  上下文
     * @param dipValue DIP大小
     * @return px值
     */
    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int)(dipValue * scale + 0.5f);
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }


    public static void LanuchActivity(Context context, Class<?> classes){
        Intent intent = new Intent();
        intent.setClass(context,classes);
        context.startActivity(intent);

    }

    /**
     * 验证手机号码
     * @param num
     * @return
     */
    public  static boolean isPhoneCorrect(String num){
        Pattern p = Pattern
                .compile("^((13[0-9])|(15[^4,\\D])|(18[0,1,2,3,4,5-9])|17[0-9])\\d{8}$");
        Matcher m = p.matcher(num);
        return m.matches();
    }

    public static String randomCode() {
        Set<Integer> set = new HashSet<Integer>();
        while (set.size()<6){

            set.add(new Random().nextInt(10));
        }

        // 使用迭代器
        Iterator<Integer> iterator = set.iterator();
        // 临时记录数据
        String result = "";
        while (iterator.hasNext()) {
            result += iterator.next();
            // System.out.print(iterator.next());
        }
        return result;

//        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//        Random rand = new Random();
//        for (int i = 10; i > 1; i--) {
//            int index = rand.nextInt(i);
//            int tmp = array[index];
//            array[index] = array[i - 1];
//            array[i - 1] = tmp;
//        }
//        int result = 0;
//        for(int i = 0; i < 6; i++)
//            result = result * 10 + array[i];
//
//        return String.valueOf(result);
    }

    public static String randomPwd(String mobile){

        String[] array = {"a","g","H","5","i","J","k","m","l","o"};
        String[] arr =  {"e","1","y","L","D","f","8","s","y","b"};

        String pwd = "";
        for (int i = 0 ;i <mobile.length();i++){
            int index = Integer.valueOf(mobile.substring(i, i + 1));
            if(i % 2 ==0){
                pwd += array[index];
            }else{
                pwd += arr[index];
            }
        }

        return pwd;
    }

    public static int getColor(int resId){
        return context.getResources().getColor(resId);
    }

    public static String getString(int resId){
        return context.getResources().getString(resId);
    }

    public static String[] getStringArray(int resId){
        return context.getResources().getStringArray(resId);
    }

    public static Drawable getDrawable(int resId){
        return context.getResources().getDrawable(resId);
    }

    public static void errorToast(int resId){
        Toast.makeText(context, context.getResources().getString(resId), Toast.LENGTH_SHORT).show();

    }

    public static void showToast(String str){
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show();

    }

    /**
     * 创建快捷方式
     *
     * @param icon ͼƬid
     * @param title
     * @param cls class
     */
    public static void createDeskShortCut(int icon,
                                          String title, Class<?> cls) {
        Intent shortcutIntent = new Intent(
                "com.android.launcher.action.INSTALL_SHORTCUT");
        shortcutIntent.putExtra("duplicate", false);
        shortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, title);
        Parcelable ico = Intent.ShortcutIconResource.fromContext(
                context, icon);
        shortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE,
                ico);
        Intent intent = new Intent(context, cls);
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        shortcutIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, intent);
        context.sendBroadcast(shortcutIntent);
    }


    /**
    *描述：计算两个日期天数差
    *作者：Jacky
    *日期：2015/12/5
    */
    public static int getIntervalDays(Date fDate, Date oDate) {

        if (null == fDate || null == oDate) {

            return -1;

        }

        long intervalMilli = fDate.getTime() - oDate.getTime();

        return (int) (intervalMilli / (24 * 60 * 60 * 1000));

    }

}
