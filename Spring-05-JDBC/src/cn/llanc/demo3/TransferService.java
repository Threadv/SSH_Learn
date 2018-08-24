package cn.llanc.demo3;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;

/**
 * @author 刘兰聪
 * @date 2018-08-09 11:02
 */
public class TransferService implements TransferServiceInterface{
//    注入Dao
    @Resource(name = "transferDao")
    private TransferDao transferDao;
//    注入事务管理模板
    @Resource(name = "transactionTemplate")
    private TransactionTemplate transactionTemplate;

    @Override
    public void transfer(String from, String to, double money) {
        transactionTemplate.equals(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                transferDao.outMoney(from, money);
                transferDao.inMoney(to, money);
            }
        });
    }
}
