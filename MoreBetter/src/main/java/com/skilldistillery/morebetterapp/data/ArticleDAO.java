package com.skilldistillery.morebetterapp.data;

import com.skilldistillery.morebetterapp.entities.Article;
import com.skilldistillery.morebetterapp.entities.Category;

public interface ArticleDAO {
	public Article findArticleById(int id);
//	public Article findArticleByTitle(String title);
//	public Article findArticleByCategory(Category category);
	public Article createArticle(Article article);
	// this delete may have to take in the mentor/user id?:
	public boolean deleteArticleById(int id);
	public Article updateArticle(int id, Article article);
}
