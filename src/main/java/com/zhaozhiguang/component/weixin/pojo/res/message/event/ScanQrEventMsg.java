package com.zhaozhiguang.component.weixin.pojo.res.message.event;

import com.zhaozhiguang.component.weixin.pojo.res.message.EventMsg;

/**
 * 扫描带参数二维码消息
 * 未关注 事件类型，subscribe
 *
 * 已关注 事件类型，SCAN
 *  @author zhiguang
 */
public class ScanQrEventMsg extends EventMsg {

    /**
     * 未关注: 事件KEY值，qrscene_为前缀，后面为二维码的参数值
     * 已关注: 事件KEY值，是一个32位无符号整数，即创建二维码时的二维码scene_id
     */
    private String EventKey;

    /**
     * 二维码的ticket，可用来换取二维码图片
     */
    private String Ticket;

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }

    public String getTicket() {
        return Ticket;
    }

    public void setTicket(String ticket) {
        Ticket = ticket;
    }
}
