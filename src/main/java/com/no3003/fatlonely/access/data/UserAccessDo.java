package com.no3003.fatlonely.access.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: lz
 * @Date: 2021/5/11 9:45
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserAccessDo {
    private int id;
    private int account;
    private String accountName;
    private String pwd;
    private Date registerTime;
    private String lastLoginIp;
    private Date lastLoginTime;
    private Date updateTime;

    public UserAccessDo(int account, String accountName, String pwd, Date registerTime, String lastLoginIp, Date lastLoginTime, Date updateTime) {
        this.account = account;
        this.accountName = accountName;
        this.pwd = pwd;
        this.registerTime = registerTime;
        this.lastLoginIp = lastLoginIp;
        this.lastLoginTime = lastLoginTime;
        this.updateTime = updateTime;
    }
}


