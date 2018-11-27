
package com.sinosoft.test;

import com.sinosoft.tx.TxConfig;
import com.sinosoft.tx.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author hoverkan
 * <p>

 */
public class IOCTest_tx {

    @Test
    public void test01() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.insertUser();
    }
}
