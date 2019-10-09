package com.revature.beans;

public class Users {
	
	private long Id;
	private String username;
	private String password;
	private String email;
	private String pswd;
	private String role;
	private boolean showInfo;
	
	public Users() {
		Id = 0;
		username = "";
		password = "";
		email = "";
		pswd = "";
		role = "";
		showInfo = true;
	}
	
	
	
	
	public Users(long id, String username, String password, 
			String email, String pswd, String role, boolean showInfo) {
		super();
		this.Id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.pswd = pswd;
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
				+ email + ", pswd=" + pswd + ", role=" + role 
				+ ", showInfo=" + showInfo + "]";
	}
	
	
	
}
