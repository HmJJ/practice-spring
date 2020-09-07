/**
 * @Author: nott
 * @Description:
 * @Date: created in 2020/9/7 15:55
 * @Modified By:
 */
package nott.spring.boot;

import nott.spring.code.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BootApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        HelloWorld helloWorld = applicationContext.getBean(HelloWorld.class);
        helloWorld.sayHello();
    }

}
