package com.sinosoft.test;

import com.sinosoft.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author hoverkan
 * @create 2018-11-19 17:06
 */
public class IOCTestLifeCycle {

    @Test
    public void test01(){
        // 1、创建IOC 容器
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成！");

        // 2、关闭容器
        ((AnnotationConfigApplicationContext) context).close();
    }
}
