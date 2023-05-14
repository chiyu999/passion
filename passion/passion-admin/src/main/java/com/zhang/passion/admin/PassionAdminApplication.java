package com.zhang.passion.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@MapperScan("com.zhang.passion.admin.mapper")
//@EnableWebMvc
public class PassionAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(PassionAdminApplication.class, args);
    }

}
