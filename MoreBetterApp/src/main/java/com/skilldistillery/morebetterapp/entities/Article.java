package com.skilldistillery.morebetterapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@JoinColumn(name = "category_id")
	private int categoryId;

	@JoinColumn(name = "mentor_id")
	private int mentorId;

	private String title;
	private String contents;
	private String created;

	// methods
	public Article() {
		super();
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

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", categoryId=" + categoryId + ", mentorId=" + mentorId + ", title=" + title
				+ ", contents=" + contents + ", created=" + created + "]";
	}

}
