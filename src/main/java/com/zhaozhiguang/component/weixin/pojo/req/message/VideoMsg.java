package com.zhaozhiguang.component.weixin.pojo.req.message;

import com.zhaozhiguang.component.weixin.pojo.SupportMsg;

/**
 * 视频消息
 * 消息类型: video
 * @author zhiguang
 */
public class VideoMsg extends SupportMsg {

    /**
     * 通过素材管理中的接口上传多媒体文件，得到的id
     */
    private String MediaId;

    /**
     * 	视频消息的标题
     * 	该字段不是必须
     */
    private String Title;

    /**
     * 视频消息的描述
     * 该字段不是必须
     */
    private String Description;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

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
}
