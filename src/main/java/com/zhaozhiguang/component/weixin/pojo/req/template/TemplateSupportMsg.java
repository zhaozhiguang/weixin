package com.zhaozhiguang.component.weixin.pojo.req.template;

import com.zhaozhiguang.component.weixin.pojo.Constant;

import java.util.HashMap;

/**
 * 微信模板消息
 * @author zhiguang
 */
public class TemplateSupportMsg {

    private String touser;

    private String template_id;

    private String url;

    private Data data;

    public TemplateSupportMsg() {
        this.data = new Data();
    }

    public String getTouser() {
        return touser;
    }

    public TemplateSupportMsg setTouser(String touser) {
        this.touser = touser;
        return this;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public TemplateSupportMsg setTemplate_id(String template_id) {
        this.template_id = template_id;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public TemplateSupportMsg setUrl(String url) {
        this.url = url;
        return this;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public TemplateSupportMsg addData(String key, Object value){
        data.addData(key, new Item(value, Constant.TEMPLATE_DEFAULT_COLOR));
        return this;
    }

    public TemplateSupportMsg addData(String key, Object value, String color){
        data.addData(key, new Item(value, color));
        return this;
    }

    public static class Data extends HashMap<String, Object> {

        public void addData(String key, Item item){
            this.put(key, item);
        }

    }

    public static class Item {

        private Object value;

        private String color;

        public Object getValue() {
            return value;
        }
        public void setValue(Object value) {
            this.value = value;
        }
        public String getColor() {
            return color;
        }
        public void setColor(String color) {
            this.color = color;
        }

        public Item(Object value, String color) {
            this.value = value;
            this.color = color;
        }
    }

}
