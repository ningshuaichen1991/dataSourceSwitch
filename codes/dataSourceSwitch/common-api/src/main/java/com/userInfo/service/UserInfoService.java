package com.userInfo.service;

import com.userInfo.domain.UserInfo;

import java.util.List;

public interface UserInfoService {

    /**
     * 添加走主库
     * @param user
     * @return
     */
    int addUserInfo(UserInfo user);

    /**
     * 走主库查询
     * @param userId
     * @return
     */
    UserInfo selectMasterUserInfoById(int userId);

    /**
     * 走从库查询
     * @param userId
     * @return
     */
    UserInfo selectSlaveUserInfoById(int userId);

    /**
     * 一起调用主从
     * @param userId
     * @return
     */
    List<UserInfo> selectAllSource(int userId);
}
