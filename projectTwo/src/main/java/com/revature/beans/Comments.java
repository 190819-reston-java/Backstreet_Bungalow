package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Comments")
@Component
public class Comments {

	@OneToOne
	@Column( name="comment_id" )
	private long commentId;
	
	@OneToOne
	@Column(name="users_id")
	private long usersId;
	
	@Column(name="content")
	private String content;

	public Comments() {
		super();
	}

	public Comments(long commentId, long usersId, String content) {
		super();
		this.commentId = commentId;
		this.usersId = usersId;
		this.content = content;
	}

	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	public long getUsersId() {
		return usersId;
	}

	public void setUsersId(long usersId) {
		this.usersId = usersId;
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
		result = prime * result + (int) (commentId ^ (commentId >>> 32));
		result = prime * result + ((content == null) ? 0 : content.hashCode());
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
		if (commentId != other.commentId)
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (usersId != other.usersId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comments [commentId=" + commentId + ", usersId=" + usersId + ", content=" + content + "]";
	}

	
}
