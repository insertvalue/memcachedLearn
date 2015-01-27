/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hd.memcachedlearn;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 获取Spring的上下文
 *
 * @version 1.0 2012/11/27
 * @since JDK1.6
 * @author Hui Wang
 */
public class SpringContextUtil implements ApplicationContextAware {

    protected static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static Object getBean(Class<?> clazz) {
        return context.getBean(clazz);
    }

    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }
}
