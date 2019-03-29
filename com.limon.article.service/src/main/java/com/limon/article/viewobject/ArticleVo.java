package com.limon.article.viewobject;

import com.limon.article.enums.ArticleWriteTypeEnum;
import com.limon.common.viewobject.BasicViewInfoVo;
import com.limon.common.viewobject.CategoryVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleVo extends BasicViewInfoVo {

    private String shortTitle;
    private String title;
    private ArticleWriteTypeEnum writeType;
    private String image;
    private String url;
}
