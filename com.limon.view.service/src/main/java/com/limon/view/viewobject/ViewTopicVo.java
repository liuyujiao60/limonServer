package com.limon.view.viewobject;

import com.limon.common.viewobject.BasicViewInfoVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViewTopicVo extends BasicViewInfoVo {

    private String name;
    private String remark;
    private String image;
}
