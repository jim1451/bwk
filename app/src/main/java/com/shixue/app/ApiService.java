package com.shixue.app;

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
import com.shixue.app.ui.bean.SmsBean;
import com.shixue.app.ui.bean.StepResult;
import com.shixue.app.ui.bean.SysTimeResult;
import com.shixue.app.ui.bean.VersionResult;
import com.shixue.app.ui.bean.VipPriceResult;
import com.shixue.app.ui.bean.WXshapeResult;

import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 作者：JJS
 * 日期：2016-11-18
 * QQ：994462623
 */

public interface ApiService {
//    String httpUrl = "http://int.banwokao.com:8080/ipa/";
//    String picUrl = "http://int.banwokao.com:8080/mr/";
//    String htmlUrl = "http://int.banwokao.com:8080/mr/";
//    String NOTIFY_URL = "http://www.banwokao.com/manager/";

    //更改之后的代理商与域名
    String httpUrl = "http://www.ntceonline.com/sxht17/";
    String picUrl = "http://int.banwokao.com:8080/mr/";
    String htmlUrl = "http://int.banwokao.com:8080/mr/";
    String NOTIFY_URL = "http://www.banwokao.com/manager/";


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
    @POST("loginAction!sendSMS.action")
    Observable<RxResult<SmsBean>> getSMS(@Query("mobile") String phone, @Query("randCode") String randCode);

    //获取图形验证码
    @POST("loginAction!randCode.action")
    Observable<RxResult<GetImgCodeResult.BodyBean>> getImgCodeSMS(@Query("mobile") String phone);


    //登陆，需要准备一些参数，用于用户是新用户时，后台直接进行注册
    @POST("loginAction!login.action")
    Observable<RxResult<LoginResult>> login(@Query("mobile") String phone, @Query("cityId") int cityId, @Query("provinceId") int provinceId, @Query("examTypeId") int examTypeId, @Query("examDirection") String examDirection, @Query("projectId") int projectId, @Query("equipmentType") int equipmentType, @Query("password") String password, @Query("systemVersion") String systemVersion, @Query("equipmentModel") String equipmentModel, @Query("softVersion") String softVersion, @Query("webchat") int webchat);

    //获取首页新闻列表
    @POST("loginAction!projNews.action")
    Observable<RxResult<NewsResult>> getNews(@Query("pageNo") int pageNo, @Query("pageSize") int pageSize, @Query("projectId") int projectId, /*@Query("provinceId") int provinceId*/ @Query("mobile") String mobile);

    //修改用户的一些信息
    @POST("loginAction!modifyUser.action")
    Observable<RxResult<LoginResult>> updateUser(@Query("userName") String userName, @Query("sex") int sex, @Query("email") String email, @Query("homeAddress") String homeAddress, @Query("mobile") String mobile);

    //获取城市信息
    @POST("loginAction!province.action")
    Observable<RxResult<CityResult>> getCityList();

    //获取项目分类
    @POST("projectAction!allProject.action")
    Observable<RxResult<ExamTypeResult>> getExamTypeList();

    //获取项目二级菜单
    @POST("projectAction!oneProject.action")
    Observable<RxResult<ExamInfoResult>> getExamTypeInfo(@Query("projectId") int projectId);

    //直播列表
    @POST("liveCourseAction!course.action")
    Observable<RxResult<LiveDirectResult>> getLiveDirectList(@Query("projectId") int projectId, @Query("examTypeId") int examTypeId);

    //获取直播课程节列表
    @POST("liveCourseAction!section.action")
    Observable<RxResult<DirectDetailsResult>> getDirectDetails(@Query("liveCourseId") int liveCourseId);

    //在线课程列表
    @POST("courseAction!course.action")
    Observable<RxResult<LiveOnlineResult>> getLiveOnlineList(@Query("projectId") int projectId, @Query("examTypeId") int examTypeId);

    //获取课程详情
    @POST("courseAction!courseDetail.action")
    Observable<RxResult<OnlineDetailsResult>> getOnlineDetails(@Query("courseId") int courseId);

    //获取试卷题库
    @POST("courseAction!library.action")
    Observable<RxResult<PractiseTitleListResult>> getPractiseTitleList(@Query("projectId") int projectId, @Query("examTypeId") int examTypeId);

    //获取试卷节
    @POST("courseAction!libraryTest.action")
    Observable<RxResult<PractiseTestListResult>> getPractiseTestList(@Query("testLibraryId") int testLibraryId);

    //获取试卷详情
    @POST("courseAction!procudeTest.action")
    Observable<RxResult<PractiseDetailsResult>> getPractiseDetails(@Query("testId") int testId);

    //项目步骤
    @POST("projectAction!projectStep.action")
    Observable<RxResult<StepResult>> getStepList(@Query("mobile") String mobile, @Query("projectId") int projectId, @Query("provinceId") int provinceId);

    //获取加微信广告
    @POST("loginAction!getLastestNews.action")
    Observable<RxResult<WXshapeResult>> getWXshape(@Query("projectId") int projectId, @Query("provinceId") int provinceId);

    //获取更新信息
    @POST("loginAction!getLastestVersion.action")
    Observable<RxResult<VersionResult>> getVersion(@Query("projectId") int projectId);

    //获取支付价格列表
    @POST("payAction!projPrice.action")
    Observable<RxResult<VipPriceResult>> getVipPrice(@Query("projectId") int projectId);

    //预交费订单
    @POST("payAction!payBefore.action")
    Observable<RxResult<PayDealResult>> getStartDeal(@Query("projectId") int projectId, @Query("userid") int userid, @Query("cargoName") String cargoName, @Query("payMoney") double payMoney, @Query("payType") int payType, @Query("bank") String bank, @Query("cardNum") String cardNum, @Query("payer") String payer);

    //缴费成功订单
    @POST("payAction!paySuccess.action")
    Observable<RxResult<PayDealResult>> setSuccessDeal(@Query("orderNumber") String orderNumber, @Query("userid") int userid, @Query("payMoney") double payMoney, @Query("payType") int payType, @Query("payDate") String payDate);

    //获取服务器时间
    @POST("payAction!currDate.action")
    Observable<RxResult<SysTimeResult>> getSysTime();

}
