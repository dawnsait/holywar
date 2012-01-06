package com.fasheng.cache.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.fasheng.cache.constants.UserCacheConstants;
import com.fasheng.cache.service.interfaces.AbstractCache;
import com.fasheng.cache.service.interfaces.UserCache;

@Service("userCache")
public class UserCacheImpl extends AbstractCache implements UserCache {

    @Override
    public boolean putUser(String userId, Map<String, String> userInfo) {
        return this.hsetHash(this.getId(userId), userInfo);
    }

    @Override
    public Map<String, String> getUser(String userId) {
        return this.hgetHash(this.getId(userId));
    }

    @Override
    public boolean delUserById(String userId) {
        return this.del(this.getId(userId));
    }

    @Override
    public boolean updateUserWithEmail(String userId, String value) {
        return this.hset(this.getId(userId), UserCacheConstants.USER_EMAIL, value);
    }

    @Override
    public boolean updateUserWithDisplayName(String userId, String value) {
        return this.hset(this.getId(userId), UserCacheConstants.USER_DISPLAY_NAME, value);
    }

    @Override
    public boolean updateUserWithRegion(String userId, String value) {
        return this.hset(this.getId(userId), UserCacheConstants.USER_REGION, value);
    }

    @Override
    public boolean updateUserWithLongitude(String userId, String value) {
        return this.hset(this.getId(userId), UserCacheConstants.USER_LONGITUDE, value);
    }

    @Override
    public boolean updateUserWithLatitude(String userId, String value) {
        return this.hset(this.getId(userId), UserCacheConstants.USER_LATITUDE, value);
    }
    
    protected String getId(String id) {
        return String.format(UserCacheConstants.USER_ID_FORMAT, id);
    }

}
