package com.limon.view.dao;

import com.limon.core.request.Page;
import com.limon.view.entity.ViewTopicColumnDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ViewTopicColumnDetailMapper {

    @Insert("insert into view_topic_column_detail(id,viewTopicId,viewTopicColumnId,basicViewInfoId,createTime) values(#{id},#{viewTopicId},#{viewTopicColumnId},#{basicViewInfoId},#{createTime})")
    public void insert(ViewTopicColumnDetail viewTopicColumnDetail);

    @Select("select * from view_topic_column_detail where viewTopicColumnId=#{viewTopicColumnId} order by orderNum,createTime desc limit #{page.current},#{page.pageSize}")
    public List<ViewTopicColumnDetail> getViewTopicColumnDetailByColumnId(@Param("viewTopicColumnId") String viewTopicColumnId, @Param("page") Page page);
}
