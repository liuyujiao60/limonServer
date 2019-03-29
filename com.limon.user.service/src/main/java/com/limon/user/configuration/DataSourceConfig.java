package com.limon.user.configuration;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration("userDataSourceConfig")
public class DataSourceConfig {

    @Primary
    @Bean(name = "userDSProperties")
    @Qualifier("userDSProperties")
    @ConfigurationProperties(prefix = "spring.datasource.datasource-user")
    public DataSourceProperties userDSProperties(){//这是是用hikariCP的时候用的
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "userDS")
    @ConfigurationProperties(prefix = "spring.datasource.datasource-user")
    public HikariDataSource dataSourceUser(){
        //return DruidDataSourceBuilder.create().build(); //使用druidCP时打开这个注释，同时注释掉下面一行
        return userDSProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

}
