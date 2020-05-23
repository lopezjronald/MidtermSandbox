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
	private LocalDateTime created;

	@Column(name = "last_updated")
	private LocalDateTime updated;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinTable(name = "event_participant",
	joinColumns = @JoinColumn(name = "event_id"),
	inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List <User> users;
	
	
	// constructors
	public Event() {
		super();
	}

	// methods

	
	 public void addUser(User user) {
         if(users == null) {
             users = new ArrayList<>();
         }
         if(! users.contains(user)) {
             users.add(user);
             user.addEvent(this);
         }
     }
  
   public void removeUser(User user) {
          
       if (users != null && users.contains(user)) {
              users.remove(user);
              user.removeEvent(this);
          }
          
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
