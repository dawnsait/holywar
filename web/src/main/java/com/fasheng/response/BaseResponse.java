package com.fasheng.response;

/**
 * 服务端api返回基类
 * TODO Comment of BaseResponse
 * @author julien.min
 *
 */
public class BaseResponse {
    /** 返回状态码 */
    protected Integer code;
    
    /** 如果是error code, message为错误信息 */
    protected String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}