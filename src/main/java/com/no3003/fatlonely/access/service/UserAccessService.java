package com.no3003.fatlonely.access.service;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.GifCaptcha;
import com.no3003.fatlonely.access.data.UserAccessConstant;
import com.no3003.fatlonely.access.data.UserAccessDo;
import com.no3003.fatlonely.access.mapper.UserAccessMapper;
import com.no3003.fatlonely.data.Result;
import com.no3003.fatlonely.access.dto.LoginReq;
import com.no3003.fatlonely.access.dto.RegisterReq;
import com.no3003.fatlonely.data.ResultCode;
import com.no3003.fatlonely.util.HttpUtil;
import com.no3003.fatlonely.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * @Author: lz
 * @Date: 2021/5/8 11:12
 */
@Service
public class UserAccessService {

    private static final Logger logger = LoggerFactory.getLogger(UserAccessService.class);

    @Autowired
    private UserAccessMapper userAccessMapper;

    public Result<Void> login(HttpServletRequest request, HttpServletResponse response, LoginReq loginReq){
        // 账号密码校验
        if (!StringUtils.hasText(loginReq.getAccount()) || !StringUtils.hasText(loginReq.getPwd())){
            return new Result<>(ResultCode.ACCOUNT_PWD_EMPTY);
        }
        // 从数据库中取出账号密码
        UserAccessDo userAccess = userAccessMapper.getUserAccessByAccount(loginReq.getAccount());
        // 比较账密
        if (userAccess == null){
            return new Result<>(ResultCode.ACCOUNT_NOT_EXISTS);
        }
        if (!userAccess.getAccount().equals(loginReq.getAccount()) || !userAccess.getPwd().equals(loginReq.getPwd())){
            return new Result<>(ResultCode.ACCOUNT_PWD_ERROR);
        }
        // 更新用户登录信息
        userAccessMapper.updateUserAccessLastRemarksByAccount(loginReq.getAccount(), HttpUtil.getIP(), new Date());
        // 登录cookie
        request.getSession().setAttribute(UserAccessConstant.F_L_ACCOUNT, userAccess.getAccount());
        if (loginReq.rememberMe()){
            writeLoginCookie(response);
        }
        return new Result<>(ResultCode.SUCCESS);
    }

    private void writeLoginCookie(HttpServletResponse response){
        String loginAuth = UUID.randomUUID().toString().replaceAll("-", "");
        HttpUtil.setCookieValue(response, UserAccessConstant.F_L_REMEMBER_COOKIE_KEY, loginAuth, UserAccessConstant.THIRTY_DAYS_SECOND);
    }

    public Result<Void> register(HttpServletRequest request, RegisterReq registerReq){
        // 账密验证（判空，判特殊字符）
        if (!StringUtils.hasText(registerReq.getAccount()) || !StringUtils.hasText(registerReq.getPwd())){
            return new Result<>(ResultCode.ACCOUNT_PWD_EMPTY);
        }
        // 账号校验
        if (!verifyAccount(registerReq.getAccount()) || !verifyPwd(registerReq.getPwd())){
            return new Result<>(ResultCode.ACCOUNT_PWD_VERIFY_FAIL);
        }
        // 验证码校验
        if (!registerReq.getCode().equals(getCaptchaCode(request))){
            return new Result<>(ResultCode.VERIFY_CODE_FAIL);
        }
        // 入库（判存）
        UserAccessDo userAccess = new UserAccessDo(registerReq.getAccount(), registerReq.getPwd(), new Date(), null, null, null);
        if(userAccessMapper.addUserAccess(userAccess) > 0){
            return new Result<>(ResultCode.ACCOUNT_EXISTS);
        }
        // todo 待定 注册后自动登录

        return Result.successResult();
    }

    private boolean verifyAccount(String account){
        return false;
    }

    private boolean verifyPwd(String pwd){
        return false;
    }

    private String getCaptchaCode(HttpServletRequest request){
        return (String) request.getSession().getAttribute(UserAccessConstant.F_L_CAPTCHA_KEY);
    }

    public Result<Void> logout(HttpServletRequest request, HttpServletResponse response){
        request.getSession().removeAttribute(UserAccessConstant.F_L_ACCOUNT);
        HttpUtil.setCookieValue(response, UserAccessConstant.F_L_REMEMBER_COOKIE_KEY, "", 0);
        return Result.successResult();
    }

    public Result<Void> sendCaptcha(HttpServletRequest request, HttpServletResponse response, String account){
        try (ServletOutputStream os = response.getOutputStream();){
            // 生成验证码
            GifCaptcha captcha = CaptchaUtil.createGifCaptcha(400, 200, 4);
            captcha.write(os);
            if (!captcha.verify(captcha.getCode())) {
                logger.warn("验证码无效, captcha:{}", captcha.getCode());
                return Result.errorResult("获取验证码失效，请刷新重试");
            }
            request.getSession().setAttribute(UserAccessConstant.F_L_CAPTCHA_KEY, captcha.getCode());
            return Result.successResult();
        } catch (IOException e) {
            logger.error("写入验证码异常", e);
        }
        return new Result<>(ResultCode.ERROR);
    }

    public Result<Boolean> existAccount(String account) {
        return Result.successResult(userAccessMapper.existsAccount(account) > 0);
    }
}
