package com.jx.pub.manage.service;

import com.jx.pub.common.pojo.Room;
import com.jx.pub.common.pojo.RoomType;
import com.jx.pub.common.util.IDUtil;
import com.jx.pub.common.util.TimeUtil;
import com.jx.pub.manage.mapper.OrderMapper;
import com.jx.pub.manage.mapper.RoomMapper;
import com.jx.pub.manage.mapper.RoomTypeMapper;
import org.csource.fastdfs.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Faxon
 * @version 1.0
 * @date 2020-01-29 15:27
 **/
@Service
public class RoomTypeService {

    @Resource
    RoomTypeMapper roomTypeMapper;

    @Resource
    RoomMapper roomMapper;

    @Resource
    OrderMapper orderMapper;

    /**
     * 获取所有房型
     *
     * @param beginTime
     * @param endTime
     * @return
     */
    public List<RoomType> getRoomTypeList(String beginTime, String endTime) {
        List<RoomType> roomTypeList = roomTypeMapper.getRoomTypeList(beginTime, endTime);
        for (RoomType roomType : roomTypeList) {
            roomType.setTypeRestRoomCount(roomType.getTypeRoomCount() - roomType.getTypeOrderSum());
            List<Room> rooms = roomMapper.getRoomsByTypeId(roomType.getTypeId());
            roomType.setRoomList(rooms);
        }
        return roomTypeList;
    }

    /**
     * 添加房型
     *
     * @param roomType
     * @return
     */
    public boolean addRoomType(RoomType roomType) {
        roomType.setTypeId(IDUtil.getUUID());
        roomType.setTypeCreatTime(TimeUtil.getNowTime());
        roomType.setTypeUpdateTime(TimeUtil.getNowTime());
        int i = roomTypeMapper.addRoomType(roomType);
        return i == 1;
    }

    /**
     * 修改房型
     *
     * @param roomType
     * @return
     */
    public boolean updateRoomType(RoomType roomType) {
        roomType.setTypeUpdateTime(TimeUtil.getNowTime());
        int i = roomTypeMapper.updateRoomTypeById(roomType);
        return i == 1;
    }

    /**
     * 删除房型
     *
     * @param typeId
     * @return
     */
    public boolean deleteRoomTypeById(String typeId) {
        int i = roomTypeMapper.deleteRoomTypeById(typeId);
        return i == 1;
    }

    /**
     * 检查房型名称是否已存在
     *
     * @param typeName
     * @return
     */
    public boolean checkTypeName(String typeName) {
        int count = roomTypeMapper.getCountByTypeName(typeName);
        return count == 0;
    }

    /**
     * 上传图片
     *
     * @param file
     * @return
     */
    public String uploadPic(MultipartFile file) {
        try {
            ClientGlobal.initByProperties("config/fastdfs-client.properties");
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getConnection();
            StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
            StorageClient storageClient = new StorageClient1(trackerServer, storageServer);
            String filename = file.getOriginalFilename();
            String extName = filename.substring(filename.lastIndexOf(".") + 1);
            String[] strings = storageClient.upload_file(file.getBytes(), extName, null);
            if (strings != null && strings.length == 2) {
                String fileId = strings[0] + "/" + strings[1];
                return fileId;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据id获取房型名称
     *
     * @param typeId
     * @return
     */
    public String getTypeNameById(String typeId) {
        return roomTypeMapper.getTypeNameById(typeId);
    }

    /**
     * 查询房型剩余房间数
     *
     * @param typeId
     * @param beginTime
     * @param endTime
     * @return
     */
    public Integer getUsableNumberById(String typeId, String beginTime, String endTime) {
        Integer totalNumber = roomMapper.getCountById(typeId);
        Integer sum = orderMapper.getRoomSumByTypeId(typeId, beginTime, endTime);
        return totalNumber - sum;
    }

    /**
     * 查询该房型是否有未完成订单
     *
     * @param typeId
     * @return
     */
    public boolean isHaveNotDoneOrder(String typeId) {
        int count = orderMapper.getNotDoneOrderCountByTypeId(typeId);
        return count == 0;
    }

    /**
     * 查询该房型下的房间数量
     *
     * @param typeId
     * @return
     */
    public int getRoomsCount(String typeId) {
        return roomMapper.getCountById(typeId);
    }

    /**
     * 查询房型限住人数
     *
     * @param typeId
     * @return
     */
    public int getTypeMaxPeopleById(String typeId) {
        return roomTypeMapper.getTypeMaxPeopleById(typeId);
    }

    /**
     * 根据id获取房型信息
     *
     * @param typeId
     * @param beginTime
     * @param endTime
     * @return
     */
    public RoomType getRoomTypeById(String typeId, String beginTime, String endTime) {
        RoomType roomType = roomTypeMapper.getRoomTypeById(typeId,beginTime,endTime);
        roomType.setTypeRestRoomCount(roomType.getTypeRoomCount() - roomType.getTypeOrderSum());
        List<Room> rooms = roomMapper.getRoomsByTypeId(roomType.getTypeId());
        roomType.setRoomList(rooms);
        return roomType;
    }
}
