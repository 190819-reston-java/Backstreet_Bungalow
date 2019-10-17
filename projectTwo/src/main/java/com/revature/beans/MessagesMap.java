package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Messages_map")
@Component
public class MessagesMap {

	@OneToOne
	@Column(name="message_id")
	private long id;
	
	@Column(name="author_id")
	private long authorId;
	
	@Column(name="receiver_id")
	private long receiverId;
	
	@Column(name="is_sent")
	private boolean isSent;
	
	@Column(name="is_in_trash")
	private boolean isInTrash;

	public MessagesMap() {
		super();
	}

	public MessagesMap(long id, long authorId, long receiverId, boolean isSent, boolean isInTrash) {
		super();
		this.id = id;
		this.authorId = authorId;
		this.receiverId = receiverId;
		this.isSent = isSent;
		this.isInTrash = isInTrash;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}

	public long getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(long receiverId) {
		this.receiverId = receiverId;
	}

	public boolean isSent() {
		return isSent;
	}

	public void setSent(boolean isSent) {
		this.isSent = isSent;
	}

	public boolean isInTrash() {
		return isInTrash;
	}

	public void setInTrash(boolean isInTrash) {
		this.isInTrash = isInTrash;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (authorId ^ (authorId >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (isInTrash ? 1231 : 1237);
		result = prime * result + (isSent ? 1231 : 1237);
		result = prime * result + (int) (receiverId ^ (receiverId >>> 32));
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
		MessagesMap other = (MessagesMap) obj;
		if (authorId != other.authorId)
			return false;
		if (id != other.id)
			return false;
		if (isInTrash != other.isInTrash)
			return false;
		if (isSent != other.isSent)
			return false;
		if (receiverId != other.receiverId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MessagesMap [id=" + id + ", authorId=" + authorId + ", receiverId=" + receiverId + ", isSent=" + isSent
				+ ", isInTrash=" + isInTrash + "]";
	}
	
}
