package com.jx.pub.common.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * @author: Faxon
 * @data: 2020/1/27
 */
@ApiModel(value = "com-jx-pub-common-pojo-Order")
@Data
public class Order implements Serializable {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private String orderId;

    /**
     * 用户id（ 线下0000 ）
     */
    @ApiModelProperty(value = "用户id（ 线下0000 ）")
    private String userId;

    /**
     * 房型id
     */
    @ApiModelProperty(value = "房型id")
    private String typeId;

    /**
     * 入住人姓名（ 线下---- ）
     */
    @ApiModelProperty(value = "入住人姓名（ 线下---- ）")
    private String lodgerName;

    /**
     * 入住人电话（ 线下---- ）
     */
    @ApiModelProperty(value = "入住人电话（ 线下---- ）")
    private String lodgerPhone;

    /**
     * 预定房间数量（默认1 线下1）
     */
    @ApiModelProperty(value = "预定房间数量（默认1）")
    private String reserveNumber;

    /**
     * 预计入住时间（yyyy-MM-dd 14:00:00）
     */
    @ApiModelProperty(value = "预计入住时间（yyyy-MM-dd 14:00:00）")
    private String comeTime;

    /**
     * 预计退房时间（yyyy-MM-dd 12:00:00）
     */
    @ApiModelProperty(value = "预计退房时间（yyyy-MM-dd 12:00:00）")
    private String leaveTime;

    /**
     * 房间价格
     */
    @ApiModelProperty(value = "房间价格")
    private String roomPrice;

    /**
     * 订单价格
     */
    @ApiModelProperty(value = "订单价格")
    private String orderPrice;

    /**
     * 实际价格
     */
    @ApiModelProperty(value = "实际价格")
    private String orderRealityPrice;

    /**
     * 订单状态（0：未完成；1：已完成；2：已删除）
     */
    @ApiModelProperty(value = "订单状态（0：未完成；1：已完成；2：已删除）")
    private String orderStatus;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private String orderCreatTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private String orderUpdateTime;

    private static final long serialVersionUID = -2556424939890132244L;
}
