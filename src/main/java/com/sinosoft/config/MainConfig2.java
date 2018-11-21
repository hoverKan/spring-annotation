package com.sinosoft.config;

import com.sinosoft.bean.Color;
import com.sinosoft.bean.ColorFactoryBean;
import com.sinosoft.bean.Person;
import com.sinosoft.bean.Red;
import com.sinosoft.condition.LinuxCondition;
import com.sinosoft.condition.MyImportBeanDefinitionRegistrar;
import com.sinosoft.condition.MySelector;
import com.sinosoft.condition.WindowsCondition;
import org.springframework.context.annotation.*;

/**
 * @author hoverkan
 * @create 2018-11-19 11:09
 *
 */
// 类中组件统一设置。满足当前条件，这个类中配置的所有bean注册才能生效
@Conditional(WindowsCondition.class)
@Configuration
@Import({Color.class,Red.class,MySelector.class,MyImportBeanDefinitionRegistrar.class})
// @Import 注解 导入组件，id默认是组件的全路径名
public class MainConfig2 {

    // 默认是单实例的

    /**
     * ConfigurableBeanFactory#SCOPE_PROTOTYPE prototype
     * ConfigurableBeanFactory#SCOPE_SINGLETON singleton
     * org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
     * org.springframework.web.context.WebApplicationContext#SCOPE_SESSION
     *
     * @return 单实例：singleton  默认的 :ioc容器启动时会调用方法创建对象放到ioc容器中
     * 以后每次获取就是直接从容器（map.get()）中拿。
     * 多实例：prototype   ioc容器启动并不会去调用方法创建对象放在容器中。
     * 每次获取的时候才会调用方法创建对象
     * request ：同一个请求创建一个实例
     * session ：同一个session创建一个实例
     * <p>
     * 懒加载：
     * 单实例bean：默认在容器启动时创建对象
     * 懒加载：容器启动时不创建对象。第一次使用（获取）Bean创建对象，并初始化；
     */
    //@Scope("prototype")
    @Lazy
    @Bean("person")
    public Person person() {
        // System.out.println("Person 对象创建了.........");
        return new Person("Kan", 22);
    }

    /**
     * @Conditional : 按照一定的条件进行判断，满足条件给容器中注册bean
     *
     * 如果系统是windows，给容器中注册("bill")
     * 如果是linux系统，给容器中注册("linus")
     *
     */
    @Conditional(WindowsCondition.class)
    @Bean("bill")
    public Person person01(){
        return new Person("Bill Gates",63);
    }

    @Conditional(LinuxCondition.class)
    @Bean("linus")
    public Person person02() {
        return new Person("Linus", 48);
    }

    /**
     * 给容器中注册组件：
     * 1）、包扫描+组件标注注解（@Controller/@Service/@Repository/@Component）
     * 2）、@Bean[导入的第三方包里面的组件]
     * 3）、@Import[快速给容器中导入一个组件]
     *      1.@Import(要导入到容器中的组件)，容器中就会自动注册这个组件，id 默认为组件的全路径名
     *      2.ImportSelector: 返回需要导入的组建的全路径名数组。
     *      3.ImportBeanDefinitionRegistrar : 手动注册bean到容器中
     * 4）、使用Spring提供的FactoryBean（工厂Bean）
     *      1.默认获取到的是工厂bean调用getObject创建的对象
     *      2.要获取工厂Bean本身，我们需要给id  前面加一个 &
     *          &colorFactoryBean
     *
     */
    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }

}
