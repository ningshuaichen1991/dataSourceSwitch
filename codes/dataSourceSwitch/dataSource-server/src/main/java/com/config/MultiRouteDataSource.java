package com.config;

import com.alibaba.druid.util.StringUtils;
import com.dataSource.DataSourceContext;
import com.dataSource.DataSourceEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


/**
 * DataSource路由类
 */
@Slf4j
public class MultiRouteDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        String resource = DataSourceContext.getDataSource();
        log.info("数据源为：{}",resource);
        if(!StringUtils.isEmpty(DataSourceContext.getDataSource())){
            return resource;
        }
        log.info("数据源为空，默认走主库");
        return DataSourceEnum.MASTER.getSource();
    }
}