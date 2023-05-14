package com.zhang.passion.admin.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 系统配置表
 * </p>
 *
 * @author chixiaoyu
 * @since 2023-05-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SysConfig对象", description="系统配置表")
public class SysConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "数据值")
    private String value;

    @ApiModelProperty(value = "标签名")
    private String label;

    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "排序（升序）")
    private BigDecimal sort;

    @ApiModelProperty(value = "创建人")
    private String createBy;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新人")
    private String lastUpdateBy;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime lastUpdateTime;

    @ApiModelProperty(value = "备注信息")
    private String remarks;

    @ApiModelProperty(value = "是否删除  -1：已删除  0：正常")
    private Integer delFlag;


}
