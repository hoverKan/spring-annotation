package com.sinosoft.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sinosoft.bean.Blue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;

/**
 * @author hoverkan
 * @create 2018-11-21 10:04
 *
 * Profile:
 *      Spring 为我们提供的可以根据当前环境，动态的激活和切换一系列组件的功能
 *
 *
 * 开发环境、测试环境、生产环境
 *
 * @Profile : 指定组件在哪个环境的境况下才能被注册到容器中，不指定，任何环境下都能注册这个组件
 *
 *      1）、加了环境标识的bean，只有这个环境被激活的时候才能注册到容器中。默认是default 环境
 *      2）、写在配置类上，只有是指定的环境的时候，整个配置类才能开始生效
 *      3）、没有任何环境标识的bean，在任何环境下都是加载的
 *
 *
 */
// @Profile("test")
@PropertySource("classpath:/dbConfig.properties")
@Configuration
public class MainConfigOfProfile implements EmbeddedValueResolverAware {

    @Value("${db.user}")
    private String user;

    private String driverClass;

    @Bean
    public Blue blue(){
        return new Blue();
    }

    @Profile("test")
    @Bean("testDataSource")
    public DataSource dataSourceTest(@Value("${db.password}") String pwd) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mysql");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Profile("dev")
    @Bean("devDataSource")
    public DataSource dataSourceDev(@Value("${db.password}") String pwd) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/e3mall");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Profile("prod")
    @Bean("prodDataSource")
    public DataSource dataSourceProd(@Value("${db.password}") String pwd) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/sit-local");
        dataSource.setDriverClass(driverClass);
        return dataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        String driverClass = resolver.resolveStringValue("$${db.driverClass}");
        this.driverClass = driverClass;
    }
}
