package com.jx.pub.services.controller;

import com.jx.pub.common.dto.ResponseResult;
import com.jx.pub.common.pojo.Orders;
import com.jx.pub.services.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Faxon
 * @version 1.0
 * @date 2020-02-27 17:53
 **/
@CrossOrigin
@RestController
@RequestMapping("/userOrder")
@Api(tags = "用户订单接口")
public class UserOrderController {

    @Resource
    OrderService orderService;

    @PostMapping("/bookingRoom")
    @ApiOperation(value = "预定房间", notes = "参数（json）：userId,typeId,lodgerName,lodgerPhone,reserveNumber," +
            "comeTime,leaveTime,roomPrice,orderPrice,orderRealityPrice")
    public ResponseResult<Void> bookingRoom(@RequestBody Orders order) {
        if (StringUtils.isBlank(order.getTypeId()) || StringUtils.isBlank(order.getReserveNumber()) || StringUtils.isBlank(order.getUserId())
                || StringUtils.isBlank(order.getLodgerName()) || StringUtils.isBlank(order.getLodgerPhone()) || StringUtils.isBlank(order.getComeTime())
                || StringUtils.isBlank(order.getLeaveTime()) || StringUtils.isBlank(order.getRoomPrice()) || StringUtils.isBlank(order.getOrderPrice())
                || StringUtils.isBlank(order.getOrderRealityPrice())) {
            return new ResponseResult<>(false, "参数不完整");
        }
        Boolean aBoolean = orderService.bookingRoom(order);
        if (aBoolean) {
            return new ResponseResult<>(true, "预定成功");
        }
        return new ResponseResult<>(false, "预定失败");
    }

    @GetMapping("/getNotInOrders/{userId}")
    @ApiOperation(value = "获取未入住订单", notes = "参数:userId")
    public ResponseResult<List<Orders>> getNotInOrdersByUserId(@PathVariable("userId") String userId) {
        if (StringUtils.isBlank(userId)) {
            return new ResponseResult<>(false, "参数不完整");
        }
        List<Orders> ordersList = orderService.getNotInOrdersByUserId(userId);
        return new ResponseResult<>(true, "查询成功", ordersList);
    }

    @GetMapping("/getHistoryOrders/{userId}")
    @ApiOperation(value = "获取历史订单", notes = "参数:userId")
    public ResponseResult<List<Orders>> getHistoryOrdersByUserId(@PathVariable("userId") String userId) {
        if (StringUtils.isBlank(userId)) {
            return new ResponseResult<>(false, "参数不完整");
        }
        List<Orders> ordersList = orderService.getHistoryOrdersByUserId(userId);
        return new ResponseResult<>(true, "查询成功", ordersList);
    }

    @GetMapping("/deleteOrderByUser/{orderId}")
    @ApiOperation(value = "用户端删除订单", notes = "参数:orderId")
    public ResponseResult<Void> deleteOrderByUser(@PathVariable("orderId") String orderId){
        if (StringUtils.isBlank(orderId)) {
            return new ResponseResult<>(false, "参数不完整");
        }
        Boolean aBoolean = orderService.deleteOrderByUser(orderId);
        if (aBoolean) {
            return new ResponseResult<>(true, "删除成功");
        }
        return new ResponseResult<>(false, "删除失败");
    }

}
