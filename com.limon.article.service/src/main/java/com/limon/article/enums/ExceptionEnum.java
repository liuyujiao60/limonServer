package com.limon.article.enums;

import com.limon.core.exception.ExceptionEnums;

public enum ExceptionEnum implements ExceptionEnums {
    PARAM_ERROR("30001","参数错误"),
    ;

    private String code;
    private String message;

    private ExceptionEnum(String code, String message){
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
