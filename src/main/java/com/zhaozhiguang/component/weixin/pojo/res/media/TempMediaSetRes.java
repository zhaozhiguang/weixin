package com.zhaozhiguang.component.weixin.pojo.res.media;

/**
 * 临时素材设置返回
 * @author zhiguang
 */
public class TempMediaSetRes {

    private String type;

    private String media_id;

    private Integer created_at;

    /**
     * 仅新增永久图片素材才会返回
     */
    private String url;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public Integer getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Integer created_at) {
        this.created_at = created_at;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
