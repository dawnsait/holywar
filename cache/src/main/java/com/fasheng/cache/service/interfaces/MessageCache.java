package com.fasheng.cache.service.interfaces;

import java.util.Map;

public interface MessageCache {

    /**
     * 保存消息
     * @param msgId
     * @param msgInfo
     */
    public boolean putMessage(String msgId, Map<String, String> msgInfo);
    
    /**
     * 根据消息Id获取消息内容    
     * @param msgId
     * @return
     */
    public Map<String, String> getMessage(String msgId);
    
    /**
     * 根据消息Id删除消息
     * @param msgId
     */
    public boolean delMessageById(String msgId);
    
//消息沒有更改入口，故更新消息的接口可不提供
//    /**
//     * 根据指定msgId，把消息的content的值更新为value
//     * @param msgId
//     * @param value
//     */
//    public void updateMessageWithContent(String msgId, String value);
//    
//    /**
//     * 根据指定msgId，把消息的image的值更新为value
//     * @param msgId
//     * @param value
//     */
//    public void updateMessageWithImage(String msgId, String value);
//    
//    /**
//     * 根据指定msgId，把属性名为content的值更新为value
//     * @param msgId
//     * @param value
//     */
//    public void updateMessageWithCategory(String msgId, String value);
//    
//    /**
//     * 根据指定msgId，把属性名为expire_time的值更新为value
//     * @param msgId
//     * @param value
//     */
//    public void updateMessageWithExpireTime(String msgId, String value);
}
