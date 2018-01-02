package com.zhaozhiguang.component.weixin.pojo.req.message;

import com.zhaozhiguang.component.weixin.pojo.SupportMsg;

/**
 * 语音消息
 * 消息类型:	voice
 * @author zhiguang
 */
public class VoiceMsg extends SupportMsg {

    /**
     * 通过素材管理中的接口上传多媒体文件，得到的id
     */
    private String MediaId;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
