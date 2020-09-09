/**
 * @Author: nott
 * @Description:
 * @Date: created in 2020/9/9 11:12
 * @Modified By:
 */
package nott.spring.code.config;

import nott.spring.code.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MainConfig2 {

    @Bean("person")
    /**
     * @Scope：调整作用域
     * SCOPE_SINGLETON、SCOPE_PROTOTYPE
     * SCOPE_REQUEST、SCOPE_SESSION
     *
     * singleton：单实例的（默认的），ioc容器启动会调用方法创建对象放到ioc容器中，以后每次获取直接从容器（map.get()）中拿
     * prototype：多实例的，ioc容器启动不会调用方法创建对象放到容器中，而是每次获取的时候创建对象
     * request：同一次请求创建一个实例
     * prototype：同一个session创建一个实例
     *
     */
    @Scope("prototype")
    public Person person() {
        System.out.println("给容器中添加Person...");
        return new Person("nott", 18);
    }

}
