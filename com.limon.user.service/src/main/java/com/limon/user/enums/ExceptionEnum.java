package com.limon.user.enums;

import com.limon.core.exception.ExceptionEnums;

public enum ExceptionEnum implements ExceptionEnums {
    USERNAME_EXISTED("20001","用户名已被使用！"),
    LOGIN_ERROR("20002","登录失败，请检查账号密码是否正确！"),
    USERNAME_NOT_EXISTED("20003","用户不存在！"),
    USER_INFO_UPDATE_ERROR("20004","用户更新失败，请确认参数正确！"),
    ;

    private String code;
    private String message;

    private ExceptionEnum(String code,String message){
        this.code=code;
        this.message=message;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
