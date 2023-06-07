package com.zhang.passion.admin.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * Description:
 * Author:
 * Date:
 */

public class JwtTokenUtils {
    private static final long serialVersionUID = 1L;

    /**
     * 用户名称
     */
    private static final String USERNAME = Claims.SUBJECT;
    /**
     * 创建时间
     */
    private static final String CREATED = "created";
    /**
     * 权限列表
     */
    private static final String AUTHORITIES = "authorities";
    /**
     * 密钥
     */
    private static final String SECRET = "abcdefgh";
    /**
     * 有效期12小时
     */
    private static final long EXPIRE_TIME = 12 * 60 * 60 * 1000;

    /**
     * 根据请求令牌获取登录认证信息
     * @param request
     * @return
     */
    public static Authentication getAuthenticationFromToken(HttpServletRequest request){
        Authentication authentication = null;
        //获取请求携带的令牌
        String token = JwtTokenUtils.getToken(request);
        if (token != null){
            //请求令牌不能为空
            if (SecurityUtils.getAuthentication() == null){
                //上下文中认证信息为空
                Claims claims = getClaimsFromToken(token);
            }
        }
        return authentication;
    }

    /**
     * 获取请求的token
     * @param request
     * @return
     */
    public  static String getToken(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        String tokenHead = "Bearer ";
        //如果token为空
        if (token == null) {
            //从请求头信息中获取token
            token = request.getHeader("token");
        } else if (token.contains(tokenHead)) {
            //如果token包含了tokenHead则去掉
            token = token.substring(tokenHead.length());
        }
        if ("".equals(token)){
            token = null;
        }
        return token;
    }

    /**
     * 从令牌中获取数据声明
     * @param token
     * @return
     */
    public static Claims getClaimsFromToken(String token){
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        }catch (Exception e){
            claims = null;
        }
        return claims;
    }
}
