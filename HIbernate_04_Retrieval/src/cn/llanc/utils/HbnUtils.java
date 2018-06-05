package cn.llanc.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HbnUtils {
	private static SessionFactory sessionFactory;
	/*
	 * 获取Session
	 */
	public static Session getSession(){
		return getSessionFactory().getCurrentSession();	
	}
	/*
	 * 	获取SessionFactory
	 */
	public static SessionFactory getSessionFactory(){
		if (sessionFactory == null || sessionFactory.isClosed()){
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		return sessionFactory;
	}
}
