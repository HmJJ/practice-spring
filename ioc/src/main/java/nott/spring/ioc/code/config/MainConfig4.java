/**
 * @Author: nott
 * @Description:
 * @Date: created in 2020/9/9 11:36
 * @Modified By:
 */
package nott.spring.ioc.code.config;

import nott.spring.ioc.code.bean.Person;
import nott.spring.ioc.code.config.condition.LinuxCondition;
import nott.spring.ioc.code.config.condition.WindowsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@Conditional({WindowsCondition.class})
public class MainConfig4 {

    @Bean("person")
    public Person person() {
        System.out.println("给容器中添加Person...");
        return new Person("nott", 18);
    }
    /**
     * @Confitional({Condition})
     * 按照一定的条件进行判断，满足条件给容器中注册bean
     *
     * 如果系统是windows，给容器中注册("bill")
     * 如果系统是linux，给容器中注册("linus")
     */
    @Bean("bill")
    public Person person01() {
        return new Person("Bill Gates", 62);
    }
    @Bean("linus")
    @Conditional({LinuxCondition.class})
    public Person person02() {
        return new Person("linus", 48);
    }

}
