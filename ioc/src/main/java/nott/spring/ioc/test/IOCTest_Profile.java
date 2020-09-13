package nott.spring.ioc.test;

import nott.spring.ioc.code.config.MainConfig11;
import nott.spring.utils.PrintInfo;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.util.Map;

/**
 * Profile:
 *      Spring为我们提供的可以根据当前环境，动态激活和切换一些列组件的功能
 * 开发环境、测试环境、生产环境
 * 数据源：（/A）（/B）（/C）

 * @Profile：指定组件在那个环境的情况下才能被注册到容器中；不指定，任何环境下都能注册这个组件
 *      a）加了环境标识的bean，只有这个环境被激活的时候才能注册到容器中
 *      b）写在配置类上，只有是指定的环境的时候，整个配置类里面的所有配置才能开始生效
 *      c）没有标注环境标识的bean在任何环境下都加载
 */
public class IOCTest_Profile {

    // 1、使用命令行动态参数：在虚拟机参数位置加载 -Dspring.profiles.active=test
    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig11.class);
        PrintInfo.printBeanNameOfType(applicationContext, DataSource.class);
        applicationContext.close();
    }

    // 2、代码的方式激活某种环境
    @Test
    public void test02() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        //1、创建一个applicationCOntext
        //2、设置需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles("dev");
        applicationContext.register(MainConfig11.class);
        applicationContext.refresh();

        PrintInfo.printBeanNameOfType(applicationContext, DataSource.class);
        applicationContext.close();
    }

    @Test
    public void test03() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig11.class);
        PrintInfo.printBeanDefinitionNames(applicationContext);
        applicationContext.close();
    }
}
