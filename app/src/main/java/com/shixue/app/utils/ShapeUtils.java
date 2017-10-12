package com.shixue.app.utils;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

/**
 * 本页：
 * Created by jjs on 2016-12-06.
 */

public class ShapeUtils {
    private static AsyncHttpClient client = new AsyncHttpClient();    //实例话对象

    static
    {
        client.setTimeout(10000);   //设置链接超时，如果不设置，默认为10s

    }
    public static void post(Context context, String url, RequestParams params, TextHttpResponseHandler res)   //url里面带参数
    {
        client.post(context, url, params, res);
    }
    public static void post(Context context,String urlString, TextHttpResponseHandler res){
        client.post(urlString, res);
    }
}
