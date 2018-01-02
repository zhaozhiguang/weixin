package com.zhaozhiguang.component.weixin.pojo.res;

/**
 * 微信端js接口验证返回
 */
public class JsSignResult {

    private String url;

    private String jsapi_ticket;

    private String nonceStr;

    private String timestamp;

    private String signature;

    public JsSignResult() {

    }

    public JsSignResult(String url, String jsapi_ticket, String nonceStr, String timestamp, String signature) {
        this.url = url;
        this.jsapi_ticket = jsapi_ticket;
        this.nonceStr = nonceStr;
        this.timestamp = timestamp;
        this.signature = signature;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getJsapi_ticket() {
        return jsapi_ticket;
    }

    public void setJsapi_ticket(String jsapi_ticket) {
        this.jsapi_ticket = jsapi_ticket;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
