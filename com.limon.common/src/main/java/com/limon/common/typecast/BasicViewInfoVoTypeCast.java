package com.limon.common.typecast;

import com.limon.common.entity.BasicViewInfo;
import com.limon.common.enums.ViewInfoStatusEnum;
import com.limon.common.enums.ViewInfoTypeEnum;
import com.limon.common.service.CategoryService;
import com.limon.common.viewobject.BasicViewInfoVo;
import com.limon.common.viewobject.DateVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.function.Function;

@Slf4j
@Service
public class BasicViewInfoVoTypeCast {

    @Resource
    private CategoryService categoryService;

    public Function<BasicViewInfoVo, BasicViewInfo> VO_ENTITY= input->{
        BasicViewInfo output=new BasicViewInfo();

        output.setStatus(input.getViewInfoStatus()!=null?input.getViewInfoStatus().getStatus():0);
        output.setType(input.getViewInfoType()!=null?input.getViewInfoType().getType():0);
        output.setCategoryId(input.getCategoryVo()!=null?input.getCategoryVo().getId():null);
        return output;
    };

    public Function<BasicViewInfo, BasicViewInfoVo> ENTITY_VO= input->{
        BasicViewInfoVo output=new BasicViewInfoVo();

        output.setId(input.getId());
        output.setViewInfoStatus(ViewInfoStatusEnum.findByStatus(input.getStatus()));
        output.setViewInfoType(ViewInfoTypeEnum.findByType(input.getType()));
        output.setCategoryVo(categoryService.getCategoryById(input.getCategoryId()));
        output.setCreateTime(new DateVo(input.getCreateTime()));
        return output;
    };
}
