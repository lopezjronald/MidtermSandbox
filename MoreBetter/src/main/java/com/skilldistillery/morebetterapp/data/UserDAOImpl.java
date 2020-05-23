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
		return em.find(User.class, id);
	}

	@Override
	public User createUser(User user) {
		em.persist(user);
		em.flush();
		return user;
	}

	@Override
	public boolean deleteUserById(int id) {
		User userToDelete = em.find(User.class, id);
		em.remove(userToDelete);
		boolean stillContains = !em.contains(userToDelete);
		em.flush();
		return stillContains; // should return TRUE if deleted successfully.
	}

	@Override
	public User updateUser(int id, User user) {
		User updatedUser = em.find(User.class, id);
		updatedUser.setFirstName(user.getFirstName());
		updatedUser.setLastName(user.getLastName());
		updatedUser.setEmail(user.getEmail());
		updatedUser.setRole(user.getRole());
		updatedUser.setAge(user.getAge());
		updatedUser.setUsername(user.getUsername());
		updatedUser.setPassword(user.getPassword());
		updatedUser.setEnabled(user.getEnabled());
		updatedUser.setPicture(user.getPicture());
		updatedUser.setBiography(user.getBiography());
		em.flush();
		return updatedUser;
	}

}
