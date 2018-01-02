package com.zhaozhiguang.component.weixin.pojo.res.message;

import com.zhaozhiguang.component.weixin.pojo.SupportMsg;

/**
 * 视频消息
 * 消息类型: 视频为video,小视频为shortvideo
 * @author zhiguang
 */
public class VideoMsg extends SupportMsg {

    /**
     * 视频消息媒体id，可以调用多媒体文件下载接口拉取数据。
     */
    private String MediaId;

    /**
     * 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
     */
    private String ThumbMediaId;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }
}
