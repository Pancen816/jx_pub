package com.jx.pub.services.controller;

import com.jx.pub.common.dto.PageBean;
import com.jx.pub.common.dto.ResponseResult;
import com.jx.pub.common.pojo.OrderItem;
import com.jx.pub.services.service.OrderItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Bruce
 * @version 1.0
 * @date 2020-02-07 17:55
 **/
@CrossOrigin
@RestController
@RequestMapping("/orderItem")
@Api(tags = "订单项接口（用于退房界面）")
public class OrderItemController {

    @Resource
    OrderItemService itemService;

    @ApiOperation(value = "退房列表接口", notes = "退房列表接口")
    @PostMapping("/getOrderItems")
    public ResponseResult<PageBean<OrderItem>> getOrderItems(Integer page, Integer size, String roomNumber) {
        if (null == page || page < 0) {
            page = 1;
        }
        if (null == size || size < 0) {
            size = 10;
        }
        PageBean<OrderItem> pageBean = itemService.getOrderItems(page, size, roomNumber);
        return new ResponseResult<>(true, "查询成功", pageBean);
    }

    @ApiOperation(value = "退房接口", notes = "退房接口（需要订单项id ）")
    @GetMapping("/checkOutRoom/{itemId}")
    public ResponseResult<Void> checkOutRoom(@PathVariable String itemId) {
        if (StringUtils.isBlank(itemId)) {
            return new ResponseResult<>(false, "退房失败，无法获取订单项id");
        }
        boolean aBoolean = itemService.checkOutRoom(itemId);
        if (aBoolean) {
            return new ResponseResult<>(true, "退房成功");
        }
        return new ResponseResult<>(false, "退房失败");
    }
}
