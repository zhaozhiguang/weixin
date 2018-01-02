package com.zhaozhiguang.component.weixin.pojo;

/**
 * 事件类型
 * subscribe: 关注
 * unsubscribe: 取消关注
 * CLICK: 点击菜单
 * VIEW: 跳转链接
 * SCAN: 扫描二维码
 *
 * @author zhiguang
 */
public enum EventType {

    SUBSCRIBE(Constant.EVENT_TYPE_SUBSCRIBE),UNSUBSCRIBE(Constant.EVENT_TYPE_UNSUBSCRIBE),
    CLICK(Constant.EVENT_TYPE_CLICK),VIEWS(Constant.EVENT_TYPE_VIEWS),SCAN(Constant.EVENT_TYPE_SCAN);

    private String value;

    public String getValue() {
        return value;
    }

    private EventType(String value){
        this.value = value;
    }
}
