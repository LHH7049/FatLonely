package com.no3003.fatlonely.access.dto;

/**
 * @Author: lz
 * @Date: 2021/5/8 10:13
 */
public class RegisterReq {
    private String account;
    private String pwd;
    private String code;

    public RegisterReq() {
    }

    public RegisterReq(String account, String pwd, String code) {
        this.account = account;
        this.pwd = pwd;
        this.code = code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "RegisterReq{" +
                "account='" + account + '\'' +
                ", pwd='" + pwd + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
