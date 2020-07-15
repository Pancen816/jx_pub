package com.jx.pub.services.mapper;

import com.jx.pub.common.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Bruce
 * @version 1.0
 * @date 2020-02-27 16:32
 **/
@Mapper
public interface UserMapper {
    /**
     * 根据用户名获取用户数量
     *
     * @param userNickName
     * @return
     */
    int getCountByUserNickName(@Param("userNickName") String userNickName);

    /**
     * 根据身份证号获取用户数量
     *
     * @param userIdNumber
     * @return
     */
    int getCountByIdNumber(@Param("userIdNumber") String userIdNumber);

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    int insertUser(@Param("user") User user);

    /**
     * 根据登录名获取用户
     *
     * @param username
     * @return
     */
    User getUserByUsername(@Param("userName") String username);


    /**
     * 根据用户id，获取用户信息
     *
     * @param userId
     * @return
     */
    User getUserByUserId(@Param("userId") String userId);

    /**
     * 修改密码
     *
     * @param userId
     * @param newPwd
     * @param updateTime
     * @return
     */
    int updatePasswordById(@Param("userId") String userId, @Param("newPwd") String newPwd, @Param("updateTime") String updateTime);

    /**
     * 修改用户信息
     *
     * @param userId
     * @param nickName
     * @param phone
     * @param updateTime
     * @return
     */
    int updateUserById(@Param("userId") String userId, @Param("nickName") String nickName, @Param("phone") String phone, @Param("updateTime") String updateTime);

    /**
     * 根据手机号 获取 用户数量
     *
     * @param userPhone
     * @return
     */
    int getCountByPhone(@Param("userPhone") String userPhone);
}
