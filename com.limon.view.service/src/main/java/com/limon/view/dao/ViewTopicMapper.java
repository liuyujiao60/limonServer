package com.limon.view.dao;

import com.limon.view.entity.ViewTopic;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ViewTopicMapper {

    @Insert("insert into view_topic values(#{id},#{name},#{remark},#{image})")
    public void insert(ViewTopic viewTopic);

    @Select("select * from view_topic where id=#{id}")
    public ViewTopic getViewTopicById(String id);
}
