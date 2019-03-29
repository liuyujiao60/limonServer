package com.limon.article.dao;

import com.limon.article.dao.provider.ArticleProvider;
import com.limon.article.entity.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface ArticleMapper {

    @Insert("insert into article values(#{id},#{shortTitle},#{title},#{writeType},#{image},#{url},#{categoryId})")
    public void insert(Article article);

    @Select("select * from article where id=#{id}")
    public Article getArticleById(String id);

    @SelectProvider(type = ArticleProvider.class,method = "getArticleListByIds" )
    public List<Article> getArticleListByIds(List<String> idList);
}
