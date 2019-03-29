package com.limon.view.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViewTopicColumn {

    private String id;
    private String name;
    private String remark;
    private String viewTopicId;
    private int status;
    private long createTime;
}
