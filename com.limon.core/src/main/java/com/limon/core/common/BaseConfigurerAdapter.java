package com.limon.core.common;

import com.limon.core.interceptor.BaseControllerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class BaseConfigurerAdapter extends WebMvcConfigurationSupport {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new BaseControllerInterceptor()).addPathPatterns("/**");
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		//添加映射路径
		registry.addMapping("/**").allowedOrigins("*").allowCredentials(true).allowedMethods("*")
			.allowedHeaders("*");
		super.addCorsMappings(registry);
	}
}
