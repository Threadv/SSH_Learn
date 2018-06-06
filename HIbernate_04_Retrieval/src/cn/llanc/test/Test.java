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
	
	@org.junit.Test
	public void hqlPageTest() {
		String hql="from Employee";
		int pageNo=2;//第2页
		int pageSize=3;//每页3条记录
		Query query=session.createQuery(hql)
				.setFirstResult((pageNo-1)*pageSize)//开始的索引
				.setMaxResults(pageSize);//每页数量
		List<Employee> emps=query.list();
		System.out.println(emps);
	}
	@org.junit.Test
	public void hqlNamedQueryTest() {
		Query query=session.getNamedQuery("selectEmpBySalary")
				.setFloat("sal", 2600);
		List<Employee> emps=query.list();
		System.out.println(emps);
		
	}
	//投影查询
	@org.junit.Test
	public void fieldQueryTest() {
		String hql="select e.name,e.email,e.dept from Employee e where e.dept=:dept";
		Department dept=new Department();
		dept.setId(1);
		Query query=session.createQuery(hql)
				.setEntity("dept", dept);
		List<Object[]> emps=query.list();
		for(Object[] objs:emps) {
			System.out.println(Arrays.asList(objs));//Arrays类包含用来操作数组（比如排序和搜索）的各种方法
		}
	}
	//投影查询，用对象的方式，注意构造方法的参数对应
	@org.junit.Test
	public void fieldObjectQueryTest() {
		String hql="select new Employee(e.name,e.email,e.dept) from Employee e where e.dept=:dept";
		Department dept=new Department();
		dept.setId(1);
		Query query=session.createQuery(hql)
				.setEntity("dept", dept);
		List<Employee> emps=query.list();
		for(Employee emp:emps) {
			System.out.println(emp.getId()+emp.getName()+emp.getEmail()+emp.getDept());//Arrays类包含用来操作数组（比如排序和搜索）的各种方法
		}
	}
	//报表查询
	@org.junit.Test
	public void groupByTest() {
		String hql="select max(e.salary),min(e.salary) from Employee e group by e.dept having min(salary)>:minsal";
		Query query=session.createQuery(hql)
						   .setFloat("minsal", 2400);
		List<Object[]> sal=query.list();
		for(Object[] objs:sal) {
			System.out.println(Arrays.asList(objs));
		}
	}
	
	//迫切左外连接查询
	@org.junit.Test
	public void leftJoinFetchTest() {
		String hql ="select distinct d from Department d left join fetch d.emps";
		Query query=session.createQuery(hql);
		List<Department> depts=query.list();
		System.out.println(depts.size());
		for(Department dept:depts) {
			System.out.println(dept.getName()+","+dept.getEmps().size());
		}
	}
	//左外连接查询
	@org.junit.Test
	public void leftJoinTest() {
		String hql ="select distinct d from Department d left join d.emps";
		Query query=session.createQuery(hql);
		List<Department> depts=query.list();
		System.out.println(depts.size());
		for(Department dept:depts) {
			System.out.println(dept.getName()+","+dept.getEmps().size());
		}
	}
	//Sql
	@org.junit.Test
	public void nativeSqlTest() {
		String sql= "select * from EMPLOYEE where DEPT_ID=?";
		Query query=session.createSQLQuery(sql).setInteger(0, 1);
		List<Employee> emps=query.list();
		System.out.println(emps.size());
	}
}
