package com.limon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableCaching
@EnableAsync
@EnableTransactionManagement
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ServerApplication {
	public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context= SpringApplication.run(ServerApplication.class, args);
    }
}
