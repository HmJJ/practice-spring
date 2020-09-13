/**
 * @Author: nott
 * @Description:
 * @Date: created in 2020/9/9 10:46
 * @Modified By:
 */
package nott.spring.ioc.code.service;

import nott.spring.ioc.code.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class BookService {

//    @Autowired
//    @Resource(name = "bookDao2")
    @Autowired
    private BookDao bookDao;

    /*@Qualifier("bookDao2")
    @Autowired(required = false)
    private BookDao bookDao2;*/

    public void print() {
        System.out.println(bookDao);
//        System.out.println(bookDao2);
    }

}
