package com.zhaozhiguang.component.weixin.pojo.req.message;

import com.zhaozhiguang.component.weixin.pojo.SupportMsg;
import com.zhaozhiguang.component.weixin.pojo.req.Article;

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

}
