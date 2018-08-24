package cn.llanc.demo1;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class SpringJDBCTest {
    @Test
    public void test1(){
        //创建链接池
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql:///springlearn");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("root");

        //创建JDBC模板
        JdbcTemplate jdbcTemplate = new JdbcTemplate(driverManagerDataSource);

        //保存数据
        jdbcTemplate.update("insert into account values (null ,?,?)","llanc",24000d);


    }
}
