package com.zhaozhiguang.component.weixin.pojo.res.message;

import com.zhaozhiguang.component.weixin.pojo.SupportMsg;

/**
 * 事件消息
 * 消息类型: event
 */
public class EventMsg extends SupportMsg {

    /**
     * 事件类型
     */
    private String Event;

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }
}
