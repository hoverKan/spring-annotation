package com.sinosoft.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author hoverkan
 * @create 2018-11-19 14:36
 * 判断是否Windows系统
 */
public class WindowsCondition implements Condition {
    /**
     * @param context  : 判断条件能使用的上下文（环境）
     * @param metadata : 注解信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 1、能获取到ioc使用的beanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        // 2、获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        // 3、获取当前环境信息
        Environment environment = context.getEnvironment();
        // 4、获取到bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();

        String property = environment.getProperty("os.name");

        // 可以判断容器中的bean 注册情况，也可以给容器中注册bean
        boolean person = registry.containsBeanDefinition("person");

        if (property.contains("Windows")){
            return true;
        }
        return false;
    }
}
