/**
 * @Author: nott
 * @Description:
 * @Date: created in 2020/9/10 14:47
 * @Modified By:
 */
package nott.spring.ioc.code.dao;

import org.springframework.stereotype.Repository;

// bean名字默认是类名首字母小写
@Repository
public class BookDao {

    private String label = "1";

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "BookDao: " + label;
    }
}
