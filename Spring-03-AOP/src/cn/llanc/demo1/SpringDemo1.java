package cn.llanc.demo1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:SpringAOP.xml")
/**
 * @RunWith Spring框架与JUnit4单元测试整合 代替Fectory
 * @ContextConfiguration 加载配置文件
 */
public class SpringDemo1 {
    @Resource(name="productDaoImpl")//属性注入
    /**
     * 属性 注入时注意与配置文件中 增强对象的ID保持一致
     */
    private ProductDaoImpl productDaoImpl;
    @Test
    public void test1(){
        productDaoImpl.save();
        productDaoImpl.update();
        productDaoImpl.delete();
        productDaoImpl.find();
    }
}
