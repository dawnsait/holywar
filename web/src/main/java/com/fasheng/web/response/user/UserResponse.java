package com.fasheng.web.response.user;

import com.alibaba.fastjson.JSON;
import com.fasheng.web.response.BaseResponse;

public class UserResponse extends BaseResponse {
    private String userId = "222";

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public static void main(String[] args) {
        BaseResponse response = new BaseResponse();
        response.setCode(222);
        response.setMsg("aaaaaaaaa");
        System.out.println(JSON.toJSONString(response));
    }
}
