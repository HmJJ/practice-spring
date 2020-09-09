/**
 * @Author: nott
 * @Description:
 * @Date: created in 2020/9/9 11:33
 * @Modified By:
 */
package nott.spring.code.config;

import nott.spring.code.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class MainConfig3 {

    @Bean
    /**
     * @Lazy 懒加载：
     *      单实例bean，默认再容器启动的时候创建对象
     *      懒加载，容器启动不创建对象，第一次使用（获取）bean创建对象，并初始化
     */
    @Lazy
    public Person person() {
        System.out.println("给容器中添加Person...");
        return new Person("nott", 18);
    }

}
