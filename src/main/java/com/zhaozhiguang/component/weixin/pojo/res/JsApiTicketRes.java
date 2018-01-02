package com.zhaozhiguang.component.weixin.pojo.res;

/**
 * jsapi_ticket 返回对象
 * @author zhiguang
 */
public class JsApiTicketRes extends SupportRes {

    private String ticket;

    private Integer expires_in;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }
}
