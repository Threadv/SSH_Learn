package cn.llanc.demo3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author 刘兰聪
 * @date 2018-08-09 11:31
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:TransferTestSpringConfig.xml")
public class TransferTest {
    @Resource(name = "transferService")
    private TransferService transferService;
    @Test
    public void test1(){
        transferService.transfer("test1","test2",1000d);
    }
}
