/**
 * @Author: nott
 * @Description:
 * @Date: created in 2020/9/9 11:50
 * @Modified By:
 */
package nott.spring.ioc.code.config.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

// 判断是否是linux系统
public class LinuxCondition implements Condition {
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment environment = conditionContext.getEnvironment();
        String property = environment.getProperty("os.name");
        if (property.contains("Linux")) {
            return true;
        }
        // 可以判断容器中的bean注册情况，也可以给容器中注册bean
        /*BeanDefinitionRegistry registry = conditionContext.getRegistry();
        boolean definition = registry.containsBeanDefinition("person");
        if (definition) {
            return true;
        }*/
        return false;
    }
}
