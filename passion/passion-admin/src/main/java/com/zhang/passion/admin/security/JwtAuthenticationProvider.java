package com.zhang.passion.admin.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Description: 身份验证提供者  重写方法，使用salt 对密码进行加密，自定义密码认证逻辑
 * Author:
 * Date:
 */

public class JwtAuthenticationProvider extends DaoAuthenticationProvider {
    public JwtAuthenticationProvider(UserDetailsService userDetailsService){
        setUserDetailsService(userDetailsService);
    }

    /**
     * 其他身份验证检查
     * @param userDetails
     * @param authentication
     * @throws AuthenticationException
     */
    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
       //身份认证凭证为空
        if(authentication.getCredentials() == null){
            //打印错误信息
            logger.debug("Authentication failed: no credentials provided");
            //抛出异常
            throw new BadCredentialsException(messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"));

        }
    }
}
