package com.sinosoft.test;

import com.sinosoft.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author hoverkan
 * @create 2018-11-21 10:49
 */
public class IOCTest_Profile {

    // 1、使用命令行动态参数设置：在虚拟机参数位置加载 -Dspring.profiles.active=test

    @Test
    public void test01(){
        // 1、创建一个 applicationContext
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 2、设置需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles("dev","prod");
        // 3、注册主配置类
        applicationContext.register(MainConfigOfProfile.class);
        // 4、刷新容器
        applicationContext.refresh();

        printBeans(applicationContext);
        // DataSource bean = applicationContext.getBean(DataSource.class);
        // System.out.println(bean);
    }

    public void printBeans(ApplicationContext applicationContext) {
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }
}
