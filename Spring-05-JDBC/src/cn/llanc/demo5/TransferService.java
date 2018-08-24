package cn.llanc.demo5;

import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author 刘兰聪
 * @date 2018-08-09 11:02
 */
@Transactional
/**
 * @Transactional 事务注解
 */
public class TransferService implements TransferServiceInterface {
//    注入Dao
    @Resource(name = "transferDao")
    private TransferDao transferDao;

    @Override
    public void transfer(String from, String to, double money) {
        transferDao.outMoney(from, money);
        //int x=1/0;
        transferDao.inMoney(to, money);
    }
}
