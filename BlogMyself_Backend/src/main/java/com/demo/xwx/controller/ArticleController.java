package com.demo.xwx.controller;

import com.demo.xwx.common.Result;
import com.demo.xwx.dao.ArticleSaveDto;
import com.demo.xwx.entity.Article;
import com.demo.xwx.entity.ArticlePicture;
import com.demo.xwx.service.ArticlePictureService;
import com.demo.xwx.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @Resource
    private ArticlePictureService articlePictureService;

    @GetMapping("/getNewestArticle")
    public Result getNewestArticle() {
        Article article = articleService.getNewestArticle();
        System.out.println("最新的一篇文章");
        System.out.println(article);
        Result res = new Result(true, "200", "查询成功", article);

        return res;
    }

    @GetMapping("/selectAnArtPictures")
    public Result selectAnArtPictures(@RequestParam("id") String id) {
        List<ArticlePicture> articlePictures = articlePictureService.selectAnArtPictures(id);
        Result res = new Result(true, "200", "查询成功", articlePictures);

        return res;
    }

    @PostMapping("/saveArticle")
    public Result saveArticle(@RequestBody ArticleSaveDto articleSaveDto) {
        Article article = new Article("000006", articleSaveDto.getTitle(), new Timestamp(System.currentTimeMillis()),
                new Timestamp(System.currentTimeMillis()), articleSaveDto.getContent());
        Integer id = articleService.saveArticle(article);
        Result res = new Result(true, "200", "保存成功", id + "");

        return res;
    }

}









































