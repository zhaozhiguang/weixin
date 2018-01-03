package com.zhaozhiguang.component.weixin.pojo.res.kefu;

import java.util.List;

/**
 * 微信在线客服返回
 * @author zhiguang
 */
public class KeFuOnlineRes {

    private List<Info> kf_online_list;

    public List<Info> getKf_online_list() {
        return kf_online_list;
    }

    public void setKf_online_list(List<Info> kf_online_list) {
        this.kf_online_list = kf_online_list;
    }

    public static class Info{

        /**
         * 完整客服帐号，格式为：帐号前缀@公众号微信号
         */
        private String kf_account;

        /**
         * 客服在线状态，目前为：1、web 在线
         */
        private String status;

        /**
         * 客服编号
         */
        private String kf_id;

        /**
         * 客服当前正在接待的会话数
         */
        private String accepted_case;

        public String getKf_account() {
            return kf_account;
        }

        public void setKf_account(String kf_account) {
            this.kf_account = kf_account;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getKf_id() {
            return kf_id;
        }

        public void setKf_id(String kf_id) {
            this.kf_id = kf_id;
        }

        public String getAccepted_case() {
            return accepted_case;
        }

        public void setAccepted_case(String accepted_case) {
            this.accepted_case = accepted_case;
        }
    }
}
