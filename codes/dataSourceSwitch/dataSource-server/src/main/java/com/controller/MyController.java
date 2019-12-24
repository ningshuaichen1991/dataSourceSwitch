package com.controller;

import com.userInfo.domain.UserInfo;
import com.userInfo.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
public class MyController {

    @Resource
    private UserInfoService userService;


    @RequestMapping("/master")
    public UserInfo getMaster(){
        return userService.selectMasterUserInfoById(1);
    }

    @RequestMapping("/slave")
    public UserInfo getSlave(){
        return userService.selectSlaveUserInfoById(1);
    }

    @RequestMapping("/slaveAndMaster")
    public List<UserInfo> slaveAndMaster(){
        return userService.selectAllSource(1);
    }

    @RequestMapping("/add")
    public String add(){
       UserInfo userInfo = new UserInfo();
       userInfo.setUserName("主库添加");
       userInfo.setMobile("13000000009");
       userService.addUserInfo(userInfo);
       return "成功";
    }
}
