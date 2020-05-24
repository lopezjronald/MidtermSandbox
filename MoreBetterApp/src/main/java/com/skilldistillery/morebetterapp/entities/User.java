package com.skilldistillery.morebetterapp.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	
	@Enumerated(EnumType.STRING)
	private Role role;

	private Integer age;

	private String username;

	private String password;

	private int enabled;

	private String picture;

	private String biography;

	// mapping

	@ManyToMany(mappedBy = "users") // check on this
	private List<Category> categories;

	@OneToMany(mappedBy = "userAuthor")
	private List<Article> writtenArticles;

	@ManyToMany(mappedBy = "attendees")
	private List<Event> eventsAttended;

	@OneToMany(mappedBy = "eventMentor")
	private List<Event> eventsOwned;

	@ManyToMany(mappedBy = "userReaders")
	private List<Article> readArticles;

	// methods

	// begin add/remove ReadArticles

	public List<Article> getReadArticles() {
		return readArticles;
	}

	public void setReadArticles(List<Article> readArticles) {
		this.readArticles = readArticles;
	}

	public void addReadArticle(Article article) {
		if (readArticles == null) {
			readArticles = new ArrayList<>();
		}
		if (!readArticles.contains(article)) {
			readArticles.add(article);
			article.addUserReader(this);
		}

	}

	public void removeReadArticle(Article article) {

		if (readArticles == null && readArticles.contains(article)) {
			readArticles.remove(article);
			article.removeUserReader(this);
		}

	}

	// end add/remove ReadArticles

//begin add/remove eventsOwned
	public void addEventOwned(Event eventOwned) {
		if (eventsOwned == null)
			eventsOwned = new ArrayList<>();

		if (!eventsOwned.contains(eventOwned)) {
			eventsOwned.add(eventOwned);
			if (eventOwned.getEventMentor() != null) {
				eventOwned.getEventMentor().getEventsOwned().remove(eventOwned);
			}
			eventOwned.setEventMentor(this);
		}
	}

	public void removeEventOwned(Event eventOwned) {
		eventOwned.setEventMentor(null);
		if (eventsOwned != null) {
			eventsOwned.remove(eventOwned);
		}
	}

//end add/remove eventsOwned

	// begin add/remove EventsAttended ---------------------------
	public void addEventAttended(Event event) {
		if (eventsAttended == null) {
			eventsAttended = new ArrayList<>();
		}
		if (!eventsAttended.contains(event)) {
			eventsAttended.add(event);
			event.addAttendee(this);
		}

	}

	public void removeEventAttended(Event event) {

		if (eventsAttended == null && eventsAttended.contains(event)) {
			eventsAttended.remove(event);
			event.removeAttendee(this);
		}

	}

	public List<Event> getEventsAttended() {
		return eventsAttended;
	}

	public void setEventsAttended(List<Event> eventsAttended) {
		this.eventsAttended = eventsAttended;
	}
//end add/remove EventsAttended ---------------------------

//begin add remove eventsOwned-----------------------

	public List<Event> getEventsOwned() {
		return eventsOwned;
	}

	public void setEventsOwned(List<Event> eventsOwned) {
		this.eventsOwned = eventsOwned;
	}

//end events owned ----------------------------------

//begin add/remove category----------------------------------
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
// end add/remove category----------------------------------

// begin add/remove  Article	----------------------------------
	public void addArticle(Article article) {
		if (writtenArticles == null)
			writtenArticles = new ArrayList<>();

		if (!writtenArticles.contains(article)) {
			writtenArticles.add(article);
			if (article.getUserAuthor() != null) {
				article.getUserAuthor().getWrittenArticles().remove(article);
			}
			article.setUserAuthor(this);
		}
	}

	public void removeArticle(Article article) {
		article.setUserAuthor(null);
		if (writtenArticles != null) {
			writtenArticles.remove(article);
		}
	}

	public List<Article> getWrittenArticles() {
		return writtenArticles;
	}

	public void setWrittenArticles(List<Article> articles) {
		this.writtenArticles = articles;
	}
// end  add/remove  Article	----------------------------------

	public User() {
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
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

	public void setId(int id) {
		this.id = id;
	}

	public User(String firstName, String lastName, String email, Role role, Integer age, String username,
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

}
