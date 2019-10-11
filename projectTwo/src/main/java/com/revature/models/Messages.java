package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Messages")
@Component
public class Messages {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="users_id")
	private String userAdmin;
	
	@Column(name="end_users_id")
	private String userUser;
	
	@Column(name="content")
	private String content;
	
	@Column(name="draft")
	private boolean draft;

	public Messages() {
		super();
	}

	public Messages(long id, String userAdmin, String userUser, String content, boolean draft) {
		super();
		this.id = id;
		this.userAdmin = userAdmin;
		this.userUser = userUser;
		this.content = content;
		this.draft = draft;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserAdmin() {
		return userAdmin;
	}

	public void setUserAdmin(String userAdmin) {
		this.userAdmin = userAdmin;
	}

	public String getUserUser() {
		return userUser;
	}

	public void setUserUser(String userUser) {
		this.userUser = userUser;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isDraft() {
		return draft;
	}

	public void setDraft(boolean draft) {
		this.draft = draft;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + (draft ? 1231 : 1237);
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((userAdmin == null) ? 0 : userAdmin.hashCode());
		result = prime * result + ((userUser == null) ? 0 : userUser.hashCode());
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
		Messages other = (Messages) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (draft != other.draft)
			return false;
		if (id != other.id)
			return false;
		if (userAdmin == null) {
			if (other.userAdmin != null)
				return false;
		} else if (!userAdmin.equals(other.userAdmin))
			return false;
		if (userUser == null) {
			if (other.userUser != null)
				return false;
		} else if (!userUser.equals(other.userUser))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Messages [id=" + id + ", userAdmin=" + userAdmin + ", userUser=" + userUser + ", content=" + content
				+ ", draft=" + draft + "]";
	}

	
	
}
