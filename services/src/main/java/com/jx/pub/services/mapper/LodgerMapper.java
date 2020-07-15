package com.jx.pub.services.mapper;

import com.jx.pub.common.pojo.Lodger;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Bruce
 * @version 1.0
 * @date 2020-02-03 18:12
 **/
@Mapper
public interface LodgerMapper {

    /**
     * 批量添加入住人
     *
     * @param lodgers
     * @return
     */
    int addLodgers(@Param("lodgers") List<Lodger> lodgers);

    /**
     * 根据订单项id 获取入住人信息
     *
     * @param itemId
     * @return
     */
    List<Lodger> getLodgersByItemId(@Param("itemId") String itemId);
}
