package com.jx.pub.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Faxon
 * @version 1.0
 * @date 2020-01-30 18:39
 **/
@Data
@ToString
@ApiModel(description = "线下开单 数据对象")
public class OfflineOrder implements Serializable {

    private static final long serialVersionUID = 4843612479711110271L;

    /**
     * 房型id
     */
    @ApiModelProperty(value = "房型id")
    private String typeId;

    /**
     * 入住时间（yyyy-MM-dd HH:mm:ss）
     */
    @ApiModelProperty(value = "入住时间（yyyy-MM-dd HH:mm:ss）")
    private String comeTime;

    /**
     * 退房时间（yyyy-MM-dd HH:mm:ss）
     */
    @ApiModelProperty(value = "退房时间（yyyy-MM-dd HH:mm:ss）")
    private String leaveTime;

    /**
     * 房间号
     */
    @ApiModelProperty(value = "房间号")
    private String roomNumber;

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
}
