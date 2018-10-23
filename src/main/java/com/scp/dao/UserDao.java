package com.scp.dao;

import java.util.List;

import com.scp.model.UserEntity;

public interface UserDao {
	public boolean addUser(UserEntity user);
	public boolean deleteUser(int id);
	public UserEntity updateUser(UserEntity user);
	public UserEntity getUser(int uid);
	public List<UserEntity> getUsers();
}
