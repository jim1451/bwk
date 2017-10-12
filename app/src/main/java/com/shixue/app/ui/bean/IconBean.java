package com.shixue.app.ui.bean;

import android.graphics.drawable.Drawable;

/**
 * 本页：直播图标
 * Created by jjs on 2017-01-03.
 * Email:994462623@qq.com
 */

public class IconBean {
    String key;
    Drawable icon;

    public IconBean(String mKey, Drawable mDra) {
        this.key = mKey;
        this.icon = mDra;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }
}
