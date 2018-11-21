package com.sinosoft.test;

import com.sinosoft.config.MainConfigOfAutowired;
import com.sinosoft.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author hoverkan
 * @create 2018-11-20 10:55
 */
public class IOCTest_Autowired {
    // 1、创建IOC 容器
    ApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);

    @Test
    public void test02(){
        printBeans(context);
        System.out.println(context);

    }


    @Test
    public void test01() {
        printBeans(context);

        BookService service = context.getBean(BookService.class);
        System.out.println(service);
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
