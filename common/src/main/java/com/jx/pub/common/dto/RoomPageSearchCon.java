package com.jx.pub.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Faxon
 * @version 1.0
 * @date 2020-01-30 10:31
 **/
@Data
@ToString
@ApiModel(description = "房间分页查询条件对象")
public class RoomPageSearchCon implements Serializable {

    private static final long serialVersionUID = -4049992949265533421L;

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
     * 类型id
     */
    @ApiModelProperty(value = "类型id")
    private String typeId;

    /**
     * 房间号
     */
    @ApiModelProperty(value = "房间号")
    private String roomNumber;

    /**
     * 房间状态 ( 0:未入住；1:已入住； )
     */
    @ApiModelProperty(value = "房间状态 ( 0:未入住；1:已入住； )")
    private String roomStatus;

}
