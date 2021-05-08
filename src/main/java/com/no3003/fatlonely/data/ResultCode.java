package com.no3003.fatlonely.data;

/**
 * @Author: lz
 * @Date: 2021/5/8 14:37
 */
public enum ResultCode {
    SUCCESS(0, "操作成功"),
    ERROR(-1, "操作失败");


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
