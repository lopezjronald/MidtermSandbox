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
		return em.find(Event.class, id);
		
	}

//	@Override
//	public Event findEventByTitle(String title) {
//		Event event = null;
//		String jpql = "SELECT e FROM Event e WHERE e.title = :title";
//		return null;
//	}

	@Override
	public Event createEvent(Event event) {
		em.persist(event);
		em.flush();
		return event;
	}

	@Override
	public boolean deleteEventById(int id) { // only a mentor can delete an event
		Event eventToDelete = em.find(Event.class, id);
		em.remove(eventToDelete);
		boolean stillContains = !em.contains(eventToDelete);
		em.flush();
		return stillContains; // returns True if event was deleted successfully
	}

	@Override
	public Event updateEvent(int id, Event event) {
		Event updatedEvent = em.find(Event.class, id);
		updatedEvent.setCategory(event.getCategory());
		updatedEvent.setEventMentor(event.getEventMentor());
		updatedEvent.setLocation(event.getLocation());
		updatedEvent.setTitle(event.getTitle());
		updatedEvent.setDescription(event.getDescription());
		updatedEvent.setLocation(event.getLocation());
		updatedEvent.setEventDate(event.getEventDate());
		updatedEvent.setMaxCapacity(event.getMaxCapacity());
		updatedEvent.setPrice(event.getPrice());;
		updatedEvent.setCreated(event.getCreated());
		updatedEvent.setUpdated(event.getUpdated());
		em.flush();
		return updatedEvent;
	}

}
