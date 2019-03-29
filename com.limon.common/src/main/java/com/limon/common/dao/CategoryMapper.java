package com.limon.common.dao;

import com.limon.common.entity.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {

    @Insert("insert into category values(#{id},#{name},#{level},#{pid},#{createTime})")
    public void insert(Category articleCategory);

    @Select("select * from category where id=#{id}")
    public Category getCategoryById(String id);

    @Select("select * from category where pid=#{parentCategoryId}")
    public List<Category> getChildCategoryListById(String parentCategoryId);

    @Select("select * from category where level=#{level}")
    public List<Category> getChildCategoryListByLevel(int level);
}
