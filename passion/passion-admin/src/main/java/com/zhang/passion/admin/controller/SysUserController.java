package com.zhang.passion.admin.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhang.passion.admin.constant.SysConstants;
import com.zhang.passion.admin.entity.SysUser;
import com.zhang.passion.admin.service.ISysUserService;
import com.zhang.passion.core.http.HttpResult;
import com.zhang.passion.core.page.PageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
//    @GetMapping("/page")
//    public Page<SysUser> findPage(int pageNum, int pageSize){
//        Page page = new Page(pageNum,pageSize);
//        LambdaQueryWrapper<SysUser> sysUserLambdaQueryWrapper = new LambdaQueryWrapper<>();
//        Page userPage = userService.page(page);
//        return userPage;
//    }

    /**
     * 保存记录
     * @param record
     * @return
     */
    @PostMapping(value="/save")
    public HttpResult save(@RequestBody SysUser record) {
        SysUser user = userService.findById(record.getId());
        if(user != null) {
            if(SysConstants.ADMIN.equalsIgnoreCase(user.getName())) {
                return HttpResult.error("超级管理员不允许修改!");
            }
        }

        return HttpResult.ok(userService.save(record));
    }

    /**
     * 删除用户
     * @param records
     * @return
     */
//    @PostMapping(value="/delete")
//    public HttpResult delete(@RequestBody List<SysUser> records) {
//    }

    /**
     * 根据名称查询
     * @param name
     * @return
     */
//    @GetMapping(value="/findByName")
//    public HttpResult findByName(@RequestParam String name) {
//
//    }

    /**
     * 查询用户权限
     * @param name
     * @return
     */
//    @GetMapping(value="/findPermissions")
//    public HttpResult findPermissions(@RequestParam String name) {
//
//    }

    /**
     * 查询用户角色
     * @param userId
     * @return
     */
//    @GetMapping(value="/findUserRoles")
//    public HttpResult findUserRoles(@RequestParam Long userId) {
//
//    }

    /**
     * 分页查询
     * @param pageRequest
     * @return
     */

    @PostMapping(value="/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        Page page = new Page(pageRequest.getPageNum(), pageRequest.getPageSize());
        Page<SysUser> userPage = null;
        Object name = pageRequest.getParam("name");
        Object email = pageRequest.getParam("email");
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper();
        if (name != null){
            queryWrapper.eq(SysUser::getName,name);
            if (email != null){
                queryWrapper.eq(SysUser::getEmail,email);

            }
            userPage = userService.page(page, queryWrapper);
        }else {
            userPage = userService.page(page);
        }
        return HttpResult.ok(userPage);
    }

//    @PostMapping(value="/exportExcelUser")
//    public void exportExcelUser(@RequestBody PageRequest pageRequest, HttpServletResponse res) {
//    }
//

}
