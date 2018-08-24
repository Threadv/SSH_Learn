package cn.llanc.demo1;

import com.sun.org.glassfish.external.probe.provider.PluginPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 注解增强类
 */
@Aspect
public class MyAspectAnno {

    @Before(value = "execution(* cn.llanc.demo1.Order.save(..))")
    /**
     * @Before 前置通知
     */
    public void before(){
        System.out.println("前置通知....");
    }

    @AfterReturning(value = "execution(* cn.llanc.demo1.Order.delete(..))",returning = "time")
    /**
     * @AfterReturning 后置通知接收返回值
     * @param time
     */
    public void after(Object time){
        System.out.println("后置通知....\t"+time);
    }

    @Around(value = "execution(* cn.llanc.demo1.Order.update(..))")
    /**
     * @Around 环绕通知
     * @param 切入点
     */
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知....前");
        Object o= joinPoint.proceed();
        System.out.println("环绕通知....后");
        return o;
    }

    @After(value = "MyAspectAnno.pointcut1()")
    /**
     * @After 最终通知一定会执行
     */
    public void after(){
        System.out.println("最终通知....");
    }

    @AfterThrowing(value = "MyAspectAnno.pointcut1()",throwing = "e")
    /**
     * @AfterThrowing 异常抛出通知 可以获取异常
     */
    public void afterThrowing(Throwable e){
        System.out.println("异常抛出通知....\t异常信息："+e.getMessage());
    }

    @Pointcut(value = "execution(* cn.llanc.demo1.Order.find(..))")
    /**
     * @Pointcut 切入点注解
     * 方法名相当于ID 利于维护
     */
    private void pointcut1(){}
}
