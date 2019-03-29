package com.limon.view.viewobject;

import com.limon.common.viewobject.DateVo;
import com.limon.view.enums.ViewTopicColumnStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViewTopicColumnVo {

    private String id;
    private String name;
    private String remark;
    private ViewTopicColumnStatusEnum status;
    private ViewTopicVo viewTopicVo;
    private DateVo createTime;
}
