package com.skilldistillery.morebetterapp.data;

import com.skilldistillery.morebetterapp.entities.User;

public interface UserDAO {
	public User findUserById(int id);
	public User createUser(User user);
	public boolean deleteUser(String name);
	public User updateUser(int id, User user);
}
