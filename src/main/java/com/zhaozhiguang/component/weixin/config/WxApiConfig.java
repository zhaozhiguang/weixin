package com.zhaozhiguang.component.weixin.config;

/**
 * 微信ApiConfig
 * @author zhiguang
 */
public class WxApiConfig {

    /**
     * 获取授权登录链接
     * @param appId
     * @param redirectUri
     * @param state
     * @return
     */
    public String getAuthorizedLoginUrl(String appId, String redirectUri, String state){
        return String.format("https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_userinfo&state=%s#wechat_redirect",
                appId, redirectUri, state==null?"state":state);
    }

    /**
     * 获取openId链接
     * @param appId
     * @param secret
     * @param code
     * @return
     */
    public String getOpenIdUrl(String appId, String secret, String code){
        return String.format("https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code", appId, secret, code);
    }

    /**
     * 获取用户信息链接
     * @param accessToken
     * @param openId
     * @return
     */
    public String getUserInfoUrl(String accessToken, String openId){
        return String.format("https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s", accessToken, openId);
    }

    /**
     * 获取二维码链接
     * @param accessToken
     * @return
     */
    public String getQrCodeUrl(String accessToken){
        return String.format("https://api.weixin.qq.com/cgi-bin/ticket/getticket?type=jsapi&access_token=%s", accessToken);
    }

    /**
     * 获取微信accesstoken链接
     * @param appId
     * @param secret
     * @return
     */
    public String getAccessTokenUrl(String appId, String secret){
        return String.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s", appId, secret);
    }

    /**
     * 获取模板消息列表链接
     * @param accessToken
     * @return
     */
    public String getTemplateListUrl(String accessToken){
        return String.format("https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=%s", accessToken);
    }

    /**
     * 获取微信模板发送链接
     * @param accessToken
     * @return
     */
    public String getTemplateMsgUrl(String accessToken){
        return String.format("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=%s", accessToken);
    }

    /**
     * 获取客服消息发送链接
     * @param accessToken
     * @return
     */
    public String getCustomerMsgUrl(String accessToken){
        return String.format("https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=%s", accessToken);
    }


}