package com.github.cszxyang.util;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * 以静态变量保存Spring ApplicationContext,
 * 可在任何代码任何地方任何时候取出 ApplicationContext.
 */
@Component
@Lazy(false)
public class SpringContextHolder implements ApplicationContextAware, DisposableBean {

    private static ApplicationContext applicationContext = null;

    /**
     * 实现 ApplicationContextAware 接口, 注入 Context 到静态变量中.
     */
    @Override
    public void setApplicationContext(ApplicationContext appContext) {
        applicationContext = appContext;
    }

    /**
     * 取得存储在静态变量中的 ApplicationContext.
     */
    public static ApplicationContext getApplicationContext() {
        assertContextInjected();
        return applicationContext;
    }

    /**
     * 检查 ApplicationContext 不为空.
     */
    private static void assertContextInjected() {
        Validate.validState(applicationContext != null,
                "applicationContext property is not injected");
    }

    /**
     * 从静态变量 applicationContext 中取得 Bean, 自动转型为所赋值对象的类型.
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanName) {
        assertContextInjected();
        return (T) applicationContext.getBean(beanName);
    }

    /**
     * 从静态变量 applicationContext 中取得 Bean, 自动转型为所赋值对象的类型.
     */
    public static <T> T getBean(Class<T> requiredType) {
        assertContextInjected();
        return applicationContext.getBean(requiredType);
    }

    /**
     * 置空 ApplicationContext
     */
    public static void clearHolder() {
        applicationContext = null;
    }

    /**
     * 实现 DisposableBean 接口, 在 Context 关闭时清理静态变量.
     */
    @Override
    public void destroy() {
        SpringContextHolder.clearHolder();
    }
}