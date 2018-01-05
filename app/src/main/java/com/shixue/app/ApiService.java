package com.shixue.app;

import com.shixue.app.ui.bean.AboutUsResult2;
import com.shixue.app.ui.bean.CityResult;
import com.shixue.app.ui.bean.DirectDetailsResult;
import com.shixue.app.ui.bean.ExamInfoResult;
import com.shixue.app.ui.bean.ExamTypeResult;
import com.shixue.app.ui.bean.GetImgCodeResult;
import com.shixue.app.ui.bean.LiveDirectResult;
import com.shixue.app.ui.bean.LiveOnlineResult;
import com.shixue.app.ui.bean.LoginResult;
import com.shixue.app.ui.bean.NewsResult;
import com.shixue.app.ui.bean.OnlineDetailsResult;
import com.shixue.app.ui.bean.PayDealResult;
import com.shixue.app.ui.bean.PractiseDetailsResult;
import com.shixue.app.ui.bean.PractiseTestListResult;
import com.shixue.app.ui.bean.PractiseTitleListResult;
import com.shixue.app.ui.bean.RxResult;
import com.shixue.app.ui.bean.SingleVipResult;
import com.shixue.app.ui.bean.SmsBean;
import com.shixue.app.ui.bean.StepResult;
import com.shixue.app.ui.bean.SysTimeResult;
import com.shixue.app.ui.bean.VersionBean;
import com.shixue.app.ui.bean.VersionResult;
import com.shixue.app.ui.bean.VipDetailsRresult;
import com.shixue.app.ui.bean.VipPriceResult;
import com.shixue.app.ui.bean.WXshapeResult;
import com.shixue.app.ui.bean.httpBean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * 作者：JJS
 * 日期：2016-11-18
 * QQ：994462623
 */

public interface ApiService {
//    String httpUrl = "http://int.banwokao.com:8080/ipa/";
//    String picUrl = "http://int.banwokao.com:8080/sxAgent/";
//    String htmlUrl = "http://int.banwokao.com:8080/mr/";
//    String NOTIFY_URL = "http://www.banwokao.com/manager/";

    //更改之后的代理商与域名
//    String httpUrl = "http://119.29.194.199/sxht17/";
  //  String httpUrl = "http://www.ntceonline.com/sxht17/";
    String httpUrl   = "http://119.29.194.199/sxkjjk/";
//    String picUrl = "http://119.29.194.199/sxAgent/";
//    String htmlUrl = "http://119.29.194.199/sxAgent/";
//    String NOTIFY_URL = "http://www.banwokao.com/manager/";


    String ali_APPID = "2088021378654330";
    String ali_APPACCOUNT = "139008791@qq.com";
    String ali_APPKEY = "MIICeQIBADANBgkqhkiG9w0BAQEFAASCAmMwggJfAgEAAoGBAL9lr7vJ2C/RHxiVUSsc5cTBW427B/9JNoSXiDo2RGFBfEKfxVm8jsHPAySvDCPKRXFZaB+ZdiVGQFNr0FYHgc0ZB8gzGgPZIdwWifI2hWQWdAFAzFa4moyHOFOOYaJNrS+P7z/HNTZkiL4Dee052OMLZSnyy+/AcxgB4kI3DvizAgMBAAECgYEAngT6XfR7xJ7HKai95vZozVVGnXF5XM+5byccldMQCavjR65ZZYlD48diNPtA7pulUbwbN1ugK44gtb8htqVkB9wc/BQzara1kS4FzMVLSDf/K6OvGAmD3Evy4wTM3SCPbKkOCRZYfu8XHTbU3sKkQcYuCjgUW4j/ZyxNiSLqpkECQQD/FwJxeUQGgohw63+abAt67Kc1oI2Q80A2Z+cXSjGWtZrEwKhv/Ki+qXPFQKykVTFTWK/glbPHwG99ETm7c+crAkEAwBSAj39ojIqV2VPBiCH83Kv+ErC3khHlCtBkBq1MlHbKQT42kyY1dXiU/PDpuFdeoExxHApsqM0TsXBH+XVwmQJBAJJNzCTw/EcPjtnU9/bFiUATg0OKticwnN+XcD83WoGp3v6B0RmJu+6+mZvEoEAQbJ30+8q/kcE7abY9rvMIYskCQQCsrYHJ/2tY9Xmzb/WLUarGI6T83nuZSJcVOrTBv+gZjBVVw/1CGlZy7d1a66XhwEHkb/Q7li+LLRooKV27KNX5AkEAh3uPYto9fdrVDvi8x++ZZMfD4bhHZ5PxukNRI2sjuZGremtR7hggfJMRBODqDqu7GfUl37s3HWOrX8+S3LQ16w==";

    String QCLOUD_APPID = "10008076";
    String QCLOUD_SecretID = "AKIDFOLsgugLe30tIpffevSz8xLr0eRiBUI1";
    String QCLOUD_SecretKey = "SnUNfpNjKGrGruUaWIbDYtafKESUjcJZ";

    String WC_APP_ID = "wxe91ff5793d109fd0";
    String WC_MCH_ID = "1273963401";
    String WC_APP_KEY = "yuxuewenyuxuewenyuxuewenyuxuewen";
    String UNIFIED_ORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    String tencentAppId = "1104932934";


    //获取验证码
//    @POST("loginAction!yzm.action")
    @FormUrlEncoded
    @POST("loginAction!sendSMS.action")
    Observable<RxResult<SmsBean>> getSMS(@Field("mobile") String phone, @Field("randCode") String randCode);

    //获取图形验证码
    @FormUrlEncoded
    @POST("loginAction!randCode.action")
    Observable<RxResult<GetImgCodeResult.BodyBean>> getImgCodeSMS(@Field("mobile") String phone);


    //登陆，需要准备一些参数，用于用户是新用户时，后台直接进行注册
    @FormUrlEncoded
    @POST("loginAction!login.action")
    Observable<RxResult<LoginResult>> login(@Field("mobile") String phone, @Field("cityId") int cityId, @Field("provinceId") int provinceId, @Field("examTypeId") int examTypeId, @Field("examDirection") String examDirection, @Field("projectId") int projectId, @Field("equipmentType") int equipmentType, @Field("password") String password, @Field("systemVersion") String systemVersion, @Field("equipmentModel") String equipmentModel, @Field("softVersion") String softVersion, @Field("webchat") int webchat);

    //获取首页新闻列表
    @FormUrlEncoded
    @POST("loginAction!projNews.action")
    Observable<RxResult<NewsResult>> getNews(@Field("pageNo") int pageNo, @Field("pageSize") int pageSize, @Field("projectId") int projectId, /*@Field("provinceId") int provinceId*/ @Field("mobile") String mobile);

    //修改用户的一些信息
    @FormUrlEncoded
    @POST("loginAction!modifyUser.action")
    Observable<RxResult<LoginResult>> updateUser(@Field("userName") String userName, @Field("sex") int sex, @Field("email") String email, @Field("homeAddress") String homeAddress, @Field("mobile") String mobile);

    //获取城市信息
    @FormUrlEncoded
    @POST("loginAction!province.action")
    Observable<RxResult<CityResult>> getCityList(@Field("") String x);

    //获取项目分类
    @FormUrlEncoded
    @POST("projectAction!allProject.action")
    Observable<RxResult<ExamTypeResult>> getExamTypeList(@Field("") String x);

    //获取项目二级菜单
    @FormUrlEncoded
    @POST("projectAction!oneProject.action")
    Observable<RxResult<ExamInfoResult>> getExamTypeInfo(@Field("projectId") int projectId);

    //直播列表
    @FormUrlEncoded
    @POST("liveCourseAction!course.action")
    Observable<RxResult<LiveDirectResult>> getLiveDirectList(@Field("projectId") int projectId, @Field("examTypeId") int examTypeId);

    //获取直播课程节列表
    @FormUrlEncoded
    @POST("liveCourseAction!section.action")
    Observable<RxResult<DirectDetailsResult>> getDirectDetails(@Field("liveCourseId") int liveCourseId, @Field("mobile") String mobile);

    //在线课程列表
    @FormUrlEncoded
    @POST("courseAction!course.action")
    Observable<RxResult<LiveOnlineResult>> getLiveOnlineList(@Field("projectId") int projectId, @Field("examTypeId") int examTypeId);

    //获取课程详情 代理商要多传一个用户手机号
    @FormUrlEncoded
    @POST("courseAction!courseDetail.action")
    Observable<RxResult<OnlineDetailsResult>> getOnlineDetails(@Field("courseId") int courseId, @Field("mobile") String mobile);

    //获取试卷题库
    @FormUrlEncoded
    @POST("courseAction!library.action")
    Observable<RxResult<PractiseTitleListResult>> getPractiseTitleList(@Field("projectId") int projectId, @Field("examTypeId") int examTypeId);

    //获取试卷节(获取题库试卷---代理商要多传手机号)
    @FormUrlEncoded
    @POST("courseAction!libraryTest.action")
    Observable<RxResult<PractiseTestListResult>> getPractiseTestList(@Field("testLibraryId") int testLibraryId, @Field("mobile") String mobile);

    //获取试卷详情
    @FormUrlEncoded
    @POST("courseAction!procudeTest.action")
    Observable<RxResult<PractiseDetailsResult>> getPractiseDetails(@Field("testId") int testId);

    //项目步骤
    @FormUrlEncoded
    @POST("projectAction!projectStep.action")
    Observable<RxResult<StepResult>> getStepList(@Field("mobile") String mobile, @Field("projectId") int projectId, @Field("provinceId") int provinceId);

    //获取加微信广告
    @FormUrlEncoded
    @POST("loginAction!getLastestNews.action")
    Observable<RxResult<WXshapeResult>> getWXshape(@Field("projectId") int projectId, @Field("provinceId") int provinceId);

    //获取更新信息
    @FormUrlEncoded
    @POST("loginAction!getLastestVersion.action")
    Observable<RxResult<VersionResult>> getVersion(@Field("projectId") int projectId);

    //获取支付价格列表
    @FormUrlEncoded
    @POST("payAction!projPrice.action")
    Observable<RxResult<VipPriceResult>> getVipPrice(@Field("projectId") int projectId);

    //预交费订单
    @FormUrlEncoded
    @POST("payAction!payBefore.action")
    Observable<RxResult<PayDealResult>> getStartDeal(@Field("projectId") int projectId, @Field("userid") int userid, @Field("cargoName") String cargoName, @Field("payMoney") double payMoney, @Field("payType") int payType, @Field("bank") String bank, @Field("cardNum") String cardNum, @Field("payer") String payer);

    //缴费成功订单
    @FormUrlEncoded
    @POST("payAction!paySuccess.action")
    Observable<RxResult<PayDealResult>> setSuccessDeal(@Field("orderNumber") String orderNumber, @Field("userid") int userid, @Field("payMoney") double payMoney, @Field("payType") int payType, @Field("payDate") String payDate);

    //获取服务器时间
    @FormUrlEncoded
    @POST("payAction!currDate.action")
    Observable<RxResult<SysTimeResult>> getSysTime(@Field("") String x);

    //获取会员详情
    @FormUrlEncoded
    @POST("loginAction!singlevipInfo.action")
    Observable<RxResult<SingleVipResult>> getSingleVipResult(@Field("projectId") String projectId, @Field("mobile") String mobile, @Field("examTypeId") String examTypeId);

    //获取关于我的数据 在这里主要是用于获取首页图片
    @FormUrlEncoded
    @POST("projectAction!aboutUs.action")
    Observable<RxResult<AboutUsResult2>> getAboutUsResult(@Field("mobile") String mobile);

    //获取所有HTML文件图标和图片的接口域名
    @FormUrlEncoded
    @POST("liveCourseAction!attachPrefixUrl.action")
    Observable<RxResult<httpBean>> getHttpServer(@Field("") String xx);
    //修改用户版本信息

    @FormUrlEncoded
    @POST("loginAction!modifyUserVersion.action")
    Observable<RxResult<VersionBean>> getUpdataVersionbean(@Field("mobile") String mobile,
                                                           @Field("equipmentType") int equipmentType,
                                                           @Field("equipmentModel") String equipmentModel,
                                                           @Field("systemVersion") String systemVersion,
                                                           @Field("softVersion") String softVersion);

}
