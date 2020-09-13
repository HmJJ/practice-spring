/**
 * @Author: nott
 * @Description:
 * @Date: created in 2020/9/10 9:29
 * @Modified By:
 */
package nott.spring.ioc.test;

import nott.spring.ioc.code.bean.Boss;
import nott.spring.ioc.code.bean.Car;
import nott.spring.ioc.code.bean.Color;
import nott.spring.ioc.code.config.MainConfig10;
import nott.spring.ioc.code.service.BookService;
import nott.spring.utils.PrintInfo;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * 自动装配：
 *      Spring利用依赖注入（DI），完成对IOC容器中各个组件的依赖关系赋值
 *  1）@Autowired，自动注入
 *      a）默认优先按照类型去容器中找对应的组件：applicationContext.getBean（）
 *      b）如果找到多个相同类型的组件，再将属性的名称作为组件的id去容器中查找
 *      c）@Qualifier(“bookDao”)：使用@Qualifier指定需要装备的组件的id，而不是使用属性名
 *      d）自动装备默认一定要将属性赋值好，没有就会报错
 *          可以使用@Autowired(required=false)；
 *      e）@Primary：让Spring进行自动装配的时候，默认使用首选的bean
 *          也可以继续使用@Qualifier指定需要装配的bean的名字
 *  2）Spring还支持使用@Resource(JSR250)和@Inject(JSR330) [Java规范注解]
 *      @Resource：可以和@Autowired一样实现自动装配功能；默认是按照组件名称进行装配的;
 *                  没有能支持@Primary功能，没有支持@Autowired(required=false)
 *      @Inject：需要先导入javax.inject的包，和Autowired的功能一样（支持@Primary），但是没有required的功能
 *    @Autowired：Spring定义的；@Resource、@Inject是java规范
 *  AutowiredAnnotationBeanPostProcessor：解析完成自动装配功能；
 *  3）@Autowired：构造器，参数，方法，属性；
 *      a）标注在方法位置：@Bean+方法参数；参数从容器中获取；默认不屑@Autowired效果是一样的；都能自动装配
 *      b）标注在构造器上：如果组件只有一个有参构造器，这个有参构造器的@Autowired可以省略，参数位置的组件还是可以从容器中获取
 *      c）标注在参数位置
 *  4）自定义组件想要使用Spring容器底层的一些组件（ApplicationContext,BeanFactory,xxx）：
 *      自定义组件实现xxxAware：在创建对象的时候，会调用接口规定的方法注入相关组件；Aware
 *      把Spring底层一些组件注入到自定义的Bean中
 *      xxxAware：功能使用xxxProcessor：
 *          ApplicationContextAware ==> ApplicationContextAwareProcessor;
 */
public class IOCTest_Autowired {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig10.class);
        PrintInfo.printBeanDefinitionNames(applicationContext);

        BookService bookService = (BookService) applicationContext.getBean("bookService");
        bookService.print();

        applicationContext.close();
    }

    @Test
    public void test02() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig10.class);
        PrintInfo.printBeanDefinitionNames(applicationContext);

        Boss boss = applicationContext.getBean(Boss.class);
        System.out.println(boss);
        Car car = applicationContext.getBean(Car.class);
        System.out.println(car.hashCode());

        applicationContext.close();
    }

    @Test
    public void test03() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig10.class);
        PrintInfo.printBeanDefinitionNames(applicationContext);

        Color color = applicationContext.getBean(Color.class);
        System.out.println(color);
        Car car = applicationContext.getBean(Car.class);
        System.out.println(car.hashCode());
        System.out.println(applicationContext);

        applicationContext.close();
    }

    @Test
    public void test05() {
        Integer a=128, b=128, c=100, d=100;
        System.out.println(a.intValue()==b.intValue());
        System.out.println(a==b);
        System.out.println(c==d);
    }

}
