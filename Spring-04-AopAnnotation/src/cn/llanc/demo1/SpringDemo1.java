package cn.llanc.demo1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:AopAnnotation.xml")
public class SpringDemo1 {
    @Resource(name = "order")
    private Order order;

    @Test
    public void test1(){
        order.save();
        order.delete();
        order.update();
        order.find();
    }
}
