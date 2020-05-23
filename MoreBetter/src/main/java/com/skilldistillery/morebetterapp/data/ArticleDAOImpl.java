package com.skilldistillery.morebetterapp.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.morebetterapp.entities.Article;

@Service
@Transactional
public class ArticleDAOImpl implements ArticleDAO {
	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public Article findArticleById(int id) {
		return em.find(Article.class, id);
	}

//	@Override
//	public Article findArticleByTitle(String title) {
//		return null;
//	}

	@Override
	public Article createArticle(Article article) {
		em.persist(article);
		em.flush();
		return article;
	}

	@Override
	public boolean deleteArticleById(int id) {
		Article article = null;
		String jpql = "SELECT a FROM Article a WHERE a.id = :id";
		article = em.createQuery(jpql, Article.class).setParameter("id", id).getSingleResult();
		em.remove(article);
		boolean stillContains = !em.contains(article);
		em.flush();
		return stillContains; // returns TRUE if deleted successfully
	}

	@Override
	public Article updateArticle(int id, Article article) {
		Article updatedArticle = em.find(Article.class, id);
		updatedArticle.setCategory(article.getCategory());
		updatedArticle.setUserAuthor(article.getUserAuthor());
		updatedArticle.setTitle(article.getTitle());
		updatedArticle.setContents(article.getContents());
		updatedArticle.setCreated(article.getCreated());
		em.flush();
		return updatedArticle;
	}

}
