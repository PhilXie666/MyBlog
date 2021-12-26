package com.demo.xwx.service.impl;

import com.demo.xwx.entity.Article;
import com.demo.xwx.mapper.ArticleDao;
import com.demo.xwx.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ArticleService")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDao articleDao;

    // 获取最新的一篇文章
    @Override
    public Article getNewestArticle() {
        return articleDao.getNewestArticle();
    }

}
