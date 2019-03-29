package com.limon.view.service;
import com.limon.common.enums.ViewInfoStatusEnum;
import com.limon.common.enums.ViewInfoTypeEnum;
import com.limon.common.service.BasicViewInfoService;
import com.limon.core.request.Page;
import com.limon.view.dao.ViewTopicColumnDetailMapper;
import com.limon.view.dao.ViewTopicColumnMapper;
import com.limon.view.dao.ViewTopicMapper;
import com.limon.view.entity.ViewTopic;
import com.limon.view.entity.ViewTopicColumn;
import com.limon.view.entity.ViewTopicColumnDetail;
import com.limon.view.typecast.ViewTopicColumnDetailTypeCast;
import com.limon.view.typecast.ViewTopicColumnTypeCast;
import com.limon.view.typecast.ViewTopicTypeCast;
import com.limon.common.viewobject.BasicViewInfoVo;
import com.limon.common.viewobject.DateVo;
import com.limon.view.viewobject.ViewTopicColumnDetailVo;
import com.limon.view.viewobject.ViewTopicColumnVo;
import com.limon.view.viewobject.ViewTopicVo;
import com.limon.core.common.IdGenarator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ViewTopicService {

    @Resource
    private ViewTopicMapper viewTopicMapper;

    @Resource
    private ViewTopicColumnMapper viewTopicColumnMapper;

    @Resource
    private ViewTopicTypeCast viewTopicTypeCast;

    @Resource
    private ViewTopicColumnTypeCast viewTopicColumnTypeCast;

    @Resource
    private BasicViewInfoService basicViewInfoService;

    @Resource
    private ViewTopicColumnDetailTypeCast viewTopicColumnDetailTypeCast;

    @Resource
    private ViewTopicColumnDetailMapper viewTopicColumnDetailMapper;

    public ViewTopicVo saveViewTopicVo(ViewTopicVo viewTopicVo){

        ViewTopic viewTopic=viewTopicTypeCast.VO_ENTITY.apply(viewTopicVo);

        BasicViewInfoVo basicViewInfoVo=basicViewInfoService.saveBasicViewInfo(new BasicViewInfoVo(IdGenarator.getStringId(), viewTopicVo.getCategoryVo(), ViewInfoTypeEnum.TOPIC, ViewInfoStatusEnum.PASSED,
                new DateVo(System.currentTimeMillis())));

        viewTopic.setId(basicViewInfoVo.getId());
        viewTopicMapper.insert(viewTopic);
        viewTopicVo.setBasicViewInfoVo(basicViewInfoVo);
        return viewTopicVo;
    }

    public ViewTopicColumnVo saveViewTopicColumnVo(ViewTopicColumnVo viewTopicColumnVo){
        ViewTopicColumn viewTopicColumn=viewTopicColumnTypeCast.VO_ENTITY.apply(viewTopicColumnVo);

        viewTopicColumn.setId(IdGenarator.getStringId());
        viewTopicColumn.setCreateTime(System.currentTimeMillis());
        viewTopicColumnMapper.insert(viewTopicColumn);
        viewTopicColumnVo.setId(viewTopicColumn.getId());

        return viewTopicColumnVo;
    }

    public ViewTopicColumnDetailVo saveViewTopicColumnDetailVo(ViewTopicColumnDetailVo viewTopicColumnDetailVo){
        ViewTopicColumnDetail viewTopicColumnDetail=viewTopicColumnDetailTypeCast.VO_ENTITY.apply(viewTopicColumnDetailVo);

        viewTopicColumnDetail.setId(IdGenarator.getStringId());
        viewTopicColumnDetail.setCreateTime(System.currentTimeMillis());
        viewTopicColumnDetailMapper.insert(viewTopicColumnDetail);

        viewTopicColumnDetailVo=viewTopicColumnDetailTypeCast.ENTITY_VO.apply(viewTopicColumnDetail);
        return viewTopicColumnDetailVo;
    }

    public ViewTopicVo getViewTopicById(BasicViewInfoVo basicViewInfoVo){
        ViewTopic viewTopic=viewTopicMapper.getViewTopicById(basicViewInfoVo.getId());

        ViewTopicVo viewTopicVo=viewTopicTypeCast.ENTITY_VO.apply(viewTopic);
        viewTopicVo.setBasicViewInfoVo(basicViewInfoVo);
        return viewTopicVo;
    }

    public ViewTopicColumnVo getViewTopicColumnById(String id){
        ViewTopicColumn viewTopicColumn=viewTopicColumnMapper.getViewTopicColumnById(id);
        ViewTopicColumnVo viewTopicColumnVo=viewTopicColumnTypeCast.ENTITY_VO.apply(viewTopicColumn);
        BasicViewInfoVo basicViewInfoVo=basicViewInfoService.getBasicViewInfoById(viewTopicColumn.getViewTopicId());
        viewTopicColumnVo.setViewTopicVo(this.getViewTopicById(basicViewInfoVo));

        return viewTopicColumnVo;
    }

    public List<ViewTopicColumnVo> getViewTopicColumnListByTopicVo(ViewTopicVo viewTopicVo){
        List<ViewTopicColumnVo> result=new ArrayList<>();

        List<ViewTopicColumn> viewTopicColumnList=viewTopicColumnMapper.getViewTopicColumnListByViewTopicId(viewTopicVo.getId());
        if(CollectionUtils.isNotEmpty(viewTopicColumnList)) {
            viewTopicColumnList.stream().forEach(viewTopicColumn -> {
                ViewTopicColumnVo viewTopicColumnVo = viewTopicColumnTypeCast.ENTITY_VO.apply(viewTopicColumn);
                viewTopicColumnVo.setViewTopicVo(viewTopicVo);
                result.add(viewTopicColumnVo);
            });
        }
        return result;
    }

    public List<ViewTopicColumnDetailVo> getViewTopicColumnDetailListByColumnId(String viewTopicColumnId, Page page){
        List<ViewTopicColumnDetailVo> result=new ArrayList<>();

        List<ViewTopicColumnDetail> viewTopicColumnDetailList=viewTopicColumnDetailMapper.getViewTopicColumnDetailByColumnId(viewTopicColumnId,page);

        viewTopicColumnDetailList.stream().forEach(viewTopicColumnDetail -> {
            result.add(viewTopicColumnDetailTypeCast.ENTITY_VO.apply(viewTopicColumnDetail));
        });
        return result;
    }
}
