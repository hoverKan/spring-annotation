package com.sinosoft.bean;

/**
 * @author hoverkan
 * @create 2018-11-19 17:01
 */
public class Car {
    public Car() {
        System.out.println("car constructor....");
    }

    public void init(){
        System.out.println("car ... init ...");
    }

    public void destroy(){
        System.out.println("car ... destroy ...");
    }
}
