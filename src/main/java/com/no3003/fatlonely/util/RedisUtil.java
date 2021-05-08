package com.no3003.fatlonely.util;

import com.no3003.fatlonely.redis.RedisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: lz
 * @Date: 2021/5/8 10:55
 */
@Component
public class RedisUtil {

    @Autowired
    private RedisServiceImpl redisService;

    public void set(String key, String value){
        redisService.setStringValue(key, value);
    }

    public void setEx(String key, String value, long ms){
        redisService.setExpireValue(key, value, ms);
    }

    public String get(String key){
        return redisService.getStringValue(key);
    }
}
