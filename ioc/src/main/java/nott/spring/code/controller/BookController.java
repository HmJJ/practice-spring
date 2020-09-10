/**
 * @Author: nott
 * @Description:
 * @Date: created in 2020/9/9 10:45
 * @Modified By:
 */
package nott.spring.code.controller;

import nott.spring.code.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

}
