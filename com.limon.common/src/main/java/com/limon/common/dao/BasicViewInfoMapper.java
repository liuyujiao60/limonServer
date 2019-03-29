package com.limon.common.dao;

import com.limon.common.dao.provider.BasicViewInfoProvider;
import com.limon.common.entity.BasicViewInfo;
import com.limon.core.request.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BasicViewInfoMapper {

    @Insert("insert into basic_view_info values(#{id},#{type},#{status},#{createTime},#{categoryId})")
    public void insert(BasicViewInfo basicViewInfo);

    @Select("select * from basic_view_info where id=#{id}")
    public BasicViewInfo getBasicViewInfoById(String id);

    @SelectProvider(type= BasicViewInfoProvider.class,method = "getBasicViewInfoByIdList")
    public List<BasicViewInfo> getBasicViewInfoByIdList(List<String> idList);

    @Select("select * from basic_view_info where categoryId=#{categoryId} limit #{page.current},#{page.pageSize}")
    public List<BasicViewInfo> getBasicViewInfoByCategoryId(@Param("categoryId")String categoryId, @Param("page") Page page);

    @Select("select * from basic_view_info limit #{page.current},#{page.pageSize}")
    public List<BasicViewInfo> getBasicViewInfoList(@Param("page") Page page);
}
