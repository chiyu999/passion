package com.zhang.passion.core.http;

import lombok.Data;

/**
 * Description: http返回结果封装
 * Author: chixiaoyu
 * Date: 2023/05/17
 */
@Data
public class HttpResult {
    private int code = 200;
    private String msg;
    private Object data;

    public static HttpResult error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR,"未知异常，请联系系统管理员");
    }

    public static HttpResult error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR,msg);
    }
    public static HttpResult error(int code,String msg) {
        HttpResult httpResult = new HttpResult();
        httpResult.setCode(code);
        httpResult.setMsg(msg);
        return httpResult;
    }
    public static HttpResult ok(){
        return new HttpResult();
    }
    public static HttpResult ok(String msg){
        HttpResult httpResult = new HttpResult();
        httpResult.setMsg(msg);
        return httpResult;
    }
    public static HttpResult ok(Object data){
        HttpResult httpResult = new HttpResult();
        httpResult.setData(data);
        return httpResult;
    }
}
