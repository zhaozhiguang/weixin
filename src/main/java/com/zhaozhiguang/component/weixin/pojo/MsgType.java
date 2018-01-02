package com.zhaozhiguang.component.weixin.pojo;

/**
 * 消息类型
 * text: 文本
 * music: 音乐
 * news: 图文
 * image: 图片
 * link: 链接
 * location: 地理位置
 * voice: 语音
 * event: 事件
 *
 * @author zhiguang
 */
public enum MsgType {

    TEXT(Constant.MESSAGE_TYPE_TEXT),MUSIC(Constant.MESSAGE_TYPE_MUSIC),NEWS(Constant.MESSAGE_TYPE_NEWS),
    IMAGE(Constant.MESSAGE_TYPE_IMAGE),LINK(Constant.MESSAGE_TYPE_LINK),LOCATION(Constant.MESSAGE_TYPE_LOCATION),
    VOICE(Constant.MESSAGE_TYPE_VOICE),EVENT(Constant.MESSAGE_TYPE_EVENT);

    private String value;

    public String getValue() {
        return value;
    }

    private MsgType(String value){
        this.value = value;
    }
}
