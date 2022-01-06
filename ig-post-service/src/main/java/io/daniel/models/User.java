package io.daniel.models;

public class User {

	private Integer userId;
	private String userName;
	private String name;
	private String image;

	public User() {

	}

	public User(Integer userId, String userName, String name, String image) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.name = name;
		this.image = image;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
