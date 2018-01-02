package com.zhaozhiguang.component.weixin.pojo.req.message;

import com.zhaozhiguang.component.weixin.pojo.SupportMsg;

/**
 * 音乐消息
 * 消息类型: music
 * @author zhiguang
 */
public class MusicMsg extends SupportMsg {

    /**
     * 音乐标题
     * 该字段不是必须
     */
    private String Title;

    /**
     * 音乐描述
     * 该字段不是必须
     */
    private String Description;

    /**
     * 音乐链接
     * 该字段不是必须
     */
    private String MusicURL;

    /**
     * 高质量音乐链接，WIFI环境优先使用该链接播放音乐
     * 该字段不是必须
     */
    private String HQMusicUrl;

    /**
     * 缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
     */
    private String ThumbMediaId;

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

    public String getMusicURL() {
        return MusicURL;
    }

    public void setMusicURL(String musicURL) {
        MusicURL = musicURL;
    }

    public String getHQMusicUrl() {
        return HQMusicUrl;
    }

    public void setHQMusicUrl(String HQMusicUrl) {
        this.HQMusicUrl = HQMusicUrl;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }
}
