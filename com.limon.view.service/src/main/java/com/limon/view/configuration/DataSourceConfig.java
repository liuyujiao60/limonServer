package com.limon.view.configuration;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration("viewDataSourceConfig")
public class DataSourceConfig {

    @Primary
    @Bean(name = "viewDSProperties")
    @Qualifier("viewDSProperties")
    @ConfigurationProperties(prefix = "spring.datasource.datasource-view")
    public DataSourceProperties viewDSProperties(){//这是是用hikariCP的时候用的
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "viewDS")
    @ConfigurationProperties(prefix = "spring.datasource.datasource-view")
    public HikariDataSource dataSourceView(){
        //return DruidDataSourceBuilder.create().build(); //使用druidCP时打开这个注释，同时注释掉下面一行
        return viewDSProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

}
