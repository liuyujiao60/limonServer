package com.limon.core.aspect;

import com.alibaba.fastjson.JSONObject;
import com.limon.core.exception.ServerException;
import com.limon.core.response.CommonResponseEntity;
import com.limon.core.response.ResponseBodyHandler;
import com.limon.core.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

@Slf4j
@Aspect
@Component
public class ControllerAspect {

	@Resource
	private ResponseBodyHandler responseBodyHandler;
	
	@Pointcut("execution(public * com.*.controller..*.*(..))")
    public void controllerHandler() {
    }
	
	@Around("controllerHandler()")
    public Object controllerHandler(ProceedingJoinPoint thisJoinPoint){
		CommonResponseEntity responseEntity=null;
		
		HttpServletRequest request =((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		JSONObject logInfo=new JSONObject();
		{
			logInfo.put("dateTime", DateUtil.getStringDateByDate(new Date()));
			
			JSONObject header=new JSONObject();
			header.put("requestUUID", request.getHeader("requestUUID"));
			logInfo.put("header", header);

			if(thisJoinPoint.getArgs()!=null&&thisJoinPoint.getArgs().length>0){
				Object[] params = (Object[]) thisJoinPoint.getArgs();
				StringBuilder paramStr=new StringBuilder();
				Arrays.stream(params).filter(param->!(param instanceof MultipartFile)).forEach(param->paramStr.append(param+","));
				logInfo.put("params", paramStr.toString());
			}else{
				logInfo.put("params", new Object());
			}
	        
	        String url = request.getRequestURL().toString();
	        logInfo.put("url", url);
		}

		long start=System.currentTimeMillis();
		try {
			
			Object result = thisJoinPoint.proceed();
			if(logInfo.getString("url").contains("ueditor")||logInfo.getString("url").contains("file"))
				return result;
			responseEntity=responseBodyHandler.response(result, null);
            logInfo.put("response",responseEntity);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			if(e instanceof ServerException){
				if(((ServerException) e).getException()!=null)
					((ServerException) e).getException().printStackTrace();
				responseEntity=responseBodyHandler.response(((ServerException)e).getCode(),((ServerException)e).getMessage(), null);
			}else{
				responseEntity=responseBodyHandler.response(e.getMessage(), null);
				e.printStackTrace();
			}
		}
		long end=System.currentTimeMillis();
		logInfo.put("spendTime",end-start);
		log.info(logInfo.toJSONString());
        return responseEntity;
    }
}
