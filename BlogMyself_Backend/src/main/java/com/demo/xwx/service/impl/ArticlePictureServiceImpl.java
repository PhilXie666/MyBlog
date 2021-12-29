package com.demo.xwx.service.impl;

import com.demo.xwx.entity.Article;
import com.demo.xwx.entity.ArticlePicture;
import com.demo.xwx.mapper.ArticlePictureDao;
import com.demo.xwx.service.ArticlePictureService;
import com.demo.xwx.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ArticlePictureService")
public class ArticlePictureServiceImpl implements ArticlePictureService {

    @Autowired
    private ArticlePictureDao articlePictureDao;

    @Override
    public List<ArticlePicture> selectAnArtPictures(String id) {
        return articlePictureDao.selectAnArtPictures(id);
    }
}
