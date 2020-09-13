/**
 * @Author: nott
 * @Description:
 * @Date: created in 2020/9/9 10:33
 * @Modified By:
 */
package nott.spring.ioc.code.config;

import nott.spring.ioc.code.bean.Person;
import nott.spring.ioc.code.config.typeFilter.MyTypeFilter;
import org.springframework.context.annotation.*;

// 配置类==配置文件
@Configuration  // 告诉Spring这是一个配置类
@ComponentScans(
        value = {
                @ComponentScan(value = "nott.spring.ioc", includeFilters = {
        /*@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {BookService.class}),*/
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
}, useDefaultFilters = false)
        }
)
//@ComponentScan   value:指定要扫描的包
//excludeFilter = Filter[], 指定扫描的时候按照什么规则排除哪些组件
//includeFilter = Filter[], 指定扫描的时候只包含哪些组件， 需要useDefaultFilters=false
//FilterType.ANNOTATION, 按照注解
//FilterType.ASSIGNABLE_TYPE, 按照给定的类型
//FilterType.ASPECTJ, 使用ASPECTJ表达式
//FilterType.REGEX, 使用正则表达式
//FilterType.CUSTOM, 使用自定义规则
public class MainConfig {

    // 给容器中注册一个Bean；类型为返回值的类型，id默认是方法名
    @Bean("person")
    public Person person() {
        return new Person("nott", 24);
    }

}
