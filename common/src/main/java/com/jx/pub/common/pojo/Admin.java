package com.jx.pub.common.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
* @author: Faxon
* @data: 2020/1/27
*/
@ApiModel(description = "管理员实体类")
@Data
public class Admin implements Serializable {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Integer adminId;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String adminName;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String adminPassword;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String adminPhone;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private String adminCreatTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private String adminUpdateTime;

    private static final long serialVersionUID = 2425503061984110097L;
}
