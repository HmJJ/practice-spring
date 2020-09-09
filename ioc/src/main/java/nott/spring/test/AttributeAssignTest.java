/**
 * @Author: nott
 * @Description:
 * @Date: created in 2020/9/9 18:20
 * @Modified By:
 */
package nott.spring.test;

import nott.spring.code.bean.Person;
import nott.spring.code.config.MainConfig9;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

public class AttributeAssignTest {

    AnnotationConfigApplicationContext applicationContext;

    @Test
    public void test01() {
        applicationContext = new AnnotationConfigApplicationContext(MainConfig9.class);
        printBeanDefinitionNames();
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("person.nick_name");
        System.out.println(property);
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
        applicationContext.close();
    }

    private void printBeanDefinitionNames() {
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
        System.out.println("IOC容器创建完成...");
    }

    private void printBeanOfType(Class<?> clazz) {
        Map<String, ?> beansOfType = applicationContext.getBeansOfType(clazz);
        System.out.println(beansOfType);
    }

    private void printBeanNameOfType(Class<?> clazz) {
        String[] namesForType = applicationContext.getBeanNamesForType(clazz);
        for (String name : namesForType) {
            System.out.println(name);
        }
    }

}
