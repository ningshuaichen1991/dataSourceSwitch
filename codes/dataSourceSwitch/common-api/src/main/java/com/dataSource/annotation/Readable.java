package com.dataSource.annotation;

import java.lang.annotation.*;

/**
 * 如果方法上添加上该注解则走从库
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Readable {
    /**
     * 数据源名称可不填写
     * @return
     */
    String sourceName() default "";
}
