package com.no3003.fatlonely.access.dto;

/**
 * @Author: lz
 * @Date: 2021/5/8 10:10
 */
public class LoginReq {
    private String account;
    private String pwd;

    public LoginReq(String account, String pwd) {
        this.account = account;
        this.pwd = pwd;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "LoginReq{" +
                "account='" + account + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
