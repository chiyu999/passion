package com.zhang.passion.admin.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Description: 用户登录认证信息查询
 * 登录认证（JwtAuthenticationProvider extends DaoAuthenticationProvider）
 * 默认通过 DaoAuthenticationProvider来完成，而登录验证器在认证时肯定要从数据库中获取用户信息进行匹配的，
 * 而这个获取用户信息的任务是通过Spring Security 的 UserDetailsService组件来完成
 * UserDetailsServiceImpl实现UserDetailsService接口，覆写其中
 * 的方法loadUserByUsername,查询用户的密码信息和权限信息并封装到UserDetails的实现类对象，
 * 作为结果JwtUserDetails返回给DaoAuthenticationProvider做进一步处理。
 * Author: chixiaoyu
 * Date: 2023/06/09
 */

public class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    }
}
