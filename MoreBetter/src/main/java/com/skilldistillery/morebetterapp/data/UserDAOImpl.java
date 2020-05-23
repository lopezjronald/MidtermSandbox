package com.skilldistillery.morebetterapp.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.morebetterapp.entities.User;

@Service
@Transactional
public class UserDAOImpl implements UserDAO {
	@PersistenceContext
	private EntityManager em;

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteUserById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User updateUser(int id, User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
