package com.sinosoft.test;

import com.sinosoft.aop.MathCalculator;
import com.sinosoft.config.MainConfigOfAOP;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author hoverkan
 * @create 2018-11-21 17:27
 */
public class IOCTest_aop {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);

        MathCalculator bean = applicationContext.getBean(MathCalculator.class);
        bean.div(1, 1);
        // applicationContext.close();
    }
}
