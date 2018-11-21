package com.sinosoft.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author hoverkan
 * @create 2018-11-20 8:29
 */
@Component
public class Dog {
    public Dog() {
        System.out.println("Dog ... construct ...");
    }

    @PostConstruct
    public void init(){
        System.out.println("Dog .... PostConstruct ...");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Dog ... destroy...");
    }
}
