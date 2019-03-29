package com.limon.common.enums;

public enum ViewInfoTypeEnum {
    ARTICLE(1,"文章"),
    VIDEO(2,"视频"),
    TOPIC(3,"专题"),
    ;

    private int type;
    private String name;

    private ViewInfoTypeEnum(int type,String name){
        this.type=type;
        this.name=name;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public static ViewInfoTypeEnum findByType(int type){
        switch (type){
            case 1:
                return ARTICLE;
            case 2:
                return VIDEO;
            case 3:
                return TOPIC;
            default:
                return null;
        }
    }
}
