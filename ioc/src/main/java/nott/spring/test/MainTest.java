/**
 * @Author: nott
 * @Description:
 * @Date: created in 2020/9/9 10:13
 * @Modified By:
 */
package nott.spring.test;

import nott.spring.code.bean.Person;
import nott.spring.code.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    public static void main(String[] args) {
        /*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);*/

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = applicationContext.getBean(Person.class);
        System.out.println(person);

        String[] names = applicationContext.getBeanDefinitionNames();
        for(String name : names) {
            System.out.println(name);
        }

    }

}
