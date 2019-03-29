package com.limon.common.service;

import com.limon.common.dao.RegionInfoMapper;
import com.limon.common.entity.RegionInfo;
import com.limon.common.typecast.RegionInfoTypeCast;
import com.limon.common.viewobject.RegionVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class RegionInfoService {

    @Resource
    private RegionInfoMapper regionInfoMapper;

    public RegionVo getRegionInfoByCode(String regionCode){
        if(StringUtils.isEmpty(regionCode)){
            return null;
        }
        RegionInfo regionInfo=regionInfoMapper.getRegionInfoByCode(regionCode);

        if(regionInfo!=null){
            return RegionInfoTypeCast.ENTITY_VO.apply(regionInfo);
        }

        return null;
    }
}
