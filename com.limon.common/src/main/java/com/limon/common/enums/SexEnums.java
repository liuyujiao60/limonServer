package com.limon.common.enums;

public enum SexEnums {

    MALE(1,"男"),
    FEMALE(2,"女"),
    ;

    public int code;
    public String name;

    private SexEnums(int code,String name){
        this.code=code;
        this.name=name;
    }

    public int getCode(){
        return code;
    }

    public String  getName(){
        return name;
    }

    public static SexEnums findSexEnums(int code){
        switch (code){
            case 1:
                return MALE;
            case 2:
                return FEMALE;
            default:
                return null;
        }
    }
}
