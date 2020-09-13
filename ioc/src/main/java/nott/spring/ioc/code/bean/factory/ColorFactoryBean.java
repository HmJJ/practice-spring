/**
 * @Author: nott
 * @Description:
 * @Date: created in 2020/9/9 14:27
 * @Modified By:
 */
package nott.spring.ioc.code.bean.factory;

import nott.spring.ioc.code.bean.Color;
import org.springframework.beans.factory.FactoryBean;

// 创建一个Spring定义的FactoryBean
public class ColorFactoryBean implements FactoryBean<Color> {

    // 返回一个Color对象，这个对象会添加到容器中
    public Color getObject() throws Exception {
        System.out.println("ColorFactoryBean...getObject...");
        return new Color();
    }

    public Class<?> getObjectType() {
        return Color.class;
    }

    // 是否为单例
    // true：这个bean是单例，在容器中保存一份
    // false：多实例，每次获取都会创建一个新的bean
    public boolean isSingleton() {
        return true;
    }
}
