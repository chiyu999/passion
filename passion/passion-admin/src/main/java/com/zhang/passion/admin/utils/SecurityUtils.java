package com.zhang.passion.admin.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.HttpServletRequest;

/**
 * Description: security 工具类
 * Author: chixiaoyu
 * Date: 2023/06/07
 */

public class SecurityUtils {
    /**
     * 获取令牌进行认证
     * @param request
     */
    public static void checkAuthentication(HttpServletRequest request) {
        // 获取令牌并根据令牌获取登录认证信息
        Authentication authentication = JwtTokenUtils.getAuthenticationFromToken(request);
        // 设置登录认证信息到上下文
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    /**
     * 获取当前登录信息
     * @return
     */
    public static Authentication getAuthentication(){
        if (SecurityContextHolder.getContext() == null){
            return null;
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication;
    }
    /**
     * 获取当前用户名
     * @return
     */
    public static String getUsername() {
        String username = null;
        Authentication authentication = getAuthentication();
        if(authentication != null) {
            Object principal = authentication.getPrincipal();
            if(principal != null && principal instanceof UserDetails) {
                username = ((UserDetails) principal).getUsername();
            }
        }
        return username;
    }

    /**
     * 获取用户名
     * @param authentication 身份认证信息
     * @return
     */
    public static String getUsername(Authentication authentication) {
        String username = null;
        //如果身份验证信息不为空
        if (authentication != null) {
            //获取权限认证主体
            Object principal = authentication.getPrincipal();
            //如果主题信息不为空 且 主体为UserDetail类型
            if (principal != null && principal instanceof UserDetails){
                username = ((UserDetails) principal).getUsername();
            }
        }
        return username;
    }
}
