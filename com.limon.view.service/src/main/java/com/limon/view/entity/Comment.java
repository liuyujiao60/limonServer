package com.limon.view.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    private String id;
    private String basicViewInfoId;
    private String userId;
    private String comment;
    private String parentCommentId;
    private int status;
    private long createTime;
}
