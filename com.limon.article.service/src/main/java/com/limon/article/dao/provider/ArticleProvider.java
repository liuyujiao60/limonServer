package com.limon.article.dao.provider;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class ArticleProvider {

    public String getArticleListByIds(List<String> idList){
        StringBuilder sql=new StringBuilder("select * from article where 1=1 and id in ('"+StringUtils.join(idList,"','")+"')");
        return sql.toString();
    }
}
