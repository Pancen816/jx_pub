package com.jx.pub.manage.mapper;

import com.github.pagehelper.Page;
import com.jx.pub.common.dto.OfflineOrder;
import com.jx.pub.common.dto.OrderPageSearchCon;
import com.jx.pub.common.pojo.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Faxon
 * @version 1.0
 * @date 2020-01-30 17:27
 **/
@Mapper
public interface OrderMapper {
    /**
     * 获取某时间段内某房型的预定房间数
     *
     * @param typeId
     * @param beginTime
     * @param endTime
     * @return
     */
    Integer getRoomSumByTypeId(@Param("typeId") String typeId, @Param("beginTime") String beginTime, @Param("endTime") String endTime);

    /**
     * 根据房型id 查询 未完成订单个数
     *
     * @param typeId
     * @return
     */
    int getNotDoneOrderCountByTypeId(@Param("typeId") String typeId);

    /**
     * 添加订单
     *
     * @param order
     * @return
     */
    int addOrder(@Param("order") OfflineOrder order);

    /**
     * 分页条件搜索订单
     *
     * @param con
     * @return
     */
    Page<Orders> getOrderList(@Param("con") OrderPageSearchCon con);

    /**
     * 根据id 删除订单
     *
     * @param orderId
     * @return
     */
    int deleteOrderById(@Param("orderId") String orderId);

    /**
     * 根据id修改订单
     *
     * @param order
     * @return
     */
    int updateOrderById(@Param("order") OfflineOrder order);

    /**
     * 根据id查询订单信息
     *
     * @param orderId
     * @return
     */
    Orders getOrderById(@Param("orderId") String orderId);

    /**
     * 更新订单状态
     *
     * @param orderId
     * @param status
     * @param updateTime
     * @return
     */
    int updateOrderStatusById(@Param("orderId") String orderId, @Param("status") String status, @Param("updateTime") String updateTime);
}
