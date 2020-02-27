package com.jx.pub.common.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Faxon
 * @data: 2020/1/27
 */
@ApiModel(value = "com-jx-pub-common-pojo-Order")
@Data
public class Orders implements Serializable {

    private static final long serialVersionUID = -2556424939890132244L;
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
     * 预定房间数量
     */
    @ApiModelProperty(value = "预定房间数量")
    private String reserveNumber;

    /**
     * 入住时间（yyyy-MM-dd 14:00:00）
     */
    @ApiModelProperty(value = "预计入住时间（yyyy-MM-dd 14:00:00）")
    private String comeTime;

    /**
     * 退房时间（yyyy-MM-dd 12:00:00）
     */
    @ApiModelProperty(value = "预计退房时间（yyyy-MM-dd 12:00:00）")
    private String leaveTime;

    /**
     * 房型价格
     */
    @ApiModelProperty(value = "房型价格")
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
     * 客户端是否展示，即用户是否删除订单
     */
    @ApiModelProperty(value = "用户是否删除订单（用户是否删除（0：未删除；1已删除））")
    private String orderShowStatus;

    /**
     * 订单状态（0：未入住；1：已入住；2：已完成；3：已删除）
     */
    @ApiModelProperty(value = "订单状态（0：未入住；1：已入住；2：已完成；3：已删除）")
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


    //----------------

    /**
     * 房型名称
     */
    @ApiModelProperty(value = "房型名称（10字内）")
    private String typeName;

    /**
     * 订单来源（0：线下；1：线上；）
     */
    @ApiModelProperty(value = "订单来源（0：线下；1：线上；）")
    private String orderSource;

    /**
     * 订单所对应的房间号（以‘/’分割）
     */
    @ApiModelProperty(value = "订单所对应的房间号（以‘/’分割）")
    private String roomNumbers;
}
