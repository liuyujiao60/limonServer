package com.limon.view.viewobject;

import com.limon.common.viewobject.BasicViewInfoVo;
import com.limon.common.viewobject.DateVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViewTopicColumnDetailVo {

    private String id;
    private ViewTopicColumnVo viewTopicColumnVo;
    private BasicViewInfoVo viewInfoVo;
    private int orderNum;
    private DateVo createTime;
}
