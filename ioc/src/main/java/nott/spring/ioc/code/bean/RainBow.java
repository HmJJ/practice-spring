/**
 * @Author: nott
 * @Description:
 * @Date: created in 2020/9/9 14:01
 * @Modified By:
 */
package nott.spring.ioc.code.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class RainBow implements InitializingBean, DisposableBean {

    public RainBow() {
        System.out.println("rainBow constructor ...");
    }

    @Override
    public String toString() {
        return "RainBow: " + this.hashCode();
    }

    public void destroy() throws Exception {
        System.out.println("rainBow ... destroy ...");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("rainBow ... afterPropertiesSet ...");
    }
}
