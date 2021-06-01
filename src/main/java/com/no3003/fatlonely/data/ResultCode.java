package com.no3003.fatlonely.data;

/**
 * @Author: lz
 * @Date: 2021/5/8 14:37
 */
public enum ResultCode {
    SUCCESS(0, "操作成功"),
    ERROR(-1, "操作失败"),

    ACCOUNT_PWD_ERROR(4001, "账号或密码错误"),
    ACCOUNT_NOT_EXISTS(4002, "账号不存在"),
    ACCOUNT_PWD_EMPTY(4003, "账号或密码不能为空"),
    ACCOUNT_NAME_VERIFY_FAIL(4004, "用户名校验不通过，请重新输入"),
    VERIFY_CODE_FAIL(4005, "验证码错误"),
    ACCOUNT_EXISTS(4006, "账号已存在");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
