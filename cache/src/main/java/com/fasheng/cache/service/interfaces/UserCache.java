package com.fasheng.cache.service.interfaces;

import java.util.Map;

public interface UserCache {
    /**
     * 保存用户
     * @param userId
     * @param msgInfo
     */
    public boolean putUser(String userId, Map<String, String> userInfo);
    
    /**
     * 根据用户Id获取用户内容    
     * @param userId
     * @return
     */
    public Map<String, String> getUser(String userId);
    
    /**
     * 根据用户Id删除用户
     * @param userId
     */
    public boolean delUserById(String userId);
    
    /**
     * 根据指定userId，把用户的email的值更新为value
     * @param userId
     * @param value
     */
    public boolean updateUserWithEmail(String userId, String value);
    
    /**
     * 根据指定userId，把用户的displayName的值更新为value
     * @param userId
     * @param value
     */
    public boolean updateUserWithDisplayName(String userId, String value);
    
    /**
     * 根据指定userId，把属性名为region的值更新为value
     * @param userId
     * @param value
     */
    public boolean updateUserWithRegion(String userId, String value);
    
    /**
     * 根据指定userId，把属性名为longitude的值更新为value
     * @param userId
     * @param value
     */
    public boolean updateUserWithLongitude(String userId, String value);
    
    /**
     * 根据指定userId，把属性名为latitude的值更新为value
     * @param userId
     * @param value
     */
    public boolean updateUserWithLatitude(String userId, String value);
}
