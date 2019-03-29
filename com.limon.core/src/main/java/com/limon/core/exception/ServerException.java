package com.limon.core.exception;

public class ServerException extends RuntimeException {
	
	private ExceptionEnums exceptionEnums;
	
	private Exception exception;

    public ServerException(ExceptionEnums exceptionEnums,Exception e) {
        this.exceptionEnums = exceptionEnums;
        this.exception=e;
    }

    public String getCode() {
        return exceptionEnums.getCode();
    }

    public String getMessage() {
        return exceptionEnums.getMessage();
    }

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}
}
