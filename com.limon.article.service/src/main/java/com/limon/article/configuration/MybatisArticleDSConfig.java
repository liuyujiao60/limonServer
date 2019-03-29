package com.limon.article.configuration;

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
@MapperScan(basePackages = {"com.limon.article.dao"}, sqlSessionFactoryRef = "articleSqlSessionFactory")
public class MybatisArticleDSConfig {

    @Autowired
    @Qualifier("articleDS")
    private DataSource articleDS;

    @Bean(name = "articleSqlSessionFactory")
    public SqlSessionFactory articleSqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(articleDS);

        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            return sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Bean(name = "articleSqlSessionTemplate")
    public SqlSessionTemplate articleSqlSessionTemplate() throws Exception{
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(articleSqlSessionFactory());
        return sqlSessionTemplate;
    }

    @Bean(name = "articleDataSourceTransactionManager")
    public DataSourceTransactionManager articleDataSourceTransactionManager() throws Exception{
        DataSourceTransactionManager manager = new DataSourceTransactionManager(articleDS);
        return manager;
    }
}
