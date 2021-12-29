package com.demo.xwx.service;

import com.demo.xwx.entity.ArticlePicture;

import java.util.List;

public interface ArticlePictureService {

    // 查询一篇文章的所有图片
    public List<ArticlePicture> selectAnArtPictures(String id);

}
