package com.zhaozhiguang.component.weixin.pojo.req.customer;

import java.util.List;

/**
 * 客服消息
 * 组合模式
 *  什么类型传什么对象
 * @author zhiguang
 */
public class CustomerSupportMsg {

    /**
     * 用户openid
     */
    private String touser;

    /**
     * 类型
     */
    private String msgtype;

    /**
     * 文本
     */
    private TextMsg text;

    /**
     * 图片
     */
    private ImageMsg image;

    /**
     * 语音
     */
    private VoiceMsg voice;

    /**
     * 视频
     */
    private VideoMsg video;

    /**
     * 音乐
     */
    private MusicMsg music;

    /**
     * 图文(外链)
     */
    private NewsMsg news;

    /**
     * 图文(微信素材库)
     */
    private SingleNewMsg mpnews;

    /**
     *卡券
     */
    private WxCardMsg wxcard;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public TextMsg getText() {
        return text;
    }

    public void setText(TextMsg text) {
        this.text = text;
    }

    public ImageMsg getImage() {
        return image;
    }

    public void setImage(ImageMsg image) {
        this.image = image;
    }

    public VoiceMsg getVoice() {
        return voice;
    }

    public void setVoice(VoiceMsg voice) {
        this.voice = voice;
    }

    public VideoMsg getVideo() {
        return video;
    }

    public void setVideo(VideoMsg video) {
        this.video = video;
    }

    public MusicMsg getMusic() {
        return music;
    }

    public void setMusic(MusicMsg music) {
        this.music = music;
    }

    public NewsMsg getNews() {
        return news;
    }

    public void setNews(NewsMsg news) {
        this.news = news;
    }

    public SingleNewMsg getMpnews() {
        return mpnews;
    }

    public void setMpnews(SingleNewMsg mpnews) {
        this.mpnews = mpnews;
    }

    public WxCardMsg getWxcard() {
        return wxcard;
    }

    public void setWxcard(WxCardMsg wxcard) {
        this.wxcard = wxcard;
    }

    /**
     * 图片客服消息
     * @author zhiguang
     */
    public static class ImageMsg {

        private String media_id;

        public ImageMsg(String media_id) {
            this.media_id = media_id;
        }

        public String getMedia_id() {
            return media_id;
        }

        public void setMedia_id(String media_id) {
            this.media_id = media_id;
        }
    }

    /**
     * 音乐客服消息
     * @author zhiguang
     */
    public static class MusicMsg {

        private String title;

        private String description;

        private String musicurl;

        private String hqmusicurl;

        private String thumb_media_id;

        public MusicMsg(String title, String description, String musicurl, String hqmusicurl, String thumb_media_id) {
            this.title = title;
            this.description = description;
            this.musicurl = musicurl;
            this.hqmusicurl = hqmusicurl;
            this.thumb_media_id = thumb_media_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getMusicurl() {
            return musicurl;
        }

        public void setMusicurl(String musicurl) {
            this.musicurl = musicurl;
        }

        public String getHqmusicurl() {
            return hqmusicurl;
        }

        public void setHqmusicurl(String hqmusicurl) {
            this.hqmusicurl = hqmusicurl;
        }

        public String getThumb_media_id() {
            return thumb_media_id;
        }

        public void setThumb_media_id(String thumb_media_id) {
            this.thumb_media_id = thumb_media_id;
        }
    }

    /**
     * 图文客服消息(可外链)
     * @author zhiguang
     */
    public static class NewsMsg {

        private List<Article> articles;

        public NewsMsg(List<Article> articles) {
            this.articles = articles;
        }

        public List<Article> getArticles() {
            return articles;
        }

        public void setArticles(List<Article> articles) {
            this.articles = articles;
        }

        public static class Article {

            public Article(String title, String description, String picUrl, String url) {
                Title = title;
                Description = description;
                Picurl = picUrl;
                Url = url;
            }

            /**
             * 图文消息标题
             */
            private String Title;

            /**
             * 图文消息描述
             */
            private String Description;

            /**
             * 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
             */
            private String Picurl;

            /**
             * 点击图文消息跳转链接
             */
            private String Url;

            public String getTitle() {
                return Title;
            }

            public void setTitle(String title) {
                Title = title;
            }

            public String getDescription() {
                return Description;
            }

            public void setDescription(String description) {
                Description = description;
            }

            public String getPicurl() {
                return Picurl;
            }

            public void setPicurl(String picUrl) {
                Picurl = picUrl;
            }

            public String getUrl() {
                return Url;
            }

            public void setUrl(String url) {
                Url = url;
            }
        }
    }

    /**
     * 图文客服消息(微信素材库)
     * @author zhiguang
     */
    public static class SingleNewMsg {

        private String media_id;

        public SingleNewMsg(String media_id) {
            this.media_id = media_id;
        }

        public String getMedia_id() {
            return media_id;
        }

        public void setMedia_id(String media_id) {
            this.media_id = media_id;
        }
    }

    /**
     * 文本客服消息
     * @author zhiguang
     */
    public static class TextMsg {

        private String content;

        public TextMsg(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    /**
     * 视频客服消息
     * @author zhiguang
     */
    public static class VideoMsg {

        private String media_id;

        private String thumb_media_id;

        private String title;

        private String description;

        public VideoMsg(String media_id, String thumb_media_id, String title, String description) {
            this.media_id = media_id;
            this.thumb_media_id = thumb_media_id;
            this.title = title;
            this.description = description;
        }

        public String getMedia_id() {
            return media_id;
        }

        public void setMedia_id(String media_id) {
            this.media_id = media_id;
        }

        public String getThumb_media_id() {
            return thumb_media_id;
        }

        public void setThumb_media_id(String thumb_media_id) {
            this.thumb_media_id = thumb_media_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    /**
     * 语音客服消息
     * @author zhiguang
     */
    public static class VoiceMsg {

        private String media_id;

        public VoiceMsg(String media_id) {
            this.media_id = media_id;
        }

        public String getMedia_id() {
            return media_id;
        }

        public void setMedia_id(String media_id) {
            this.media_id = media_id;
        }
    }

    /**
     * 卡券客服消息
     * @author zhiguang
     */
    public static class WxCardMsg {

        private String card_id;

        public WxCardMsg(String card_id) {
            this.card_id = card_id;
        }

        public String getCard_id() {
            return card_id;
        }

        public void setCard_id(String card_id) {
            this.card_id = card_id;
        }
    }



}
