package cn.llanc.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HbnUtils {
	private static SessionFactory sessionFactory;
	/*
	 * ��ȡSession
	 */
	public static Session getSession(){
		return getSessionFactory().getCurrentSession();	
	}
	/*
	 * 	��ȡSessionFactory
	 */
	public static SessionFactory getSessionFactory(){
		if (sessionFactory == null || sessionFactory.isClosed()){
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		return sessionFactory;
	}
}
