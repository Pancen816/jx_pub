package com.jx.pub.manage.mapper;


import com.jx.pub.common.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: Faxon
 * @data: 2020/1/27
 */
@Mapper
public interface AdminMapper {
    /**
     * 获取管理员信息
     *
     * @param loginName
     * @return
     */
    Admin getAdminByLoginName(@Param("loginName") String loginName);


    /**
     * 新增管理员
     *
     * @param admin
     * @return
     */
    int insertAdmin(@Param("admin") Admin admin);

    /**
     * 根据id获取密码
     *
     * @param adminId
     * @return
     */
    String getPasswordById(@Param("adminId") String adminId);

    /**
     * 根据id修改密码
     *
     * @param adminId
     * @param newPwd
     * @return
     */
    int updatePasswordById(@Param("adminId") String adminId, @Param("newPwd") String newPwd);
}