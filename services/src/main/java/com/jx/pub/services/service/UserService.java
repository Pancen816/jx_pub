package com.jx.pub.services.service;

import com.jx.pub.common.pojo.User;
import com.jx.pub.common.util.IDUtil;
import com.jx.pub.common.util.TimeUtil;
import com.jx.pub.services.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;

/**
 * @author Faxon
 * @version 1.0
 * @date 2020-02-27 16:31
 **/
@Service
public class UserService {

    @Resource
    UserMapper userMapper;

    public int getCountByUserNickName(String userName) {
        return userMapper.getCountByUserNickName(userName);
    }

    public int getCountByIdNumber(String userIdNumber) {
        return userMapper.getCountByIdNumber(userIdNumber);
    }

    public boolean userRegister(User user) {
        user.setUserId(IDUtil.getUUID());
        user.setUserPassword(DigestUtils.md5DigestAsHex(user.getUserPassword().getBytes()));
        String nowTime = TimeUtil.getNowTime();
        user.setUserCreatTime(nowTime);
        user.setUserUpdateTime(nowTime);
        int i = userMapper.insertUser(user);
        return i == 1;
    }

    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }


    public User getUserByUserId(String userId) {
        return userMapper.getUserByUserId(userId);
    }

    public boolean updatePasswordById(String userId, String newPwd) {
        String md5DigestAsHex = DigestUtils.md5DigestAsHex(newPwd.getBytes());
        int i = userMapper.updatePasswordById(userId, md5DigestAsHex,TimeUtil.getNowTime());
        return i == 1;
    }

    public boolean updateUserById(String userId, String nickName, String phone) {
        int i = userMapper.updateUserById(userId,nickName,phone,TimeUtil.getNowTime());
        return i == 1;
    }
}
