package com.zhang.passion.admin.service.impl;

import com.zhang.passion.admin.entity.SysUser;
import com.zhang.passion.admin.mapper.SysUserMapper;
import com.zhang.passion.admin.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户管理 服务实现类
 * </p>
 *
 * @author chixiaoyu
 * @since 2023-05-14
 */
@Service
@RequiredArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
    private final SysUserMapper userMapper;
    @Override
    public SysUser findById(Long id) {
        return userMapper.selectById(id);
    }
}
