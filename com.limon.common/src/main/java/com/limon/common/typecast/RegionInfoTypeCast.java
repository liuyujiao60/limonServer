package com.limon.common.typecast;

import com.limon.common.entity.RegionInfo;
import com.limon.common.viewobject.RegionVo;

import java.util.function.Function;

public class RegionInfoTypeCast {

    public final static Function<RegionInfo, RegionVo> ENTITY_VO= input->{
        RegionVo output=new RegionVo();

        output.setRegionCode(input.getRegionCode());
        output.setProvinceCode(input.getProvinceCode());
        output.setProvinceName(input.getProvinceName());
        output.setCityCode(input.getCityCode());
        output.setCityName(input.getCityName());
        output.setDistrictCode(input.getDistrictCode());
        output.setDistrictName(input.getDistrictName());
        output.setLevel(input.getLevel());

        return output;
    };
}
