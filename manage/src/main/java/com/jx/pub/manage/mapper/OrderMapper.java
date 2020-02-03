package com.jx.pub.manage.mapper;

import com.jx.pub.common.dto.OfflineOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Faxon
 * @version 1.0
 * @date 2020-01-30 17:27
 **/
@Mapper
public interface OrderMapper {
    /**
     * 获取某时间段内某房型的预定房间数
     *
     * @param typeId
     * @param beginTime
     * @param endTime
     * @return
     */
    Integer getRoomSumByTypeId(@Param("typeId") String typeId, @Param("beginTime") String beginTime, @Param("endTime") String endTime);

    /**
     * 根据房型id 查询 未完成订单个数
     *
     * @param typeId
     * @return
     */
    int getNotDoneOrderCountByTypeId(@Param("typeId") String typeId);

    /**
     * 添加订单
     * @param order
     * @return
     */
    int addOrder(@Param("order") OfflineOrder order);
}
