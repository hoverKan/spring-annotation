package com.sinosoft.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author hoverkan
 * @create 2018-11-19 16:28
 * <p>
 * 创建一个Spring定义的FactoryBean
 */
public class ColorFactoryBean implements FactoryBean<Color> {
    // 返回一个Color对象，这个对象会添加到容器中
    @Override
    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean......");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    // 是否单例？
    // true:单实例，在容器中保存一份
    // false：多实例，每次获取都会创建一个新的Bean
    @Override
    public boolean isSingleton() {
        return true;
    }
}
