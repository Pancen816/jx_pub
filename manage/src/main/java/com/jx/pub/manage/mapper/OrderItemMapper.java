package com.jx.pub.manage.mapper;

import com.github.pagehelper.Page;
import com.jx.pub.common.pojo.OrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Faxon
 * @version 1.0
 * @date 2020-02-03 18:04
 **/
@Mapper
public interface OrderItemMapper {

    /**
     * 批量添加订单项
     *
     * @param orderItems
     * @return
     */
    int addOrderItems(@Param("orderItems") List<OrderItem> orderItems);

    /**
     * 获取订单项
     *
     * @param roomNumber
     * @return
     */
    Page<OrderItem> getOrderItems(@Param("roomNumber") String roomNumber);

    /**
     * 根据id获取订单项
     *
     * @param itemId
     * @return
     */
    OrderItem getOrderItemById(@Param("itemId") String itemId);

    /**
     * 更新订单项状态
     *
     * @param orderItem
     * @return
     */
    int updateItemStatusById(@Param("orderItem") OrderItem orderItem);

    /**
     * 获取该订单下剩余未退房订单项的数量
     *
     * @param orderId
     * @return
     */
    int getOrderRestCountByOrderId(@Param("orderId") String orderId);
}
