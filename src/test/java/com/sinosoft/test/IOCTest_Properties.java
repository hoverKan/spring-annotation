package com.sinosoft.test;

import com.sinosoft.bean.Person;
import com.sinosoft.config.MainConfigOfProperties;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author hoverkan
 * @create 2018-11-20 10:55
 */
public class IOCTest_Properties {
    // 1、创建IOC 容器
    ApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfProperties.class);

    @Test
    public void test01() {
        printBeans(context);

        Person person = (Person) context.getBean("person");
        System.out.println(person);
        // 2、关闭容器
        ((AnnotationConfigApplicationContext) context).close();
    }

    public void printBeans(ApplicationContext applicationContext) {
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

    }
}
