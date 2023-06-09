package com.zhang.passion.admin.utils;

import com.zhang.passion.admin.security.GrantedAuthorityImpl;
import com.zhang.passion.admin.security.JwtAuthenticatioToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
            //请求令牌不为空
            if (SecurityUtils.getAuthentication() == null){
                //上下文中认证信息为空
                Claims claims = getClaimsFromToken(token);
                if(claims == null){
                    return null;
                }
                String username = claims.getSubject();
                if (username == null) {
                    return  null;
                }
                if (isTokenExpired(token)) {
                    return null;
                }
                //获取权限
                Object authors = claims.get(AUTHORITIES);
                ArrayList<GrantedAuthority> authorities = new ArrayList<>();
                if (authors != null && authors instanceof List){
                    for(Object object : (List) authors) {
                        //给authorities添加权限
                        authorities.add(new GrantedAuthorityImpl(
                                (String) ((Map) object).get("authority")));
                    }
                }
                //身份验证使用自定义令牌认证
                authentication = new JwtAuthenticatioToken(username,null,authorities,token);
            }else {
                //如果上下文中 authentication（认证信息）非空，且令牌要求合法
                //直接返回当前登录认证信息
                if(validateToken(token,SecurityUtils.getUsername())){
                    authentication = SecurityUtils.getAuthentication();
                }
            }
        }
        return authentication;
    }

    /**
     * 验证令牌是否合法
     * @param token
     * @param username
     * @return
     */
    private static boolean validateToken(String token,String username) {
        //从令牌中获取用户名
        String userName = getUsernameFromToken(token);
        return (userName.equals(username)) && !isTokenExpired(token);
    }

    /**
     * 从令牌中获取用户名
     * @param token 令牌
     * @return
     */
    private static String getUsernameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        }catch (Exception e){
            username = null;
        }
        return username;
    }

    /**
     * 令牌是否过期
     * @param token
     * @return
     */
    private static boolean isTokenExpired(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            Date expiration = claims.getExpiration();
            return expiration.before(new Date());
        }catch (Exception e){
            return false;
        }

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
