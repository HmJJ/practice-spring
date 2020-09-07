/**
 * @Author: nott
 * @Description:
 * @Date: created in 2020/9/7 15:47
 * @Modified By:
 */
package nott.spring.code;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.math.BigDecimal;

public class TimeLoggingAop implements MethodBeforeAdvice, AfterReturningAdvice {

    private long startTime = 0;

    public void before(Method method, Object[] objects, Object o) throws Throwable {
        startTime = System.nanoTime();
    }

    public void afterReturning(Object o, Method method, Object[] objects, Object target) throws Throwable {
        long spentTime = System.nanoTime() - startTime;
        String clazzName = target.getClass().getCanonicalName();
        String methodName = method.getName();
        System.out.println("执行" + clazzName + "#" + methodName + "消耗" + new BigDecimal(spentTime).divide(new BigDecimal(1000000)) + "毫秒");
    }
}
