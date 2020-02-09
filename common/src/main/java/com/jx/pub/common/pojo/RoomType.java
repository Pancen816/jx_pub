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
    @ApiModelProperty(value = "类型名称（10字内）")
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
     * 是否有早餐（0:无，1有）
     */
    @ApiModelProperty(value = "是否有早餐（0:无，1有）")
    private String typeBreakfast;

    /**
     * 床铺信息(15字以内)
     */
    @ApiModelProperty(value = "床铺信息")
    private String typeBed;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private String typeCreatTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private String typeUpdateTime;

    // --------------------------------

    /**
     * 已预定房间数
     */
    @ApiModelProperty(value = "已预定房间数")
    private Integer typeOrderSum;

    /**
     * 房间总数
     */
    @ApiModelProperty(value = "房间总数")
    private Integer typeRoomCount;

    /**
     * 剩余房间数（房间总数-预定房间数）
     */
    @ApiModelProperty(value = "剩余房间数（房间总数-预定房间数）")
    private Integer typeRestRoomCount;

    /**
     * 所属房间集合
     */
    @ApiModelProperty(value = "所属房间集合")
    List<Room> roomList;

    private static final long serialVersionUID = -8681146305242423028L;
}
