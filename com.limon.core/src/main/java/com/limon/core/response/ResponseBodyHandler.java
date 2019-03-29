package com.limon.core.response;

import com.limon.core.exception.ServerExceptionEnums;
import org.springframework.stereotype.Component;

@Component
public class ResponseBodyHandler {
	
	public CommonResponseEntity response(Object object,String requestStamp){
		CommonResponseEntity responseEntity=new CommonResponseEntity();
		responseEntity.responseCode= ServerExceptionEnums.REQUEST_SUCCESS.getCode();
		responseEntity.responseMessage=ServerExceptionEnums.REQUEST_SUCCESS.getMessage();
		responseEntity.setResponseData(object);
		responseEntity.requestStamp=requestStamp;
		return responseEntity;
		
	}
	
	public CommonResponseEntity response(String exception,String requestStamp){
		CommonResponseEntity responseEntity=new CommonResponseEntity();
		responseEntity.responseCode=ServerExceptionEnums.UNKNOWN_REQUEST_ERROR.getCode();
		responseEntity.responseMessage=exception;
		responseEntity.requestStamp=requestStamp;
		return responseEntity;
	}
	
	public CommonResponseEntity response(String code,String message,String requestStamp){
		CommonResponseEntity responseEntity=new CommonResponseEntity();
		responseEntity.responseCode=code;
		responseEntity.responseMessage=message;
		responseEntity.requestStamp=requestStamp;
		return responseEntity;
	}
}
