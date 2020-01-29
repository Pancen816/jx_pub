package com.jx.pub.common.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * @author: Faxon
 * @data: 2020/1/27
 */
@ApiModel(value = "com-jx-pub-common-pojo-RoomType")
@Data
public class RoomType implements Serializable {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private String typeId;

    /**
     * 类型名称
     */
    @ApiModelProperty(value = "类型名称")
    private String typeName;

    /**
     * 图片地址
     */
    @ApiModelProperty(value = "图片地址")
    private String typePic;

    /**
     * 房间价格
     */
    @ApiModelProperty(value = "房间价格")
    private String typePrice;

    /**
     * 面积（单位 平方米）
     */
    @ApiModelProperty(value = "面积（单位 平方米）")
    private String typeArea;

    /**
     * 是否有窗（0:无窗，1有窗）
     */
    @ApiModelProperty(value = "是否有窗（0:无窗，1有窗）")
    private String typeWindow;

    /**
     * 最多居住人数
     */
    @ApiModelProperty(value = "最多居住人数")
    private String typeMaxPeople;

    /**
     * 是否有早餐
     */
    @ApiModelProperty(value = "是否有早餐")
    private String typeBreakfast;

    /**
     * 床铺信息
     */
    @ApiModelProperty(value = "床铺信息")
    private String typeBed;

    /**
     *
     */
    @ApiModelProperty(value = "")
    private String typeCreatTime;

    /**
     *
     */
    @ApiModelProperty(value = "")
    private String typeUpdateTime;

    private static final long serialVersionUID = -8681146305242423028L;
}
