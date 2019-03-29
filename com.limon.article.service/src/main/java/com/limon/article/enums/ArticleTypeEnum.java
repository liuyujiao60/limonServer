package com.limon.article.enums;

public enum ArticleTypeEnum {
    ARTICLE(1,"文章"),
    VIDEO(2,"视频"),
    TOPIC(3,"专题")
    ;

    private int code;
    private String name;

    private ArticleTypeEnum(int code,String name){
        this.code=code;
        this.name=name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
