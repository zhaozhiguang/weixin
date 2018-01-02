package com.zhaozhiguang.component.weixin.pojo.res.message;

import com.zhaozhiguang.component.weixin.pojo.SupportMsg;

/**
 * 文本消息
 * 消息类型:	text
 * @author zhiguang
 */
public class TextMsg extends SupportMsg {

    /**
     * 	文本消息内容
     */
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
