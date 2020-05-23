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
		return em.find(Category.class, id);
	}

	@Override
	public Category findCategoryByName(String name) {
		Category category = null;
		String jpql = "SELECT c FROM Category c WHERE c.name = :name";
		category = em.createQuery(jpql, Category.class).setParameter("name", name).getSingleResult();
		return category;
	}

	@Override
	public List<Event> displayAllEventsByCategory(int id) {
		List<Event> events = null;
		String jpql = "SELECT e FROM Event e WHERE e.category = :id";
		events = em.createQuery(jpql, Event.class).setParameter("id", id).getResultList();
		return events;
	}

	@Override
	public List<Article> displayAllArticlesByCategory(int id) {
		List<Article> articles = null;
		String jpql = "SELECT a FROM Article a WHERE a.category = :id";
		articles = em.createQuery(jpql, Article.class).setParameter("id", id).getResultList();
		return articles;
	}
}
