package com.limon.user.configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.limon.user.dao"}, sqlSessionFactoryRef = "userSqlSessionFactory")
public class MybatisUserDSConfig {

    @Autowired
    @Qualifier("userDS")
    private DataSource userDS;

    @Bean(name = "userSqlSessionFactory")
    public SqlSessionFactory userSqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(userDS);

        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            return sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Bean(name = "userSqlSessionTemplate")
    public SqlSessionTemplate userSqlSessionTemplate() throws Exception{
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(userSqlSessionFactory());
        return sqlSessionTemplate;
    }

    @Bean(name = "userDataSourceTransactionManager")
    public DataSourceTransactionManager userDataSourceTransactionManager() throws Exception{
        DataSourceTransactionManager manager = new DataSourceTransactionManager(userDS);
        return manager;
    }
}
