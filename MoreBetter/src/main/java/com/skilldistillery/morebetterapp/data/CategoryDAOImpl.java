package com.skilldistillery.morebetterapp.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.morebetterapp.entities.Article;
import com.skilldistillery.morebetterapp.entities.Category;
import com.skilldistillery.morebetterapp.entities.Event;

@Service
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Category findCategoryById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category findCategoryByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> findAllEventsByCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> findAllArticlesByCategory() {
		// TODO Auto-generated method stub
		return null;
	}
}
