
package com.sinosoft.test;

import com.sinosoft.bean.Person;
import com.sinosoft.config.MainConfig;
import com.sinosoft.config.MainConfig2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

/**
 * @author hoverkan
 * @create 2018-11-19 10:07
 * <p>
 * -Dos.name=linux  修改运行时环境变量
 */
public class IOCTest {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);

    @Test
    public void test04() {
        // 工厂bean获取的是调用getObject创建的对象
        Object bean = applicationContext.getBean("colorFactoryBean");
        Object bean2 = applicationContext.getBean("colorFactoryBean");
        System.out.println(bean == bean2);

        //
        Object bean1 = applicationContext.getBean("&colorFactoryBean");
        System.out.println(bean1.getClass());
    }

    public void printBeans(ApplicationContext applicationContext) {
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }

    @Test
    public void test03() {
        String[] names = applicationContext.getBeanNamesForType(Person.class);
        // 获取操作系统环境变量的值
        Environment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);
        for (String name : names) {
            System.out.println(name);
        }

        Map<String, Person> beans = applicationContext.getBeansOfType(Person.class);
        System.out.println(beans);
    }

    @Test
    public void test02() {
        //ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        // String[] names = applicationContext.getBeanDefinitionNames();
        // for (String name : names) {
        //     System.out.println(name);
        // }
        //
        System.out.println("IOC 容器创建完成！");
        // Object bean = applicationContext.getBean("person");
        // Object bean1 = applicationContext.getBean("person");
        // System.out.println(bean == bean1);
    }

    @Test
    public void test01() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }
}
