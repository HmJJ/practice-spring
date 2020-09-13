/**
 * @Author: nott
 * @Description:
 * @Date: created in 2020/9/9 14:39
 * @Modified By:
 */
package nott.spring.ioc.code.config;

import nott.spring.ioc.code.bean.Animal;
import nott.spring.ioc.code.bean.Car;
import nott.spring.ioc.code.bean.Dog;
import nott.spring.ioc.code.bean.RainBow;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

@Configuration
@Import(value = {Dog.class})
public class MainConfig7 {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car() {
        return new Car();
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    @Scope("prototype")
    public Animal animal() {
        return new Animal();
    }

    @Bean
    public RainBow rainBow() {
        return new RainBow();
    }

}
