package com.limon.article.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    private String id;
    private String shortTitle;
    private String title;
    private int writeType;
    private String image;
    private String url;
    private String categoryId;
}
