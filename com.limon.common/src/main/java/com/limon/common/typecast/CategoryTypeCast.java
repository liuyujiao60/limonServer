package com.limon.common.typecast;

import com.limon.common.entity.Category;
import com.limon.common.service.CategoryService;
import com.limon.common.viewobject.CategoryVo;
import com.limon.common.viewobject.DateVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.function.Function;

@Slf4j
@Service
public class CategoryTypeCast {

    @Resource
    private CategoryService articleCategoryService;

    public Function<Category, CategoryVo> ENTITY_VO = input ->{
        CategoryVo output=new CategoryVo();

        output.setId(input.getId());
        output.setName(input.getName());
        output.setLevel(input.getLevel());
        output.setParentCategoryVo(articleCategoryService.getCategoryById(input.getPid()));
        output.setCreateTime(new DateVo(input.getCreateTime()));
        return output;
    };

    public Function<CategoryVo, Category> VO_ENTITY = input ->{
        Category output=new Category();

        output.setId(input.getId());
        output.setName(input.getName());
        output.setLevel(input.getLevel());
        output.setPid(input.getParentCategoryVo()!=null?input.getParentCategoryVo().getId():null);
        output.setCreateTime(input.getCreateTime()!=null?input.getCreateTime().getTime():null);
        return output;
    };

}
