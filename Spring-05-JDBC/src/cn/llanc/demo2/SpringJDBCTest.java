package cn.llanc.demo2;

import cn.llanc.bean.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:SpringJDBCTemplate.xml")
public class SpringJDBCTest {
    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    @Test
    public void update(){
        //jdbcTemplate.update("insert into account values (null ,?,?)", "lance", 26000d);
        //jdbcTemplate.update("update account set name = ?,money = ? where id = ?", "Temp", 21000d,1);
        jdbcTemplate.update("delete from account where id = ?", 1);
    }
    @Test
    public void find(){
        String name= jdbcTemplate.queryForObject("select name from account where id=?",String.class,2);
        System.out.println(name);

        Long count= jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        System.out.println(count);

        Account account= jdbcTemplate.queryForObject("select * from account where id = ?",new myRowMaper(), 2);
        System.out.println(account);

        List<Account> list= jdbcTemplate.query("select * from account",new myRowMaper());
        for (Account account1 : list) {
            System.out.println(account);
        }

    }

    class myRowMaper implements RowMapper<Account> {
        @Override
        public Account mapRow(ResultSet resultSet, int i) throws SQLException {
            Account account = new Account();
            account.setId(resultSet.getInt("id"));
            account.setName(resultSet.getString("name"));
            account.setMoney(resultSet.getDouble("money"));

            return account;
        }
    }

}
