package com.skilldistillery.morebetterapp.data;

import com.skilldistillery.morebetterapp.entities.Event;

public interface EventDAO {
	public Event findById(int id);
	public Event findByTitle(String title);
	public Event createEvent(Event event);
	public boolean deleteEvent(String name);
	public Event updateEvent(int id, Event event);
}
