package com.no3003.fatlonely.access.controller;

import com.no3003.fatlonely.access.dto.LoginReq;
import com.no3003.fatlonely.access.dto.RegisterReq;
import com.no3003.fatlonely.access.service.AccessService;
import com.no3003.fatlonely.data.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: lz
 * @Date: 2021/5/8 9:59
 */
@RequestMapping("/access")
@RestController
public class AccessController {

    @Autowired
    private AccessService accessService;

    @PostMapping("/login")
    public Result<Void> login(@RequestBody LoginReq req){
        accessService.login(req);
        return null;
    }

    @PostMapping("/register")
    public Result<Void> register(@RequestBody RegisterReq req){
        accessService.register(req);
        return null;
    }

    @RequestMapping("/logout")
    public Result<Void> logout(){
        return null;
    }

    @RequestMapping("/getCode")
    public Result<Void> getCode(HttpServletRequest request){
        accessService.getCode(request);
        return null;
    }

}
