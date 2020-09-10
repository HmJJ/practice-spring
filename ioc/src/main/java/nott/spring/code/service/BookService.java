/**
 * @Author: nott
 * @Description:
 * @Date: created in 2020/9/9 10:46
 * @Modified By:
 */
package nott.spring.code.service;

import nott.spring.code.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    @Qualifier("bookDao2")
    @Autowired
    private BookDao bookDao2;

    public void print() {
        System.out.println(bookDao);
        System.out.println(bookDao2);
    }

}
