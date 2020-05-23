package com.skilldistillery.morebetterapp.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String logo;

	private String description;

	// mapping


	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	@JoinTable(name = "mentor_category", 
	joinColumns = @JoinColumn(name = "category_id"), 
	inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users;

	@OneToMany(mappedBy = "category")
	private List<Event> events;

	@OneToMany(mappedBy = "category")
	private List<Article> articles;

	// methods
	
	
	
	 public void addUser(User user) {
		   if(users == null) {
			   users = new ArrayList<>();
		   }
		   if(! users.contains(user)) {
			   users.add(user);
			   user.addCategory(this);
		   }
	   }
	
	 public void removeUser(User user) {
			
		 if (users != null && users.contains(user)) {
				users.remove(user);
				user.removeCategory(this);
			}
			
		}
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	

	public List<Event> getEvents() { // events
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public void addEvent(Event event) {
		if (events == null) {
			events = new ArrayList<>();
		}
		if (!events.contains(event)) {
			events.add(event);
			if (event.getCategory() != null) {
				event.getCategory().getEvents().remove(event);
			}
			event.setCategory(this);
		}
	}

	public void removeEvent(Event event) {
		event.setCategory(null);
		if (events != null) {
			events.remove(event);// events closing
		}
	}

	public void addArticle(Article article) { // article
		if (articles == null) {
			articles = new ArrayList<>();
		}
		if (!articles.contains(article)) {
			articles.add(article);
			if (article.getCategory() != null) {
				article.getCategory().getArticles().remove(article);
			}
			article.setCategory(this);
		}
	}

	public void removeArticle(Article article) {
		article.setCategory(null);
		if (articles != null) {
			articles.remove(article);
		}
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles; // article closing
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category(int id, String name, String logo, String description) {
		super();
		this.id = id;
		this.name = name;
		this.logo = logo;
		this.description = description;
	}

	public Category() {
		super();
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", logo=" + logo + ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (id != other.id)
			return false;
		return true;
	}



	

}
