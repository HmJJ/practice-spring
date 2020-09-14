package nott.spring.aop.test;

import nott.spring.aop.code.aop.MathCalculator;
import nott.spring.aop.code.config.MainConfig1;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 *  Aop: [动态代理]
 *      指定程序运行期间动态的将某段代码切入到指定方法指定位置进行运行的编程
 *  1、导入aop模块；Spring AOP：（spring-aspects）
 *  2、定义一个业务逻辑类（MathCalculator），在业务逻辑运行的时候将日志打印（方法之前、方法运行结束、方法出现异常等）
 *  3、定义一个日志切面类（LogAspects）：切面类里面的方法MathCalculator.div需要动态感知运行到哪里然后执行
 *      通知方法：
 *          前置同事(@Before)：logStart：在目标方法（div）运行之前运行
 *          后置通知(@After)：logEnd：在目标方法（div）运行结束之后运行（无论方法正常结束还是异常结束）
 *          返回通知(@AfterReturning)：logReturn：在目标方法（div）正常返回之后运行
 *          异常通知(@AfterThrowing)：logException：在目标方法（div）运行出现异常之后运行
 *          环绕通知(@Around)：动态代理，手动推进目标方法运行（joinPoint.proceed()）
 *  4、给切面类的目标方法标注何时何地运行（通知注解）
 *  5、将切面类和业务逻辑类（目标方法所在类）都加入到容器中；
 *  6、必须告诉Spring哪个类是切面类（给切面类加一个注解：@Aspect）
 *  7、给配置类中加@EnableAspectJAutoProxy（开启基于注解的aop模式）
 *      在Spring中很多的@EnableXXX；
 *
 *  三步：
 *      1）将业务逻辑组件和切面类都加入到容器中，告诉Spring哪个是切面类（@Aspect）
 *      2）在切面类上的每一个溶质方法上标注通知注解，告诉Spring何时何地运行（切入点表达式）
 *      3）开启基于注解的aop模式：@EnableAspectJAutoProxy
 *
 *  AOP原理：[看给容器中注册了什么组件，这个组件什么时候工作，这个组件的功能是什么]
 *      @EnableAspectJAutoProxy：
 *          1、@EnableAspectJAutoProxy是什么？
 *              @Import({AspectJAutoProxyRegistrar.class})：往容器中导入AspectJAutoProxyRegistrar
 *                  利用AspectJAutoProxyRegistrar自定义给容器中注册bean；
 *                  internalAutoProxyCreator=AnnotationAwareAspectjAutoProxyCreator
 *              往容器中注册一个AnnotationAwareAspectjAutoProxyCreator：
 *
 *          2、AnnotationAwareAspectjAutoProxyCreator：
 *              AnnotationAwareAspectjAutoProxyCreator
 *                  ->AspectJAwareAdvisorAutoProxyCreator
 *                      ->AbstractAdvisorAutoProxyCreator
 *                          ->AbstractAutoProxyCreator
 *                             implements SmartInstantiationAwareBeanPostProcessor
 *                           关注后置处理器（在bean初始化完成前后做的事情）、自动装配BeanFactory
 *              AbstractAutoProxyCreator.setBeanFactory
 *              有后置处理器的逻辑
 *              AbstractAutoProxyCreator.postProcessBeforeInstantiation
 *              AbstractAutoProxyCreator.postProcessAfterInitialization
 *              AspectJAwareAdvisorAutoProxyCreator.setBeanFactory -> initBeanFactory
 *              AnnotationAwareAspectjAutoProxyCreator.initBeanFactory
 *
 *  流程：
 *      1、传入配置类，创建IOC容器
 *      2、注册配置类，调用refresh()刷新容器
 *      3、registerBeanPostProcessors(beanFactory);注册bean的后置处理器来方便拦截bean的创建
 *          a）先获取IOC容器中已经定义了的需要创建对象的所有BeanPostProcessor
 *          b）给容器中加别的BeanPostProcessor
 *          c）优先注册实现了PriorityOrdered接口的BeanPostProcessor
 *          d）再给容器中注册实现了Ordered接口的BeanPostProcessor
 *          e）注册没实现优先级接口的BeanPostProcessor
 *          f）注册BeanPostProcessor，实际上就是创建BeanPostProcessor对象，保存到容器中
 *              创建internalAutoProxyCreator的BeanPostProcessor [AnnotationAwareAspectjAutoProxyCreator]
 *              1）创建bean的实例
 *              2）populateBean：给bean的各种属性赋值
 *              3）initializeBean：初始化bean
 *                  1）invokeAwareMethods：处理Aware接口的方法回调
 *                  2）applyBeanPostProcessorsBeforeInitialization：执行后置处理器的applyBeanPostProcessorsBeforeInitialization
 *                  3）invokeInitMethods：执行自定义的初始化方法
 *                  4）applyBeanPostProcessorsAfterInitialization：执行后置处理器的applyBeanPostProcessorsAfterInitialization
 *              4）BeanPostProcessor（AnnotationAwareAspectjAutoProxyCreator）创建成功；--> aspectJAdvisorsBuilder
 *          g）把BeanPostProcessor注册到BeanFactory中：
 *              beanFactory.addBeanPostProcessor(postProcessor)
 * =========以上是创建和注册AnnotationAwareAspectjAutoProxyCreator的过程===============
 *        AnnotationAwareAspectjAutoProxyCreator -> InstantiationAwareBeanPostProcessor
 *      4）finishBeanFactoryInitialization(beanFactory);完成BeanFactory初始化工作，创建剩下的单实例bean
 *          a）遍历获取容器中所有的Bean，依次创建对象getBean(beanName)
 *              getBean() -> doGetBean() -> getSingleton()
 *          b）创建bean
 *              [AnnotationAwareAspectjAutoProxyCreator在所有bean创建之前会有一个拦截，会调用postProcessBeforeInstantiation()]
 *              1）先从缓存中获取当前bean，如果能获取到没说明bean是之前被创建过的，直接使用，否则再创建
 *                  只要创建好的Bean都会被缓存起来
 *              2）createBean()；创建bean，AnnotationAwareAspectjAutoProxyCreator会在任何bean创建之前先返回bean的实例
 *                  [BeanPostProcessor是在Bean对象创建完成初始化前后调用的]
 *                  [InstantiationAwareBeanPostProcessor实在创建Bean实例之前先尝试用后置处理器返回代理对象的]
 *                  a）resolveBeforeInstantiation(beanName, mbdToUse);解析BeforeInstantiation
 *                      希望后置处理器在此能返回一个代理对象：如果能就使用，如果不能就继续
 *                      1）后置处理器先尝试返回对象
 *                          bean = this.applyBeanPostProcessorsBeforeInstantiation(targetType, beanName);
 *                              拿到所有后置处理器，如果是InstantiationAwareBeanPostProcessor，就执行postProcessBeforeInstantiation(beanClass, beanName);
 *                          if (bean != null) {
 *                              bean = this.applyBeanPostProcessorsAfterInitialization(bean, beanName);
 *                          }
 *                  b）doCreateBean(beanName, mbdToUse, args);真正的去创建一个bean实例，和3.6流程一样
 *                  c）
 *   AnnotationAwareAspectJAutoProxyCreator [InstantiationAwareBeanPostProcessor]的作用：
 *      1）每一个bean创建之前，调用postProcessBeforeInstantiation()
 *          MathCalculator和LogAspect的创建
 *          a）判断当前bean是否在advisedBeans中（保存了所有需要增强的bean）
 *          b）判断当前bean是否是基础类型的Advice、PointCut、Advisor、AopInfrastructureBean，
 *              或者是否是切面（@Aspect）
 *          c）判断是否需要跳过
 *              1）获取候选的增强器（切面里面的通知方法） [List<Advisor> candidateAdvisors]
 *                  每一个封装的通知方法的增强器是InstantiationModelAwarePointcutAdvisor
 */
public class AopTest {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig1.class);

        // 不要自己创建对象
        // MathCalculator mathCalculator = new MathCalculator();
        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
        mathCalculator.div(1, 1);

        applicationContext.close();
    }

}
