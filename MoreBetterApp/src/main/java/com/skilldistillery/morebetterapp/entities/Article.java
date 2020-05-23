package com.skilldistillery.morebetterapp.entities;

import java.time.LocalDateTime;
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
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String title;
	private String contents;

	@CreationTimestamp
	private LocalDateTime created;

	// mapping

	//
	@ManyToOne
	@JoinColumn(name = "mentor_id")
	private User userAuthor;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	@JoinTable(name = "article_comment", joinColumns = @JoinColumn(name = "article_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> userReaders;

	// methods

	public Article() {
		super();
	}

	// begin mapping articles to userreaders

	public void addUserReader(User user) {
		if (userReaders == null) {
			userReaders = new ArrayList<>();
		}
		if (!userReaders.contains(user)) {
			userReaders.add(user);
			user.addReadArticle(this);
		}
	}

	public void removeUserReader(User user) {

		if (userReaders != null && userReaders.contains(user)) {
			userReaders.remove(user);
			user.removeReadArticle(this);
		}

	}

	public List<User> getUserReaders() {
		return userReaders;
	}

	public void setUserReaders(List<User> userReaders) {
		this.userReaders = userReaders;

	}

	// end mapping article to userreaders

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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
		Article other = (Article) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public User getUserAuthor() {
		return userAuthor;
	}

	public void setUserAuthor(User user) {
		this.userAuthor = user;
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

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", contents=" + contents + ", created=" + created + "]";
	}

}
