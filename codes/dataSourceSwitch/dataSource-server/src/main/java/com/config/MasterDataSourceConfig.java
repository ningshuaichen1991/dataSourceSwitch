package com.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 主数据源信息获取
 */
@Configuration
@ConfigurationProperties(prefix = "spring.datasource.druid.master")
@Data
public class MasterDataSourceConfig {
    @Value("${spring.datasource.druid.master.url}")
    private String url;
    @Value("${spring.datasource.druid.master.username}")
    private String username;
    @Value("${spring.datasource.druid.master.password}")
    private String password;
    @Value("${spring.datasource.druid.master.driverClassName}")
    private String driverClassName;
}