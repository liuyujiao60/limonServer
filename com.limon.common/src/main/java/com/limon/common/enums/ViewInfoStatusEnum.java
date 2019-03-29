package com.limon.common.enums;

public enum ViewInfoStatusEnum {

    PASSED(1,"审核通过"),
    REJECT(2,"审核拒绝"),
    ONLINE(3,"上架"),
    OFFLINE(4,"下线"),
    ;

    private int status;
    private String name;

    private ViewInfoStatusEnum(int status,String name){
        this.status=status;
        this.name=name;
    }

    public int getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public static ViewInfoStatusEnum findByStatus(int status){
        switch (status){
            case 1:
                return PASSED;
            case 2:
                return REJECT;
            case 3:
                return ONLINE;
            case 4:
                return OFFLINE;
            default:
                return null;
        }
    }
}
