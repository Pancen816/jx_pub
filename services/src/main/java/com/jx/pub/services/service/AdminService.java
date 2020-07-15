package com.jx.pub.services.service;

import com.jx.pub.common.pojo.Admin;
import com.jx.pub.common.util.TimeUtil;
import com.jx.pub.services.mapper.AdminMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;

/**
 * @author Bruce
 * @version 1.0
 * @date 2020-01-28 12:36
 **/
@Service
public class AdminService {

    @Resource
    AdminMapper adminMapper;

    /**
     * 管理员登录
     *
     * @param username
     * @param password
     * @return
     */
    public Admin adminLogin(String username, String password) {
        Admin admin = adminMapper.getAdminByLoginName(username);
        if (admin != null) {
            String adminPassword = admin.getAdminPassword();
            String md5Pwd = DigestUtils.md5DigestAsHex(password.getBytes());
            if (md5Pwd.equals(adminPassword)) {
                admin.setAdminPassword(null);
                return admin;
            }
        }
        return null;
    }

    /**
     * 管理员注册
     *
     * @param admin
     * @return
     */
    public boolean adminRegister(Admin admin) {
        admin.setAdminPassword(DigestUtils.md5DigestAsHex(admin.getAdminPassword().getBytes()));
        admin.setAdminCreatTime(TimeUtil.getNowTime());
        admin.setAdminUpdateTime(TimeUtil.getNowTime());
        int i = adminMapper.insertAdmin(admin);
        return i == 1;
    }

    /**
     * 验证密码
     *
     * @param adminId  管理员ID
     * @param password 密码
     * @return boolean
     */
    public boolean verifyPasswordById(String adminId, String password) {
        String pwd = adminMapper.getPasswordById(adminId);
        return DigestUtils.md5DigestAsHex(password.getBytes()).equals(pwd);
    }

    /**
     * 修改密码
     *
     * @param adminId
     * @param newPwd
     * @return
     */
    public boolean updatePassword(String adminId, String newPwd) {
        int i = adminMapper.updatePasswordById(adminId, DigestUtils.md5DigestAsHex(newPwd.getBytes()));
        return i == 1;
    }
}
