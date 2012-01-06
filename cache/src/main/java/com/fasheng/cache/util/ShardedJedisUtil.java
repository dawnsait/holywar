//package com.fasheng.cache.util;
//
//import redis.clients.jedis.ShardedJedis;
//
//public class ShardedJedisUtil {
//    public static final ThreadLocal<ShardedJedis> threadLocal = new ThreadLocal<ShardedJedis>();
//    
//    public static ShardedJedis getShardedJedis() {
//        ShardedJedis jedis = (ShardedJedis) threadLocal.get();
//        // 如果Session还没有打开，则新开一个Session
//        if (s == null) {
//            s = sessionFactory.openSession();
//            session.set(s);         //将新开的Session保存到线程局部变量中
//        }
//        return s;
//    }
// 
//    public static void closeSession() throws HibernateException {
//        //获取线程局部变量，并强制转换为Session类型
//        Session s = (Session) session.get();
//        session.set(null);
//        if (s != null)
//            s.close();
//    }
//}
