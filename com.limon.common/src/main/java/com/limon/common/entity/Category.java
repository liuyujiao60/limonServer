package com.limon.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    private String id;
    private String name;
    private int level;
    private String pid;
    private long createTime;
}
