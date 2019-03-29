package com.limon.common.configuration;

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
@MapperScan(basePackages = {"com.limon.common.dao"}, sqlSessionFactoryRef = "commonSqlSessionFactory")
public class MybatisCommonDSConfig {

    @Autowired
    @Qualifier("commonDS")
    private DataSource commonDS;

    @Bean(name = "commonSqlSessionFactory")
    public SqlSessionFactory userSqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(commonDS);

        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            return sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Bean(name = "commonSqlSessionTemplate")
    public SqlSessionTemplate commonSqlSessionTemplate() throws Exception{
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(userSqlSessionFactory());
        return sqlSessionTemplate;
    }

    @Bean(name = "userDataSourceTransactionManager")
    public DataSourceTransactionManager commonDataSourceTransactionManager() throws Exception{
        DataSourceTransactionManager manager = new DataSourceTransactionManager(commonDS);
        return manager;
    }
}
