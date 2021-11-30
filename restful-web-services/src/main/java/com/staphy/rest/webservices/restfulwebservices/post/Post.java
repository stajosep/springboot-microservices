package com.staphy.rest.webservices.restfulwebservices.post;

import java.util.Date;

import com.staphy.rest.webservices.restfulwebservices.user.User;

public class Post {

	private int id;
	private String content;
	private Date postedDate;
	
	public Post() {
		super();
	}

	public Post(int id, String content, Date postedDate) {
		super();
		this.id = id;
		this.content = content;
		this.postedDate = postedDate;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

}
