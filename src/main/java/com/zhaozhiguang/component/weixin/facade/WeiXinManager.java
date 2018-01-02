package com.zhaozhiguang.component.weixin.facade;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhaozhiguang.component.weixin.cache.SimpleRedisWxCacheImpl;
import com.zhaozhiguang.component.weixin.cache.WxCache;
import com.zhaozhiguang.component.weixin.config.WxApiConfig;
import com.zhaozhiguang.component.weixin.config.WxProperties;
import com.zhaozhiguang.component.weixin.pojo.req.customer.CustomerSupportMsg;
import com.zhaozhiguang.component.weixin.pojo.req.template.TemplateSupportMsg;
import com.zhaozhiguang.component.weixin.pojo.res.*;
import com.zhaozhiguang.component.weixin.sign.JsApiSignUtil;
import com.zhaozhiguang.component.weixin.sign.WxSignUtil;
import com.zhaozhiguang.component.weixin.util.ArgsCheckUtils;
import com.zhaozhiguang.component.weixin.util.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * 微信接入总处理
 */
public class WeiXinManager {

    private static final Logger logger = LoggerFactory.getLogger(WeiXinManager.class);

    private WxApiConfig config = new WxApiConfig();

    private WxCache wxCache = new SimpleRedisWxCacheImpl("localhost",6379);

    private WxProperties properties;

    public void setWxCache(WxCache wxCache) {
        this.wxCache = wxCache;
    }

    public void setProperties(WxProperties properties) {
        this.properties = properties;
    }

    private static final String WX_ACCESS_TOKEN = "WX_ACCESS_TOKEN";

    private static final String WX_JS_ACCESS_TOKEN = "WX_JS_ACCESS_TOKEN";

    /**
     * 微信验证接口
     * @param token
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    public static boolean checkSignature(String token, String signature, String timestamp, String nonce){
        return WxSignUtil.checkSignature(token, signature, timestamp, nonce);
    }

    /**
     * 获取授权登录链接
     * @param redirectUri
     * @param state
     * @return
     */
    public String getAuthorizedLoginUrl(String redirectUri, String state){
        return config.getAuthorizedLoginUrl(properties.getAppId(), redirectUri, state);
    }

    /**
     * 获取AccessToken
     * @return
     */
    public String getAccessToken(){
        String value = wxCache.getValue(WX_ACCESS_TOKEN);
        if(value!=null) return value;
        try {
            String accesstoken = HttpUtils.get(config.getAccessTokenUrl(properties.getAppId(), properties.getSecret()), null);
            if(accesstoken!=null){
                AccessTokenRes object = JSON.parseObject(accesstoken, AccessTokenRes.class);
                if(object!=null && object.getErrcode()==null){
                    wxCache.setValue(WX_ACCESS_TOKEN,object.getAccess_token(),object.getExpires_in()-1000);
                    return object.getAccess_token();
                }
            }
        } catch (IOException e) {
            logger.error("获取accessToken发生异常", e);
        }
        ArgsCheckUtils.notNull(value);
        return null;
    }

    /**
     * 获取openid
     * @param code
     * @return
     */
    public String getOpenId(String code){
        ArgsCheckUtils.notNull(code);
        String openId = null;
        try {
            String result = HttpUtils.get(config.getOpenIdUrl(properties.getAppId(), properties.getSecret(), code), null);
            JSONObject obj = JSON.parseObject(result);
            if(obj!=null && obj.get("openid")!=null)
                openId = obj.get("openid").toString();
        } catch (IOException e) {
            logger.error("获取openid发生异常", e);
        }
        return openId;
    }

    /**
     * 获取用户微信信息
     * @param code
     * @return
     */
    public UserInfoRes getUserInfoByCode(String code){
        String openId = getOpenId(code);
        if(openId!=null)
            return getUserInfoByOpenId(openId);
        return null;
    }

    /**
     * 获取用户微信信息
     * @param openId
     * @return
     */
    public UserInfoRes getUserInfoByOpenId(String openId){
        ArgsCheckUtils.notNull(openId);
        String token = getAccessToken();
        try {
            String result = HttpUtils.get(config.getUserInfoUrl(token, openId), null);
            if(result!=null){
                UserInfoRes userInfo = JSON.parseObject(result, UserInfoRes.class);
                return userInfo;
            }
        } catch (IOException e) {
            logger.error("获取用户信息发生异常", e);
        }
        return null;
    }

    /**
     * 发送模板消息
     * @param template
     * @return
     */
    public boolean SendTemplateMsg(TemplateSupportMsg template){
        ArgsCheckUtils.notNull(template);
        String token = getAccessToken();
        try {
            String result = HttpUtils.postJson(config.getTemplateMsgUrl(token),null, JSON.toJSONString(template));
            if(result!=null){
                SupportRes res = JSON.parseObject(result, SupportRes.class);
                if(res!=null && res.getErrcode()==0) return true;
            }
        } catch (IOException e) {
            logger.error("发送模板消息发生异常", e);
        }
        return false;
    }

    /**
     * 发送客服消息
     * @param customerMsg
     * @return
     */
    public boolean SendCustomerMsg(CustomerSupportMsg customerMsg){
        ArgsCheckUtils.notNull(customerMsg);
        String token = getAccessToken();
        try {
            String result = HttpUtils.postJson(config.getCustomerMsgUrl(token),null, JSON.toJSONString(customerMsg));
            if(result!=null){
                SupportRes res = JSON.parseObject(result, SupportRes.class);
                if(res!=null && res.getErrcode()==0) return true;
            }
        } catch (IOException e) {
            logger.error("发送客服消息发生异常", e);
        }
        return false;
    }

    /**
     * 获取jsApiTicket
     * @return
     */
    public String getJsApiTicket(){
        String value = wxCache.getValue(WX_JS_ACCESS_TOKEN);
        if(value!=null) return value;
        try {
            String token = getAccessToken();
             String result = HttpUtils.get(config.getJsApiTicketUrl(token),null);
             if(result!=null){
                 JsApiTicketRes res = JSON.parseObject(result, JsApiTicketRes.class);
                 if(res!=null&&res.getErrcode()==0){
                     wxCache.setValue(WX_JS_ACCESS_TOKEN, res.getTicket(), res.getExpires_in());
                     return res.getTicket();
                 }
             }
        } catch (IOException e) {
            logger.error("获取JsApiTicket发生异常", e);
        }
        return null;
    }

    /**
     * 获取微信js接口验证结果
     * @param url
     * @return
     */
    public JsSignResult getJsApiSignResult(String url){
        ArgsCheckUtils.notNull(url);
        String ticket = getJsApiTicket();
        return JsApiSignUtil.sign(ticket, url);
    }




}
