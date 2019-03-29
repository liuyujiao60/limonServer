package com.limon.controller;

import com.limon.common.entity.BasicViewInfo;
import com.limon.common.viewobject.BasicViewInfoVo;
import com.limon.parameter.ViewInfoQueryParameter;
import com.limon.view.service.ViewService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/view")
public class ViewController {

    @Resource
    private ViewService viewService;

    @RequestMapping("/getViewInfoListByCategoryId")
    public Object getViewInfoListByCategoryId(@RequestBody ViewInfoQueryParameter viewInfoQueryParameter){
        List<BasicViewInfoVo> basicViewInfoVoList=viewService.getViewInfoListByCategoryId(viewInfoQueryParameter.getCategoryId(),viewInfoQueryParameter.getPage());

        return basicViewInfoVoList;
    }

    @RequestMapping("/getViewInfoListByColumnId")
    public Object getViewInfoListByColumnId(@RequestBody ViewInfoQueryParameter viewInfoQueryParameter){
        List<BasicViewInfoVo> basicViewInfoVoList=viewService.getViewInfoListByViewTopicColumnId(viewInfoQueryParameter.getViewTopicColumnId(),viewInfoQueryParameter.getPage());

        return basicViewInfoVoList;
    }
}
