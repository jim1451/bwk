package com.shixue.app.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.jjs.Jbase.BaseFragment;
import com.shixue.app.APP;
import com.shixue.app.ApiService;
import com.shixue.app.R;
import com.shixue.app.utils.L;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * 本页：
 * Created by jjs on 2016-11-28.
 */

public class HtmlFragment extends BaseFragment {
    @Bind(R.id.web_html)
    WebView mWebHtml;

    @Override
    protected void onCreat() {
        setContentView(R.layout.fragment_html);
    }

    @Override
    protected void init() {
        Bundle bundle = getArguments();
        WebSettings webSettings = mWebHtml.getSettings();

        //  webSettings.setUseWideViewPort(true);
        //  webSettings.setLoadWithOverviewMode(true);
        webSettings.setJavaScriptEnabled(true);
        //  webSettings.setBuiltInZoomControls(true);
        //  webSettings.setSupportZoom(false);
        //  webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        //  webSettings.setLoadWithOverviewMode(true);
        // webSettings.setLoadsImagesAutomatically(true);
        //mWebHtml.requestFocusFromTouch();
//
//        webSettings.setUseWideViewPort(true);
//        webSettings.setLoadWithOverviewMode(true);
//        webSettings.setJavaScriptEnabled(true);
//        webSettings.setBuiltInZoomControls(false);//支持是否缩放
////        webSettings.setSupportZoom(true);
//        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
//        webSettings.setDomStorageEnabled(true);
////        webSettings.setLoadWithOverviewMode(true);
////        webSettings.setLoadsImagesAutomatically(true);
////        webSettings.setDisplayZoomControls(false);
////        mWebHtml.requestFocusFromTouch();
//        mWebHtml.setVerticalScrollBarEnabled(false);
//        mWebHtml.setVerticalScrollbarOverlay(false);
//        mWebHtml.setHorizontalScrollBarEnabled(false);
//        mWebHtml.setHorizontalScrollbarOverlay(false);



        if (bundle.getString("url").contains("http")) {
            mWebHtml.loadUrl(bundle.getString("url"));

         } else {
            mWebHtml.loadUrl(APP.htmlUrl + bundle.getString("url"));
            Log.e("html:", APP.htmlUrl + bundle.getString("url"));

        }
        mWebHtml.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                view.loadUrl(url);
                return true;
            }
        });

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
}
