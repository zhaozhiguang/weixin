package com.zhaozhiguang.component.weixin.pojo.res.message;

import com.zhaozhiguang.component.weixin.pojo.SupportMsg;

/**
 * 链接消息
 * 消息类型: link
 * @author zhiguang
 */
public class LinkMsg extends SupportMsg {

    /**
     * 消息标题
     */
    private String Title;

    /**
     * 消息描述
     */
    private String Description;

    /**
     * 消息链接
     */
    private String Url;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
