package com.limon.parameter;

import com.limon.core.request.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentQueryParameter {

    private String viewInfoId;
    private String userId;
    private String parentCommentId;
    private Page page;
}
