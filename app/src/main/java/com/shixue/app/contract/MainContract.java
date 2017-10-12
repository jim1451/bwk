package com.shixue.app.contract;

import com.jjs.Jbase.BaseView;

/**
 * 本页：
 * Created by jjs on 2016-11-26.
 */

public interface MainContract {
    interface View extends BaseView{
        void getCityOK(String str);
        void getAddressOK(String str);
    }
    interface Model{
        void getCity();
        void getAddress();
    }

}
