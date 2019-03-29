package com.limon.core.exception;

public enum ServerExceptionEnums implements ExceptionEnums {
    REQUEST_SUCCESS("9999","请求成功！"),
    UNKNOWN_REQUEST_ERROR("10000","未捕获的请求异常！"),
	REGIST_ERROR("10001","注册失败，请重新注册！"),
	USER_NOT_EXIST("10002","用户不存在！"),
	MODIFY_USER_ERROR("10003","修改用户信息失败！"),
	ACCOUNT_IS_EXIST("10004","用户名已存在！"),
	MOBILE_IS_EXIST("10005","手机号已存在！"),
	DONT_HAVE_MORE_DATA("10006","列表已经拉取到底！"),
	NEWS_NOT_EXIST("10007","帖子不存在！"),
	FILE_UPLOAD_ERROR("10008","文件上传失败！"),
    PARAM_ERROR("10009","参数异常！");
	
    public String code;
    public String message;
    private  ServerExceptionEnums(String code,String message)
    {
        this.code=code;
        this.message=message;
    }
    public String getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
