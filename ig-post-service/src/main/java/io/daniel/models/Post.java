package io.daniel.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postId;
	private Integer userId;
	private Integer likeCount;
	private String image;
	private String postDesc;

	public Post() {

	}

	public Post(Integer postId, Integer userId, Integer likeCount, String image, String postDesc) {
		super();
		this.postId = postId;
		this.userId = userId;
		this.likeCount = likeCount;
		this.image = image;
		this.postDesc = postDesc;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPostDesc() {
		return postDesc;
	}

	public void setPostDesc(String postDesc) {
		this.postDesc = postDesc;
	}

}
