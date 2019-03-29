package com.limon.user.dao.provider;

import com.limon.core.exception.ServerException;
import com.limon.user.entity.UserInfo;
import com.limon.user.enums.ExceptionEnum;
import org.apache.commons.lang3.StringUtils;

public class UserInfoMapperProvider {

    public String updateUserInfo(UserInfo userInfo){
        StringBuilder sql=new StringBuilder("update user_info set ");
        boolean hasUpdateItem=false;
        if(StringUtils.isNoneEmpty(userInfo.getPassword())){
            sql.append(" password=#{password},");
            hasUpdateItem=true;
        }
        if(StringUtils.isNoneEmpty(userInfo.getNickname())){
            sql.append(" nickname=#{nickname},");
            hasUpdateItem=true;
        }
        if(StringUtils.isNoneEmpty(userInfo.getMobile())){
            sql.append(" mobile=#{mobile},");
            hasUpdateItem=true;
        }
        if(userInfo.getBirthday()>0){
            sql.append(" birthday=#{birthday},");
            hasUpdateItem=true;
        }
        if(StringUtils.isNoneEmpty(userInfo.getRegionCode())){
            sql.append(" regionCode=#{regionCode},");
            hasUpdateItem=true;
        }
        if(StringUtils.isNoneEmpty(userInfo.getAddress())){
            sql.append(" address=#{address},");
            hasUpdateItem=true;
        }
        if(userInfo.getSex()>0){
            sql.append(" sex=#{sex},");
            hasUpdateItem=true;
        }
        if(StringUtils.isNoneEmpty(userInfo.getHeadImage())){
            sql.append(" headImage=#{headImage},");
            hasUpdateItem=true;
        }
        if(hasUpdateItem) {
            sql = sql.deleteCharAt(sql.length() - 1);

            sql.append(" where id=#{id}");

            return sql.toString();
        }else{
            throw new ServerException(ExceptionEnum.USER_INFO_UPDATE_ERROR,null);
        }
    }
}
