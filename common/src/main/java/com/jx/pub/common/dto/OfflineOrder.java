package com.jx.pub.common.dto;

import com.jx.pub.common.pojo.OrderItem;
import com.jx.pub.common.pojo.Orders;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author Faxon
 * @version 1.0
 * @date 2020-01-30 18:39
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@ApiModel(description = "线下开单 数据对象")
public class OfflineOrder extends Orders implements Serializable {

    private static final long serialVersionUID = 4843612479711110271L;

    /**
     * 订单项集合
     */
    @ApiModelProperty(value = "订单项集合")
    private List<OrderItem> orderItems;
}
