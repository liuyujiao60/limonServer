package com.limon.view.dao.provider;

import com.limon.core.request.Page;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.ibatis.annotations.Param;

public class CommentProvider {

    public String getCommentList(@Param("basicViewInfoId") String basicViewInfoId, @Param("userId") String userId,
                                 @Param("parentCommentId") String parentCommentId, @Param("status")Integer status, @Param("page") Page page){
        StringBuilder sql=new StringBuilder("select * from comment where 1=1 ");
        if(StringUtils.isNotEmpty(basicViewInfoId)) {
            sql.append(" and basicViewInfoId=#{basicViewInfoId}");
        }
        if(StringUtils.isNotEmpty(userId)) {
            sql.append(" and userId=#{userId}");
        }
        if(StringUtils.isNotEmpty(parentCommentId)) {
            sql.append(" and parentCommentId=#{parentCommentId}");
        }
        if(status!=null) {
            sql.append(" and status=#{status}");
        }
        sql.append(" order by createTime limit #{page.current},#{page.pageSize}");

        return sql.toString();
    }
}
