/**
 * @Author: nott
 * @Description:
 * @Date: created in 2020/9/9 10:47
 * @Modified By:
 */
package nott.spring.test;

import nott.spring.code.bean.Animal;
import nott.spring.code.bean.Person;
import nott.spring.code.bean.RainBow;
import nott.spring.code.config.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * 给容器中注册组件：
 * 1）包扫描+组件标注注解（@Controller/@Service/@Repository/@Component）
 * 2）@Bean[导入的第三方包里面的组件]
 * 3）@Import[快速给容器中导入一个组件]
 *      a、@Import(要导入到容器中的组件)，容器会自动注册这个组件，id默认是全类名
 *      b、ImportSelector：返回需要导入的组件的全类名数组
 *      c、ImportBeanDefinitionRegistrar：手动注册bean到容器
 * 4）使用Spring提供的FactoryBean（工厂Bean）
 *      a、默认获取到的是工厂bean调用getObject创建的对象
 *      b、要获取工厂bean本身需要在id前加 & 标识
 */
public class IOCTest {

    ApplicationContext applicationContext;

    @SuppressWarnings("resource")
    @Test
    public void test01() {
        applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        printBeanDefinitionNames();
    }

    @Test
    public void test02() {
        applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        printBeanDefinitionNames();
        Person person = (Person) applicationContext.getBean("person");
        Person person2 = (Person) applicationContext.getBean("person");
        System.out.println(person==person2);
    }

    @Test
    public void test03() {
        applicationContext = new AnnotationConfigApplicationContext(MainConfig3.class);
        printBeanDefinitionNames();
        Person person = (Person) applicationContext.getBean("person");
        Person person2 = (Person) applicationContext.getBean("person");
        System.out.println(person==person2);
    }

    @Test
    public void test04() {
        applicationContext = new AnnotationConfigApplicationContext(MainConfig4.class);
        printBeanNameOfType(Person.class);
        ConfigurableEnvironment environment = (ConfigurableEnvironment) applicationContext.getEnvironment();
        // 获取环境变量的值， Windows 10
        String property = environment.getProperty("os.name");
        System.out.println(property);
        printBeanOfType(Person.class);
    }

    @Test
    public void test05() {
        applicationContext = new AnnotationConfigApplicationContext(MainConfig5.class);
        printBeanDefinitionNames();
        Animal animal = applicationContext.getBean(Animal.class);
        System.out.println(animal);
        RainBow rainBow = applicationContext.getBean(RainBow.class);
        System.out.println(rainBow);
    }

    @Test
    public void test06() {
        applicationContext = new AnnotationConfigApplicationContext(MainConfig6.class);
        printBeanDefinitionNames();
        Object bean1 = applicationContext.getBean("colorFactoryBean");
        System.out.println(bean1.getClass());
        Object bean2 = applicationContext.getBean("&colorFactoryBean");
        System.out.println(bean2.getClass());
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
