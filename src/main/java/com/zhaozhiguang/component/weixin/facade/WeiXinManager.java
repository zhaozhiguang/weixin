package com.zhaozhiguang.component.weixin.facade;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhaozhiguang.component.weixin.cache.SimpleRedisWxCacheImpl;
import com.zhaozhiguang.component.weixin.cache.WxCache;
import com.zhaozhiguang.component.weixin.config.WxApiConfig;
import com.zhaozhiguang.component.weixin.config.WxProperties;
import com.zhaozhiguang.component.weixin.pojo.MediaType;
import com.zhaozhiguang.component.weixin.pojo.req.customer.CustomerSupportMsg;
import com.zhaozhiguang.component.weixin.pojo.req.kefu.AddKeFuReq;
import com.zhaozhiguang.component.weixin.pojo.req.kefu.BindWxKeFuReq;
import com.zhaozhiguang.component.weixin.pojo.req.media.MediaPermNewsReq;
import com.zhaozhiguang.component.weixin.pojo.req.menu.MenuSetReq;
import com.zhaozhiguang.component.weixin.pojo.req.qrcode.QrCodeMsg;
import com.zhaozhiguang.component.weixin.pojo.req.template.TemplateSupportMsg;
import com.zhaozhiguang.component.weixin.pojo.res.*;
import com.zhaozhiguang.component.weixin.pojo.res.kefu.KeFuInfoListRes;
import com.zhaozhiguang.component.weixin.pojo.res.kefu.KeFuOnlineRes;
import com.zhaozhiguang.component.weixin.pojo.res.media.PermMediaNewsRes;
import com.zhaozhiguang.component.weixin.pojo.res.media.TempMediaSetRes;
import com.zhaozhiguang.component.weixin.pojo.res.menu.MenuQueryRes;
import com.zhaozhiguang.component.weixin.sign.JsApiSignUtil;
import com.zhaozhiguang.component.weixin.sign.WxSignUtil;
import com.zhaozhiguang.component.weixin.util.ArgsCheckUtils;
import com.zhaozhiguang.component.weixin.util.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
        try {
            String result = HttpUtils.get(config.getUserInfoUrl(getAccessToken(), openId), null);
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
        try {
            String result = HttpUtils.postJson(config.getTemplateMsgUrl(getAccessToken()),null, JSON.toJSONString(template));
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
        try {
            String result = HttpUtils.postJson(config.getCustomerMsgUrl(getAccessToken()),null, JSON.toJSONString(customerMsg));
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
             String result = HttpUtils.get(config.getJsApiTicketUrl(getAccessToken()),null);
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

    /**
     * 获取二维码ticket
     * @return
     */
    public String getQrCodeTicket(QrCodeMsg qrCodeMsg){
        ArgsCheckUtils.notNull(qrCodeMsg);
        try {
            String result = HttpUtils.postJson(config.getQrCodeUrl(getAccessToken()),null, JSON.toJSONString(qrCodeMsg));
            if(result!=null){
                JSONObject obj = JSON.parseObject(result);
                if(obj!=null&&obj.get("ticket")!=null){
                    return obj.get("ticket").toString();
                }
            }
        } catch (IOException e) {
            logger.error("获取二维码ticket发生异常", e);
        }
        return null;
    }

    /**
     * 获取二维码地址
     * @return
     */
    public String getQrCodeUrl(QrCodeMsg qrCodeMsg){
        String ticket = getQrCodeTicket(qrCodeMsg);
        return config.getShowQrCodeUrl(ticket);
    }

    /**
     * 获取客服基本信息列表
     * @return
     */
    public KeFuInfoListRes kfInfoList(){
        try {
            String result = HttpUtils.get(config.getkfinfoListUrl(getAccessToken()),null);
            if(result!=null){
                return JSON.parseObject(result, KeFuInfoListRes.class);
            }
        } catch (IOException e) {
            logger.error("获取客服基本信息列表发生异常", e);
        }
        return null;
    }

    /**
     * 获取在线客服列表
     * @return
     */
    public KeFuOnlineRes kfOnlineList(){
        try {
            String result = HttpUtils.get(config.getkfonlineListUrl(getAccessToken()),null);
            if(result!=null){
                return JSON.parseObject(result, KeFuOnlineRes.class);
            }
        } catch (IOException e) {
            logger.error("获取客服基本信息列表发生异常", e);
        }
        return null;
    }

    /**
     * 客服添加
     * @return
     */
    public boolean kfAdd(AddKeFuReq kefu){
        ArgsCheckUtils.notNull(kefu);
        try {
            String result = HttpUtils.postJson(config.getkfAddUrl(getAccessToken()),null, JSON.toJSONString(kefu));
            if(result!=null){
                SupportRes res = JSON.parseObject(result, SupportRes.class);
                if(res!=null&&res.getErrcode()==0) return true;
            }
        } catch (IOException e) {
            logger.error("添加客服发生异常", e);
        }
        return false;
    }

    /**
     * 客服绑定
     * @return
     */
    public boolean kfBind(BindWxKeFuReq kefu){
        ArgsCheckUtils.notNull(kefu);
        try {
            String result = HttpUtils.postJson(config.getkfBindWxUrl(getAccessToken()),null, JSON.toJSONString(kefu));
            if(result!=null){
                SupportRes res = JSON.parseObject(result, SupportRes.class);
                if(res!=null&&res.getErrcode()==0) return true;
            }
        } catch (IOException e) {
            logger.error("客服绑定微信号发生异常", e);
        }
        return false;
    }

    /**
     * 菜单添加
     * @return
     */
    public boolean menuSet(MenuSetReq menu){
        ArgsCheckUtils.notNull(menu);
        try {
            String result = HttpUtils.postJson(config.getMenuSetUrl(getAccessToken()),null, JSON.toJSONString(menu));
            if(result!=null){
                SupportRes res = JSON.parseObject(result, SupportRes.class);
                if(res!=null&&res.getErrcode()==0) return true;
            }
        } catch (IOException e) {
            logger.error("设置菜单发生异常", e);
        }
        return false;
    }

    /**
     * 菜单查询
     * @return
     */
    public MenuQueryRes menuQuery(){
        try {
            String result = HttpUtils.get(config.getMenuQueryUrl(getAccessToken()),null);
            if(result!=null){
                return JSON.parseObject(result, MenuQueryRes.class);
            }
        } catch (IOException e) {
            logger.error("查询菜单发生异常", e);
        }
        return null;
    }

    /**
     * 上传图文消息内的图片获取URL
     * 本接口所上传的图片不占用公众号的素材库中图片数量的5000个的限制。图片仅支持jpg/png格式，大小必须在1MB以下。
     * @return url 图片链接
     */
    public String mediaImgUrl(File file){
        ArgsCheckUtils.notNull(file);
        Map<String, File> map = new HashMap<>();
        map.put("media", file);
        try {
            String result = HttpUtils.postForm(config.getMediaImgSetUrl(getAccessToken()),null,null, map);
            if(result!=null){
                JSONObject obj = JSON.parseObject(result);
                if(obj!=null&&obj.get("url")!=null) return obj.get("url").toString();
            }
        } catch (IOException e) {
            logger.error("上传图片发生异常", e);
        }
        return null;
    }

    /**
     * 新增临时素材
     * @param file
     * @return
     */
    public TempMediaSetRes mediaTempSet(MediaType type, File file){
        ArgsCheckUtils.notNull(type);
        ArgsCheckUtils.notNull(file);
        Map<String, File> map = new HashMap<>();
        map.put("media", file);
        try {
            String result = HttpUtils.postForm(config.getMediaTempSetUrl(getAccessToken(), type.type),null,null, map);
            if(result!=null){
                return JSON.parseObject(result, TempMediaSetRes.class);
            }
        } catch (IOException e) {
            logger.error("新增临时素材发生异常", e);
        }
        return null;
    }

    /**
     * 新增永久素材
     * @param file
     * @return
     */
    public TempMediaSetRes mediaPermSet(MediaType type, File file){
        ArgsCheckUtils.notNull(type);
        ArgsCheckUtils.notNull(file);
        Map<String, File> map = new HashMap<>();
        map.put("media", file);
        try {
            String result = HttpUtils.postForm(config.getMediaPermSetUrl(getAccessToken(), type.type),null,null, map);
            if(result!=null){
                return JSON.parseObject(result, TempMediaSetRes.class);
            }
        } catch (IOException e) {
            logger.error("新增永久素材发生异常", e);
        }
        return null;
    }

    /**
     * 新增永久图文素材
     * 适用单图文/未上传封面图片
     * @param file
     * @return
     */
    public TempMediaSetRes mediaPermNewsSet(MediaType type, File file, MediaPermNewsReq mediaReq){
        TempMediaSetRes tempMediaSetRes = mediaPermSet(type, file);
        ArgsCheckUtils.notEmptyByList(mediaReq.getArticles());
        mediaReq.getArticles().get(0).setThumb_media_id(tempMediaSetRes.getMedia_id());
        if(tempMediaSetRes!=null) return mediaPermNewsSet(mediaReq);
        return null;
    }

    /**
     * 新增永久图文素材
     * @param mediaReq
     * @return
     */
    public TempMediaSetRes mediaPermNewsSet(MediaPermNewsReq mediaReq){
        ArgsCheckUtils.notNull(mediaReq);
        ArgsCheckUtils.notEmptyByList(mediaReq.getArticles());
        try {
            String result = HttpUtils.postJson(config.getMediaPermSetUrl(getAccessToken()),null,JSON.toJSONString(mediaReq));
            if(result!=null){
                return JSON.parseObject(result, TempMediaSetRes.class);
            }
        } catch (IOException e) {
            logger.error("新增永久图文素材发生异常", e);
        }
        return null;
    }

    /**
     * 获取永久图文素材
     * @param mediaId
     * @return
     */
    public PermMediaNewsRes mediaPermNewsQuery(String mediaId){
        ArgsCheckUtils.notNull(mediaId);
        Map map = new HashMap();
        map.put("media_id", mediaId);
        try {
            String result = HttpUtils.postJson(config.getMediaPermQueryUrl(getAccessToken()),null,JSON.toJSONString(map));
            if(result!=null){
                return JSON.parseObject(result, PermMediaNewsRes.class);
            }
        } catch (IOException e) {
            logger.error("获取永久图文素材发生异常", e);
        }
        return null;
    }

    /**
     * 删除永久素材
     * @param mediaId
     * @return
     */
    public boolean mediaPermDelete(String mediaId){
        ArgsCheckUtils.notNull(mediaId);
        Map map = new HashMap();
        map.put("media_id", mediaId);
        try {
            String result = HttpUtils.postJson(config.getMediaPermDeleteUrl(getAccessToken()),null, JSON.toJSONString(map));
            if(result!=null){
                SupportRes res = JSON.parseObject(result, SupportRes.class);
                if(res!=null&&res.getErrcode()==0) return true;
            }
        } catch (IOException e) {
            logger.error("删除永久素材发生异常", e);
        }
        return false;
    }


}
