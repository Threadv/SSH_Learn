package cn.llanc.test;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;

import cn.llanc.bean.Customer;
import cn.llanc.bean.CustomerBoth;
import cn.llanc.bean.Order;
import cn.llanc.bean.OrderBoth;
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
	public void testUpdate() {
		CustomerBoth customerBoth=session.get(CustomerBoth.class, 1);
		customerBoth.getOrders().iterator().next().setOrderName("YYY");
	}
	
	@org.junit.Test
	public void testOneToManyBothGet() {
		CustomerBoth customerBoth=session.get(CustomerBoth.class, 1);
		System.out.println(customerBoth.getCustomerName());
		System.out.println(customerBoth.getOrders().size());
	}
	
	@org.junit.Test
	public void testOneToManyBoth() {
		CustomerBoth customer=new CustomerBoth();
		customer.setCustomerName("BB");
		
		OrderBoth order1=new OrderBoth();
		order1.setOrderName("Order-3");
		OrderBoth order2=new OrderBoth();
		order2.setOrderName("Order-4");
		
		order1.setCustomer(customer);
		order2.setCustomer(customer);
		
		customer.getOrders().add(order1);
		customer.getOrders().add(order2);
		
		session.save(customer);
		session.save(order1);
		session.save(order2);
	}
	
	@org.junit.Test
	public void testManyToOneSave() {
		Customer customer=new Customer();
		customer.setCustomerName("AA");
		
		Order order1=new Order();
		order1.setOrderName("Order-1");
		Order order2=new Order();
		order2.setOrderName("Order-2");
		
		order1.setCustomer(customer);
		order2.setCustomer(customer);
		
		session.save(customer);
		session.save(order1);
		session.save(order2);
	}
	@org.junit.Test
	public void testManyToOneGet() {
		Order order=session.get(Order.class, 1);
		System.out.println(order.getOrderName());
		
		Customer customer =order.getCustomer();
		System.err.println(customer.getCustomerName());
	}

}
