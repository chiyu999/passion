package com.zhang.passion.admin.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 机构管理
 * </p>
 *
 * @author chixiaoyu
 * @since 2023-05-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SysDept对象", description="机构管理")
public class SysDept implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "机构名称")
    private String name;

    @ApiModelProperty(value = "上级机构ID，一级机构为0")
    private Long parentId;

    @ApiModelProperty(value = "排序")
    private Integer orderNum;

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
