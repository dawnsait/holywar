package com.fasheng.response.user;

import com.fasheng.response.BaseResponse;

public class UserRegisterResponse extends BaseResponse {
    private String userId;
    private String userName;

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
