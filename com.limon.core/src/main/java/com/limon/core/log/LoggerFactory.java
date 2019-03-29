package com.limon.core.log;

import org.slf4j.Logger;

public class LoggerFactory {
	
	private static final String REQUEST_INFO = "requestInfo";
	
	public static Logger getRequestInfoLogger(Class<?> clazz) {
        return org.slf4j.LoggerFactory.getLogger(REQUEST_INFO);
    }

}
