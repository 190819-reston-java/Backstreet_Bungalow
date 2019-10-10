package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Users")
public class Users {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name="id" )
	private long Id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="pswd")
	private String password;
	
	@Column(name="email")
	private String email;
	
	@Column(name="role")
	private String role;
	
	@Column(name="show_info")
	private boolean showInfo;
	
	public Users() {
		Id = 0;
		username = "";
		password = "";
		email = "";
		password = "";
		role = "";
		showInfo = true;
	}
	
	
	
	
	public Users(long id, String username, String password, 
			String email, String role, boolean showInfo) {
		super();
		this.Id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.password = password;
		this.role = role;
		this.showInfo = showInfo;
	}




	public long getId() {
		return Id;
	}
	
	public void setId(long Id) {
		this.Id = Id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}

	public boolean isShowInfo() {
		return showInfo;
	}

	public void setShowInfo(boolean showInfo) {
		this.showInfo = showInfo;
	}

	@Override
	public String toString() {
		return "Users [username=" + username + ", password=" + password + ", email=" 
				+ email + ", password=" + password + ", role=" + role 
				+ ", showInfo=" + showInfo + "]";
	}
	
	
	
}
