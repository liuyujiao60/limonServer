package com.limon.controller;

import com.limon.common.service.CategoryService;
import com.limon.common.viewobject.CategoryVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/common")
public class CommonController {

    @Resource
    private CategoryService categoryService;

    @RequestMapping("/saveCategory")
    public Object saveCategory(@RequestBody CategoryVo categoryVo){
        categoryVo=categoryService.saveCategory(categoryVo);

        return categoryVo;
    }

    @RequestMapping("/getCategoryList")
    public Object getCategoryList(String categoryId){
        if(StringUtils.isNotEmpty(categoryId)) {
            List<CategoryVo> categoryVoList = categoryService.getCategoryListByParentId(categoryId);
            return categoryVoList;
        }else{
            List<CategoryVo> categoryVoList = categoryService.getCategoryListByLevel(1);
            return categoryVoList;
        }


    }
}
