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
import com.skilldistillery.morebetterapp.entities.Event;

@Controller
public class EventController {

	@Autowired
	private ArticleDAO articleDao;
	private CategoryDAO categoryDao;
	private EventDAO eventDao;
	private UserDAO userDao;
	
//	@RequestMapping(path= )
//	public String eventPage() {
//		return "";
//	}
	//------------------------------------------FIND EVENT-----------------------------------------------------//
	
	@RequestMapping(path = "getEvent.do", params = "id") // takes id inputed by user/looks up event
	public String findEvent(@RequestParam("id") Integer eId, Model model) {
		Event event = eventDao.findEventById(eId);
			model.addAttribute("event", event);

			return "FIXME"; //JSP for Event found
	}
	
	//------------------------------------------FIND EVENT-----------------------------------------------------//
	
	
	
	
	//------------------------------------------ADD EVENT-----------------------------------------------------//
	
	@RequestMapping(path = "addEvent.do", method = RequestMethod.GET)
	public ModelAndView goToAddEventPage() throws SQLException { // addEvent view page for mentor to input data
		ModelAndView mv = new ModelAndView(); 
		mv.setViewName("FIXME");     //JSP for adding an event view

		return mv;

	}

	@RequestMapping(path = "addEvent.do", method = RequestMethod.POST)
	public ModelAndView addEvent(Event event) { // takes user input/process it/posts new trip
		ModelAndView mv = new ModelAndView();

		Event newEvent = eventDao.createEvent(event);

			mv.addObject("event", newEvent);
			mv.setViewName("FIXME");    // jsp for mentor to add event
			return mv;
		}

	
	//------------------------------------------ADD EVENT-----------------------------------------------------//
	
	
	//------------------------------------------UPDATE EVENT-----------------------------------------------------//
	
	
	@RequestMapping(path = "updateEvent.do", params = "id", method = RequestMethod.POST)
	public ModelAndView updateEvent(int id, Event event) throws SQLException {
																									
		ModelAndView mv = new ModelAndView();
			mv.addObject("event", eventDao.updateEvent(id, event));
			mv.setViewName("FIXME");   //
			return mv;
	}
	
	
	//------------------------------------------UPDATE EVENT-----------------------------------------------------//
	
	
	//------------------------------------------DELETE EVENT-----------------------------------------------------//
	
	@RequestMapping(path = "deleteEvent.do", method = RequestMethod.GET)
	public ModelAndView deleteEventViewPage() throws SQLException { // delete event view page for mentor
		ModelAndView mv = new ModelAndView();
		mv.setViewName("FIXME");     //JSP view for mentor to delete event

		return mv;

	}
	
	@RequestMapping(path = "deleteEvent.do", params = "id", method = RequestMethod.POST)
	public ModelAndView deleteEvent(int id) throws SQLException { 

		ModelAndView mv = new ModelAndView();
		eventDao.deleteEventById(id);

		mv.setViewName("FIXME"); //JSP page to submit event delete
		return mv;

	}
	
	//------------------------------------------DELETE EVENT-----------------------------------------------------//
}
