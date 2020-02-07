package com.jx.pub.manage.controller;

import com.jx.pub.common.dto.PageBean;
import com.jx.pub.common.dto.ResponseResult;
import com.jx.pub.common.pojo.OrderItem;
import com.jx.pub.manage.service.OrderItemService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Faxon
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
}
