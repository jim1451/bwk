package com.shixue.app.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jjs.Jbase.BaseActivity;
import com.jjs.Jutils.RecyclerView.BaseReHolder;
import com.jjs.Jutils.RecyclerView.ReItemDivider;
import com.jjs.Jutils.RecyclerView.SingleReAdpt;
import com.shixue.app.APP;
import com.shixue.app.R;
import com.shixue.app.RxSubscribe;
import com.shixue.app.ui.bean.CityResult;
import com.shixue.app.utils.HTTPutils;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by MZ安卓 on 2016/11/26.
 */

public class CityAty extends BaseActivity {

    @Bind(R.id.rv_city)
    RecyclerView recyclerCity;
    private int type = 0;//判断是省还是地区
    private int provinceType = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        ButterKnife.bind(this);
        if (APP.provinceBeanList == null || APP.provinceBeanList.size() == 0) {
            APP.apiService.getCityList()
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new RxSubscribe<CityResult>() {
                        @Override
                        protected void _onNext(CityResult cityResult) {
                            APP.provinceBeanList = cityResult.getProvList();
                            init();
                        }

                        @Override
                        protected void _onError(String msg) {
                            APP.mToast(msg);
                        }
                    });
            return;
        } else {
            init();
        }

    }

    @Override
    protected void init() {
        setTitle("请选择省份和城市");

        setOnBackListener(new OnBackListener() {
            @Override
            public void onBackLister() {
                if (type == 0) {
                    finish();
                } else {
                    getpro();
                }

            }
        });
        recyclerCity.setLayoutManager(new LinearLayoutManager(CityAty.this));
        getpro();//获得省份
    }

    @Override
    protected void onResult(int request, Intent data) {

    }

    private void getpro() {
        type = 0;
        SingleReAdpt singleReAdpt = new SingleReAdpt<CityResult.ProvListBean>(CityAty.this, R.layout.recycler_city_item, APP.provinceBeanList) {
            @Override
            protected void BindData(BaseReHolder holder, int position, CityResult.ProvListBean data) {
                holder.getTV(R.id.item_city).setText(data.getProvinceName());
            }
        };
        recyclerCity.setAdapter(singleReAdpt);
        recyclerCity.addItemDecoration(new ReItemDivider(CityAty.this, getResources().getColor(R.color.colorLine), ReItemDivider.Orientation.VERTICAL));
        singleReAdpt.setOnItemClickListener(new SingleReAdpt.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                provinceType = position;
                getcity(position);

            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });

    }

    private void getcity(int position) {
        type = 1;
        SingleReAdpt singleReAdpt1 = new SingleReAdpt<CityResult.ProvListBean.CityListBean>(CityAty.this, R.layout.recycler_city_item, APP.provinceBeanList.get(position).getCityList()) {
            @Override
            protected void BindData(BaseReHolder holder, int position, CityResult.ProvListBean.CityListBean data) {
                holder.getTV(R.id.item_city).setText(data.getCityName());
            }
        };
        recyclerCity.setAdapter(singleReAdpt1);
        singleReAdpt1.setOnItemClickListener(new SingleReAdpt.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                APP.ProvinceID = APP.provinceBeanList.get(provinceType).getProvinceId();
                APP.CityID = APP.provinceBeanList.get(provinceType).getCityList().get(position).getCityId();
                APP.shared.edit().putInt("ProvinceID", APP.provinceBeanList.get(provinceType).getProvinceId()).commit();
                APP.shared.edit().putInt("CityID", APP.provinceBeanList.get(provinceType).getCityList().get(position).getCityId()).commit();
                /**
                 * 保存城市
                 */
                if (APP.userInfo != null) {
                    HTTPutils.updateCity(APP.userInfo.getBody().getUser().getMobile(), APP.ProvinceID, APP.CityID, new HTTPutils.OnTaskClick() {
                        @Override
                        public void onSuccess(Object o) {
                            setResult(ResultOK);
                            finish();
                        }

                        @Override
                        public void onError(String ex) {
                            APP.mToast(ex);
                        }
                    });
                } else {
                    setResult(ResultOK);
                    finish();
                }

            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });

    }
}
