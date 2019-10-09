package com.revature.beans;

public class Messages {

	private long Id;
	private String userFrom;
	private String userTo;
	private String content;
	
	public Messages() {
		Id = 0;
		userFrom = userTo = content = "";
	}

	public Messages(long id, String userFrom, String userTo, 
			String content) {
		super();
		Id = id;
		this.userFrom = userFrom;
		this.userTo = userTo;
		this.content = content;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getUserFrom() {
		return userFrom;
	}

	public void setUserFrom(String userFrom) {
		this.userFrom = userFrom;
	}

	public String getUserTo() {
		return userTo;
	}

	public void setUserTo(String userTo) {
		this.userTo = userTo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Messages [Id=" + Id + ", userFrom=" + userFrom 
				+ ", userTo=" + userTo + ", content=" + content + "]";
	}
	
	
}
