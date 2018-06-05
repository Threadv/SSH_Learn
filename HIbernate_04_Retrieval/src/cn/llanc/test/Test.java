package cn.llanc.test;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;

import cn.llanc.bean.*;
import cn.llanc.utils.HbnUtils;

public class Test {
	
	Session session;
	Transaction transaction;
	@Before
	public void init() {
		session=HbnUtils.getSession();//获取Session
		transaction=session.beginTransaction();//开启事务
	}
	
	@After
	public void destroy() {
		transaction.commit();//提交事务	
		HbnUtils.getSession().close();//关闭Session
		HbnUtils.getSessionFactory().close();//关闭SessionFactory
	}
	
	@org.junit.Test
	public void hqlTest() {
		String hql="from Employee e where e.salary>? and e.email like ? and e.dept=?";
		Department dept=new Department();
		dept.setId(2);
		Query query =session.createQuery(hql)
					.setFloat(0, 2500)
				    .setString(1, "%@llanc.cn")
				    .setEntity(2, dept);
		List<Employee> emps=query.list();
		System.out.println(emps.size());
	}
	
	@org.junit.Test
	public void hqlNameParameterTest() {
		//别名
		String hql="from Employee e where e.salary> :sal and e.email like :email order by e.salary";
		Query query =session.createQuery(hql).setFloat("sal", 2500).setString("email", "%@llanc.cn");
		List<Employee> emps=query.list();
		System.out.println(emps.size());
	}
	
	

}
