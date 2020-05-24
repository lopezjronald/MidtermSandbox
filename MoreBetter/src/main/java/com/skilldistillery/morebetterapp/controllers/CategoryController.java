package com.skilldistillery.morebetterapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.morebetterapp.data.ArticleDAO;
import com.skilldistillery.morebetterapp.data.CategoryDAO;
import com.skilldistillery.morebetterapp.data.EventDAO;
import com.skilldistillery.morebetterapp.data.UserDAO;
import com.skilldistillery.morebetterapp.entities.Category;

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
	
	//------------------------------------------FIND BY ID CATEGORY-----------------------------------------------------//
	
	
	@RequestMapping(path = "getCategory.do", params = "id") // takes id inputed by user/looks up category
	public String findCategoryById(@RequestParam("id") Integer cId, Model model) {
		Category category = categoryDao.findCategoryById(cId);
			model.addAttribute("category", category);

			return "FIXME"; //JSP for category found by id
		}
	
	
	//------------------------------------------FIND BY ID CATEGORY-----------------------------------------------------//
	
	
	//------------------------------------------FIND BY NAME CATEGORY-----------------------------------------------------//
	
	
	@RequestMapping(path = "getCategory.do", params = "name") // takes id inputed by user/looks up category
	public String findCategoryByName(String name, Model model) {
		Category category = categoryDao.findCategoryByName(name);
			model.addAttribute("category", category);

			return "FIXME"; //JSP for category found by name
		} 
	
	
	
	//------------------------------------------FIND BY NAME CATEGORY-----------------------------------------------------//
	
	
	//--------------------------------------- DISPLAY EVENTS BY CATEGORY--------------------------------------------------//
	
	
	
	@RequestMapping(path = "getCategory.do", params = "id") // takes id inputed by user/looks up category
	public String findCategoryByName(@RequestParam("name") Integer cId, Model model) {
		
			model.addAttribute("eventsByCategory", categoryDao.displayAllEventsByCategory(cId));

			return "FIXME"; //JSP for list of events found
		
	}
	
	//--------------------------------------- DISPLAY EVENTS BY CATEGORY--------------------------------------------------//
	//--------------------------------------- DISPLAY ARTICLE BY CATEGORY--------------------------------------------------//
	
	
	
	@RequestMapping(path = "getCategory.do", params = "id") // takes id inputed by user/looks up category
	public String displayAllArticlesByCategory(@RequestParam("name") Integer cId, Model model) {
		
		model.addAttribute("articlesByCategory", categoryDao.displayAllArticlesByCategory(cId));
		
		return "FIXME"; //JSP for list of events found
		
	}
	
	//--------------------------------------- DISPLAY ARTICLE BY CATEGORY--------------------------------------------------//
	
}
