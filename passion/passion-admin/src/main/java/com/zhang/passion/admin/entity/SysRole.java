package com.zhang.passion.admin.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色管理
 * </p>
 *
 * @author chixiaoyu
 * @since 2023-05-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SysRole对象", description="角色管理")
public class SysRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色名称")
    private String name;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "创建人")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新人")
    private String lastUpdateBy;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime lastUpdateTime;

    @ApiModelProperty(value = "是否删除  -1：已删除  0：正常")
    private Integer delFlag;


}
