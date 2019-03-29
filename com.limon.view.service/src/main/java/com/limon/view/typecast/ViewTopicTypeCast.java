package com.limon.view.typecast;

import com.limon.view.entity.ViewTopic;
import com.limon.view.viewobject.ViewTopicVo;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ViewTopicTypeCast {

    public Function<ViewTopicVo, ViewTopic> VO_ENTITY= input->{
        ViewTopic output=new ViewTopic();

        output.setId(input.getId());
        output.setName(input.getName());
        output.setRemark(input.getRemark());
        output.setImage(input.getImage());
        return output;
    };

    public Function<ViewTopic,ViewTopicVo> ENTITY_VO=input->{
        ViewTopicVo output=new ViewTopicVo();

        output.setId(input.getId());
        output.setName(input.getName());
        output.setRemark(input.getRemark());
        output.setImage(input.getImage());

        return output;
    };
}
