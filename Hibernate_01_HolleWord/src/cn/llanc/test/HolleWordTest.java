package cn.llanc.test;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.Test;

import cn.llanc.bean.Student;
import cn.llanc.utils.HbnUtils;

public class HolleWordTest {

	@Test
	public void test() {
		//����Session
		Session session= HbnUtils.getSession();
		try {
			//��������
			session.beginTransaction();
			//ִ�в���
			Student student=new Student("С��",23,"��");
			session.save(student);
			//�ύ����
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			//�ع�����
			session.getTransaction().rollback();
		}
		
		
	}

}
