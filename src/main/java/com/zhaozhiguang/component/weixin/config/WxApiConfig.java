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
        return String.format("https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=%s", accessToken);
    }

    /**
     * 获取显示二维码链接
     * @param ticket
     * @return
     */
    public String getShowQrCodeUrl(String ticket){
        return String.format("https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=%s", ticket);
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

    /**
     * 获取jsapiTicket链接
     * @param accessToken
     * @return
     */
    public String getJsApiTicketUrl(String accessToken){
        return String.format("https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=%s&type=jsapi", accessToken);
    }



    /****---------------------------新版客服系统--------------------------------****/

    /**
     * 获取微信客服基本信息列表链接
     * @param accessToken
     * @return
     */
    public String getkfinfoListUrl(String accessToken){
        return String.format("https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token=%s", accessToken);
    }

    /**
     * 获取微信在线客服列表链接
     * @param accessToken
     * @return
     */
    public String getkfonlineListUrl(String accessToken){
        return String.format("https://api.weixin.qq.com/cgi-bin/customservice/getonlinekflist?access_token=%s", accessToken);
    }

    /**
     * 获取客服添加链接
     * @param accessToken
     * @return
     */
    public String getkfAddUrl(String accessToken){
        return String.format("https://api.weixin.qq.com/customservice/kfaccount/add?access_token=%s", accessToken);
    }

    /**
     * 获取客服绑定微信链接
     * @param accessToken
     * @return
     */
    public String getkfBindWxUrl(String accessToken){
        return String.format("https://api.weixin.qq.com/customservice/kfaccount/inviteworker?access_token=%s", accessToken);
    }

    /****-----------------------------公众号菜单---------------------------------****/

    /**
     * 获取公众号菜单设置链接
     * @param accessToken
     * @return
     */
    public String getMenuSetUrl(String accessToken){
        return String.format("https://api.weixin.qq.com/cgi-bin/menu/create?access_token=%s", accessToken);
    }

    /**
     * 获取公众号菜单查询链接
     * @param accessToken
     * @return
     */
    public String getMenuQueryUrl(String accessToken){
        return String.format("https://api.weixin.qq.com/cgi-bin/menu/get?access_token=%s", accessToken);
    }

    /****------------------------------素材管理-------------------------------------****/

    /**
     * 获取新增临时素材链接
     * @param accessToken
     * @param mediaType
     * @return
     */
    public String getMediaTempSetUrl(String accessToken, String mediaType){
        return String.format("https://api.weixin.qq.com/cgi-bin/media/upload?access_token=%s&type=%s", accessToken, mediaType);
    }

    /**
     * 获取临时素材链接
     * @param accessToken
     * @param mediaId
     * @return
     */
    public String getMediaTempQueryUrl(String accessToken, String mediaId){
        return String.format("https://api.weixin.qq.com/cgi-bin/media/get?access_token=%s&media_id=%s", accessToken, mediaId);
    }

    /**
     * 获取新增永久其他类型素材链接
     * @param accessToken
     * @param mediaType
     * @return
     */
    public String getMediaPermSetUrl(String accessToken, String mediaType){
        return String.format("https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=%s&type=%s", accessToken, mediaType);
    }

    /**
     * 获取新增图文素材链接
     * @param accessToken
     * @return
     */
    public String getMediaPermSetUrl(String accessToken){
        return String.format("https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=%s", accessToken);
    }

    /**
     * 上传图文消息内的图片获取URL
     * @param accessToken
     * @return
     */
    public String getMediaImgSetUrl(String accessToken){
        return String.format("https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=%s", accessToken);
    }

    /**
     * 获取永久图文素材链接
     * @param accessToken
     * @return
     */
    public String getMediaPermQueryUrl(String accessToken){
        return String.format("https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=%s", accessToken);
    }

    /**
     * 获取永久其他类型素材链接
     * @param accessToken
     * @return
     */
    public String getMediaPermNewsQueryUrl(String accessToken){
        return String.format("https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=%s", accessToken);
    }

    /**
     * 获取删除永久素材链接
     * @param accessToken
     * @return
     */
    public String getMediaPermDeleteUrl(String accessToken){
        return String.format("https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=%s", accessToken);
    }



}
