package com.zhang.passion.core.exception;

/**
 * Description: 自定义异常
 * Author: chixiaoyu
 * Date: 2023/05/17
 */

public class PassionException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private String msg;
    private int code = 500;

    public PassionException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public PassionException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public PassionException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public PassionException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
