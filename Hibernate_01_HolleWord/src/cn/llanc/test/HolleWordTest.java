package cn.llanc.test;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.Test;

import cn.llanc.bean.Student;
import cn.llanc.utils.HbnUtils;

public class HolleWordTest {

	@Test
	public void test() {
		//创建Session
		Session session= HbnUtils.getSession();
		try {
			//开始事务
			session.beginTransaction();
			//ִ执行操作
			Student student=new Student("小明",23,"男");
			session.save(student);
			//提交事务
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			//异常回滚
			session.getTransaction().rollback();
		}
		
		
	}

}
