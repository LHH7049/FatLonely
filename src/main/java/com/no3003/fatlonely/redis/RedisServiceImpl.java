package com.no3003.fatlonely.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author: lz
 * @Date: 2021/5/8 10:57
 */
@Service
public class RedisServiceImpl implements IRedisService {
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void setStringValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void setExpireValue(String key, String value, long expireMS) {
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set(key, value);
        redisTemplate.expire(key, expireMS, TimeUnit.MILLISECONDS);
    }

    @Override
    public String getStringValue(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }
}
