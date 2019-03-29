package com.limon.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasicViewInfo {

    private String id;
    private int type;
    private long createTime;
    private int status;
    private String categoryId;
}
