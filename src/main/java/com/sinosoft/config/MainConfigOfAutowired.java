package com.sinosoft.config;

import com.sinosoft.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author hoverkan
 * @create 2018-11-20 11:34
 *
 * 自动装配：
 *      Spring利用依赖注入(DI),完成对IOC容器中各个组件的依赖关系赋值
 *
 * 1.@Autowired ：自动注入
 *      1）、默认优先依照类型去容器中找对应的组件：applicationContext.getBean(BookDao.class)
 *      2）、如果找到多个相同类型的组件，再将属性的名称作为组件的id 去容器中查找
 *                  applicationContext.getBean("bookDao")
 *      3）、@Qualifier("bookDao"):使用@Qualifier 指定需要装配组件的id，而不是使用属性名
 *      4）、自动装配默认一定要将属性赋值好，没有就会报错
 *           可以使用@Autowired(required=false); 这样没有就不会报错了
 *      5）、@Primary: 让Spring 进行自动装配的时候，默认使用首选的bean，
 *                  也可以继续使用@Qualifier 指定需要装配的bean的名字
 * 2. Spring还支持使用@Resource(JSR250)和@Inject(JSR330) [Java 规范的注解]
 *      @Resource :
 *          可以和@Autowired一样实现自动装配功能，默认是按照组件名称进行装配的
 *          没有能支持@Primary功能没有支持@Autowired(required=false)
 *      @Inject :
 *          需要导入javax.inject 的包，和Autowired 的功能一样，但没有required=false 的功能
 *
 *    @Autowired ：Spring 定义的 、@Resource :、@Inject :、都是Java规范
 *
 * 3.@Autowired :构造器，参数，方法，属性。都是从容器中获取参数组件的值
 *      1、[标注在方法位置] ：@Bean标注创建对象是+方法参数；参数从容器中获取；默认不写@Autowired效果是一样的，都能自动装配
 *      2、[标在构造器上] ： 如果组件只有一个有参构造器，这个有参构造器的@Autowired 可以省略，参数位置的组件还是可以自动从容器中获取
 *      3、放在参数位置 ：
 * 4.自定义组件想要使用Spring容器底层的一些组件（applicationContext，BeanFactory，xxx）;
 *      自定义组件实现xxxAware,在创建对象的时候会调用接口规定的方法注入相关组件；Aware
 *      把Spring底层的一些组件注入到自定义的Bean中；
 *      xxxAware : 功能使用 xxxProcessor 对应的后置处理器 ：
 *           ApplicationContextAware ==>>  ApplicationContextAwareProcessor
 *
 */
@ComponentScan({"com.sinosoft.service","com.sinosoft.dao","com.sinosoft.bean"})
@Configuration
public class MainConfigOfAutowired {

    @Primary
    @Bean
    public BookDao bookDao(){
        BookDao bookDao = new BookDao();
        bookDao.label="2";
        return bookDao;
}
}
