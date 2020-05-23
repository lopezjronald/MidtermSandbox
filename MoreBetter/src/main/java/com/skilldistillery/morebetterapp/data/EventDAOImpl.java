package com.skilldistillery.morebetterapp.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.morebetterapp.entities.Event;

@Service
@Transactional
public class EventDAOImpl implements EventDAO {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Event findEventById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event findEventByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event createEvent(Event event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteEventById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Event updateEvent(int id, Event event) {
		// TODO Auto-generated method stub
		return null;
	}

}
