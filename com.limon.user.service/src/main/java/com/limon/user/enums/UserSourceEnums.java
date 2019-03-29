package com.limon.user.enums;

public enum UserSourceEnums {

    NORMAL(1,"注册"),
    WEIXIN(2,"微信"),
    QQ(3,"QQ"),
    ;

    public int code;
    public String name;

    private UserSourceEnums(int code, String name){
        this.code=code;
        this.name=name;
    }

    public int getCode(){
        return code;
    }

    public String  getName(){
        return name;
    }

    public static UserSourceEnums findUserSourceEnums(int code){
        switch (code){
            case 1:
                return NORMAL;
            case 2:
                return WEIXIN;
            case 3:
                return QQ;
            default:
                return NORMAL;
        }
    }
}
