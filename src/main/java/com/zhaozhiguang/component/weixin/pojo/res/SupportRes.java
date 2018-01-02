package com.zhaozhiguang.component.weixin.pojo.res;

/**
 * 微信返回基础
 * @author zhiguang
 */
public class SupportRes {

    protected Integer errcode;

    protected String errmsg;

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
