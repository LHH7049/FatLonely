package com.no3003.fatlonely.access.controller;

import com.no3003.fatlonely.access.dto.LoginReq;
import com.no3003.fatlonely.access.dto.RegisterReq;
import com.no3003.fatlonely.access.service.UserAccessService;
import com.no3003.fatlonely.data.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: lz
 * @Date: 2021/5/8 9:59
 */
@RequestMapping("/access")
@RestController
public class UserAccessController {

    @Autowired
    private UserAccessService userAccessService;

    @PostMapping("/login")
    public Result<Void> login(HttpServletRequest request, HttpServletResponse response, @RequestBody LoginReq loginReq){
        return userAccessService.login(request, response, loginReq);
    }

    @PostMapping("/register")
    public Result<Void> register(HttpServletRequest request, @RequestBody RegisterReq registerReq){
        return userAccessService.register(request, registerReq);
    }

    @RequestMapping("/existAccount")
    public Result<Boolean> existAccount(@RequestParam String account){
        return userAccessService.existAccount(account);
    }

    @RequestMapping("/logout")
    public Result<Void> logout(HttpServletRequest request, HttpServletResponse response){
        return userAccessService.logout(request,response);
    }

    @RequestMapping("/sendCaptcha")
    public Result<Void> sendCaptcha(HttpServletRequest request, HttpServletResponse response, @RequestParam String account){
        return userAccessService.sendCaptcha(request, response, account);
    }

}
