package com.no3003.fatlonely.access.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: lz
 * @Date: 2021/5/8 10:10
 */
@AllArgsConstructor
@Data
public class LoginReq {
    private int account;
    private String pwd;
    private int remember;

    public boolean rememberMe(){
        return remember == 1;
    }
}
