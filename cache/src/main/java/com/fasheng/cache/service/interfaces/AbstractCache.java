package com.fasheng.cache.service.interfaces;

import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public abstract class AbstractCache {
    @Autowired
    protected ShardedJedisPool shardedJedisPool;
    
    /**
     * 字符串操作：新增
     * @param key
     * @param value
     * @return
     */
    protected boolean set(String key, String value) {
        ShardedJedis jedis = shardedJedisPool.getResource();
        try {
            jedis.set(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            shardedJedisPool.returnResource(jedis);
        }
        return true;
    }
    
    /**
     * 字符串操作：获取值
     * @param key
     * @return
     */
    protected String get(String key) {
        ShardedJedis jedis = shardedJedisPool.getResource();
        String value = null;
        try {
            value = jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            shardedJedisPool.returnResource(jedis);
        }
        return value;
    }
    
    /**
     * 根据key删除
     * @param key
     * @return
     */
    protected boolean del(String key) {
        ShardedJedis jedis = shardedJedisPool.getResource();
        try {
            jedis.del(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            shardedJedisPool.returnResource(jedis);
        }
        return true;
    }
   
    protected boolean hset(String key, String field, String value) {
        ShardedJedis jedis = shardedJedisPool.getResource();
        try {
            jedis.hset(key, field, value);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            shardedJedisPool.returnResource(jedis);
        }
        return true;
    }
    
    protected String hget(String key, String field) {
        ShardedJedis jedis = shardedJedisPool.getResource();
        String value = null;
        try {
            value = jedis.hget(key, field);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            shardedJedisPool.returnResource(jedis);
        }
        return value;
    }

    @SuppressWarnings("rawtypes")
    protected boolean hsetHash(String key, Map<String, String> hash) {
        ShardedJedis jedis = shardedJedisPool.getResource();
        try {
            Iterator iter = hash.entrySet().iterator(); 
            while (iter.hasNext()) { 
                Map.Entry entry = (Map.Entry) iter.next(); 
                String field = entry.getKey().toString(); 
                String value = entry.getValue().toString();
                jedis.hset(key, field, value);
            } 
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            shardedJedisPool.returnResource(jedis);
        }
        return true;
    }
    
    protected Map<String, String> hgetHash(String key) {
        ShardedJedis jedis = shardedJedisPool.getResource();
        Map<String, String> hash = null;
        try {
            hash = jedis.hgetAll(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            shardedJedisPool.returnResource(jedis);
        }
        return hash;
    }
    
    protected abstract String getId(String id);
}
