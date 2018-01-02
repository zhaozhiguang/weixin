package com.zhaozhiguang.component.weixin.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


/**
 * redis缓存实现
 * @author zhiguang
 */
public class SimpleRedisWxCacheImpl implements WxCache {

    private static final Logger logger = LoggerFactory.getLogger(SimpleRedisWxCacheImpl.class);

    private static volatile JedisPool pool = null;

    public SimpleRedisWxCacheImpl(String ip, Integer port){
        if(pool==null){
            synchronized(this){
                if(pool==null){
                    pool = new JedisPool(ip, port);
                }
            }
        }
    }

    private Jedis getResource(){
        return pool.getResource();
    }

    private void close(Jedis jedis){
        if(jedis!=null){
            jedis.close();
        }
    }

    @Override
    public boolean setValue(String key, String value) {
        Jedis jedis = getResource();
        try {
            String code = jedis.set(key, value);
            if(code.equals("OK")) {
                return true;
            }
        } catch (Exception e){
            logger.error("redis存储错误", e);
        } finally {
            close(jedis);
        }
        return false;
    }

    @Override
    public boolean setValue(String key, String value, int seconds) {
        Jedis jedis = getResource();
        try {
            String code = jedis.set(key, value);
            jedis.expire(key, seconds);
            if(code.equals("OK")) {
                return true;
            }
        } catch (Exception e){
            logger.error("redis存储错误", e);
        } finally {
            close(jedis);
        }
        return false;
    }

    @Override
    public String getValue(String key) {
        Jedis jedis = getResource();
        try {
            return jedis.get(key);
        } catch (Exception e){
            logger.error("redis存储错误", e);
        } finally {
            close(jedis);
        }
        return null;
    }

    @Override
    public void disableTime(String key, int seconds) {
        Jedis jedis = getResource();
        try {
            jedis.expire(key, seconds);
        } catch (Exception e){
            logger.error("redis存储错误", e);
        } finally {
            close(jedis);
        }
    }

}
