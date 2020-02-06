package com.jx.pub.manage.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jx.pub.common.dto.OfflineOrder;
import com.jx.pub.common.dto.OrderPageSearchCon;
import com.jx.pub.common.dto.PageBean;
import com.jx.pub.common.pojo.OrderItem;
import com.jx.pub.common.pojo.Orders;
import com.jx.pub.manage.mapper.LodgerMapper;
import com.jx.pub.manage.mapper.OrderItemMapper;
import com.jx.pub.manage.mapper.OrderMapper;
import org.apache.commons.lang3.StringUtils;
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
        int i = 0;
        if(StringUtils.isBlank(order.getOrderId())){
            i = orderMapper.addOrder(order);
        }else {
            i = orderMapper.updateOrderById(order);
        }

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

    public PageBean<Orders> getOrderList(OrderPageSearchCon con) {
        PageHelper.startPage(con.getPage(),con.getSize());
        Page<Orders> page = orderMapper.getOrderList(con);
        return new PageBean<>(page.getPageNum(),page.getPageSize(),page.getResult(),page.getTotal());
    }

    public boolean deleteOrderById(String orderId) {
        int i = orderMapper.deleteOrderById(orderId);
        return i == 1;
    }

    public Orders getOrderById(String orderId) {
        return orderMapper.getOrderById(orderId);
    }
}
