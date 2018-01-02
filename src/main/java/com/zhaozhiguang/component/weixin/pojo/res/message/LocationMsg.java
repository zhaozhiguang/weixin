package com.zhaozhiguang.component.weixin.pojo.res.message;

import com.zhaozhiguang.component.weixin.pojo.SupportMsg;

/**
 * 地理位置消息
 * 消息类型:	location
 * @author zhiguang
 */
public class LocationMsg extends SupportMsg {

    /**
     * 	地理位置纬度
     */
    private Double Location_X;

    /**
     * 地理位置经度
     */
    private Double Location_Y;

    /**
     * 地图缩放大小
     */
    private Integer Scale;

    /**
     * 地理位置信息
     */
    private String Label;

    public Double getLocation_X() {
        return Location_X;
    }

    public void setLocation_X(Double location_X) {
        Location_X = location_X;
    }

    public Double getLocation_Y() {
        return Location_Y;
    }

    public void setLocation_Y(Double location_Y) {
        Location_Y = location_Y;
    }

    public Integer getScale() {
        return Scale;
    }

    public void setScale(Integer scale) {
        Scale = scale;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }
}
