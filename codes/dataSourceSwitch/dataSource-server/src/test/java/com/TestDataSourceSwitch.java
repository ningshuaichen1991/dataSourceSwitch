package com;

import com.alibaba.fastjson.JSONObject;
import com.userInfo.domain.UserInfo;
import com.userInfo.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TestDataSourceSwitch {

    @Resource
    UserInfoService userInfoService;

    /**
     * 从库查询
     */
    @Test
    public void slaveSelect(){
        UserInfo userInfo =  userInfoService.selectSlaveUserInfoById(1);
        log.info(JSONObject.toJSONString(userInfo));
    }

    /**
     * 主库查询
     */
    @Test
    public void masterSelect(){
        UserInfo userInfo = userInfoService.selectMasterUserInfoById(1);
        log.info(JSONObject.toJSONString(userInfo));
    }

    /**
     * 从库查询
     */
    @Test
    public void selectAllSource(){
        List<UserInfo> userInfos = userInfoService.selectAllSource(1);
        log.info(JSONObject.toJSONString(userInfos));
    }
}
