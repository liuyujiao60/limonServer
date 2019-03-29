package com.limon.user.typecast;

import com.limon.common.enums.SexEnums;
import com.limon.common.service.RegionInfoService;
import com.limon.common.viewobject.DateVo;
import com.limon.core.util.MD5Utils;
import com.limon.user.entity.UserInfo;
import com.limon.user.enums.UserSourceEnums;
import com.limon.user.viewobject.UserInfoVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.function.Function;

@Service
public class UserInfoTypeCast {

    @Resource
    private RegionInfoService regionInfoService;

    public Function<UserInfoVo, UserInfo> VO_ENTITY = input -> {
        UserInfo output=new UserInfo();

        output.setId(input.getUserId());
        output.setUsername(input.getUsername());
        output.setPassword(MD5Utils.MD5Encode(input.getPassword(),"UTF-8"));
        output.setNickname(input.getNickname());
        output.setMobile(input.getMobile());
        if(input.getBirthday()!=null) {
            output.setBirthday(input.getBirthday().getTime());
        }
        if(input.getRegionInfo()!=null) {
            output.setRegionCode(input.getRegionInfo().getRegionCode());
        }
        output.setAddress(input.getAddress());
        if(input.getSex()!=null) {
            output.setSex(input.getSex().getCode());
        }
        output.setHeadImage(input.getHeadImage());
        if(input.getSource()!=null) {
            output.setSource(input.getSource().getCode());
        }
        return output;
    };

    public Function<UserInfo,UserInfoVo> ENTITY_VO = input -> {
        UserInfoVo output=new UserInfoVo();

        output.setUserId(input.getId());
        output.setUsername(input.getUsername());
        output.setPassword(input.getPassword());
        output.setNickname(input.getNickname());
        output.setMobile(input.getMobile());
        output.setBirthday(new DateVo(input.getBirthday()));
        output.setRegionInfo(regionInfoService.getRegionInfoByCode(input.getRegionCode()));
        output.setAddress(input.getAddress());
        output.setSex(SexEnums.findSexEnums(input.getSex()));
        output.setHeadImage(input.getHeadImage());
        output.setRegistTime(new DateVo(input.getRegistTime()));
        output.setLastLoginTime(new DateVo(input.getLastLoginTime()));
        output.setSource(UserSourceEnums.findUserSourceEnums(input.getSource()));
        return output;
    };


}
