package com.dataSource.aop;

import com.alibaba.druid.util.StringUtils;
import com.dataSource.DataSourceEnum;
import com.dataSource.annotation.Readable;
import com.dataSource.DataSourceContext;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 从库切换AOP入口
 */
@Component
@Aspect
@Slf4j
public class ReadDataSourceSwitchAop {

    /**
     * 切入方法为环绕
     * @param joinPoint
     * @return
     */
    @Around(value = "pointcut()")
    public Object proccess(ProceedingJoinPoint joinPoint) {
        try {
            log.info("从库数据源拦截开始：{}",joinPoint.getSignature().toString());
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            Method method = methodSignature.getMethod();
            Readable readable = method.getAnnotation(Readable.class);
            if(readable == null){//如果注解为空则走主库
                DataSourceContext.setDataSource(DataSourceEnum.MASTER.getSource());
            }else {
                DataSourceContext.setDataSource(StringUtils.isEmpty(readable.sourceName())?DataSourceEnum.SLAVE.getSource()
                        :readable.sourceName());//如果注解属性不填写则走默认从库
            }
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    /**
     * 只要添加了该注解就表示走从库，为查询方法服务
     */
    @Pointcut("@annotation(com.dataSource.annotation.Readable)")
    public void pointcut(){}

    /**
     * 数据源方法切换完之后需要把threadLocal清楚，否则会发生内存泄漏
     */
    @After(value = "pointcut()")
    public void clearThreadLocal(){
        if(StringUtils.isEmpty(DataSourceContext.getDataSource())){
            return;
        }
        DataSourceContext.clearDataSource();
        log.info("数据源threadLocal已清除");
    }
}
