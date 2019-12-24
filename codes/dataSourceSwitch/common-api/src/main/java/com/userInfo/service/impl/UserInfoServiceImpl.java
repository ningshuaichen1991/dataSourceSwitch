package com.userInfo.service.impl;

import com.dataSource.annotation.Readable;
import com.userInfo.dao.UserInfoDao;
import com.userInfo.domain.UserInfo;
import com.userInfo.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoDao userInfoDao;

    @Override
    public int addUserInfo(UserInfo user) {
        return userInfoDao.insert(user);
    }

    /**
     * 默认走主库
     * @param userId
     * @return
     */
    @Override
    public UserInfo selectMasterUserInfoById(int userId) {
        return userInfoDao.selectByPrimaryKey(userId);
    }

    /**
     * 查询从库
     * @param userId
     * @return
     */
    @Override
    @Readable
    public UserInfo selectSlaveUserInfoById(int userId) {
        return userInfoDao.selectByPrimaryKey(userId);
    }

    /**
     * 在主方法中加上注解则全部走从库
     * @param userId
     * @return
     */
    @Override
    @Readable
    public List<UserInfo> selectAllSource(int userId) {
        UserInfo masterUserInfo = this.selectMasterUserInfoById(userId);
        UserInfo slaveUserInfo = this.selectSlaveUserInfoById(userId);
        return Arrays.asList(masterUserInfo,slaveUserInfo);
    }
}
