/**
 * @Author: nott
 * @Description:
 * @Date: created in 2020/9/9 10:13
 * @Modified By:
 */
package nott.spring.ioc.test;

import nott.spring.ioc.code.bean.Person;
import nott.spring.ioc.code.config.MainConfig;
import nott.spring.utils.PrintInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {

    public static void main(String[] args) {
        /*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);*/

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = applicationContext.getBean(Person.class);
        System.out.println(person);

        PrintInfo.printBeanDefinitionNames(applicationContext);

    }

}
