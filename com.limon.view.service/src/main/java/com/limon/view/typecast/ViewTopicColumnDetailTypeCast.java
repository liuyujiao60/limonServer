package com.limon.view.typecast;

import com.limon.common.viewobject.DateVo;
import com.limon.view.entity.ViewTopicColumnDetail;
import com.limon.view.service.ViewService;
import com.limon.view.service.ViewTopicService;
import com.limon.view.viewobject.ViewTopicColumnDetailVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.function.Function;

@Slf4j
@Service
public class ViewTopicColumnDetailTypeCast {

    @Resource
    private ViewTopicService viewTopicService;

    @Resource
    private ViewService viewService;

    public Function<ViewTopicColumnDetailVo, ViewTopicColumnDetail> VO_ENTITY= input->{
        ViewTopicColumnDetail output=new ViewTopicColumnDetail();

        output.setId(input.getId());
        output.setViewTopicColumnId(input.getViewTopicColumnVo().getId());
        output.setViewTopicId(input.getViewTopicColumnVo().getViewTopicVo().getId());
        output.setBasicViewInfoId(input.getViewInfoVo().getId());
        output.setCreateTime(input.getCreateTime()!=null?input.getCreateTime().getTime():0);
        return output;
    };

    public Function<ViewTopicColumnDetail, ViewTopicColumnDetailVo> ENTITY_VO= input->{
        ViewTopicColumnDetailVo output=new ViewTopicColumnDetailVo();

        output.setId(input.getId());
        output.setViewTopicColumnVo(viewTopicService.getViewTopicColumnById(input.getViewTopicColumnId()));
        output.setViewInfoVo(viewService.getViewInfoById(input.getBasicViewInfoId()));
        output.setOrderNum(input.getOrderNum());
        output.setCreateTime(new DateVo(input.getCreateTime()));
        return output;
    };
}
