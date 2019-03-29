package com.limon.user.dao;

import com.limon.core.annotation.TargetDataSource;
import com.limon.user.contants.Contants;
import com.limon.user.dao.provider.UserInfoMapperProvider;
import com.limon.user.entity.UserInfo;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserInfoMapper {

    @Select("select count(1) from user_info where username=#{username}")
    public Integer usernameExist(String username);

    @Select("select * from user_info where username=#{username} and password=#{passwordMD5} and status=1")
    public UserInfo userLogin(@Param("username") String username, @Param("passwordMD5") String passwordMD5);

    @Select("select * from user_info where id=#{userId}")
    public UserInfo getUserInfoById(String userId);

    @Update("update user_info set lastLoginTime=#{loginTime} where id=#{userId}")
    public Integer updateUserLoginTime(@Param("userId") String userId,@Param("loginTime") long loginTime);

    @Insert("insert into user_info(id,username,password,nickname,mobile,birthday,regionCode,address,sex,registTime,lastLoginTime,headImage,source)" +
            " values(#{id},#{username},#{password},#{nickname},#{mobile},#{birthday},#{regionCode},#{address},#{sex},#{registTime},#{lastLoginTime},#{headImage},#{source})")
    public void userRegist(UserInfo userInfo);

    @UpdateProvider(type=UserInfoMapperProvider.class,method = "updateUserInfo")
    public Integer updateUserInfo(UserInfo userInfo);
}
