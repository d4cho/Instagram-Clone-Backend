package io.daniel.models;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String userId;
	private String userName;
	private String name;
	private String image;

	public User() {

	}

	public User(String userId, String userName, String name, String image) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.name = name;
		this.image = image;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
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
