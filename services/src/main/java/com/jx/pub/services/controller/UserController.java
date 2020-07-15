package com.jx.pub.services.controller;

import com.jx.pub.common.dto.ResponseResult;
import com.jx.pub.common.pojo.User;
import com.jx.pub.services.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Bruce
 * @version 1.0
 * @date 2020-02-27 16:30
 **/
@CrossOrigin
@RestController
@RequestMapping("/user")
@Api(tags = "用户接口")
public class UserController {
    @Resource
    UserService userService;

    @PostMapping("/register")
    @ApiOperation(value = "用户注册", notes = "参数（json）：username,userIdNumber,userNickName,userPassword,userPhone,userSex")
    public ResponseResult<Void> userRegister(@RequestBody User user) {
        if (user == null || StringUtils.isBlank(user.getUserName()) || StringUtils.isBlank(user.getUserIdNumber())
                || StringUtils.isBlank(user.getUserNickName()) || StringUtils.isBlank(user.getUserPassword())
                || StringUtils.isBlank(user.getUserPhone()) || StringUtils.isBlank(user.getUserSex())) {
            return new ResponseResult<>(false, "参数不完整");
        }
        if (!"0".equals(user.getUserSex()) && !"1".equals(user.getUserSex())) {
            return new ResponseResult<>(false, "性别限定 0,1");
        }
        if (userService.getCountByUserNickName(user.getUserNickName()) > 0) {
            return new ResponseResult<>(false, "该用户名已被使用");
        }
        if (userService.getCountByIdNumber(user.getUserIdNumber()) > 0) {
            return new ResponseResult<>(false, "该身份证已被注册");
        }
        if (userService.getCountByPhone(user.getUserPhone()) > 0) {
            return new ResponseResult<>(false, "该手机号码已被使用");
        }
        boolean aBoolean = userService.userRegister(user);
        if (aBoolean) {
            return new ResponseResult<>(true, "注册成功");
        }
        return new ResponseResult<>(false, "注册失败");
    }

    @PostMapping("/login")
    @ApiOperation(value = "用户登录", notes = "参数：username,password")
    public ResponseResult<User> userLogin(String username, String password) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return new ResponseResult<>(false, "参数不完整");
        }
        User user = userService.getUserByUsername(username);
        if (user == null || !user.getUserPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()))) {
            return new ResponseResult<>(false, "用户名或密码错误");
        }
        user.setUserPassword(null);
        return new ResponseResult<>(true, "登录成功", user);
    }

    @GetMapping("/getUserById/{userId}")
    @ApiOperation(value = "根据用户id获取用户信息", notes = "参数：userId")
    public ResponseResult<User> userUpdatePassword(@PathVariable("userId") String userId) {
        if (StringUtils.isBlank(userId)) {
            return new ResponseResult<>(false, "参数不完整");
        }
        User user = userService.getUserByUserId(userId);
        if (user == null) {
            return new ResponseResult<>(false, "用户不存在");
        }
        user.setUserPassword(null);
        return new ResponseResult<>(true, "查询成功", user);
    }

    @PostMapping("/updatePassword")
    @ApiOperation(value = "修改密码", notes = "参数：userId,oldPwd,newPwd")
    public ResponseResult<Void> userUpdatePassword(String userId, String oldPwd, String newPwd) {
        if (StringUtils.isBlank(userId) || StringUtils.isBlank(oldPwd) || StringUtils.isBlank(newPwd)) {
            return new ResponseResult<>(false, "参数不完整");
        }
        User user = userService.getUserByUserId(userId);
        if (user == null) {
            return new ResponseResult<>(false, "用户不存在");
        }
        if (!user.getUserPassword().equals(DigestUtils.md5DigestAsHex(oldPwd.getBytes()))) {
            return new ResponseResult<>(false, "原密码输入错误");
        }
        boolean aBoolean = userService.updatePasswordById(userId, newPwd);
        if (aBoolean) {
            return new ResponseResult<>(true, "修改成功");
        }
        return new ResponseResult<>(false, "修改失败");
    }

    @PostMapping("/updateUser")
    @ApiOperation(value = "修改用户信息", notes = "参数：userId,nickName,phone")
    public ResponseResult<Void> updateUserById(String userId, String nickName, String phone) {
        if (StringUtils.isBlank(userId) || StringUtils.isBlank(nickName) || StringUtils.isBlank(phone)) {
            return new ResponseResult<>(false, "参数不完整");
        }
        User user = userService.getUserByUserId(userId);
        if (!user.getUserNickName().equals(nickName) && userService.getCountByUserNickName(nickName) > 0) {
            return new ResponseResult<>(false, "用户名已被使用");
        }
        boolean aBoolean = userService.updateUserById(userId,nickName,phone);
        if (aBoolean) {
            return new ResponseResult<>(true, "修改成功");
        }
        return new ResponseResult<>(false, "修改失败");
    }
}
