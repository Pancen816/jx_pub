package com.jx.pub.manage.controller;

import com.jx.pub.common.dto.PageBean;
import com.jx.pub.common.dto.ResponseResult;
import com.jx.pub.common.dto.RoomPageSearchCon;
import com.jx.pub.common.pojo.Lodger;
import com.jx.pub.common.pojo.Room;
import com.jx.pub.manage.service.RoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Faxon
 * @version 1.0
 * @date 2020-01-30 09:56
 **/
@CrossOrigin
@RestController
@RequestMapping("/room")
@Api(tags = "房间管理接口")
public class RoomController {

    @Resource
    RoomService roomService;

    @ApiOperation(value = "分页条件查询房间列表", notes = "分页条件查询房间列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页数", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "单页条数", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "typeId", value = "类型id", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "roomNumber", value = "房间号", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "roomStatus", value = "房间状态 ( 0:未入住；1:已入住； )", required = false, dataType = "String", paramType = "query"),
    })
    @PostMapping("/getRoomPageByCon")
    public ResponseResult<PageBean<Room>> getRoomPageByCon(RoomPageSearchCon con) {
        if (null == con.getPage() || null == con.getSize()) {
            return new ResponseResult<>(false, "查询失败：获取不到页数、每页条目数");
        }
        if (StringUtils.isNotBlank(con.getRoomStatus()) && !"0".equals(con.getRoomStatus()) && !"1".equals(con.getRoomStatus())) {
            return new ResponseResult<>(false, "查询失败：roomStatus参数非法（限定 0，1）");
        }
        PageBean<Room> pageBean = roomService.getRoomPageByCon(con);
        return new ResponseResult<>(true, "查询成功", pageBean);
    }

    @ApiOperation(value = "验证房间号是否重复", notes = "验证房间号是否重复")
    @ApiImplicitParam(name = "roomNumber", value = "房间号", required = true, dataType = "String", paramType = "path")
    @GetMapping("/checkRoomNumber/{roomNumber}")
    public ResponseResult<Void> checkRoomNumber(@PathVariable("roomNumber") String roomNumber) {
        if (!roomService.checkRoomNumber(roomNumber)) {
            return new ResponseResult<>(false, "房间号重复");
        }
        return new ResponseResult<>(true, "房间号合法");
    }

    @ApiOperation(value = "添加房间", notes = "添加房间")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "typeId", value = "类型id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "roomNumber", value = "房间号", required = true, dataType = "String", paramType = "query"),
    })
    @PostMapping("/addRoom")
    public ResponseResult<Void> addRoom(Room room) {
        String checkResult = checkRoomParams(room);
        if (checkResult != null) {
            return new ResponseResult<>(false, "添加失败:" + checkResult);
        }
        boolean aBoolean = roomService.addRoom(room);
        if (aBoolean) {
            return new ResponseResult<>(true, "添加成功");
        }
        return new ResponseResult<>(false, "添加失败");
    }

    @ApiOperation(value = "根据id获取房间信息", notes = "根据id获取房间信息")
    @GetMapping("/getRoomByRoomId/{roomId}")
    public ResponseResult<Room> getRoomByRoomId(@PathVariable("roomId") String roomId){
        if(StringUtils.isBlank(roomId)){
            return new ResponseResult<>(false, "获取不到房间id");
        }
        Room room = roomService.getRoomByRoomId(roomId);
        if(null != room){
            return new ResponseResult<>(true,"查询成功",room);
        }
        return new ResponseResult<>(false, "查询失败");
    }

    @ApiOperation(value = "更新房间", notes = "更新房间")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roomId", value = "房间id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "typeId", value = "房型id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "roomNumber", value = "房间号", required = true, dataType = "String", paramType = "query"),
    })
    @PostMapping("/updateRoom")
    public ResponseResult<Void> updateRoom(Room room) {
        if (StringUtils.isBlank(room.getRoomId()) || StringUtils.isBlank(room.getTypeId()) || StringUtils.isBlank(room.getRoomNumber())) {
            return new ResponseResult<>(false, "更新失败:参数不完整");
        }

        String roomNumber = roomService.getRoomNumberById(room.getRoomId());
        //修改了房间号，验证是否重复
        if (!room.getRoomNumber().equals(roomNumber)) {
            if (!roomService.checkRoomNumber(room.getRoomNumber())) {
                return new ResponseResult<>(true, "更新失败：房间号重复");
            }
        }

        boolean aBoolean = roomService.updateRoomById(room);
        if (aBoolean) {
            return new ResponseResult<>(true, "更新成功");
        }
        return new ResponseResult<>(false, "更新失败");
    }

    @ApiOperation(value = "删除单个房间", notes = "删除单个房间")
    @ApiImplicitParam(name = "roomId", value = "房间id", required = true, dataType = "String", paramType = "path")
    @GetMapping("/deleteRoomById/{roomId}")
    public ResponseResult<Void> deleteRoomById(@PathVariable("roomId") String roomId) {
        if (StringUtils.isBlank(roomId)) {
            return new ResponseResult<>(false, "删除失败,无法获取房间id");
        }
        boolean isNotPeopleIn = roomService.isNotPeopleIn(roomId);
        if (!isNotPeopleIn) {
            return new ResponseResult<>(false, "删除失败,有客人尚未退房");
        }
        boolean aBoolean = roomService.deleteRoomById(roomId);
        if (aBoolean) {
            return new ResponseResult<>(true, "删除成功");
        }
        return new ResponseResult<>(false, "删除失败");
    }

    @ApiOperation(value = "根据房间id获取入住人信息", notes = "根据房间id获取入住人信息")
    @GetMapping("getLodgersByRoomId/{roomId}")
    public ResponseResult<List<Lodger>> getLodgersByRoomId(@PathVariable("roomId") String roomId) {
        if (StringUtils.isBlank(roomId)) {
            return new ResponseResult<>(false, "查询入住人失败,无法获取房间id");
        }
        List<Lodger> lodgerList = roomService.getLodgersByRoomId(roomId);
        if (lodgerList != null) {
            return new ResponseResult<>(true, "查询入住人成功", lodgerList);
        }
        return new ResponseResult<>(false, "查询入住人失败");
    }

    /**
     * 验证房间参数
     *
     * @param room
     * @return
     */
    public String checkRoomParams(Room room) {
        if (StringUtils.isBlank(room.getTypeId()) || StringUtils.isBlank(room.getRoomNumber())) {
            return "参数不完整";
        }
        if (!roomService.checkRoomNumber(room.getRoomNumber())) {
            return "房间号重复";
        }
        return null;
    }
}
