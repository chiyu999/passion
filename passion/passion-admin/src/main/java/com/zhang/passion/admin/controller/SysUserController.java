package com.zhang.passion.admin.controller;


import com.zhang.passion.admin.entity.SysUser;
import com.zhang.passion.admin.service.ISysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户管理 前端控制器
 * </p>
 *
 * @author chixiaoyu
 * @since 2023-05-14
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class SysUserController {
    private final ISysUserService userService;

    /**
     * localhost:8081/user/list
     * @return
     */
    @GetMapping("/list")
    public List<SysUser> listAll(){
        List<SysUser> list = userService.list();
        return list;
    }

}
