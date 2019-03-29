package com.limon.controller;

import com.limon.user.service.UserInfoService;
import com.limon.user.viewobject.UserInfoVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;

    @RequestMapping("/usernameExist")
    public Object usernameExist(String username){
        Boolean result=userInfoService.usernameExist(username);
        return result;
    }

    @RequestMapping("/userLogin")
    public Object usernameExist(String username,String password){
        UserInfoVo userInfoVo=userInfoService.userLogin(username,password);
        return userInfoVo;
    }

    @RequestMapping("/userRegist")
    public Object userRegist(@RequestBody UserInfoVo userInfoVo){
        UserInfoVo result=userInfoService.userRegist(userInfoVo);
        return result;
    }

    @RequestMapping("/updateUserInfo")
    public Object updateUserInfo(@RequestBody UserInfoVo userInfoVo){
        UserInfoVo result=userInfoService.updateUserInfo(userInfoVo);
        return result;
    }

    @RequestMapping("/getWxOpenId")
    public Object getWxOpenId(String reqCode){
        String openId=userInfoService.getWxUserOpenId(reqCode);
        return openId;
    }

}
