package com.limon.view.service;

import com.limon.core.common.IdGenarator;
import com.limon.core.request.Page;
import com.limon.view.dao.CommentMapper;
import com.limon.view.entity.Comment;
import com.limon.view.enums.CommentStatusEnum;
import com.limon.view.typecast.CommentTypeCast;
import com.limon.view.viewobject.CommentVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Resource
    private CommentTypeCast commentTypeCast;

    public CommentVo saveCommentVo(CommentVo commentVo){
        Comment comment=commentTypeCast.VO_ENTITY.apply(commentVo);
        comment.setId(IdGenarator.getStringId());
        comment.setCreateTime(System.currentTimeMillis());
        commentMapper.insert(comment);

        commentVo=commentTypeCast.ENTITY_VO.apply(comment);
        return commentVo;
    }

    public List<CommentVo> getCommentVoByUserId(String userId, Page page){
        List<CommentVo> result=new ArrayList<>();
        List<Comment> commentList= commentMapper.getCommentList(null,userId,null, CommentStatusEnum.ONLINE.getStatus(),page);

        commentList.stream().forEach(comment -> {
            CommentVo commentVo=commentTypeCast.ENTITY_VO.apply(comment);
            List<CommentVo> childCommentList=this.getCommentVoByParentCommentId(commentVo.getId(),new Page(1,3));
            commentVo.setChildCommentList(childCommentList);
            result.add(commentVo);

        });

        return result;
    }

    public List<CommentVo> getCommentVoByViewInfoId(String basicViewInfoId, Page page){
        List<CommentVo> result=new ArrayList<>();
        List<Comment> commentList= commentMapper.getCommentList(basicViewInfoId,null,null, CommentStatusEnum.ONLINE.getStatus(),page);

        commentList.stream().forEach(comment -> {
            CommentVo commentVo=commentTypeCast.ENTITY_VO.apply(comment);
            List<CommentVo> childCommentList=this.getCommentVoByParentCommentId(commentVo.getId(),new Page(1,3));
            commentVo.setChildCommentList(childCommentList);
            result.add(commentVo);

        });

        return result;
    }

    public List<CommentVo> getCommentVoByParentCommentId(String parentCommentId, Page page){
        List<CommentVo> result=new ArrayList<>();
        List<Comment> commentList= commentMapper.getCommentList(null,null,parentCommentId, CommentStatusEnum.ONLINE.getStatus(),page);

        commentList.stream().forEach(comment -> {
            CommentVo commentVo=commentTypeCast.ENTITY_VO.apply(comment);
            result.add(commentVo);
        });

        return result;
    }
}
