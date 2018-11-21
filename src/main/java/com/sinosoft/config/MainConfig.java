package com.sinosoft.config;

import com.sinosoft.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @author hoverkan
 * @create 2018-11-19 9:18
 * <p>
 * 配置类==配置文件
 */

@Configuration  //告诉Spring这是一个配置类
@ComponentScan(value = "com.sinosoft", includeFilters = {
        @ComponentScan.Filter(/*type = FilterType.ANNOTATION, classes = {Controller.class, Service.class*/
                type = FilterType.CUSTOM, classes = {MyTypeFilter.class})

}, useDefaultFilters = false)
//@ComponentScan value:指定要扫描的包
//excludeFilters = Filter[] :指定扫描的时候按照什么规则排除那些组件
//includeFilters = Filter[] :指定扫描的时候只需要包含那些组件,
// 需要同时指定 useDefaultFilters= false includeFilters才会生效
// FilterType.ANNOTATION：按照注解
// FilterType.ASSIGNABLE_TYPE：按照给定的类型
// FilterType.ASPECTJ：使用ASPECTJ表达式
// FilterType.REGEX:使用正则表达式指定
// FilterType.CUSTOM:自定义

public class MainConfig {

    // 给容器中注册一个Bean; 类型为返回值的类型，id 默认以方法名作为id
    @Bean
    public Person person() {
        return new Person("Hover", 23);
    }
}
