package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Comments")
@Component
public class Comments {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name="comment_id" )
	private long id;
	
	@Column(name="users_id")
	private long usersId;
	
	@Column(name="post_id")
	private long postId;
	
	@Column(name="content")
	private String content;

	public Comments() {
		super();
	}

	public Comments(long id, long usersId, long postId, String content) {
		super();
		this.id = id;
		this.usersId = usersId;
		this.postId = postId;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUsersId() {
		return usersId;
	}

	public void setUsersId(long usersId) {
		this.usersId = usersId;
	}

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (postId ^ (postId >>> 32));
		result = prime * result + (int) (usersId ^ (usersId >>> 32));
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
		Comments other = (Comments) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (id != other.id)
			return false;
		if (postId != other.postId)
			return false;
		if (usersId != other.usersId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comments [id=" + id + ", usersId=" + usersId + ", postId=" + postId + ", content=" + content + "]";
	}
	
}
