package com.zhaozhiguang.component.weixin.pojo;

/**
 * 素材类型
 * @author zhiguang
 */
public enum MediaType {
    /**
     * 图片
     */
    IMAGE("image"),
    /**
     * 语音
     */
    VOICE("voice"),
    /**
     * 视频
     */
    VIDEO("video"),
    /**
     * 缩略图
     */
    THUMB("thumb");

    public final String type;

    MediaType(String type){
        this.type = type;
    }
}
