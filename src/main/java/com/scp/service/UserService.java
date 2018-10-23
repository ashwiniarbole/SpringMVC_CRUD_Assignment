package com.scp.service;

import java.util.List;

import com.scp.bean.UserBean;
import com.scp.model.UserEntity;

public interface UserService {

	public boolean addUser(UserBean user);

	public boolean deleteUser(int id);

	public UserBean updateUser(UserBean user);

	public UserBean getUser(int uid);

	public List<UserBean> getUsers();

}
