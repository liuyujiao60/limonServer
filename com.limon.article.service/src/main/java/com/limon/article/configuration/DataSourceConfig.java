package com.limon.article.configuration;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration("articleDataSourceConfig")
public class DataSourceConfig {

    @Primary
    @Bean(name = "articleDSProperties")
    @Qualifier("articleDSProperties")
    @ConfigurationProperties(prefix = "spring.datasource.datasource-article")
    public DataSourceProperties articleDSProperties(){//这是是用hikariCP的时候用的
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "articleDS")
    @ConfigurationProperties(prefix = "spring.datasource.datasource-article")
    public HikariDataSource dataSourceArticle(){
        //return DruidDataSourceBuilder.create().build(); //使用druidCP时打开这个注释，同时注释掉下面一行
        return articleDSProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

}
