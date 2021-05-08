package com.no3003.fatlonely.data;

/**
 * @Author: lz
 * @Date: 2021/5/8 10:02
 */
public class Result<T> {
    private int code;
    private String msg;
    private T value;

    public static final int SUCCESS = 0;
    public static final int ERROR = -1;

    public Result() {
    }

    public Result(int code, String msg, T value) {
        this.code = code;
        this.msg = msg;
        this.value = value;
    }

    public Result(ResultCode resultCode, T value){
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.value = value;
    }

    public boolean isSuccess(){
        return this.code == SUCCESS;
    }

    public static <T> Result<T> successResult(){
        return new Result<>(ResultCode.SUCCESS, null);
    }

    public static <T> Result<T> successResult(T value){
        return new Result<>(ResultCode.SUCCESS, value);
    }

    public static <T> Result<T> errorResult(String msg){
        return new Result<>(ERROR, msg, null);
    }
}
