package nott.spring.utils;

import org.springframework.context.ApplicationContext;

import java.util.Map;

public class PrintInfo {


    public static void printBeanDefinitionNames(ApplicationContext applicationContext) {
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
        System.out.println("IOC容器创建完成...");
    }

    public static void printBeanOfType(ApplicationContext applicationContext, Class<?> clazz) {
        Map<String, ?> beansOfType = applicationContext.getBeansOfType(clazz);
        System.out.println(beansOfType);
    }

    public static void printBeanNameOfType(ApplicationContext applicationContext, Class<?> clazz) {
        String[] namesForType = applicationContext.getBeanNamesForType(clazz);
        for (String name : namesForType) {
            System.out.println(name);
        }
    }

}
