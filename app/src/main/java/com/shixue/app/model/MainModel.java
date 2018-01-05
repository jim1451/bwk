package com.shixue.app.model;


import android.content.Context;

import com.baidu.location.BDLocationListener;
import com.jjs.Jbase.BaseModel;
import com.shixue.app.APP;
import com.shixue.app.RxSubscribe;
import com.shixue.app.contract.MainContract;
import com.shixue.app.ui.bean.CityResult;
import com.shixue.app.utils.HTTPutils;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 本页：
 * Created by jjs on 2016-11-26.
 */

public class MainModel extends BaseModel<MainContract.View> implements MainContract.Model {

    public MainModel(Context context, MainContract.View view) {
        super(context, view);
    }

    int error = 0;

    @Override
    public void getCity() {
        APP.apiService.getCityList("")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxSubscribe<CityResult>() {
                    @Override
                    protected void _onNext(CityResult cityResult) {
                        APP.provinceBeanList = cityResult.getProvList();
                        mView.getCityOK("");
                    }

                    @Override
                    protected void _onError(String msg) {
                        error++;
                        if (error < 4) {
                            getCity();
                        }
                    }
                });
    }

    @Override
    public void getAddress() {
        if (!APP.shared.getBoolean("isLogin", false) && APP.shared.getInt("ProvinceID", 2) != 2 && APP.shared.getInt("CityID", 128) != 128) {
            APP.ProvinceID = APP.shared.getInt("ProvinceID", 2);
            APP.CityID = APP.shared.getInt("CityID", 128);
            mView.getAddressOK(HTTPutils.getAddressName());
        } else if (APP.userInfo == null || APP.userInfo != null && APP.userInfo.getBody().getUser().getProvinceId() == 0 || APP.userInfo != null && APP.userInfo.getBody().getUser().getCityId() == 0) {
            //数据为空，联网请求数据
            BDLocationListener listener = location -> {
                if (location.getCity() != null) {
                    /**
                     * 对定位获取到的信息进行判断
                     */
                    if (APP.provinceBeanList != null) {
                        String cityName = "";
                        for (int i = 0; i < APP.provinceBeanList.size(); i++) {
                            if (location.getProvince().contains(APP.provinceBeanList.get(i).getProvinceName())) {
                                //包含
                                APP.ProvinceID = APP.provinceBeanList.get(i).getProvinceId();
                                APP.shared.edit().putInt("ProvinceID", APP.provinceBeanList.get(i).getProvinceId()).commit();
                                cityName = APP.provinceBeanList.get(i).getProvinceName();
                                for (int j = 0; j < APP.provinceBeanList.get(i).getCityList().size(); j++) {
                                    if (location.getCity().contains(APP.provinceBeanList.get(i).getCityList().get(j).getCityName())) {
                                        APP.CityID = APP.provinceBeanList.get(i).getCityList().get(j).getProvinceId();
                                        APP.shared.edit().putInt("CityID", APP.provinceBeanList.get(i).getCityList().get(j).getCityId()).commit();
                                        cityName += " - " + APP.provinceBeanList.get(i).getCityList().get(j).getCityName();
                                    }
                                }
                            }
                        }
                        mView.getAddressOK(cityName);
                    }
                    APP.baiduClient.stop();
                }
            };
            APP.baiduClient.registerLocationListener(listener);
            APP.baiduClient.start();
        } else {
            //读取用户信息进行显示
//            APP.ProvinceID = APP.userInfo.getProvinceId();
//            APP.CityID = APP.userInfo.getCityId();
            mView.getAddressOK(HTTPutils.getAddressName());
        }
    }
}
