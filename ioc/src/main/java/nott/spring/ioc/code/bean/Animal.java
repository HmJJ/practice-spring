/**
 * @Author: nott
 * @Description:
 * @Date: created in 2020/9/9 13:21
 * @Modified By:
 */
package nott.spring.ioc.code.bean;

public class Animal {

    public Animal() {
        System.out.println("animal constructor...");
    }

    public void init() {
        System.out.println("animal ... init ...");
    }

    public void destroy() {
        System.out.println("animal ... destroy ...");
    }

    @Override
    public String toString() {
        return "Animal: " + this.hashCode();
    }
}
