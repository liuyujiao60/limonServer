package com.limon.controller;

import com.limon.core.exception.ServerException;
import com.limon.core.exception.ServerExceptionEnums;
import com.limon.core.request.Page;
import com.limon.parameter.CommentQueryParameter;
import com.limon.view.service.CommentService;
import com.limon.view.viewobject.CommentVo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    @RequestMapping("/saveComment")
    public Object saveComment(@RequestBody CommentVo commentVo){
        if(commentVo==null){
            throw new ServerException(ServerExceptionEnums.PARAM_ERROR,null);
        }

        commentVo=commentService.saveCommentVo(commentVo);

        return commentVo;
    }

    @RequestMapping("/getViewInfoCommentList")
    public Object getViewInfoCommentList(@RequestBody CommentQueryParameter commentQueryParameter){

        List<CommentVo> commentVoList=commentService.getCommentVoByViewInfoId(commentQueryParameter.getViewInfoId(),commentQueryParameter.getPage());

        return commentVoList;
    }

    @RequestMapping("/getChildCommentList")
    public Object getChildCommentList(@RequestBody CommentQueryParameter commentQueryParameter){

        List<CommentVo> commentVoList=commentService.getCommentVoByParentCommentId(commentQueryParameter.getParentCommentId(),commentQueryParameter.getPage());

        return commentVoList;
    }

    @RequestMapping("/getUserCommentList")
    public Object getUserCommentList(@RequestBody CommentQueryParameter commentQueryParameter){

        List<CommentVo> commentVoList=commentService.getCommentVoByUserId(commentQueryParameter.getUserId(),commentQueryParameter.getPage());

        return commentVoList;
    }
}
