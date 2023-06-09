package com.zhang.passion.admin.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;


/**
 * Description: 自定义令牌认证
 * Author: chixiaoyu
 * Date: 2023/06/09
 * UsernamePasswordAuthenticationToken：
 *              一个身份验证实现，设计用于简单地表示用户名和密码。主体和凭据应该通过Object. tostring()方法设置
 * */

public class JwtAuthenticatioToken extends UsernamePasswordAuthenticationToken {
    private static final long serialVersionUID = 1L;

    private String token;

    public JwtAuthenticatioToken(Object principal, Object credentials){
        super(principal, credentials);
    }

    public JwtAuthenticatioToken(Object principal, Object credentials, String token){
        super(principal, credentials);
        this.token = token;
    }

    public JwtAuthenticatioToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities, String token) {
        super(principal, credentials, authorities);
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
