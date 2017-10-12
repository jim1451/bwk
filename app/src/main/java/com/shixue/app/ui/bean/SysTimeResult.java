package com.shixue.app.ui.bean;

/**
 * 本页：
 * Created by jjs on 2016-12-29.
 * Email:994462623@qq.com
 */

public class SysTimeResult {

    /**
     * currDate : 2016-12-29 09:09:01
     * softAndroidVersion : 0
     * softIosVersion : 0
     */

    private String currDate;
    private int softAndroidVersion;
    private int softIosVersion;

    @Override
    public String toString() {
        return "SysTimeResult{" +
                "currDate='" + currDate + '\'' +
                ", softAndroidVersion=" + softAndroidVersion +
                ", softIosVersion=" + softIosVersion +
                '}';
    }

    public String getCurrDate() {
        return currDate;
    }

    public void setCurrDate(String currDate) {
        this.currDate = currDate;
    }

    public int getSoftAndroidVersion() {
        return softAndroidVersion;
    }

    public void setSoftAndroidVersion(int softAndroidVersion) {
        this.softAndroidVersion = softAndroidVersion;
    }

    public int getSoftIosVersion() {
        return softIosVersion;
    }

    public void setSoftIosVersion(int softIosVersion) {
        this.softIosVersion = softIosVersion;
    }
}
