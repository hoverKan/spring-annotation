package com.sinosoft.condition;

import com.sinosoft.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author hoverkan
 * @create 2018-11-19 16:10
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean definition = registry.containsBeanDefinition("com.sinosoft.bean.Yellow");
        boolean definition2 = registry.containsBeanDefinition("com.sinosoft.bean.Red");
        if (definition && definition2){
            // 指定Bean定义信息，（Bean的类型，Bean..）
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
            // 注册一个Bean,指定bean名
            registry.registerBeanDefinition("RainBow",rootBeanDefinition);
        }
    }
}
