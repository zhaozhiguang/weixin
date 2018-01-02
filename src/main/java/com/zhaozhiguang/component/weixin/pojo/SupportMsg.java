package com.zhaozhiguang.component.weixin.pojo;

import java.io.Serializable;

/**
 * 基础消息
 * @author zhiguang
 */
public class SupportMsg implements Serializable {

    private static final long serialVersionUID = -3728490424738325020L;

    /**
     * 开发者账号 / 接收方帐号（收到的OpenID）
     */
    private String ToUserName;

    /**
     * 开发者账号 / 接收方帐号（收到的OpenID）
     */
    private String FromUserName;

    /**
     * 消息创建时间(整型)
     */
    private Long CreateTime;

    /**
     * 消息类型
     */
    private String MsgType;

    /**
     * 消息id
     */
    private Long MsgId;

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public Long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public Long getMsgId() {
        return MsgId;
    }

    public void setMsgId(Long msgId) {
        MsgId = msgId;
    }
}
