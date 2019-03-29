package com.limon.common.viewobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryVo {

    private String id;
    private String name;
    private int level;
    private CategoryVo parentCategoryVo;
    private DateVo createTime;
}
