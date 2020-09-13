/**
 * @Author: nott
 * @Description:
 * @Date: created in 2020/9/9 18:20
 * @Modified By:
 */
package nott.spring.ioc.test;

import nott.spring.ioc.code.bean.Person;
import nott.spring.ioc.code.config.MainConfig9;
import nott.spring.utils.PrintInfo;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

public class IOCTest_PropertyValue {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig9.class);
        PrintInfo.printBeanDefinitionNames(applicationContext);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("person.nick_name");
        System.out.println(property);
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
        applicationContext.close();
    }

}
