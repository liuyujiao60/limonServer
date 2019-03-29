package com.limon.article.enums;

public enum ArticleGroupStatusEnum {
    ONLINE(1,"上线中"),
    OFFLINE(2,"下线"),
    ;

    private int status;
    private String name;

    private ArticleGroupStatusEnum(int status,String name){
        this.status=status;
        this.name=name;
    }

    public int getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public static ArticleGroupStatusEnum findByStatus(int status){
        switch (status){
            case 1:
                return ONLINE;
            case 2:
                return OFFLINE;
            default:
                return null;
        }
    }
}
