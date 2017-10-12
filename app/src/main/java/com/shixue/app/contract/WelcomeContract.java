package com.shixue.app.contract;

import com.jjs.Jbase.BaseView;
import com.jjs.Jview.JviewPager;

/**
 * 作者：JJS
 * 日期：2016-11-18
 * QQ：994462623
 */

public interface WelcomeContract {
    interface View extends BaseView {

    }

    interface Model {
        void addPagerImages(JviewPager jvp, int[] imgs);

        void getWindowDisplay( );
    }
}
