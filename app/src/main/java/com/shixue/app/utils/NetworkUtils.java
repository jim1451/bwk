package com.shixue.app.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;

/**
 * Created by Jacky Xu on 2015/9/23.
 * 网络检查工具类
 */
public class NetworkUtils {

    Context context;
    static ConnectivityManager connManager;
    static NetworkUtils networkUtils;

    public static NetworkUtils getInstance(Context ctx){
        if(null == networkUtils){
            networkUtils = new NetworkUtils(ctx);
        }
        return  networkUtils;
    }
    public NetworkUtils(Context context) {
        this.context = context;
        this.connManager = ((ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE));
    }

    /**
     * 检测网络是否可用
     */
    public  static boolean isConnected() {
        NetworkInfo info = connManager.getActiveNetworkInfo();
        return (info != null && info.isAvailable());
    }

    //打开wif
    public boolean toggleWiFi(boolean paramBoolean) {
        return ((WifiManager) this.context.getSystemService(Context.WIFI_SERVICE))
                .setWifiEnabled(paramBoolean);
    }

    public String getNetworkType() {
        String networkType = "";
        NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                networkType = "WIFI";
            } else if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                String subtypeName = networkInfo.getSubtypeName();
                int subType = networkInfo.getSubtype();

                switch (subType) {
                    case TelephonyManager.NETWORK_TYPE_GPRS:
                    case TelephonyManager.NETWORK_TYPE_EDGE:
                    case TelephonyManager.NETWORK_TYPE_CDMA:
                    case TelephonyManager.NETWORK_TYPE_1xRTT:
                    case TelephonyManager.NETWORK_TYPE_IDEN: //api<8 : replace by 11
                        networkType = "2G";
                        break;
                    case TelephonyManager.NETWORK_TYPE_UMTS:
                    case TelephonyManager.NETWORK_TYPE_EVDO_0:
                    case TelephonyManager.NETWORK_TYPE_EVDO_A:
                    case TelephonyManager.NETWORK_TYPE_HSDPA:
                    case TelephonyManager.NETWORK_TYPE_HSUPA:
                    case TelephonyManager.NETWORK_TYPE_HSPA:
                    case TelephonyManager.NETWORK_TYPE_EVDO_B: //api<9 : replace by 14
                    case TelephonyManager.NETWORK_TYPE_EHRPD:  //api<11 : replace by 12
                    case TelephonyManager.NETWORK_TYPE_HSPAP:  //api<13 : replace by 15
                        networkType = "3G";
                        break;
                    case TelephonyManager.NETWORK_TYPE_LTE:    //api<11 : replace by 13
                        networkType = "4G";
                        break;
                    default:
                        // http://baike.baidu.com/item/TD-SCDMA 中国移动 联通 电信 三种3G制式
                        if (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) {
                            networkType = "3G";
                        } else {
                            networkType = subtypeName;
                        }

                        break;
                }
            }
        }
        return networkType;
    }
}
