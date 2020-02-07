package com.jx.pub.manage.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jx.pub.common.dto.PageBean;
import com.jx.pub.common.pojo.OrderItem;
import com.jx.pub.manage.mapper.OrderItemMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Faxon
 * @version 1.0
 * @date 2020-02-07 18:06
 **/
@Service
public class OrderItemService {

    @Resource
    OrderItemMapper itemMapper;

    public PageBean<OrderItem> getOrderItems(Integer page, Integer size, String roomNumber) {
        PageHelper.startPage(page,size);
        Page<OrderItem> result = itemMapper.getOrderItems(roomNumber);
        return new PageBean<>(result.getPageNum(),result.getPageSize(),result.getResult(),result.getTotal());
    }
}
