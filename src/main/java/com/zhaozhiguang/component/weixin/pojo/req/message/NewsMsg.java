package com.zhaozhiguang.component.weixin.pojo.req.message;

import com.zhaozhiguang.component.weixin.pojo.SupportMsg;

import java.util.List;

/**
 * 图文消息
 * 消息类型: news
 * @author zhiguang
 */
public class NewsMsg extends SupportMsg {

    /**
     * 图文消息个数，限制为8条以内
     */
    private Integer ArticleCount;

    /**
     * 多条图文消息信息，默认第一个item为大图,注意，如果图文数超过8，则将会无响应
     */
    private List<Article> Articles;

    public Integer getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(Integer articleCount) {
        ArticleCount = articleCount;
    }

    public List<Article> getArticles() {
        return Articles;
    }

    public void setArticles(List<Article> articles) {
        Articles = articles;
    }

    public static class Article {

        public Article(String title, String description, String picUrl, String url) {
            Title = title;
            Description = description;
            PicUrl = picUrl;
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
        private String PicUrl;

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

        public String getPicUrl() {
            return PicUrl;
        }

        public void setPicUrl(String picUrl) {
            PicUrl = picUrl;
        }

        public String getUrl() {
            return Url;
        }

        public void setUrl(String url) {
            Url = url;
        }
    }

}
