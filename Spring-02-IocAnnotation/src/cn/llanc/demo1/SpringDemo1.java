package cn.llanc.demo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo1 {
    @Test
    public void Test1(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(
                "IocAnnotation.xml");
        UserDaoImpl userDaoImpl= (UserDaoImpl) applicationContext.getBean("userDao");
        userDaoImpl.save();
    }
    @Test
    public void Test2(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(
                "IocAnnotation.xml");
        UserServiceImpl userServiceImpl= (UserServiceImpl) applicationContext.getBean(
                "userServiceImpl");
        userServiceImpl.save();

    }
}
