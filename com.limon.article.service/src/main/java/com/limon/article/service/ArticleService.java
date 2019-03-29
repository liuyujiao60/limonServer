package com.limon.article.service;

import com.limon.article.dao.ArticleMapper;
import com.limon.article.entity.Article;
import com.limon.article.typecast.ArticleTypeCast;
import com.limon.article.viewobject.ArticleVo;
import com.limon.common.enums.ViewInfoStatusEnum;
import com.limon.common.enums.ViewInfoTypeEnum;
import com.limon.common.service.BasicViewInfoService;
import com.limon.common.viewobject.BasicViewInfoVo;
import com.limon.common.viewobject.DateVo;
import com.limon.core.common.IdGenarator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class ArticleService {

    @Resource
    private BasicViewInfoService basicViewInfoService;
    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private ArticleTypeCast articleTypeCast;

    public ArticleVo saveArticle(ArticleVo articleVo){
        BasicViewInfoVo basicViewInfoVo=new BasicViewInfoVo();

        basicViewInfoVo=basicViewInfoService.saveBasicViewInfo(new BasicViewInfoVo(IdGenarator.getStringId(), articleVo.getCategoryVo(), ViewInfoTypeEnum.ARTICLE, ViewInfoStatusEnum.PASSED,
                new DateVo(System.currentTimeMillis())));

        Article article=articleTypeCast.VO_ENTITY.apply(articleVo);
        article.setId(basicViewInfoVo.getId());
        articleMapper.insert(article);

        articleVo=articleTypeCast.ENTITY_VO.apply(article);
        articleVo.setBasicViewInfoVo(basicViewInfoVo);
        return articleVo;
    }

    public ArticleVo getArticleById(BasicViewInfoVo basicViewInfoVo){
        Article article=articleMapper.getArticleById(basicViewInfoVo.getId());

        ArticleVo articleVo=articleTypeCast.ENTITY_VO.apply(article);
        articleVo.setBasicViewInfoVo(basicViewInfoVo);
        return articleVo;
    }
}
