/**
 * @Author: nott
 * @Description:
 * @Date: created in 2020/9/9 13:55
 * @Modified By:
 */
package nott.spring.ioc.code.config.selector;

import nott.spring.ioc.code.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * @param importingClassMetadata：当前类的注解信息
     * @param registry：BeanDefinition注册类
     *             把所有需要添加到容器中的bean，调用
     *             BeanDefinitionRegistry.registerBeanDefinition手工注册bean
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        boolean definition = registry.containsBeanDefinition("nott.spring.ioc.code.bean.Color");
        boolean definition2 = registry.containsBeanDefinition("nott.spring.ioc.code.bean.Animal");
        if (definition && definition2) {
            // 指定bean定义信息，（类型等）
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(RainBow.class);
            // 指定bean名
            registry.registerBeanDefinition("rainBow", rootBeanDefinition);
        }

    }
}
