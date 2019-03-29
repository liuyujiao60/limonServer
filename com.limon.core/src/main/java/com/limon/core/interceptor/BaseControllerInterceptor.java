package com.limon.core.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseControllerInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		response.setHeader("Access-Control-Allow-Methods","GET, POST, OPTIONS");
		response.setHeader("Access-Control-Max-Age","1728000");
		response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, DNT,X-CustomHeader,Keep-Alive,User-Agent,X-Requested-With,X_Requested_With,If-Modified-Since,Cache-Control,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers"); 
		response.setHeader("Access-Control-Allow-Credentials", "true");
	}

}
