package com.limon.view.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViewTopic {

    private String id;
    private String name;
    private String remark;
    private String image;
}
