package com.shixue.app.ui.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016-11-22.
 */

public class RxResult<T> implements Serializable {


    /**
     * body : {"mobile":"18607917251","password":"170500"}
     * errorCode : -1
     * msg : 获取验证码成功！
     * success : true
     */
    private T body;
    private String errorCode;
    private String msg;
    private boolean success;

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "RxResult{" +
                "body=" + body +
                ", errorCode='" + errorCode + '\'' +
                ", msg='" + msg + '\'' +
                ", success=" + success +
                '}';
    }
}
