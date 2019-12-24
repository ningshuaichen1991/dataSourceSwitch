package com.userInfo.dao;

import com.common.BaseDao;
import com.userInfo.domain.UserInfo;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserInfoDao extends BaseDao<UserInfo> {
}
