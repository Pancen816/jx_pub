package com.jx.pub.manage.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jx.pub.common.dto.OfflineOrder;
import com.jx.pub.common.dto.OrderPageSearchCon;
import com.jx.pub.common.dto.PageBean;
import com.jx.pub.common.pojo.Lodger;
import com.jx.pub.common.pojo.OrderItem;
import com.jx.pub.common.pojo.Orders;
import com.jx.pub.common.util.TimeUtil;
import com.jx.pub.manage.mapper.LodgerMapper;
import com.jx.pub.manage.mapper.OrderItemMapper;
import com.jx.pub.manage.mapper.OrderMapper;
import com.jx.pub.manage.mapper.RoomMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Resource
    RoomMapper roomMapper;

    @Transactional(rollbackFor = Exception.class)
    public boolean addOrder(OfflineOrder order) {
        int i;
        if (StringUtils.isBlank(order.getOrderId())) {
            i = orderMapper.addOrder(order);
        } else {
            i = orderMapper.updateOrderById(order);
        }

        if (i == 1) {
            List<OrderItem> orderItems = order.getOrderItems();
            int j = orderItemMapper.addOrderItems(orderItems);
            if (j > 0) {
                for (OrderItem item : orderItems) {
                    roomMapper.updateRoomStatusById(item.getRoomId(), "1", TimeUtil.getNowTime());
                    lodgerMapper.addLodgers(item.getLodgers());
                }
            }
        }
        return true;
    }

    public PageBean<Orders> getOrderList(OrderPageSearchCon con) {
        PageHelper.startPage(con.getPage(), con.getSize());
        Page<Orders> page = orderMapper.getOrderList(con);
        List<Orders> result = page.getResult();
        for (Orders orders : result) {
            if (!"0000".equals(orders.getUserId())) {
                orders.setOrderSource("1");
            } else {
                orders.setOrderSource("0");
            }
            List<String> roomNumbers = orderItemMapper.getRoomListByOrderId(orders.getOrderId());
            if (null != roomNumbers && roomNumbers.size() > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < roomNumbers.size(); i++) {
                    sb.append(roomNumbers.get(i)).append("/");
                }
                String roomNumbersStr = sb.toString().substring(0, sb.toString().length() - 1);
                orders.setRoomNumbers(roomNumbersStr);
            } else {
                orders.setRoomNumbers("");
            }
        }
        return new PageBean<>(page.getPageNum(), page.getPageSize(), result, page.getTotal());
    }

    public boolean deleteOrderById(String orderId) {
        int i = orderMapper.deleteOrderById(orderId);
        return i == 1;
    }

    public Orders getOrderById(String orderId) {
        return orderMapper.getOrderById(orderId);
    }

    public List<OrderItem> getOrderLodgerById(String orderId) {
        List<OrderItem> orderItems = orderItemMapper.getOrderLodgerByOrderId(orderId);
        if(null != orderItems){
            for (OrderItem item : orderItems) {
                List<Lodger> lodgers = lodgerMapper.getLodgersByItemId(item.getItemId());
                item.setLodgers(lodgers);
            }
            return orderItems;
        }
        return null;
    }

    public List<Map<String, Object>> getOrdersMap(OrderPageSearchCon con) {
        List<Orders> ordersList = orderMapper.getOrderListForExport(con);
        List<Map<String, Object>> data = new ArrayList<>();
        for (Orders orders : ordersList) {
            if (!"0000".equals(orders.getUserId())) {
                orders.setOrderSource("线上");
            } else {
                orders.setOrderSource("线下");
            }
            List<String> roomNumbers = orderItemMapper.getRoomListByOrderId(orders.getOrderId());
            if (null != roomNumbers && roomNumbers.size() > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < roomNumbers.size(); i++) {
                    sb.append(roomNumbers.get(i)).append("/");
                }
                String roomNumbersStr = sb.toString().substring(0, sb.toString().length() - 1);
                orders.setRoomNumbers(roomNumbersStr);
            } else {
                orders.setRoomNumbers("");
            }
            if("0".equals(orders.getOrderStatus())){
                orders.setOrderStatus("未入住");
            }else if("1".equals(orders.getOrderStatus())){
                orders.setOrderStatus("已入住");
            }else {
                orders.setOrderStatus("已完成");
            }
            Map<String, Object> map = new HashMap<>(9);
            map.put("typeName",orders.getTypeName());
            map.put("roomNumbers",orders.getRoomNumbers());
            map.put("lodgerName",orders.getLodgerName());
            map.put("orderCreatTime",orders.getOrderCreatTime());
            map.put("comeTime",orders.getComeTime());
            map.put("leaveTime",orders.getLeaveTime());
            map.put("orderSource",orders.getOrderSource());
            map.put("orderRealityPrice",orders.getOrderRealityPrice());
            map.put("orderStatus",orders.getOrderStatus());
            data.add(map);
        }
        return data;
    }
}
