package com.demo.xwx.dao;

import lombok.Data;

import java.io.Serializable;

@Data
public class ArticleSaveDto implements Serializable {

    private String title;// 文章标题

    private String content;// 文章内容

}
