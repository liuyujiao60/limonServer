package com.limon.common.viewobject;

import com.limon.common.enums.ViewInfoStatusEnum;
import com.limon.common.enums.ViewInfoTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasicViewInfoVo {

    private String id;
    private CategoryVo categoryVo;
    private ViewInfoTypeEnum viewInfoType;
    private ViewInfoStatusEnum viewInfoStatus;
    private DateVo createTime;

    public void setBasicViewInfoVo(BasicViewInfoVo basicViewInfoVo){
        this.id=basicViewInfoVo.getId();
        this.categoryVo=basicViewInfoVo.getCategoryVo();
        this.viewInfoType=basicViewInfoVo.getViewInfoType();
        this.viewInfoStatus=basicViewInfoVo.getViewInfoStatus();
        this.createTime=basicViewInfoVo.getCreateTime();
    }
}
