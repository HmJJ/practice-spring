/**
 * @Author: nott
 * @Description:
 * @Date: created in 2020/9/9 11:50
 * @Modified By:
 */
package nott.spring.ioc.code.config.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

// 判断是否是windows系统
public class WindowsCondition implements Condition {

    /**
     * @param conditionContext, 判断条件能使用的上下文（环境）
     * @param annotatedTypeMetadata, 注释信息
     */
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        // 1、能获取到ioc使用的beanFactory
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        // 2、获取类加载器
        ClassLoader classLoader = conditionContext.getClassLoader();
        // 3、获取当前环境变量
        Environment environment = conditionContext.getEnvironment();
        // 4、获取bean定义的注册类
        BeanDefinitionRegistry registry = conditionContext.getRegistry();

        String property = environment.getProperty("os.name");
        if (property.contains("Windows")) {
            return true;
        }
        return false;
    }
}
