package io.daniel.models;

import java.util.List;

public class Posts {

	private List<Post> posts;

	public Posts() {

	}

	public Posts(List<Post> posts) {
		super();
		this.posts = posts;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

}
