package com.sinosoft.config;

import com.sinosoft.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author hoverkan
 * @create 2018-11-20 10:54
 */
// 使用@PropertySource读取外部配置文件中的K/V 保存到运行的环境变量中；加载完外部的配置完以后可以使用${}取出配置文件中的值
@PropertySource(value = {"classpath:/person.properties"})
@Configuration
public class MainConfigOfProperties {
    @Bean
    public Person person(){
        return new Person();
    }
}
