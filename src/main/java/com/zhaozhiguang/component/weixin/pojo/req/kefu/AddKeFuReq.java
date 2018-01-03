package com.zhaozhiguang.component.weixin.pojo.req.kefu;

/**
 * 添加客服请求
 * @author zhiguang
 */
public class AddKeFuReq {

    /**
     * 账号
     */
    private String kf_account;

    /**
     * 昵称
     */
    private String nickname;

    public String getKf_account() {
        return kf_account;
    }

    public void setKf_account(String kf_account) {
        this.kf_account = kf_account;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
