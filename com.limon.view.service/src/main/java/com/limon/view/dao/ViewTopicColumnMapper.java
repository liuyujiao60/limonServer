package com.limon.view.dao;

import com.limon.view.entity.ViewTopicColumn;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ViewTopicColumnMapper {

    @Insert("insert into view_topic_column(id,name,remark,viewTopicId,createTime) values(#{id},#{name},#{remark},#{viewTopicId},#{createTime})")
    public void insert(ViewTopicColumn viewTopicColumn);

    @Select("select * from view_topic_column where viewTopicId=#{viewTopicId} and status=1")
    public List<ViewTopicColumn> getViewTopicColumnListByViewTopicId(String viewTopicId);

    @Select("select * from view_topic_column where id=#{id}")
    public ViewTopicColumn getViewTopicColumnById(String id);
}
