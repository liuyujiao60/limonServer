package com.limon.common.dao.provider;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class BasicViewInfoProvider {

    public String getBasicViewInfoByIdList(List<String> idList){
        StringBuilder sql=new StringBuilder("select * from basic_view_info where 1=1 and id in ('"+ StringUtils.join(idList,"','")+"')");
        return sql.toString();
    }
}
