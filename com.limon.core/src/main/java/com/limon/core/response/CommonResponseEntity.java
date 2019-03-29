package com.limon.core.response;

public class CommonResponseEntity<T> {
	
	public String responseCode;
	public String responseMessage;
	private T responseData;
	public String requestStamp;
	
	public T getResponseData() {
		return responseData;
	}
	public void setResponseData(T responseData) {
		this.responseData = responseData;
	}
}
