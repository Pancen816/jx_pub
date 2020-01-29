package com.jx.pub.common.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * @author: Faxon
 * @data: 2020/1/27
 */
@ApiModel(value = "com-jx-pub-common-pojo-User")
@Data
public class User implements Serializable {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private String userId;

    /**
     * 真实姓名
     */
    @ApiModelProperty(value = "真实姓名")
    private String userName;

    /**
     * 身份证号
     */
    @ApiModelProperty(value = "身份证号")
    private String userIdNumber;

    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称")
    private String userNickName;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String userPassword;

    /**
     * 电话
     */
    @ApiModelProperty(value = "电话")
    private String userPhone;

    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private String userSex;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private String userCreatTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private String userUpdateTime;

    private static final long serialVersionUID = -4563099408185432860L;
}
