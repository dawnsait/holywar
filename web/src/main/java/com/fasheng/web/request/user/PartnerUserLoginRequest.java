package com.fasheng.web.request.user;

import com.fasheng.web.request.BaseRequest;

public class PartnerUserLoginRequest extends BaseRequest {
    /** 合作方返回的id， 新浪微博返回用户id */
    private String partnerUserId;
    
    private String accessToken;
    
    private String refreshToken;
    
    private String userId;
    
    /** 表示是新浪微博，还是腾讯微博 */
    private String type;
    
    /** api版本 */
    private String version;

    public String getPartnerUserId() {
        return partnerUserId;
    }

    public void setPartnerUserId(String partnerUserId) {
        this.partnerUserId = partnerUserId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    
}
