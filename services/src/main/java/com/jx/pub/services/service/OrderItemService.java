package com.jx.pub.services.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jx.pub.common.dto.PageBean;
import com.jx.pub.common.pojo.OrderItem;
import com.jx.pub.common.util.TimeUtil;
import com.jx.pub.services.mapper.OrderItemMapper;
import com.jx.pub.services.mapper.OrderMapper;
import com.jx.pub.services.mapper.RoomMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Bruce
 * @version 1.0
 * @date 2020-02-07 18:06
 **/
@Service
public class OrderItemService {

    @Resource
    OrderItemMapper itemMapper;

    @Resource
    OrderMapper orderMapper;

    @Resource
    RoomMapper roomMapper;

    public PageBean<OrderItem> getOrderItems(Integer page, Integer size, String roomNumber) {
        PageHelper.startPage(page, size);
        Page<OrderItem> result = itemMapper.getOrderItems(roomNumber);
        return new PageBean<>(result.getPageNum(), result.getPageSize(), result.getResult(), result.getTotal());
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean checkOutRoom(String itemId) {
        OrderItem orderItem = itemMapper.getOrderItemById(itemId);
        orderItem.setItemStatus("1");
        orderItem.setItemUpdateTime(TimeUtil.getNowTime());
        int i = itemMapper.updateItemStatusById(orderItem);
        if (i == 1) {
            int j = roomMapper.updateRoomStatusById(orderItem.getRoomId(), "0", TimeUtil.getNowTime());
            if (j == 1) {
                int orderRestCount = itemMapper.getOrderRestCountByOrderId(orderItem.getOrderId());
                if (orderRestCount == 0) {
                    orderMapper.updateOrderStatusById(orderItem.getOrderId(), "2", TimeUtil.getNowTime());
                }
            }

        }
        return true;
    }
}
