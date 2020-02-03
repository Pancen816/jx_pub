package com.jx.pub.manage.service;

import com.jx.pub.common.dto.OfflineOrder;
import com.jx.pub.common.pojo.OrderItem;
import com.jx.pub.manage.mapper.LodgerMapper;
import com.jx.pub.manage.mapper.OrderItemMapper;
import com.jx.pub.manage.mapper.OrderMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Faxon
 * @version 1.0
 * @date 2020-01-30 17:26
 **/
@Service
public class OrderService {

    @Resource
    OrderMapper orderMapper;

    @Resource
    OrderItemMapper orderItemMapper;

    @Resource
    LodgerMapper lodgerMapper;

    @Transactional(rollbackFor = Exception.class)
    public boolean addOrder(OfflineOrder order) {
        int i = orderMapper.addOrder(order);
        if (i == 1) {
            List<OrderItem> orderItems = order.getOrderItems();
            int j = orderItemMapper.addOrderItems(orderItems);
            if (j > 0) {
                for (OrderItem item : orderItems) {
                    lodgerMapper.addLodgers(item.getLodgers());
                }
            }
        }
        return true;
    }
}
