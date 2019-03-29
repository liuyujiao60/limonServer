package com.limon.core.request;

public class RequestEntity<T> extends CommonRequestEntity{
	
	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
}
