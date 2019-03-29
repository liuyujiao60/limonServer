package com.limon.article.typecast;

import com.limon.article.entity.Article;
import com.limon.article.enums.ArticleWriteTypeEnum;
import com.limon.article.viewobject.ArticleVo;
import com.limon.common.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.function.Function;

@Slf4j
@Service
public class ArticleTypeCast {

    @Resource
    private CategoryService categoryService;

    public Function<ArticleVo, Article> VO_ENTITY=input->{
        Article output=new Article();

        output.setShortTitle(input.getShortTitle());
        output.setTitle(input.getTitle());
        output.setImage(input.getImage());
        output.setUrl(input.getUrl());
        output.setCategoryId(input.getCategoryVo().getId());
        output.setWriteType(input.getWriteType().getCode());
        return output;
    };

    public Function<Article, ArticleVo> ENTITY_VO=input->{
        ArticleVo output=new ArticleVo();

        output.setShortTitle(input.getShortTitle());
        output.setTitle(input.getTitle());
        output.setImage(input.getImage());
        output.setUrl(input.getUrl());
        output.setCategoryVo(categoryService.getCategoryById(input.getCategoryId()));
        output.setWriteType(ArticleWriteTypeEnum.findByCode(input.getWriteType()));
        return output;
    };

}
