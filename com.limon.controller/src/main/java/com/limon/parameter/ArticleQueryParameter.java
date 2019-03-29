package com.limon.parameter;

import com.limon.core.request.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleQueryParameter {

    private String articleGroupId;
    private Integer level;
    private Page page;
}
