package com.limon.view.configuration;

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
@MapperScan(basePackages = {"com.limon.view.dao"}, sqlSessionFactoryRef = "viewSqlSessionFactory")
public class MybatisViewDSConfig {

    @Autowired
    @Qualifier("viewDS")
    private DataSource viewDS;

    @Bean(name = "viewSqlSessionFactory")
    public SqlSessionFactory viewSqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(viewDS);

        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            return sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Bean(name = "viewSqlSessionTemplate")
    public SqlSessionTemplate viewSqlSessionTemplate() throws Exception{
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(viewSqlSessionFactory());
        return sqlSessionTemplate;
    }

    @Bean(name = "viewDataSourceTransactionManager")
    public DataSourceTransactionManager viewDataSourceTransactionManager() throws Exception{
        DataSourceTransactionManager manager = new DataSourceTransactionManager(viewDS);
        return manager;
    }
}
