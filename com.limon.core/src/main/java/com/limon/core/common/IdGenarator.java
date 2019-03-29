package com.limon.core.common;

import java.util.UUID;

public class IdGenarator {
	
	public static Long getNumberId(){
		return null;
	}
	
	public static String getStringId(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	public static String getSecretId(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	public static void main(String[] args) {
		System.out.println(IdGenarator.getSecretId());
		System.out.println(System.currentTimeMillis());
	}
}
