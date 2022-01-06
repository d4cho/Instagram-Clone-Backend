package io.daniel.models;

import java.util.List;

public class Users {

	private List<User> users;

	public Users() {

	}

	public Users(List<User> users) {
		super();
		this.users = users;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
