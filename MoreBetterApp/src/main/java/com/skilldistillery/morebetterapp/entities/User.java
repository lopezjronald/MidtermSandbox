package com.skilldistillery.morebetterapp.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	private String email;

	private String role;

	private Integer age;

	private String username;

	private String password;

	private int enabled;

	private String picture;

	private String biography;

	// mapping

	@ManyToMany(mappedBy = "users")
	private List<Category> categories;

	@OneToMany(mappedBy = "user")
	private List<Article> articles;

	@ManyToMany(mappedBy = "users")
	private List<Event> events;

	// methods

	public void addEvent(Event event) {
		if (events == null) {
			events = new ArrayList<>();
		}
		if (!events.contains(event)) {
			events.add(event);
			event.addUser(this);
		}

	}

	public void removeEvent(Event event) {

		if (events == null && events.contains(event)) {
			events.remove(event);
			event.removeUser(this);
		}

	}

	public void addCategory(Category category) {
		if (categories == null) {
			categories = new ArrayList<>();
		}
		if (!categories.contains(category)) {
			categories.add(category);
			category.addUser(this);
		}

	}

	public void removeCategory(Category category) {

		if (categories == null && categories.contains(category)) {
			categories.remove(category);
			category.removeUser(this);
		}

	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public void addArticle(Article article) {
		if (articles == null)
			articles = new ArrayList<>();

		if (!articles.contains(article)) {
			articles.add(article);
			if (article.getUser() != null) {
				article.getUser().getArticles().remove(article);
			}
			article.setUser(this);
		}
	}

	public void removeArticle(Article article) {
		article.setUser(null);
		if (articles != null) {
			articles.remove(article);
		}
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
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public User() {
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User(String firstName, String lastName, String email, String role, Integer age, String username,
			String password, Integer enabled, String picture, String biography) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
		this.age = age;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.picture = picture;
		this.biography = biography;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public int getId() {
		return id;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=").append(id).append(", firstName=").append(firstName).append(", lastName=")
				.append(lastName).append(", email=").append(email).append(", role=").append(role).append(", age=")
				.append(age).append(", username=").append(username).append(", password=").append(password)
				.append(", enabled=").append(enabled).append(", picture=").append(picture).append(", biography=")
				.append(biography).append("]");
		return builder.toString();
	}

}
