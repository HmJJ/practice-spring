/**
 * @Author: nott
 * @Description:
 * @Date: created in 2020/9/9 14:39
 * @Modified By:
 */
package nott.spring.test;

import nott.spring.code.bean.Animal;
import nott.spring.code.config.MainConfig7;
import nott.spring.code.config.MainConfig8;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * bean的生命周期：
 *      bean创建----初始化----销毁的过程
 * 容器管理bean的生命周期
 * 我们可以自定义初始化和销毁方法，容器在bean进行到当前生命周期的时候来调用我们自定义的初始化和销毁方法
 *
 * 构造（对象创建）
 *      单实例：在容器启动的时候创建对象
 *      多实例：在每次获取的时候创建
 * BeanPostProcessor.postProcessBeforeInitialization
 * 初始化：
 *      对象创建完成，并赋值好，调用初始化方法
 * BeanPostProcessor.postProcessAfterInitialization
 * 销毁：
 *      单实例：容器关闭的时候
 *      多实例：容器不会管理这个bean，容器不会调用销毁方法
 *
 * 遍历得到容器中所有的BeanPostProcessor，逐个执行beforeInitialization，
 * 一旦返回null，跳出循环，不会执行后面的BeanPostProcessor
 *
 * 1）指定初始化和销毁方法
 *      通过@Bean指定init-method和destroy-method
 * 2）通过让bean实现InitializingBean（定义初始化逻辑），
 *                  DisposableBean（定义销毁逻辑）
 * 3）可以使用JSR250：
 *      @PostConstruct：在bean创建完成并且属性赋值完成，来执行初始化方法
 *      @PreDestroy：在容器销毁bean之前通知我们进行清理工作
 * 4）BeanPostProcessor：bean的后置处理器
 *      在bean初始化前后进行一些处理工作
 *      postProcessBeforeInitialization：在初始化之前工作
 *      postProcessAfterInitialization：在初始化之后工作
 *
 * Spring底层对BeanPostProcessor的使用
 *
 */
public class LifeCycleTest {

    AnnotationConfigApplicationContext applicationContext;

    @Test
    public void test01() {
        applicationContext = new AnnotationConfigApplicationContext(MainConfig7.class);
        printBeanDefinitionNames();

        Animal bean = applicationContext.getBean(Animal.class);
        Animal bean2 = applicationContext.getBean(Animal.class);

        applicationContext.close();
    }

    @Test
    public void test02() {
        applicationContext = new AnnotationConfigApplicationContext(MainConfig8.class);
        printBeanDefinitionNames();
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
