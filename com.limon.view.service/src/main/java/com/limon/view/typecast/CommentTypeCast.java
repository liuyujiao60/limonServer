package com.limon.view.typecast;

import com.limon.common.viewobject.DateVo;
import com.limon.user.service.UserInfoService;
import com.limon.view.entity.Comment;
import com.limon.view.enums.CommentStatusEnum;
import com.limon.view.service.CommentService;
import com.limon.view.service.ViewService;
import com.limon.view.viewobject.CommentVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.function.Function;

@Service
public class CommentTypeCast {

    @Resource
    private UserInfoService userInfoService;

    @Resource
    private ViewService viewService;

    @Resource
    private CommentService commentService;

    public Function<CommentVo, Comment> VO_ENTITY= input->{
        Comment output=new Comment();
        output.setId(input.getId());
        output.setBasicViewInfoId(input.getViewInfo().getId());
        output.setUserId(input.getUserInfoVo().getUserId());
        output.setComment(input.getComment());
        output.setParentCommentId(input.getParentCommentId());
        output.setStatus(input.getStatus().getStatus());
        output.setCreateTime(input.getCreateTime()!=null?input.getCreateTime().getTime():0);
        return output;
    };

    public Function<Comment, CommentVo> ENTITY_VO= input->{
        CommentVo output=new CommentVo();
        output.setId(input.getId());
        output.setViewInfo(viewService.getViewInfoById(input.getBasicViewInfoId()));
        output.setUserInfoVo(userInfoService.getUserInfoById(input.getUserId()));
        output.setComment(input.getComment());
        output.setParentCommentId(input.getParentCommentId());
        output.setStatus(CommentStatusEnum.findByStatus(input.getStatus()));
        output.setCreateTime(new DateVo(input.getCreateTime()));
        return output;
    };


}
