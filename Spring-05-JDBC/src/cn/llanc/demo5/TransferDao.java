package cn.llanc.demo5;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * @author 刘兰聪
 * @date 2018-08-09 11:03
 */
public class TransferDao extends JdbcDaoSupport implements TransferDaoInterface {

    @Override
    public void outMoney(String from,Double money) {
        this.getJdbcTemplate().update("update account set money = money - ? where name = ?",money,from);
    }

    @Override
    public void inMoney(String in,Double money) {
        this.getJdbcTemplate().update("update account set money = money + ? where name= ? ",money,in);
    }
}
