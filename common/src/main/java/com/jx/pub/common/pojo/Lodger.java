package com.jx.pub.common.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Bruce
 * @version 1.0
 * @date 2020-01-30 18:39
 **/
@ApiModel(value = "com-jx-pub-common-pojo-Lodger")
@Data
public class Lodger implements Serializable {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private String lodgerId;

    /**
     * 入住人名称
     */
    @ApiModelProperty(value = "入住人名称")
    private String lodgerName;

    /**
     * 身份证号
     */
    @ApiModelProperty(value = "身份证号")
    private String lodgerIdNumber;

    /**
     * 性别（0：男，1：女）
     */
    @ApiModelProperty(value = "性别（0：男，1：女）")
    private String lodgerSex;

    /**
     * 订单项id
     */
    @ApiModelProperty(value = "订单项id")
    private String orderItemId;

    /**
     * 创建时间（即入住时间）
     */
    @ApiModelProperty(value = "创建时间（即入住时间）")
    private String lodgerCreatTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private String lodgerUpdateTime;

    /**
     * 退房时间（yyyy-MM-dd 12:00:00）
     */
    @ApiModelProperty(value = "预计退房时间（yyyy-MM-dd 12:00:00）")
    private String leaveTime;

    private static final long serialVersionUID = -5858166733322294952L;
}
