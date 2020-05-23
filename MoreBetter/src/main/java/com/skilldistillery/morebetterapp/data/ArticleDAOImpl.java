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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Article findArticleByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Article createArticle(Article article) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteArticleById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Article updateArticle(int id, Article article) {
		// TODO Auto-generated method stub
		return null;
	}

}
