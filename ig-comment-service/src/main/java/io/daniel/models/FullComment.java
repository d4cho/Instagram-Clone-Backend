package io.daniel.models;

public class FullComment {

	private Integer commentId;
	private Integer userId;
	private Integer postId;
	private String commentText;
	private Integer likeCount;

	private String userName;
	private String profileImage;

	public FullComment() {

	}

	public FullComment(Integer commentId, Integer userId, Integer postId, String commentText, Integer likeCount,
			String userName, String profileImage) {
		super();
		this.commentId = commentId;
		this.userId = userId;
		this.postId = postId;
		this.commentText = commentText;
		this.likeCount = likeCount;
		this.userName = userName;
		this.profileImage = profileImage;
	}

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public Integer getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
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

}
