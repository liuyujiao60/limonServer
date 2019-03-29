package com.limon.common.service;

import com.limon.common.dao.CategoryMapper;
import com.limon.common.entity.Category;
import com.limon.common.typecast.CategoryTypeCast;
import com.limon.common.viewobject.CategoryVo;
import com.limon.common.viewobject.DateVo;
import com.limon.core.common.IdGenarator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private CategoryTypeCast categoryTypeCast;

    public CategoryVo getCategoryById(String categoryId){
        Category category=categoryMapper.getCategoryById(categoryId);

        if(category==null){
            return null;
        }

        CategoryVo CategoryVo=categoryTypeCast.ENTITY_VO.apply(category);

        return CategoryVo;
    }

    public CategoryVo saveCategory(CategoryVo categoryVo){
        Category category=categoryTypeCast.VO_ENTITY.apply(categoryVo);
        category.setId(IdGenarator.getStringId());
        category.setCreateTime(System.currentTimeMillis());
        categoryMapper.insert(category);

        categoryVo.setId(category.getId());
        categoryVo.setCreateTime(new DateVo(category.getCreateTime()));

        return categoryVo;
    }

    public List<CategoryVo> getCategoryListByParentId(String parentCategoryId){
        List<CategoryVo> result=new ArrayList<>();

        List<Category> categoryList=categoryMapper.getChildCategoryListById(parentCategoryId);
        if(CollectionUtils.isNotEmpty(categoryList)) {
            categoryList.stream().forEach(category -> {
                result.add(categoryTypeCast.ENTITY_VO.apply(category));
            });
        }

        return result;
    }

    public List<CategoryVo> getCategoryListByLevel(int level){
        List<CategoryVo> result=new ArrayList<>();

        List<Category> categoryList=categoryMapper.getChildCategoryListByLevel(level);
        if(CollectionUtils.isNotEmpty(categoryList)) {
            categoryList.stream().forEach(category -> {
                result.add(categoryTypeCast.ENTITY_VO.apply(category));
            });
        }

        return result;
    }
}
