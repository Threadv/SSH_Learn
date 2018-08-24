package cn.llanc.demo4;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;

/**
 * @author 刘兰聪
 * @date 2018-08-09 11:02
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
