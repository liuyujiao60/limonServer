package com.limon.user.service;

import com.alibaba.fastjson.JSONObject;
import com.limon.core.common.IdGenarator;
import com.limon.core.common.TransactionEvent;
import com.limon.core.exception.ServerException;
import com.limon.core.util.HttpUrl;
import com.limon.core.util.MD5Utils;
import com.limon.user.contants.Contants;
import com.limon.user.dao.UserInfoMapper;
import com.limon.user.entity.UserInfo;
import com.limon.user.enums.ExceptionEnum;
import com.limon.user.typecast.UserInfoTypeCast;
import com.limon.user.viewobject.UserInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.security.provider.MD5;

import javax.annotation.Resource;

@Slf4j
@Service
public class UserInfoService {

    @Resource
    private UserInfoTypeCast userInfoTypeCast;

    @Resource
    private UserInfoMapper userInfoMapper;

    public Boolean usernameExist(String username){
        Integer result=userInfoMapper.usernameExist(username);
        return result>0;
    }

    @Transactional(rollbackFor = Exception.class,transactionManager = "userDataSourceTransactionManager")
    public UserInfoVo userLogin(String username,String password){
        UserInfo userInfo=userInfoMapper.userLogin(username, MD5Utils.MD5Encode(password,"UTF-8"));
        if(userInfo!=null){
            userInfoMapper.updateUserLoginTime(userInfo.getId(),System.currentTimeMillis());
            return userInfoTypeCast.ENTITY_VO.apply(userInfo);
        }else{
            throw new ServerException(ExceptionEnum.LOGIN_ERROR,null);
        }
    }

    @Transactional(rollbackFor = Exception.class,transactionManager = "userDataSourceTransactionManager")
    public UserInfoVo userRegist(UserInfoVo userInfoVo){

        UserInfo userInfo=userInfoTypeCast.VO_ENTITY.apply(userInfoVo);

        if(!this.usernameExist(userInfo.getUsername())) {
            userInfo.setId(IdGenarator.getStringId());
            userInfo.setRegistTime(System.currentTimeMillis());
            userInfo.setLastLoginTime(System.currentTimeMillis());
            userInfoMapper.userRegist(userInfo);

            return userInfoTypeCast.ENTITY_VO.apply(userInfo);
        }else{
            throw new ServerException(ExceptionEnum.USERNAME_EXISTED,null);
        }
    }

    public UserInfoVo updateUserInfo(UserInfoVo userInfoVo){
        UserInfo userInfo=userInfoTypeCast.VO_ENTITY.apply(userInfoVo);

        Integer updateCount=userInfoMapper.updateUserInfo(userInfo);

        if(updateCount>0){
            userInfo=userInfoMapper.getUserInfoById(userInfo.getId());

            return userInfoTypeCast.ENTITY_VO.apply(userInfo);
        }else{
            throw new ServerException(ExceptionEnum.USERNAME_NOT_EXISTED,null);
        }
    }

    public String getWxUserOpenId(String reqCode){
        String result=HttpUrl.get(String.format(Contants.wxCode2SessionUrl,reqCode));
        if(result!=null){
            JSONObject resultObject=JSONObject.parseObject(result);

            if(resultObject.containsKey("openid")){
                return resultObject.getString("openid");
            }
        }
        return null;
    }

    public UserInfoVo getUserInfoById(String userId){
        UserInfo userInfo=userInfoMapper.getUserInfoById(userId);

        UserInfoVo userInfoVo=userInfoTypeCast.ENTITY_VO.apply(userInfo);

        return userInfoVo;
    }
}
