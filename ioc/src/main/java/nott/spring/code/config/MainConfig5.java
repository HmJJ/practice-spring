/**
 * @Author: nott
 * @Description:
 * @Date: created in 2020/9/9 13:18
 * @Modified By:
 */
package nott.spring.code.config;

import nott.spring.code.bean.Color;
import nott.spring.code.bean.Person;
import nott.spring.code.config.selector.MyImportBeanDefinitionRegistrar;
import nott.spring.code.config.selector.MyImportSelector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({Color.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
// @Import导入组件，id默认是组件的全类名
public class MainConfig5 {

    @Bean
    public Person person() {
        return new Person("nott", 18);
    }

}
