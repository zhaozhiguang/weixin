package com.zhaozhiguang.component.weixin.pojo.req.kefu;

/**
 * 客服绑定微信号
 * @author zhiguang
 */
public class BindWxKeFuReq {

    /**
     * 账号
     */
    private String kf_account;

    /**
     * 微信号
     */
    private String invite_wx;

    public String getKf_account() {
        return kf_account;
    }

    public void setKf_account(String kf_account) {
        this.kf_account = kf_account;
    }

    public String getInvite_wx() {
        return invite_wx;
    }

    public void setInvite_wx(String invite_wx) {
        this.invite_wx = invite_wx;
    }
}
