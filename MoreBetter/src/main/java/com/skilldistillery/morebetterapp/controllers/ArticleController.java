package com.skilldistillery.morebetterapp.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.morebetterapp.data.ArticleDAO;
import com.skilldistillery.morebetterapp.data.CategoryDAO;
import com.skilldistillery.morebetterapp.data.EventDAO;
import com.skilldistillery.morebetterapp.data.UserDAO;
import com.skilldistillery.morebetterapp.entities.Article;
import com.skilldistillery.morebetterapp.entities.Event;

@Controller
public class ArticleController {
	
	@Autowired
	private ArticleDAO articleDao;
	private CategoryDAO categoryDao;
	private EventDAO eventDao;
	private UserDAO userDao;
	
//	@RequestMapping(path= )
//	public String articlePage() {
//		return "";
//	}

	//------------------------------------------FIND ARTICLE-----------------------------------------------------//
	
	@RequestMapping(path = "getArticle.do", params = "id") // takes id inputed by user/looks up event
	public String findArticle(@RequestParam("id") Integer aId, Model model) {
		Article article = articleDao.findArticleById(aId);
			model.addAttribute("article", article);
			return "FIXME"; //JSP for Article found

	}
	
	//------------------------------------------FIND ARTICLE-----------------------------------------------------//
	
	
	//------------------------------------------ADD ARTICLE-----------------------------------------------------//
	@RequestMapping(path = "addArticle.do", method = RequestMethod.GET)
	public ModelAndView goToAddArticlePage() throws SQLException { // addArticle view page for mentor to input data
		ModelAndView mv = new ModelAndView();
		mv.setViewName("FIXME");                    //JSP for article view

		return mv;

	}
	
	//mentor can add article
	@RequestMapping(path = "addArticle.do", method = RequestMethod.POST)
	public ModelAndView addArticle(Article article) { // takes mentor input/process it/posts new article
		ModelAndView mv = new ModelAndView();

		Article newArticle = articleDao.createArticle(article);
			mv.addObject("article", newArticle);
			mv.setViewName("FIXME");     //jsp name for articles
			return mv;
		}

	//------------------------------------------UPDATE ARTICLE-----------------------------------------------------//
	
	
	//------------------------------------------UPDATE ARTICLE-----------------------------------------------------//
	
	
	@RequestMapping(path = "updateArticle.do", method = RequestMethod.POST)
	public ModelAndView updateTrip(int id, Article article) throws SQLException {  //requestParam deleted, might have to put it back
		ModelAndView mv = new ModelAndView();
			mv.addObject("article", articleDao.updateArticle(id, article));
			mv.setViewName("FIXME");    //JSP for updating article
			return mv;
	}
	
	//------------------------------------------UPDATE ARTICLE-----------------------------------------------------//
	
	//------------------------------------------DELETE ARTICLE-----------------------------------------------------//
	
	@RequestMapping(path = "deleteArticle.do", method = RequestMethod.GET)
	public ModelAndView deleteArticleViewPage() throws SQLException { // delete article view page for mentor
		ModelAndView mv = new ModelAndView();
		mv.setViewName("FIXME");     //JSP view for mentor to delete articles

		return mv;

	}
	
	@RequestMapping(path = "deleteArticle.do", method = RequestMethod.POST)
	public ModelAndView deleteTrip(int id) throws SQLException { 

		ModelAndView mv = new ModelAndView();
		articleDao.deleteArticleById(id);

		mv.setViewName("FIXME");  //JSP to submit article deletion
		return mv;

	}
	
	//------------------------------------------DELETE ARTICLE-----------------------------------------------------//
	
}
