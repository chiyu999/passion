package com.zhang.passion.admin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description: 登录认证过滤器 负责登录认证时检查并生产令牌并保存到上下文
 *              接口权限认证过程时，系统从上下文获取令牌校验接口访问权限
 * Author: chixiaoyu
 * Date: 2023/06/07
 */

public class JwtAuthenticationFilter extends BasicAuthenticationFilter {
    @Autowired
    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        //获取token 并检查登录状态

        //继续执行
        chain.doFilter(request,response);
    }
}
