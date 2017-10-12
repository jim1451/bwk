package com.shixue.app.ui.bean;

/**
 * 本页：
 * Created by jjs on 2016-12-20.
 * Email:994462623@qq.com
 */

public class WXshapeResult {

    /**
     * softAndroidVersion : 0
     * softIosVersion : 0
     * weixin : dade006
     * weixinAd : 伴我考学历推广期间，加学历老师微信dade006，赠送价值128元的三个月会员，全部学历课程免费学。朋友圈分享伴我考链接，再免费赠送三个月会员
     */

    private int softAndroidVersion;
    private int softIosVersion;
    private String weixin;//微信号
    private String weixinAd;//内容
    private String oneWord;//标题

    public String getOneWord() {
        return oneWord;
    }

    public void setOneWord(String oneWord) {
        this.oneWord = oneWord;
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

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getWeixinAd() {
        return weixinAd;
    }

    public void setWeixinAd(String weixinAd) {
        this.weixinAd = weixinAd;
    }
}
