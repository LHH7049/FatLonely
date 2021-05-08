package com.no3003.fatlonely.access.service;

import com.no3003.fatlonely.data.Result;
import com.no3003.fatlonely.access.dto.LoginReq;
import com.no3003.fatlonely.access.dto.RegisterReq;
import com.no3003.fatlonely.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: lz
 * @Date: 2021/5/8 11:12
 */
@Service
public class AccessService {

    @Autowired
    private RedisUtil redisUtil;

    public Result<Void> login(LoginReq req){
        redisUtil.set("test", "1");
        return null;
    }

    public Result<Void> register(RegisterReq req){
        String result = redisUtil.get("test");
        System.out.println(result);
        return null;
    }

    public Result<Void> getCode(HttpServletRequest request){
        return null;
    }
}
