package com.jx.pub.services.controller;

import com.jx.pub.common.dto.OfflineOrder;
import com.jx.pub.common.dto.OrderPageSearchCon;
import com.jx.pub.common.dto.PageBean;
import com.jx.pub.common.dto.ResponseResult;
import com.jx.pub.common.pojo.Lodger;
import com.jx.pub.common.pojo.OrderItem;
import com.jx.pub.common.pojo.Orders;
import com.jx.pub.common.util.IDUtil;
import com.jx.pub.common.util.POIUtil;
import com.jx.pub.common.util.TimeUtil;
import com.jx.pub.services.service.OrderService;
import com.jx.pub.services.service.RoomTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author Bruce
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

    /**
     * 列表导出常量
     */
    public static final String ORDERS_SHEETNAME = "订单列表";
    public static final String[] ORDERS_HEADERSNAME = {"序号", "房型", "房号", "开房人姓名", "创建时间", "入住时间", "退房时间", "订单来源", "实收价格", "订单状态"};
    public static final String[] ORDERS_KEYS = {"typeName", "roomNumbers", "lodgerName", "orderCreatTime", "comeTime", "leaveTime", "orderSource", "orderRealityPrice", "orderStatus"};

    @ApiOperation(value = "开单", notes = "开单")
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

    @ApiOperation(value = "条件分页获取订单列表", notes = "条件分页获取订单列表")
    @PostMapping("/getOrderList")
    public ResponseResult<PageBean<Orders>> getOrderList(@RequestBody OrderPageSearchCon con) {
        String message = checkConParams(con);
        if (null != message) {
            return new ResponseResult<>(false, message);
        }
        PageBean<Orders> pageBean = orderService.getOrderList(con);
        return new ResponseResult<>(true, "查询成功", pageBean);
    }

    @ApiOperation(value = "根据id删除订单", notes = "根据id删除订单")
    @GetMapping("/deleteOrderById/{orderId}")
    public ResponseResult<Void> deleteOrderById(@PathVariable("orderId") String orderId) {
        boolean aBoolean = orderService.deleteOrderById(orderId);
        if (aBoolean) {
            return new ResponseResult<>(true, "删除订单成功");
        }
        return new ResponseResult<>(false, "删除订单失败");
    }

    @ApiOperation(value = "根据id获取订单信息", notes = "根据id获取订单信息")
    @GetMapping("/getOrderById/{orderId}")
    public ResponseResult<Orders> getOrderById(@PathVariable("orderId") String orderId) {
        Orders orders = orderService.getOrderById(orderId);
        if (null == orders) {
            return new ResponseResult<>(false, "查询订单失败");
        }
        return new ResponseResult<>(true, "查询订单成功", orders);
    }

    @ApiOperation(value = "根据id获取相关订单项信息", notes = "根据id获取相关订单项信息")
    @GetMapping("/getOrderLodgerById/{orderId}")
    public ResponseResult<List<OrderItem>> getOrderLodgerById(@PathVariable("orderId") String orderId) {
        List<OrderItem> orderItems = orderService.getOrderLodgerById(orderId);
        if (null == orderItems) {
            return new ResponseResult<>(false, "查询订单项失败");
        }
        return new ResponseResult<>(true, "查询订单项成功", orderItems);
    }

    @ApiOperation(value = "订单导出", notes = "订单导出")
    @GetMapping("/exportOrdersByCon")
    public void exportOrdersByCon(OrderPageSearchCon con, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> data = orderService.getOrdersMap(con);

        String fileName = ORDERS_SHEETNAME + TimeUtil.getNow("yyyyMMdd");

        SXSSFWorkbook export = POIUtil.export(fileName, data, ORDERS_HEADERSNAME, ORDERS_KEYS);

        POIUtil.writeTo(fileName, export, response);
    }

    /**
     * 检查条件搜索时的参数合法性
     *
     * @param con
     * @return
     */
    private String checkConParams(OrderPageSearchCon con) {
        if (null != con) {
            if (null == con.getPage() || con.getPage() < 0) {
                con.setPage(1);
            }
            if (null == con.getSize() || con.getSize() < 0) {
                con.setSize(3);
            }
            String status = con.getOrderStatus();
            if (StringUtils.isNotBlank(status) && !"0".equals(status) && !"1".equals(status) && !"2".equals(status)) {
                return "搜索失败，订单状态参数非法（限定0,1,2）";
            }
            String beginTime = con.getBeginTime();
            String endTime = con.getEndTime();
            if (StringUtils.isNotBlank(beginTime) && StringUtils.isNotBlank(endTime) && beginTime.compareTo(endTime) >= 0) {
                return "搜索失败，时间参数非法（开始时间应小于结束时间）";
            }
        }
        return null;
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
        if (!"0000".equals(order.getUserId())) {
            if (StringUtils.isBlank(order.getOrderId())) {
                return "开单失败，线上订单开单时需要订单id";
            }
        } else {
            order.setOrderCreatTime(TimeUtil.getNowTime());
        }
        order.setOrderShowStatus("0");
        order.setOrderStatus("1");
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
            item.setRealityComeTime(TimeUtil.getNowTime());
            item.setRealityLeaveTime(order.getLeaveTime());
            item.setItemStatus("0");
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
