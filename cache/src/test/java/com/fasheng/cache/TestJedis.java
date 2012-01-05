package com.fasheng.cache;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

@ContextConfiguration(locations = { "/application-context.xml"})
public class TestJedis extends AbstractJUnit4SpringContextTests {
    @Autowired
    private ShardedJedisPool shardedJedisPool;
    
    @Test
    public void test() {
        ShardedJedis jedis = shardedJedisPool.getResource();
        String key = "aaa";
        jedis.set(key, "bbbbbbbbbbbbbb"); 
        System.out.println(jedis.get(key)); 
    }

}
