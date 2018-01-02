package com.zhaozhiguang.component.weixin.cache;

/**
 * 微信cache接口
 * @author zhiguang
 */
public interface WxCache {

    /**
     * 设置值
     * @param key
     * @param value
     * @return
     */
    boolean setValue(String key, String value);

    /**
     * 设置值+过期时间
     * @param key
     * @param value
     * @param seconds
     * @return
     */
    boolean setValue(String key, String value, int seconds);

    /**
     * 获取值
     * @param key
     * @return
     */
    String getValue(String key);

    /**
     * 设置过期时间
     * @param key
     * @param seconds
     */
    void disableTime(String key,int seconds);

}
