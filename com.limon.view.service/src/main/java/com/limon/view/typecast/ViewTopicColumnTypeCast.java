package com.limon.view.typecast;

import com.limon.common.viewobject.DateVo;
import com.limon.view.entity.ViewTopicColumn;
import com.limon.view.enums.ViewTopicColumnStatusEnum;
import com.limon.view.viewobject.ViewTopicColumnVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Slf4j
@Service
public class ViewTopicColumnTypeCast {

    public Function<ViewTopicColumn, ViewTopicColumnVo> ENTITY_VO= input->{
        ViewTopicColumnVo output=new ViewTopicColumnVo();

        output.setId(input.getId());
        output.setName(input.getName());
        output.setRemark(input.getRemark());
        output.setStatus(ViewTopicColumnStatusEnum.findByStatus(input.getStatus()));
        output.setCreateTime(new DateVo(input.getCreateTime()));
        return output;
    };

    public Function<ViewTopicColumnVo, ViewTopicColumn> VO_ENTITY= input->{
        ViewTopicColumn output=new ViewTopicColumn();

        output.setId(input.getId());
        output.setName(input.getName());
        output.setRemark(input.getRemark());
        output.setStatus(input.getStatus().getStatus());
        output.setViewTopicId(input.getViewTopicVo().getId());
        output.setCreateTime(input.getCreateTime()!=null?input.getCreateTime().getTime():0);
        return output;
    };
}
