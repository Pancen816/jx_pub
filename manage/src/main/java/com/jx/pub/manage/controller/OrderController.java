package com.jx.pub.manage.controller;

import com.jx.pub.common.dto.OfflineOrder;
import com.jx.pub.common.dto.ResponseResult;
import com.jx.pub.manage.mapper.OrderMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
    OrderMapper orderMapper;

    @ApiOperation(value = "线下开单", notes = "线下开单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "typeId", value = "房型id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "comeTime", value = "入住时间", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "leaveTime", value = "退房时间", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "roomNumber", value = "房间号", required = true, dataType = "String", paramType = "query"),
    })
    @PostMapping("/addOrder")
    public ResponseResult<Void> addOrder(OfflineOrder order) {
        return null;
    }
}
