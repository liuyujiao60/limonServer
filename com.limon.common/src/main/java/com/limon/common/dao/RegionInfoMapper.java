package com.limon.common.dao;

import com.limon.common.contants.Contants;
import com.limon.common.entity.RegionInfo;
import com.limon.core.annotation.TargetDataSource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RegionInfoMapper {

    @Select("select * from region_info where regionCode=#{regionCode}")
    public RegionInfo getRegionInfoByCode(String regionCode);
}
