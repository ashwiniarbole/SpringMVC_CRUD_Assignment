package com.scp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scp.dao.UserDao;
import com.scp.dao.impl.UserDaoImpl;
import com.scp.model.UserEntity;
import com.scp.service.UserService;
import com.scp.bean.UserBean;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	public boolean addUser(UserBean user) {
		return userDao.addUser(processBeanToEntity(user));
	}

	public boolean deleteUser(int id) {
		return userDao.deleteUser(id);
	}

	public UserBean updateUser(UserBean user) {
		System.out.println("-----------------------------In Service---------------------");
		return processEntityToBean(userDao.updateUser(processBeanToEntity(user)));
	}

	public UserBean getUser(int uid) {
		UserEntity entity = userDao.getUser(uid);
		System.out.println(entity.getFname()+"----------------------------------");
		return processEntityToBean(entity);
	}

	public List<UserBean> getUsers() {
		return processEntitiesToBeans(userDao.getUsers());
	}
	
	private UserEntity processBeanToEntity(UserBean bean){
		UserEntity userEntity = new UserEntity();
		userEntity.setFname(bean.getFname());
		userEntity.setLname(bean.getLname());
		userEntity.setuAddress(bean.getuAddress());
		userEntity.setUserPhone(bean.getUserPhone());
		userEntity.setUserId(bean.getUserId());
		return userEntity;
		
	}
	private List<UserBean> processEntitiesToBeans(List<UserEntity> entities){
		List<UserBean> beans = new ArrayList<UserBean>();
		for (UserEntity entity : entities) {
			beans.add(processEntityToBean(entity));
		}
		return beans;
		
	}

	private UserBean processEntityToBean(UserEntity entity){
		UserBean userbean = new UserBean();
		userbean.setUserId(entity.getUserId());
		userbean.setFname(entity.getFname());
		userbean.setLname(entity.getLname());
		userbean.setuAddress(entity.getuAddress());
		userbean.setUserPhone(entity.getUserPhone());
		return userbean;
		
	}
}
