package com.jx.pub.common.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author: Faxon
 * @data: 2020/1/27
 */
@ApiModel(value = "com-jx-pub-common-pojo-OrderItem")
@Data
public class OrderItem implements Serializable {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private String itemId;

    /**
     * 订单id
     */
    @ApiModelProperty(value = "订单id")
    private String orderId;

    /**
     * 房间id
     */
    @ApiModelProperty(value = "房间id")
    private String roomId;

    /**
     * 实际入住时间
     */
    @ApiModelProperty(value = "实际入住时间")
    private String realityComeTime;

    /**
     * 实际退房时间
     */
    @ApiModelProperty(value = "实际退房时间")
    private String realityLeaveTime;

    /**
     * 订单项状态（0：已入住，1：已退房）
     */
    @ApiModelProperty(value = "订单项状态（0：已入住，1：已退房）")
    private String itemStatus;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private String itemCreatTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private String itemUpdateTime;

    /**
     * 入住人信息集合
     */
    @ApiModelProperty(value = "入住人信息集合")
    private List<Lodger> lodgers;

    private static final long serialVersionUID = -8897591827401779135L;
}
