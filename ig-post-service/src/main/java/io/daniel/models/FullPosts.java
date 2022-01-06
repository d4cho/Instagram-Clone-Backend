package io.daniel.models;

import java.util.List;

public class FullPosts {

	private List<FullPost> fullPosts;

	public FullPosts() {

	}

	public FullPosts(List<FullPost> fullPosts) {
		super();
		this.fullPosts = fullPosts;
	}

	public List<FullPost> getFullPosts() {
		return fullPosts;
	}

	public void setFullPosts(List<FullPost> fullPosts) {
		this.fullPosts = fullPosts;
	}

}
