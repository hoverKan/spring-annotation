package com.sinosoft.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author hoverkan
 * @create 2018-11-19 15:57
 */
public class MySelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        return new String[]{"com.sinosoft.bean.Yellow","com.sinosoft.bean.Blue"};
    }
}
