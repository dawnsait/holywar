package com.fasheng.web.request;

public class BaseRequest {
    /** token, 验证请求是否是授权 */
    protected String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
}
