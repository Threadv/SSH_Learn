package bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    @Test
    public void test(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserImpl user= (UserImpl) applicationContext.getBean("user");
        user.save();
        System.out.println(user.getName());
        UserImpl user1= (UserImpl) applicationContext.getBean("user");
        System.out.println(user==user1?"yes":"no");
        ((ClassPathXmlApplicationContext) applicationContext).close();//单例模式下可以销毁
    }
}
