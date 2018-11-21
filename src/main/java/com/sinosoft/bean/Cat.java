package com.sinosoft.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author hoverkan
 * @create 2018-11-19 17:26
 */
@Component
public class Cat implements InitializingBean,DisposableBean {
    public Cat() {
        System.out.println("Cat ... construct...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Cat ... destroy...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Cat ... afterPropertiesSet ");
    }
}
