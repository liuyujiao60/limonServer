package com.limon.view.dao;

import com.limon.core.request.Page;
import com.limon.view.dao.provider.CommentProvider;
import com.limon.view.entity.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper {

    @Insert("insert into comment(id,basicViewInfoId,userId,comment,parentCommentId,createTime) value(#{id},#{basicViewInfoId}," +
            "#{userId},#{comment},#{parentCommentId},#{createTime})")
    public void insert(Comment comment);

    @SelectProvider(type= CommentProvider.class,method = "getCommentList")
    public List<Comment> getCommentList(@Param("basicViewInfoId") String basicViewInfoId, @Param("userId") String userId,
                                       @Param("parentCommentId") String parentCommentId,@Param("status")Integer status, @Param("page") Page page);

    @Update("update comment set status=#{status} where id=#{id}")
    public int updateCommentStatus(@Param("id") String id,@Param("status") int status);
}
