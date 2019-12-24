package com.dataSource;

/**
 * 数据源
 */
public enum DataSourceEnum {

    MASTER("master","主库"),
    SLAVE("slave","从库");
    /**
     * 数据源
     */
    private String source;
    /**
     * 描述
     */
    private String desc;

    DataSourceEnum(String source, String desc) {
        this.source = source;
        this.desc = desc;
    }

    public String getSource() {
        return source;
    }

    public String getDesc() {
        return desc;
    }
}
