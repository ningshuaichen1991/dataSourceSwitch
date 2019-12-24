package com.userInfo.domain;


import lombok.Data;

/**
 * 用户实体类
 */
@Data
public class UserInfo {

    /**
     * id
     */
    private int userId;
    /**
     * 名称
     */
    private String userName;
    /**
     * 手机号
     */
    private String mobile;

}
