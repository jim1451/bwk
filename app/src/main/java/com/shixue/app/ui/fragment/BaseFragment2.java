package com.shixue.app.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjs.Jbase.BaseModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MZ安卓 on 2017/11/24.
 */

public abstract class BaseFragment2<M extends BaseModel> extends Fragment {
    private View mView;
    private int layout;
    protected int ResultOK = 999;
    public FragmentManager FramManager;
    public List<Fragment> framList = new ArrayList<>();
    public M mModel;
    protected Activity mActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        onCreat();
        if (mView == null) {
            if (layout != 0) {
                mView = inflater.inflate(layout, container, false);
            } else {
                Log.e("baseFragment", "请在onCreat中使用setContentView方法添加布局文件");
            }
        }
        return mView;

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FramManager = getActivity().getSupportFragmentManager();
        init();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == ResultOK) {
            onResult(requestCode, data);
        }
    }

    protected abstract void onCreat();

    protected abstract void init();

    protected abstract void onResult(int request, Intent data);

    public void setContentView(int layout) {
        this.layout = layout;
    }

    public FragmentTransaction getTransaction() {
        return FramManager.beginTransaction();
    }

    public void addFragment(@IdRes int IdRes, Fragment fragment) {
        getTransaction().add(IdRes, fragment).hide(fragment).commit();
        framList.add(fragment);
    }

    public void setFragment(@IdRes int IdRes, int position, Fragment fragment) {
        getTransaction().add(IdRes, fragment).hide(fragment).commit();
        framList.set(position, fragment);
    }

    public void hideFragment(int position) {
        getTransaction().hide(framList.get(position)).commit();
    }

    private void hideAllFragment() {
        for (int i = 0; i < framList.size(); i++) {
            if (!framList.get(i).isHidden()) {
                getTransaction().hide(framList.get(i)).commit();
            }
        }
    }

    public void showFragment(int position) {
        hideAllFragment();
        getTransaction().show(framList.get(position)).commit();
    }


    public void goActivity(Class mClass) {
        Intent intent = new Intent(getActivity(), mClass);
        startActivity(intent);
    }

    public void goActivity(Class mClass, int request) {
        Intent intent = new Intent(getActivity(), mClass);
        startActivityForResult(intent, request);
    }

    @Override
    public void onAttach(Context context) {//这个方法主要是为了防止在Fragment中 getActivity为空
        super.onAttach(context);
        this.mActivity = (Activity) context;
    }


}
