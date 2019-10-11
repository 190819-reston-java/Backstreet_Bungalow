package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Posts")
public class Posts {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name="id" )
	private long Id;
	
	@OneToMany
	private String userId;
	private String content;
	private String title;
	
	public Posts() {
		Id = 0;
		userId = content = title = "";
	}

	public Posts(long id, String userId, String content, 
			String title) {
		Id = id;
		this.userId = userId;
		this.content = content;
		this.title = title;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Posts [Id=" + Id + ", userId=" + userId 
				+ ", content=" + content + ", title=" + title + "]";
	}
	
	
	
	
	
}