package com.zhang.passion.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Description: swagger配置类
 * Author: chixiaoyu
 * Date: 2023/05/13
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                //指定构建api文档的详细信息的方法：apiInfo()
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
    /**
     * 设置api文档的详细信息
     */
    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                // 标题
                .title("Passion权限管理系统")
                //描述
                .description("一个基于 SpringBoot + SpringCloud + Vue + Element 的权限管理系统")
                // 版本信息
                .version("1.0")
                // 构建
                .build();
    }
}
