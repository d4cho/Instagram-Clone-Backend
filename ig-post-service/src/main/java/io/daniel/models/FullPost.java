package io.daniel.models;

import java.util.List;

public class FullPost {

	private Integer postId;
	private Integer userId;
	private Integer likeCount;
	private String image;
	private String postdesc;

	private String userName;
	private String profileImage;

	private List<FullComment> fullComments;

	public FullPost() {

	}

	public FullPost(Integer postId, Integer userId, Integer likeCount, String image, String postdesc, String userName,
			String profileImage, FullComments fullComments) {
		super();
		this.postId = postId;
		this.userId = userId;
		this.likeCount = likeCount;
		this.image = image;
		this.postdesc = postdesc;
		this.userName = userName;
		this.profileImage = profileImage;
		this.fullComments = fullComments.getFullComments();
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

	public String getPostdesc() {
		return postdesc;
	}

	public void setPostdesc(String postdesc) {
		this.postdesc = postdesc;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public List<FullComment> getFullComments() {
		return fullComments;
	}

	public void setFullComments(FullComments fullComments) {
		this.fullComments = fullComments.getFullComments();
	}

}