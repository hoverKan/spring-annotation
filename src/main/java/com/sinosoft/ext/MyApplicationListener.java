package com.sinosoft.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author hoverkan
 * @create 2018-11-27 16:06
 */
@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {

    // 当容器发布此事件后，方法触发
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("收到事件：" + event);
    }
}
