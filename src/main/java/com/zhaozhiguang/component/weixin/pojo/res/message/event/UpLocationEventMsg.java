package com.zhaozhiguang.component.weixin.pojo.res.message.event;

import com.zhaozhiguang.component.weixin.pojo.res.message.EventMsg;

/**
 * 上报地理位置消息
 * 事件类型，LOCATION
 * @author zhiguang
 */
public class UpLocationEventMsg extends EventMsg {

    /**
     * 地理位置纬度
     */
    private Double Latitude;

    /**
     * 地理位置经度
     */
    private Double Longitude;

    /**
     * 地理位置精度
     */
    private Double Precision;

    public Double getLatitude() {
        return Latitude;
    }

    public void setLatitude(Double latitude) {
        Latitude = latitude;
    }

    public Double getLongitude() {
        return Longitude;
    }

    public void setLongitude(Double longitude) {
        Longitude = longitude;
    }

    public Double getPrecision() {
        return Precision;
    }

    public void setPrecision(Double precision) {
        Precision = precision;
    }
}
