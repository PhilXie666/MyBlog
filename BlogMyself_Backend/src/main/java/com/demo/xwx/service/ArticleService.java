package com.demo.xwx.service;

import com.demo.xwx.entity.Article;

public interface ArticleService {

    // 获取最新的一篇文章
    public Article getNewestArticle();

    // 保存一篇文章
    public Integer saveArticle(Article article);

}
