package com.no3003.fatlonely.redis;

/**
 * @Author: lz
 * @Date: 2021/5/8 10:55
 */
public interface IRedisService {
    void setStringValue(String key, String value);

    void setExpireValue(String key, String value, long expireMS);

    String getStringValue(String key);
}
