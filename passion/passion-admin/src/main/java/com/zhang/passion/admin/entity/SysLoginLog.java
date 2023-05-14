package com.zhang.passion.admin.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 系统登录日志
 * </p>
 *
 * @author chixiaoyu
 * @since 2023-05-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SysLoginLog对象", description="系统登录日志")
public class SysLoginLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "登录状态（online:在线，登录初始状态，方便统计在线人数；login:退出登录后将online置为login；logout:退出登录）")
    private String status;

    @ApiModelProperty(value = "IP地址")
    private String ip;

    @ApiModelProperty(value = "创建人")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新人")
    private String lastUpdateBy;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime lastUpdateTime;


}
