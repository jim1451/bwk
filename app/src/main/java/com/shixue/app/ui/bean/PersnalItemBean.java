package com.shixue.app.ui.bean;

/**
 * 本页：
 * Created by jjs on 2016-11-25.
 */

public class PersnalItemBean {
    int img;
    String strLeft;
    String strRight;

    public PersnalItemBean(int img, String strLeft, String strRight) {
        this.img = img;
        this.strLeft = strLeft;
        this.strRight = strRight;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getStrLeft() {
        return strLeft;
    }

    public void setStrLeft(String strLeft) {
        this.strLeft = strLeft;
    }

    public String getStrRight() {
        return strRight;
    }

    public void setStrRight(String strRight) {
        this.strRight = strRight;
    }
}
