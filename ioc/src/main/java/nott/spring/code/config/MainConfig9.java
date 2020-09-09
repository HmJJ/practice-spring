/**
 * @Author: nott
 * @Description:
 * @Date: created in 2020/9/9 18:20
 * @Modified By:
 */
package nott.spring.code.config;

import nott.spring.code.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// 使用@propertySource读取外部配置文件中的k/v保存到运行的环境变量中；加载完外部的配置文件以后使用${}取出配置文件的值
@PropertySource({"classpath:application.properties"})
@Configuration
public class MainConfig9 {

    @Bean
    public Person person() {
        return new Person();
    }

}
