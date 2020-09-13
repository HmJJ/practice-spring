/**
 * @Author: nott
 * @Description:
 * @Date: created in 2020/9/9 14:31
 * @Modified By:
 */
package nott.spring.ioc.code.config;

import nott.spring.ioc.code.bean.factory.ColorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainConfig6 {

    @Bean
    public ColorFactoryBean colorFactoryBean() {
        return new ColorFactoryBean();
    }

}
