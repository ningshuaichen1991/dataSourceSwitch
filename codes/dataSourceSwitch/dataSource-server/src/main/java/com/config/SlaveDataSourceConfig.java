package com.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 从数据源信息获取
 */
@Configuration
@ConfigurationProperties(prefix = "spring.datasource.druid.slave")
@Data
public class SlaveDataSourceConfig {
    @Value("${spring.datasource.druid.slave.url}")
    private String url;
    @Value("${spring.datasource.druid.slave.username}")
    private String username;
    @Value("${spring.datasource.druid.slave.password}")
    private String password;
    @Value("${spring.datasource.druid.slave.driverClassName}")
    private String driverClassName;
}