package com.limon.view.service;

import com.limon.article.service.ArticleService;
import com.limon.common.enums.ViewInfoTypeEnum;
import com.limon.common.service.BasicViewInfoService;
import com.limon.common.viewobject.BasicViewInfoVo;
import com.limon.core.request.Page;
import com.limon.view.viewobject.ViewTopicColumnDetailVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ViewService {

    @Resource
    private BasicViewInfoService basicViewInfoService;

    @Resource
    private ArticleService articleService;

    @Resource
    private ViewTopicService viewTopicService;

    public BasicViewInfoVo getViewInfoById(String id){
        BasicViewInfoVo viewInfoVo=basicViewInfoService.getBasicViewInfoById(id);

        if(viewInfoVo.getViewInfoType()== ViewInfoTypeEnum.TOPIC){
            viewInfoVo=viewTopicService.getViewTopicById(viewInfoVo);
        }else if(viewInfoVo.getViewInfoType()== ViewInfoTypeEnum.ARTICLE){
            viewInfoVo=articleService.getArticleById(viewInfoVo);
        }

        return viewInfoVo;
    }

    private BasicViewInfoVo getViewInfoById(BasicViewInfoVo viewInfoVo){

        if(viewInfoVo.getViewInfoType()== ViewInfoTypeEnum.TOPIC){
            return viewTopicService.getViewTopicById(viewInfoVo);
        }else if(viewInfoVo.getViewInfoType()== ViewInfoTypeEnum.ARTICLE){
            return articleService.getArticleById(viewInfoVo);
        }
        return null;
    }

    public List<BasicViewInfoVo> getViewInfoListByCategoryId(String categoryId, Page page){
        List<BasicViewInfoVo> result=new ArrayList<>();

        List<BasicViewInfoVo> basicViewInfoVoList=basicViewInfoService.getBasicViewInfoByCategoryId(categoryId,page);

        basicViewInfoVoList.stream().forEach(basicViewInfoVo -> {
            result.add(this.getViewInfoById(basicViewInfoVo));
        });

        return result;
    }

    public List<BasicViewInfoVo> getViewInfoListByViewTopicColumnId(String viewTopicColumnId,Page page){
        List<BasicViewInfoVo> result=new ArrayList<>();

        List<ViewTopicColumnDetailVo> viewTopicColumnDetailVoList=viewTopicService.getViewTopicColumnDetailListByColumnId(viewTopicColumnId,page);

        viewTopicColumnDetailVoList.stream().forEach(viewTopicColumnDetailVo -> {
            result.add(viewTopicColumnDetailVo.getViewInfoVo());
        });

        return result;
    }
}
