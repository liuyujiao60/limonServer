package com.limon.view.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViewTopicColumnDetail {

    private String id;
    private String viewTopicId;
    private String viewTopicColumnId;
    private String basicViewInfoId;
    private int orderNum;
    private long createTime;
}
