/**
 * @Author: nott
 * @Description:
 * @Date: created in 2020/9/9 14:51
 * @Modified By:
 */
package nott.spring.ioc.code.bean;

import org.springframework.stereotype.Component;

@Component
public class Car {

    public Car() {
        System.out.println("car constructor...");
    }

    public void init() {
        System.out.println("car ... init ...");
    }

    public void destroy() {
        System.out.println("car ... destroy ...");
    }
}
