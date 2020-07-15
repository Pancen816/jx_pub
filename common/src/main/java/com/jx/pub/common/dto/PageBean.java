package com.jx.pub.common.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author Bruce
 * @version 1.0
 * @date 2020-01-30 18:39
 **/
@Data
@ToString
@ApiModel(description = "分页数据对象")
public class PageBean<T> implements Serializable {

    private static final long serialVersionUID = -7595799684416080512L;

    /**
     * 页数
     */
    @ApiModelProperty(value = "页数")
    private Integer page;

    /**
     * 单页条数
     */
    @ApiModelProperty(value = "单页条数")
    private Integer size;

    /**
     * 数据列表
     */
    @ApiModelProperty(value = "数据列表")
    private List<T> dataList;

    /**
     * 数据总数
     */
    @ApiModelProperty(value = "数据总数")
    private long total;

    public PageBean(Integer page, Integer size, List<T> dataList, long total) {
        this.page = page;
        this.size = size;
        this.dataList = dataList;
        this.total = total;
    }
}
