package com.limon.view.viewobject;

import com.limon.common.viewobject.BasicViewInfoVo;
import com.limon.common.viewobject.DateVo;
import com.limon.user.viewobject.UserInfoVo;
import com.limon.view.enums.CommentStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentVo {

    private String id;
    private UserInfoVo userInfoVo;
    private BasicViewInfoVo viewInfo;
    private String comment;
    private String parentCommentId;
    private List<CommentVo> childCommentList;
    private CommentStatusEnum status;
    private DateVo createTime;
}
