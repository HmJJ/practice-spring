/**
 * @Author: nott
 * @Description:
 * @Date: created in 2020/9/9 13:16
 * @Modified By:
 */
package nott.spring.ioc.code.bean;

public class Color {

    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Color{" +
                "car=" + car.hashCode() +
                '}';
    }
}
