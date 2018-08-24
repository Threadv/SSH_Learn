package cn.llanc.demo1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 切面类 包含各种通知等
 */
public class MyAspectXml {
    /**
     * 前置通知
     * @param joinPoint
     */
    public void checkPri(JoinPoint joinPoint){
        System.out.println("++++权限校验++++"+joinPoint);
    }

    /**
     * 后置通知
     */
    public void printLog(Object result){
        System.out.println("++++日志记录++++"+result);
    }

    /**
     * 环绕通知
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("----环绕前通知----");
        Object object =joinPoint.proceed(); //执行目标函数
        System.out.println("----环绕后通知----");
        return object;
    }
    /**
     *异常抛出通知 可以获得异常信息
     */
    public void afterThrowing(Throwable ex){
        System.out.println("抛出异常"+ex.getMessage());
    }

    /**
     * 最终通知 一定会执行的代码块
     */
    public void after(){
        System.out.println("++++最终通知++++");
    }
}
