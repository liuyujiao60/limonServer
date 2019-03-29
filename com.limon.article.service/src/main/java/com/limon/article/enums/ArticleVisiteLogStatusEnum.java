package com.limon.article.enums;

public enum ArticleVisiteLogStatusEnum {
    Click(1,"点击"),
    OPEN(2,"曝光"),
    SHARE(3,"分享"),
    COMMENT(4,"评论"),
    COLLECTED(5,"收藏"),
    TIPOFF(6,"举报"),
    PRAISE(7,"点赞")
    ;

    private int status;
    private String name;

    private ArticleVisiteLogStatusEnum(int status,String name){
        this.status=status;
        this.name=name;
    }

    public int getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }
}
