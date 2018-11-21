package com.sinosoft.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author hoverkan
 * @create 2018-11-19 9:05
 */
public class Person {

    //使用@Value赋值：
    //1、基本数值
    //2、可以写SpEL: #{}
    //3、可以写${}:取出配置文件【properties】的值（即运行变量里面的值）
    @Value("阚先通")
    private String name;
    @Value("#{20+3}")
    private Integer age;

    @Value("${person.nickname}")
    private String nickName;

    public Person() {
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
