/**
 * @Author: nott
 * @Description:
 * @Date: created in 2020/9/10 9:33
 * @Modified By:
 */
package nott.spring.ioc.code.config;

import nott.spring.ioc.code.bean.Car;
import nott.spring.ioc.code.bean.Color;
import nott.spring.ioc.code.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan({"nott.spring.ioc.code.controller", "nott.spring.ioc.code.dao", "nott.spring.ioc.code.service", "nott.spring.ioc.code.bean"})
public class MainConfig10 {

    @Primary
    @Bean("bookDao2")
    public BookDao bookDao() {
        BookDao bookDao = new BookDao();
        bookDao.setLabel("2");
        return bookDao;
    }

    // @Bean标注的方法创建对象的时候，方法参数的值从容器中获取
    @Bean
    public Color color(Car car) {
        Color color = new Color();
        color.setCar(car);
        return color;
    }
}
