package com.limon.controller;

import com.limon.view.entity.ViewTopic;
import com.limon.view.entity.ViewTopicColumn;
import com.limon.view.service.ViewTopicService;
import com.limon.view.viewobject.ViewTopicColumnDetailVo;
import com.limon.view.viewobject.ViewTopicColumnVo;
import com.limon.view.viewobject.ViewTopicVo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/viewTopic")
public class ViewTopicController {

    @Resource
    private ViewTopicService viewTopicService;

    @RequestMapping("/saveViewTopic")
    public Object saveViewTopic(@RequestBody ViewTopicVo viewTopicVo){
        viewTopicVo=viewTopicService.saveViewTopicVo(viewTopicVo);
        return viewTopicVo;
    }

    @RequestMapping("/saveViewTopicColumn")
    public Object saveViewTopicColumn(@RequestBody ViewTopicColumnVo viewTopicColumnVo){
        viewTopicColumnVo=viewTopicService.saveViewTopicColumnVo(viewTopicColumnVo);
        return viewTopicColumnVo;
    }

    @RequestMapping("/saveViewTopicColumnDetail")
    public Object saveViewTopicColumnDetail(@RequestBody ViewTopicColumnDetailVo viewTopicColumnDetailVo){
        viewTopicColumnDetailVo=viewTopicService.saveViewTopicColumnDetailVo(viewTopicColumnDetailVo);
        return viewTopicColumnDetailVo;
    }
}
