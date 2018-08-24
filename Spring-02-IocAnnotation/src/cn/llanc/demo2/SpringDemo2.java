package cn.llanc.demo2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo2 {
    @Test
    public void test1(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(
                "IocAnnotation.xml");
        CustomerService customerService= (CustomerService) applicationContext.getBean(
                "customerService");
        customerService.save();

        CustomerService customerService1= (CustomerService) applicationContext.getBean(
                "customerService");
        System.out.println(customerService==customerService1?"两个类相同":"两个类不同");

        ((ClassPathXmlApplicationContext) applicationContext).close();
    }
}
