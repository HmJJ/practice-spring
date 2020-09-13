/**
 * @Author: nott
 * @Description:
 * @Date: created in 2020/9/9 13:39
 * @Modified By:
 */
package nott.spring.ioc.code.config.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

// 自定义逻辑返回需要导入的组件
public class MyImportSelector implements ImportSelector {

    /**
     * @param annotationMetadata 当前标注@Import注解的类的所有注解信息
     * @return 返回值就是要导入到容器中的组件全类名数组
     */
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[] {"nott.spring.ioc.code.bean.Animal"};
    }

}
