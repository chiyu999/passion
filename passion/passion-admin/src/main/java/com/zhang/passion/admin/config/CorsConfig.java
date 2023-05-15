package com.zhang.passion.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Description: cors配置类，实现跨域访问
 * Author: chixiaoyu
 * Date: 2023/05/15
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //允许跨域访问的路径
        registry.addMapping("/**")
                //允许跨域访问的源
                .allowedOrigins("*")
                //允许请求方法
                .allowedMethods("POST","GET","PUT","OPTIONS","DELETE")
                //预检间隔时间
                .maxAge(168000)
                //允许头部设置
                .allowedHeaders("*")
                //是否发送cookie
                .allowCredentials(true);

    }
}
