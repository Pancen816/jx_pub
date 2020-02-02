package com.jx.pub.manage.controller;

import com.jx.pub.common.dto.ResponseResult;
import com.jx.pub.common.pojo.RoomType;
import com.jx.pub.common.util.TimeUtil;
import com.jx.pub.manage.service.RoomTypeService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.sql.Time;
import java.util.List;

/**
 * @author Faxon
 * @version 1.0
 * @date 2020-01-29 15:26
 **/
@CrossOrigin
@RestController
@RequestMapping("/roomType")
@Api(tags = "房型管理接口")
public class RoomTypeController {

    @Resource
    RoomTypeService roomTypeService;

    @Value("${picUrl}")
    private String picUrl;

    @ApiOperation(value = "获取所有房型", notes = "获取所有房型")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "beginTime", value = "开始时间(默认为当日14点)", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "endTime", value = "结束时间(默认为明日12点)", required = false, dataType = "String", paramType = "query"),
    })
    @GetMapping("/getRoomTypeList")
    public ResponseResult<List<RoomType>> getRoomTypeList(String beginTime, String endTime) {
        if (StringUtils.isBlank(beginTime) || StringUtils.isBlank(endTime)) {
            beginTime = TimeUtil.getRoomBeginTime();
            endTime = TimeUtil.getRoomEndTime();
        }
        List<RoomType> roomTypeList = roomTypeService.getRoomTypeList(beginTime, endTime);
        return new ResponseResult<>(true, "获取全部房型列表", roomTypeList);
    }

    @ApiOperation(value = "上传图片", notes = "上传图片")
    @PostMapping("/uploadPic")
    public ResponseResult<String> uploadPic(MultipartFile file) {
        if (!isImage(file)) {
            return new ResponseResult<>(false, "上传失败:非图片文件");
        }
        String url = roomTypeService.uploadPic(file);
        if (StringUtils.isBlank(url)) {
            return new ResponseResult<>(false, "上传失败");
        }
        return new ResponseResult<>(true, "上传成功0", picUrl + url);
    }

    @ApiOperation(value = "检查房型名是否重复", notes = "用户输入完房型名后前端调用此接口")
    @ApiImplicitParam(name = "typeName", value = "类型名称", required = true, dataType = "String", paramType = "path")
    @GetMapping("/checkTypeName/{typeName}")
    public ResponseResult<Boolean> checkTypeName(@PathVariable("typeName") String typeName) {
        if (StringUtils.isBlank(typeName)) {
            return new ResponseResult<>(false, "房型名称为空");
        }
        if (roomTypeService.checkTypeName(typeName)) {
            return new ResponseResult<>(true, "房型名称合法");
        }
        return new ResponseResult<>(false, "房型名称已存在");
    }

    @ApiOperation(value = "添加房型", notes = "添加房型")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "typeName", value = "类型名称(10字以内)", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "typePic", value = "图片地址", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "typePrice", value = "房间价格", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "typeArea", value = "面积", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "typeWindow", value = "是否有窗（0:无窗，1有窗）", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "typeMaxPeople", value = "最多居住人数", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "typeBreakfast", value = "是否有早餐（0:无，1有）", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "typeBed", value = "床铺信息（15字以内）", required = true, dataType = "String", paramType = "query"),
    })
    @PostMapping("/addRoomType")
    public ResponseResult<Void> addRoomType(RoomType roomType) {
        String checkResult = checkRoomTypeParams(roomType);
        if (checkResult != null) {
            return new ResponseResult<>(false, checkResult);
        }
        if (!roomTypeService.checkTypeName(roomType.getTypeName())) {
            return new ResponseResult<>(false, "房间名称重复");
        }

        boolean aBoolean = roomTypeService.addRoomType(roomType);
        if (aBoolean) {
            return new ResponseResult<>(true, "添加成功");
        }
        return new ResponseResult<>(false, "添加失败");
    }


    @ApiOperation(value = "修改房型", notes = "修改房型")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "typeId", value = "房型id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "typeName", value = "类型名称", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "typePic", value = "图片地址", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "typePrice", value = "房间价格", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "typeArea", value = "面积", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "typeWindow", value = "是否有窗（0:无窗，1有窗）", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "typeMaxPeople", value = "最多居住人数", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "typeBreakfast", value = "是否有早餐（0:无，1有）", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "typeBed", value = "床铺信息（15字以内）", required = true, dataType = "String", paramType = "query"),
    })
    @PostMapping("/updateRoomType")
    public ResponseResult<Void> updateRoomType(RoomType roomType) {
        if (StringUtils.isBlank(roomType.getTypeId())) {
            return new ResponseResult<>(false, "无法获取房型id");
        }
        String checkResult = checkRoomTypeParams(roomType);
        if (checkResult != null) {
            return new ResponseResult<>(false, checkResult);
        }

        String typeName = roomTypeService.getTypeNameById(roomType.getTypeId());
        //修改了房型名，验证是否重复
        if (!typeName.equals(roomType.getTypeName())) {
            if (!roomTypeService.checkTypeName(roomType.getTypeName())) {
                return new ResponseResult<>(false, "修改失败:房型名称重复");
            }
        }

        boolean aBoolean = roomTypeService.updateRoomType(roomType);
        if (aBoolean) {
            return new ResponseResult<>(true, "修改成功");
        }
        return new ResponseResult<>(false, "修改失败");
    }

    @ApiOperation(value = "删除房型", notes = "删除房型")
    @ApiImplicitParam(name = "typeId", value = "房型id", required = true, dataType = "String", paramType = "path")
    @GetMapping("/deleteRoomTypeById/{typeId}")
    public ResponseResult<Void> deleteRoomTypeById(@PathVariable("typeId") String typeId) {
        if (StringUtils.isBlank(typeId)) {
            return new ResponseResult<>(false, "删除失败：无法获取房型id");
        }
        boolean isHaveNotDoneOrder = roomTypeService.isHaveNotDoneOrder(typeId);
        if (!isHaveNotDoneOrder) {
            return new ResponseResult<>(false, "删除失败：该房型有未完成订单");
        }
        int roomCount = roomTypeService.getRoomsCount(typeId);
        if (roomCount > 0) {
            return new ResponseResult<>(false, "删除失败：该房型下还有" + roomCount + "个房间");
        }
        boolean aBoolean = roomTypeService.deleteRoomTypeById(typeId);
        if (aBoolean) {
            return new ResponseResult<>(true, "删除成功");
        }
        return new ResponseResult<>(false, "删除失败");
    }

    @ApiOperation(value = "查询房型某时间段内剩余房间数", notes = "查询房型某时间段内剩余房间数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "typeId", value = "房型id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "beginTime", value = "开始时间(默认为当日14点)", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "endTime", value = "结束时间(默认为明日12点)", required = false, dataType = "String", paramType = "query"),
    })
    @PostMapping("/getUsableNumberById")
    public ResponseResult<Integer> getUsableNumberById(String typeId, String beginTime, String endTime) {
        if (StringUtils.isBlank(typeId)) {
            return new ResponseResult<>(false, "查询失败：无法获取房型id");
        }
        if (StringUtils.isBlank(beginTime) || StringUtils.isBlank(endTime)) {
            beginTime = TimeUtil.getRoomBeginTime();
            endTime = TimeUtil.getRoomEndTime();
        }
        Integer usableNumber = roomTypeService.getUsableNumberById(typeId, beginTime, endTime);
        return new ResponseResult<>(true, "查询成功", usableNumber);
    }

    /**
     * 验证参数完整性
     *
     * @param rt
     * @return
     */
    private String checkRoomTypeParams(RoomType rt) {
        if (StringUtils.isBlank(rt.getTypeName()) || StringUtils.isBlank(rt.getTypePic()) || StringUtils.isBlank(rt.getTypePrice())
                || StringUtils.isBlank(rt.getTypeArea()) || StringUtils.isBlank(rt.getTypeWindow()) || StringUtils.isBlank(rt.getTypeMaxPeople())
                || StringUtils.isBlank(rt.getTypeBreakfast()) || StringUtils.isBlank(rt.getTypeBed())) {
            return "参数不完整";
        }
        if (rt.getTypeName().length() > 10) {
            return "typeName参数非法:（限定 10 字以内）";
        }
        if (!"0".equals(rt.getTypeWindow()) && !"1".equals(rt.getTypeWindow())) {
            return "typeWindow参数非法:（限定 0 、 1）";
        }
        if (!"0".equals(rt.getTypeBreakfast()) && !"1".equals(rt.getTypeBreakfast())) {
            return "typeBreakfast参数非法:（限定 0 、 1）";
        }
        if (rt.getTypeBed().length() > 15) {
            return "typeBed参数非法:（限定 15 字以内）";
        }
        return null;
    }


    /**
     * 判断是否是图片
     *
     * @param file
     * @return
     */
    private boolean isImage(MultipartFile file) {
        try {
            // 通过ImageReader来解码这个file并返回一个BufferedImage对象
            // 如果找不到合适的ImageReader则会返回null，我们可以认为这不是图片文件
            // 或者在解析过程中报错，也返回false
            Image image = ImageIO.read(file.getInputStream());
            return image != null;
        } catch (IOException ex) {
            return false;
        }
    }


}
