/**
 * @Author: nott
 * @Description:
 * @Date: created in 2020/9/10 9:29
 * @Modified By:
 */
package nott.spring.test;

import nott.spring.code.config.MainConfig10;
import nott.spring.code.dao.BookDao;
import nott.spring.code.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * 自动装配：
 *      Spring利用依赖注入（DI），完成对IOC容器中各个组件的依赖关系赋值
 *  1）@Autowired，自动注入
 *      a）默认优先按照类型去容器中找对应的组件：applicationContext.getBean（）
 *      b）如果找到多个相同类型的组件，再将属性的名称作为组件的id去容器中查找
 */
public class AutowiredTest {

    AnnotationConfigApplicationContext applicationContext;

    @Test
    public void test01() {
        applicationContext = new AnnotationConfigApplicationContext(MainConfig10.class);
        printBeanDefinitionNames();

        BookService bookService = (BookService) applicationContext.getBean("bookService");
        bookService.print();

        applicationContext.close();
    }

    @Test
    public void test02() {
        Integer a=128, b=128, c=100, d=100;
        System.out.println(a.intValue()==b.intValue());
        System.out.println(a==b);
        System.out.println(c==d);
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
