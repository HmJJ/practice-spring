/**
 * @Author: nott
 * @Description:
 * @Date: created in 2020/9/10 9:33
 * @Modified By:
 */
package nott.spring.code.config;

import nott.spring.code.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"nott.spring.code.controller","nott.spring.code.dao","nott.spring.code.service"})
public class MainConfig10 {

    @Bean("bookDao2")
    public BookDao bookDao() {
        BookDao bookDao = new BookDao();
        bookDao.setLabel("2");
        return bookDao;
    }
}
