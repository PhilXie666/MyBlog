package com.demo.xwx.controller;

import com.demo.xwx.common.Result;
import com.demo.xwx.entity.Article;
import com.demo.xwx.service.ArticleService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @GetMapping("/getNewestArticle")
    public Result getNewestArticle() {
        Article article = articleService.getNewestArticle();
        System.out.println("最新的一篇文章");
        System.out.println(article);
        Result res = new Result(true, "200", "查询成功", article);

        return res;
    }

}
