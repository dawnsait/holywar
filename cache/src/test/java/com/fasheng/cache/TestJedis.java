package com.fasheng.cache;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import com.fasheng.cache.service.impl.UserCacheImpl;

@ContextConfiguration(locations = { "/application-context.xml"})
public class TestJedis extends AbstractJUnit4SpringContextTests {
    @Autowired
    private ShardedJedisPool shardedJedisPool;
    
    @Autowired
    private UserCacheImpl userCache;
    
    @Test
    public void test() {
        ShardedJedis jedis = shardedJedisPool.getResource();
        String key = "aaa";
//        jedis.set(key, "bbbbbbbbbbbbbb"); 
//        jedis.hset("aaa", "bbbb", "ccc");
        Map<String, String> map = jedis.hgetAll("acd");
        System.out.println(jedis.get(key)); 
    }
    
    @Test
    public void test2() {
        String userId = "2223333333";
        Map<String, String> map = new HashMap<String, String>();
        map.put("fffffff1", "vvvvv1");
        map.put("fffffff2", "vvvvv2");
        map.put("fffffff3", "vvvvv3");
        map.put("fffffff4", "vvvvv4");
        userCache.putUser(userId, map);
        Map<String, String> map2 = userCache.getUser(userId);
        System.out.println(""); 
    }

}
