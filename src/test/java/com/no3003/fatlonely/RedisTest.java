package com.no3003.fatlonely;

import com.no3003.fatlonely.util.RedisUtil;
import javafx.application.Application;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: lz
 * @Date: 2021/5/8 16:07
 */
@SpringBootTest(classes = Application.class)
public class RedisTest {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void test(){
        redisUtil.set("test", "value");
        String result = redisUtil.get("test");
        System.out.println(result);
    }
}
