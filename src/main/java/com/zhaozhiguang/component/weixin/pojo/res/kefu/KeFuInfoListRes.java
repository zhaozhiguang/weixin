package com.zhaozhiguang.component.weixin.pojo.res.kefu;

import java.util.List;

/**
 * 客服基础信息返回
 * @author zhiguang
 */
public class KeFuInfoListRes {

    private List<KeFuInfo> kf_list;

    public List<KeFuInfo> getKf_list() {
        return kf_list;
    }

    public void setKf_list(List<KeFuInfo> kf_list) {
        this.kf_list = kf_list;
    }

    public static class KeFuInfo {

        /**
         * 完整客服帐号，格式为：帐号前缀@公众号微信号
         */
        private String kf_account;

        /**
         * 客服头像
         */
        private String kf_headimgurl;

        /**
         * 客服编号
         */
        private String kf_id;

        /**
         * 客服昵称
         */
        private String kf_nick;

        /**
         * 如果客服帐号已绑定了客服人员微信号， 则此处显示微信号
         */
        private String kf_wx;

        /**
         * 如果客服帐号尚未绑定微信号，但是已经发起了一个绑定邀请， 则此处显示绑定邀请的微信号
         */
        private String invite_wx;

        /**
         * 如果客服帐号尚未绑定微信号，但是已经发起过一个绑定邀请， 邀请的过期时间，为unix 时间戳
         */
        private Integer invite_expire_time;

        /**
         * 邀请的状态，有等待确认“waiting”，被拒绝“rejected”， 过期“expired”
         */
        private String invite_status;

        public String getKf_account() {
            return kf_account;
        }

        public void setKf_account(String kf_account) {
            this.kf_account = kf_account;
        }

        public String getKf_headimgurl() {
            return kf_headimgurl;
        }

        public void setKf_headimgurl(String kf_headimgurl) {
            this.kf_headimgurl = kf_headimgurl;
        }

        public String getKf_id() {
            return kf_id;
        }

        public void setKf_id(String kf_id) {
            this.kf_id = kf_id;
        }

        public String getKf_nick() {
            return kf_nick;
        }

        public void setKf_nick(String kf_nick) {
            this.kf_nick = kf_nick;
        }

        public String getKf_wx() {
            return kf_wx;
        }

        public void setKf_wx(String kf_wx) {
            this.kf_wx = kf_wx;
        }

        public String getInvite_wx() {
            return invite_wx;
        }

        public void setInvite_wx(String invite_wx) {
            this.invite_wx = invite_wx;
        }

        public Integer getInvite_expire_time() {
            return invite_expire_time;
        }

        public void setInvite_expire_time(Integer invite_expire_time) {
            this.invite_expire_time = invite_expire_time;
        }

        public String getInvite_status() {
            return invite_status;
        }

        public void setInvite_status(String invite_status) {
            this.invite_status = invite_status;
        }
    }

}
