package com.skilldistillery.morebetterapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.skilldistillery.morebetterapp.data.ArticleDAO;
import com.skilldistillery.morebetterapp.data.CategoryDAO;
import com.skilldistillery.morebetterapp.data.EventDAO;
import com.skilldistillery.morebetterapp.data.UserDAO;

@Controller
public class CategoryController {

	@Autowired
	private ArticleDAO articleDao;
	private CategoryDAO categoryDao;
	private EventDAO eventDao;
	private UserDAO userDao;
	
//	@RequestMapping(path= )
//	public String categoryPage() {
//		return "";
//	}
}
