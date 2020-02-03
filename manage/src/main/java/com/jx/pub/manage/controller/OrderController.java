package com.jx.pub.manage.controller;

import com.jx.pub.common.dto.OfflineOrder;
import com.jx.pub.common.dto.ResponseResult;
import com.jx.pub.common.pojo.Lodger;
import com.jx.pub.common.pojo.OrderItem;
import com.jx.pub.common.util.IDUtil;
import com.jx.pub.common.util.TimeUtil;
import com.jx.pub.manage.service.OrderService;
import com.jx.pub.manage.service.RoomTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Faxon
 * @version 1.0
 * @date 2020-01-30 17:24
 **/
@CrossOrigin
@RestController
@RequestMapping("/order")
@Api(tags = "订单接口")
public class OrderController {

    @Resource
    OrderService orderService;

    @Resource
    RoomTypeService roomTypeService;

    @ApiOperation(value = "线下开单", notes = "线下开单")
    @PostMapping("/addOrder")
    public ResponseResult<Void> addOrder(@RequestBody OfflineOrder order) {
        String message = checkOrdersParams(order);
        if (null != message) {
            return new ResponseResult<>(false, message);
        }
        boolean aBoolean = orderService.addOrder(order);
        if (aBoolean) {
            return new ResponseResult<>(true, "开单成功");
        }
        return new ResponseResult<>(false, "开单失败");
    }

    /**
     * 检查并完善开单时的订单信息
     *
     * @param order
     * @return
     */
    private String checkOrdersParams(OfflineOrder order) {
        if (StringUtils.isBlank(order.getTypeId()) || StringUtils.isBlank(order.getReserveNumber()) || StringUtils.isBlank(order.getUserId())
                || StringUtils.isBlank(order.getLodgerName()) || StringUtils.isBlank(order.getLodgerPhone()) || StringUtils.isBlank(order.getComeTime())
                || StringUtils.isBlank(order.getLeaveTime()) || StringUtils.isBlank(order.getRoomPrice()) || StringUtils.isBlank(order.getOrderPrice())
                || StringUtils.isBlank(order.getOrderRealityPrice()) || order.getOrderItems().size() < 1) {
            return "开单失败，订单信息缺少必要参数";
        }
        order.setOrderId(IDUtil.getUUID());
        order.setOrderStatus("1");
        order.setOrderCreatTime(TimeUtil.getNowTime());
        order.setOrderUpdateTime(TimeUtil.getNowTime());
        List<OrderItem> orderItems = order.getOrderItems();
        if (orderItems.size() > Integer.parseInt(order.getReserveNumber())) {
            return "开单失败，订单项大于预定房间数";
        }
        int maxNumber = roomTypeService.getTypeMaxPeopleById(order.getTypeId());
        for (int i = 0; i < orderItems.size(); i++) {
            OrderItem item = orderItems.get(i);
            if (StringUtils.isBlank(item.getRoomId()) || item.getLodgers().size() < 1) {
                return "开单失败，第" + (i + 1) + "条订单项 缺少必要参数";
            }
            List<Lodger> lodgers = item.getLodgers();
            if (lodgers.size() > maxNumber) {
                return "开单失败，第" + (i + 1) + "条订单项 入住人数 超过 房型限住人数";
            }
            item.setItemId(IDUtil.getUUID());
            item.setOrderId(order.getOrderId());
            item.setRealityComeTime(TimeUtil.getNowTime());
            item.setRealityLeaveTime(order.getLeaveTime());
            item.setItemCreatTime(order.getOrderCreatTime());
            item.setItemUpdateTime(order.getOrderUpdateTime());
            for (int j = 0; j < lodgers.size(); j++) {
                Lodger lodger = lodgers.get(j);
                if (StringUtils.isBlank(lodger.getLodgerIdNumber()) || StringUtils.isBlank(lodger.getLodgerSex()) || StringUtils.isBlank(lodger.getLodgerName())) {
                    return "开单失败，第" + (i + 1) + "条订单项,第" + (j + 1) + "个入住人缺少必要参数";
                }
                lodger.setLodgerId(IDUtil.getUUID());
                lodger.setOrderItemId(item.getItemId());
                lodger.setLodgerCreatTime(TimeUtil.getNowTime());
                lodger.setLodgerUpdateTime(TimeUtil.getNowTime());
            }
        }
        return null;
    }
}
