package com.zhaozhiguang.component.weixin.pojo.res.message.event;

import com.zhaozhiguang.component.weixin.pojo.res.message.EventMsg;

/**
 * 点击菜单消息
 * 事件类型，CLICK(拉取消息时) 事件类型，VIEW(跳转链接时)
 * @author zhiguang
 */
public class ClickMenuEventMsg extends EventMsg {

    /**
     * 拉取消息时: 事件KEY值，与自定义菜单接口中KEY值对应
     * 跳转链接时: 事件KEY值，设置的跳转URL
     */
    private String EventKey;

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }
}
