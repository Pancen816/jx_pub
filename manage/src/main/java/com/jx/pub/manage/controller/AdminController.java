package com.jx.pub.manage.controller;

import com.jx.pub.common.dto.ResponseResult;
import com.jx.pub.common.pojo.Admin;
import com.jx.pub.common.util.CookieUtil;
import com.jx.pub.manage.service.AdminService;
import com.sun.org.apache.regexp.internal.RE;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Faxon
 * @version 1.0
 * @date 2020-01-28 11:55
 **/
@CrossOrigin
@RestController
@RequestMapping("/admin")
@Api(tags = "管理员接口")
public class AdminController {

    @Resource
    private AdminService adminService;

    @Value("${cookieDomain}")
    private String cookieDomain;

    @ApiOperation(value = "管理员登录", notes = "管理员登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "登录名或电话", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String", paramType = "query")
    })
    @PostMapping(value = "/login")
    public ResponseResult<Admin> adminLogin(HttpServletResponse response, String username, String password) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return new ResponseResult<>(false, "参数不完整");
        }
        Admin admin = adminService.adminLogin(username, password);
        if (admin != null) {
            CookieUtil.addCookie(response, cookieDomain, "/", "admin", admin.getAdminId().toString(), -1, false);
            return new ResponseResult<>(true, "登陆成功", admin);
        }
        return new ResponseResult<>(false, "用户名或密码错误");
    }


    @ApiOperation(value = "管理员退出登录", notes = "管理员退出登录")
    @GetMapping("/logout")
    public ResponseResult<Void> adminLogin(HttpServletResponse response) {
        CookieUtil.addCookie(response, cookieDomain, "/", "admin", "", 0, false);
        return new ResponseResult<>(true, "操作成功");
    }


    @ApiOperation(value = "管理员修改密码", notes = "管理员修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "adminId", value = "管理员id", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "oldPwd", value = "旧密码", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "newPwd", value = "新密码", required = true, dataType = "String", paramType = "query")
    })
    @PostMapping("/updatePassword")
    public ResponseResult<Void> adminUpdatePassword(HttpServletResponse response, String adminId, String oldPwd, String newPwd) {
        if (StringUtils.isBlank(adminId) || StringUtils.isBlank(oldPwd) || StringUtils.isBlank(newPwd)) {
            return new ResponseResult<>(false, "参数不完整");
        }
        boolean aBoolean = adminService.verifyPasswordById(adminId, oldPwd);
        if (!aBoolean) {
            return new ResponseResult<>(false, "密码不正确，无法修改");
        }
        boolean bBoolean = adminService.updatePassword(adminId, newPwd);
        if (bBoolean) {
            CookieUtil.addCookie(response, cookieDomain, "/", "admin", "", 0, false);
            return new ResponseResult<>(true, "修改成功");
        }
        return new ResponseResult<>(false, "修改错误");
    }


    @ApiOperation(value = "管理员注册", notes = "管理员注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "adminName", value = "用户名", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "adminPassword", value = "密码", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "adminPhone", value = "电话", required = true, dataType = "String", paramType = "query")
    })
    @PostMapping("/register")
    public ResponseResult<Void> adminRegister(Admin admin) {
        if (admin == null || StringUtils.isBlank(admin.getAdminName()) || StringUtils.isBlank(admin.getAdminPassword())
                || StringUtils.isBlank(admin.getAdminPhone())) {
            return new ResponseResult<>(false, "参数不完整");
        }
        boolean aBoolean = adminService.adminRegister(admin);
        if (aBoolean) {
            return new ResponseResult<>(true, "注册成功");
        }
        return new ResponseResult<>(false, "注册失败");
    }
}
