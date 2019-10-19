package com.revature.beans;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Photos")
@Component
public class Photos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="users_id")
	private long usersId;
		
	@Column(name="img")
	private byte[] img;

	public Photos() {
		super();
	}

	public Photos(long id, long usersId, byte[] img) {
		super();
		this.id = id;
		this.usersId = usersId;
		this.img = img;
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

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + Arrays.hashCode(img);
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
		Photos other = (Photos) obj;
		if (id != other.id)
			return false;
		if (!Arrays.equals(img, other.img))
			return false;
		if (usersId != other.usersId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Photos [id=" + id + ", usersId=" + usersId + ", img=" + Arrays.toString(img) + "]";
	}
	
}
