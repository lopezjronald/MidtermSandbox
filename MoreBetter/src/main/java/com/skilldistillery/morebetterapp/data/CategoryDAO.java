package com.skilldistillery.morebetterapp.data;

import java.util.List;

import com.skilldistillery.morebetterapp.entities.Article;
import com.skilldistillery.morebetterapp.entities.Category;
import com.skilldistillery.morebetterapp.entities.Event;

public interface CategoryDAO {
	public Category findCategoryById(int id);
	public Category findCategoryByName(String name);
	public List<Event> findAllEventsByCategory();
	public List<Article> findAllArticlesByCategory();
}
