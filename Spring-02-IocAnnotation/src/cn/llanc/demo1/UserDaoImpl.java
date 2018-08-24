package cn.llanc.demo1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * UserDao的实现类
 */


@Repository("userDao")
/**
 * @Component("userDao")修饰一个类，交给Spring处理 有三个衍生：
 * @Controller ：web层
 * @Service :service层
 * @Repository ：dao层
 */
public class UserDaoImpl implements UserDao {

    @Value("张三") //属性注入可以没有set方法
    private String name;
    private int age;

    @Value("21")
    /**
     * 普通类型的属性可以直接使用@Value注解
     * 对象类型可以使用@Autowired
     */
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void save() {
        System.out.println("UserDao Save执行。。。"+name+age);
    }
}
