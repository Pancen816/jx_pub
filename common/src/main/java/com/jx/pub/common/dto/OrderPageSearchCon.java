package com.jx.pub.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Faxon
 * @version 1.0
 * @date 2020-02-04 16:34
 **/
@Data
@ToString
@ApiModel(description = "订单分页查询条件对象")
public class OrderPageSearchCon implements Serializable {

    private static final long serialVersionUID = 5980476162398206974L;

    /**
     * 页数
     */
    @ApiModelProperty(value = "页数")
    private Integer page;

    /**
     * 单页条数
     */
    @ApiModelProperty(value = "单页条数")
    private Integer size;

    /**
     * 房型id
     */
    @ApiModelProperty(value = "房型id")
    private String typeId;

    /**
     * 入住人姓名
     */
    @ApiModelProperty(value = "入住人姓名")
    private String lodgerName;

    /**
     * 入住人电话
     */
    @ApiModelProperty(value = "入住人电话")
    private String lodgerPhone;

    /**
     * 订单状态（0：未入住；1：已入住；2：已完成；）
     */
    @ApiModelProperty(value = "订单状态（0：未入住；1：已入住；2：已完成；）")
    private String orderStatus;

    /**
     * 订单来源（0：线下；1：线上；）
     */
    @ApiModelProperty(value = "订单来源（0：线下；1：线上；）")
    private String orderSource;

    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间")
    private String beginTime;

    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间")
    private String endTime;
}
