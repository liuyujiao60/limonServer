package com.limon.controller;


import com.limon.article.service.ArticleService;
import com.limon.article.viewobject.*;
import com.limon.common.service.CategoryService;
import com.limon.common.viewobject.CategoryVo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @RequestMapping("/saveArticle")
    public Object saveArticle(@RequestBody ArticleVo articleVo){

        articleVo=articleService.saveArticle(articleVo);

        return articleVo;
    }

}
