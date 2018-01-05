package com.shixue.app.ui.bean;

/**
 * 本页：
 * Created by jjs on 2016-12-20.
 * Email:994462623@qq.com
 */

public class VersionResult {


    /**
     * examTypeId : 0
     * softAndroidVersion : 4.1.3
     * softIosVersion : 4
     */

    private int examTypeId;
    private String softAndroidVersion;
    private String softIosVersion;

    public int getExamTypeId() {
        return examTypeId;
    }

    public void setExamTypeId(int examTypeId) {
        this.examTypeId = examTypeId;
    }

    public String getSoftAndroidVersion() {
        return softAndroidVersion;
    }

    public void setSoftAndroidVersion(String softAndroidVersion) {
        this.softAndroidVersion = softAndroidVersion;
    }

    public String getSoftIosVersion() {
        return softIosVersion;
    }

    public void setSoftIosVersion(String softIosVersion) {
        this.softIosVersion = softIosVersion;
    }
}
