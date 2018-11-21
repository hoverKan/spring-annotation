package com.sinosoft;

import com.sinosoft.bean.Person;
import com.sinosoft.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author hoverkan
 * @create 2018-11-19 9:12
 */
public class MainTest {
    public static void main(String[] args) {
        // 配置文件
        // ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        // Person bean = (Person) context.getBean("person");
        // System.out.println(bean);

        // 注解
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean);

        String[] names = applicationContext.getBeanNamesForType(Person.class);
        for (String name : names) {
            System.out.println(name);
        }
    }
}
