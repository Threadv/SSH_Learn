package cn.llanc.demo3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo3 {
    @Test
    public void test1(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(
                "IocAnnotation.xml");
        ProductService productService= (ProductService) applicationContext.getBean("productService");
        productService.save();

    }
}
