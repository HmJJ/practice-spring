package nott.spring.ioc.code.bean;

import org.springframework.stereotype.Component;

/**
 * @PackgeName: nott.spring.ioc.code.bean
 * @ClassName: Boss
 * @Author: nott
 * Date: 2020/9/12 11:29
 * project name: ioc
 * @Version:
 * @Description:
 */
// 默认加在ioc容器中的组件，容器启动会调用无参构造器创建对象，在进行初始化赋值等操作
@Component
public class Boss {

    private Car car;

    // 构造器要用的组件都从ioc容器中获取
    /*@Autowired
    public Boss(Car car) {
        this.car = car;
        System.out.println("Boss。。。有参构造器");
    }*/

    // 构造器要用的组件都从ioc容器中获取
    /*public Boss(@Autowired Car car) {
        this.car = car;
        System.out.println("Boss。。。有参构造器");
    }*/

    public Boss(Car car) {
        this.car = car;
        System.out.println("Boss。。。有参构造器");
    }

    public Car getCar() {
        return car;
    }

//    @Autowired
    // 标注再方法上，Spring容器创建当前对象，会调用方法，完成赋值
    // 方法使用的参数，自定义类型的值从ioc容器中获取
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car.hashCode() +
                '}';
    }
}
