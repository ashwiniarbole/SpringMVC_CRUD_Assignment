package com.scp.app.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class SessionFactoryUtil {
	SessionFactory sessionFactory = null;
	static SessionFactoryUtil util =null;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	public static SessionFactory getSFactory(){
		if(null==util) 
			util = new SessionFactoryUtil();
		return util.sessionFactory;
	}
	
	
	public static void clearDAOResources(Session session, Transaction tr){
		if(null!=tr){
			tr.commit();
		}
		if(null!=session){
			session.flush();
			session.close();
		}
	}	
}
