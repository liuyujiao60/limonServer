package com.limon.article.enums;

import lombok.Data;

public enum ArticleWriteTypeEnum {

    ORIGINAL(1,"原创"),
    REPRINT(2,"转载"),
    REDIRECT(3,"转链"),
    ;

    private int code;
    private String value;

    private ArticleWriteTypeEnum(int code,String value){
        this.code=code;
        this.value=value;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public static ArticleWriteTypeEnum findByCode(int code){
        switch (code){
            case 1:
                return ORIGINAL;
            case 2:
                return REPRINT;
            case 3:
                return REDIRECT;
            default:
                return null;
        }
    }
}
