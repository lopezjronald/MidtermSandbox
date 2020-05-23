package com.skilldistillery.morebetterapp.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String title;
	private String description;
	private String location;

	@Column(name = "event_date")
	private String eventDate;

	@Column(name = "max_capacity")
	private Integer maxCapacity;

	private Double price;

	@Column(name = "created_at")
	@CreationTimestamp
	private LocalDateTime created;

	@Column(name = "last_updated")
	@UpdateTimestamp
	private LocalDateTime updated;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	@JoinTable(name = "event_participant", joinColumns = @JoinColumn(name = "event_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> attendees;

	@ManyToOne
	@JoinColumn(name = "mentor_id")
	private User eventMentor;

	// constructors
	public Event() {
		super();
	}

	// methods

	public void addAttendee(User attendee) {
		if (attendees == null) {
			attendees = new ArrayList<>();
		}
		if (!attendees.contains(attendee)) {
			attendees.add(attendee);
			attendee.addEventAttended(this);
		}
	}

	public void removeAttendee(User attendee) {

		if (attendees != null && attendees.contains(attendee)) {
			attendees.remove(attendee);
			attendee.removeEventAttended(this);
		}

	}

	public List<User> getAttendees() {
		return attendees;
	}

	public void setAttendees(List<User> attendees) {
		this.attendees = attendees;
	}

	public User getEventMentor() {
		return eventMentor;
	}

	public void setEventMentor(User eventMentor) {
		this.eventMentor = eventMentor;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", description=" + description + ", location=" + location
				+ ", eventDate=" + eventDate + ", maxCapacity=" + maxCapacity + ", price=" + price + ", created="
				+ created + ", updated=" + updated + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public Integer getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(Integer maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
