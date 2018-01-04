package com.zhaozhiguang.component.weixin.pojo.req.menu;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单设置请求
 * @author zhiguang
 */
public class MenuSetReq {

    /**
     * 一级菜单数组，个数应为1~3个
     */
    private List<Button> button;

    public List<Button> getButton() {
        return button;
    }

    public void setButton(List<Button> button) {
        this.button = button;
    }

    public MenuSetReq addButton(Button button){
        if(this.button==null) this.button = new ArrayList<>();
        this.button.add(button);
        return this;
    }

    /**
     * 菜单类型
     */
    public enum BUTTONTYPE {
        CLICK("click"),VIEW("view"),SCANCODE_WAITMSG("scancode_waitmsg"),SCANCODE_PUSH("scancode_push"),
        PIC_SYSPHOTO("pic_sysphoto"),PIC_PHOTO_OR_ALBUM("pic_photo_or_album"),PIC_WEIXIN("pic_weixin"),LOCATION_SELECT("location_select"),
        MEDIA_ID("media_id"),VIEW_LIMITED("view_limited");
        private String type;
        BUTTONTYPE(String type){
            this.type = type;
        }
    }

    public static class Button {

        /**
         * 菜单标题，不超过16个字节，子菜单不超过60个字节
         */
        private String name;

        /**
         * 菜单的响应动作类型，view表示网页类型，click表示点击类型，miniprogram表示小程序类型
         */
        private String type;

        /**
         * 菜单KEY值，用于消息接口推送，不超过128字节
         */
        private String key;

        /**
         * 网页 链接，用户点击菜单可打开链接，不超过1024字节。 type为miniprogram时，不支持小程序的老版本客户端将打开本url。
         */
        private String url;

        /**
         * 调用新增永久素材接口返回的合法media_id
         */
        private String media_id;

        /**
         * 小程序的appid（仅认证公众号可配置）
         */
        private  String appid;

        /**
         * 小程序的页面路径
         */
        private String pagepath;

        /**
         * 二级菜单数组，个数应为1~5个
         */
        private List<Button> sub_button;

        public Button(){

        }

        public Button(String name){
            this.name = name;
        }

        public Button addChildButton(Button button){
            if(this.sub_button==null) this.sub_button = new ArrayList<>();
            this.sub_button.add(button);
            return this;
        }

        public String getName() {
            return name;
        }

        public Button setName(String name) {
            this.name = name;
            return this;
        }

        public String getType() {
            return type;
        }

        public Button setType(BUTTONTYPE type) {
            this.type = type.type;
            return this;
        }

        public String getKey() {
            return key;
        }

        public Button setKey(String key) {
            this.key = key;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public Button setUrl(String url) {
            this.url = url;
            return this;
        }

        public String getMedia_id() {
            return media_id;
        }

        public Button setMedia_id(String media_id) {
            this.media_id = media_id;
            return this;
        }

        public String getAppid() {
            return appid;
        }

        public Button setAppid(String appid) {
            this.appid = appid;
            return this;
        }

        public String getPagepath() {
            return pagepath;
        }

        public Button setPagepath(String pagepath) {
            this.pagepath = pagepath;
            return this;
        }

        public List<Button> getSub_button() {
            return sub_button;
        }

        public void setSub_button(List<Button> sub_button) {
            this.sub_button = sub_button;
        }
    }
}
