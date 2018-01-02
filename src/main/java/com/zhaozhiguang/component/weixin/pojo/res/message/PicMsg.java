package com.zhaozhiguang.component.weixin.pojo.res.message;

import com.zhaozhiguang.component.weixin.pojo.SupportMsg;

/**
 * 图片消息
 * 消息类型:	image
 * @author zhiguang
 */
public class PicMsg extends SupportMsg {

    /**
     * 	图片链接（由系统生成）
     */
    private String PicUrl;

    /**
     * 图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
     */
    private String MediaId;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
