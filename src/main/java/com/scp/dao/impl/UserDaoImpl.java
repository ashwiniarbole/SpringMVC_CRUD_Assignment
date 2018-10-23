package com.scp.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.scp.model.UserEntity;

import com.scp.app.util.SessionFactoryUtil;
import com.scp.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	SessionFactory sfacotry;

	
	public boolean addUser(UserEntity user) {
		/*SessionFactory sfactory = SessionFactoryUtil.getSFactory();
		Session session = sfactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(user);
		SessionFactoryUtil.clearDAOResources(session, tr);
		return true;*/
		
		//SessionFactory sfacotry = util.getSessionFactory();
		Session session = sfacotry.openSession();
		Transaction tr = session.beginTransaction();
		session.save(user);
		SessionFactoryUtil.clearDAOResources(session,tr);
		return false;
	}

	public boolean deleteUser(int id) {
	
		Session session = sfacotry.openSession();
		UserEntity u = (UserEntity) session.load(UserEntity.class, new Integer(id));
		System.out.println("-----------------------------"+u.getFname()+"-----------------------------");
		if(null != u){
			Transaction tr = session.beginTransaction();
			session.delete(u);
			session.flush();
			tr.commit();
			return true;
		}
		return false;
	}

	public UserEntity updateUser(UserEntity user) {
		Session session = sfacotry.openSession();
		Transaction tr = session.beginTransaction();
		UserEntity updatedEntity  = (UserEntity) session.merge(user);
		SessionFactoryUtil.clearDAOResources(session, tr);
		return updatedEntity;
	}

	public UserEntity getUser(int uid) {
		Session session = sfacotry.openSession();
		UserEntity dbEntity = (UserEntity) session.get(UserEntity.class,uid);
		SessionFactoryUtil.clearDAOResources(session,null);
		return dbEntity;
		
	}

	public List<UserEntity> getUsers() {
		Session session = sfacotry.openSession();		
		List<UserEntity> entities = session.createCriteria(UserEntity.class).list();
		return entities;
		
	}
	
	

}

