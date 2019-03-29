package com.limon.article.enums;

public enum  ArticleGroupChildTypeEnum {

    ARTICLE(1,"文章"),
    GROUP(2,"文组"),
            ;

    private int code;
    private String value;

    private ArticleGroupChildTypeEnum(int code,String value){
        this.code=code;
        this.value=value;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public static ArticleGroupChildTypeEnum findByCode(int code){
        switch (code){
            case 1:
                return ARTICLE;
            case 2:
                return GROUP;
            default:
                return null;
        }
    }
}
