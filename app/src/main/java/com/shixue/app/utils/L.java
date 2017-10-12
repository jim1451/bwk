package com.shixue.app.utils;


import com.orhanobut.logger.Logger;

import com.shixue.app.APP;

/**
 * 作者：JJS
 * 日期：2016-11-18
 * QQ：994462623
 */

public class L {


    public static void e(String msg) {
        if (APP.isDebug) {
            Logger.e(msg);
        }
    }

    public static void w(String msg) {
        if (APP.isDebug) Logger.w(msg);
    }

    public static void i(String msg) {
        if (APP.isDebug) Logger.i(msg);
    }

    public static void d(String msg) {
        if (APP.isDebug) Logger.d(msg);
    }

    public static void Json(String jsonStr) {
        if (APP.isDebug) Logger.json(jsonStr);
    }

}
