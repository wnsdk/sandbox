package com.wnsdk.spring.model;

public class CommentDto {
	private int commentNo;
	private String userId;
	private String comment;
	private String commentTime;
	private int articleNo;
	
	public CommentDto() {
		super();
	}
	
	public CommentDto(int commentNo, String userId, String comment, String commentTime, int articleNo) {
		super();
		this.commentNo = commentNo;
		this.userId = userId;
		this.comment = comment;
		this.commentTime = commentTime;
		this.articleNo = articleNo;
	}
	
	public int getCommentNo() {
		return commentNo;
	}
	
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getCommentTime() {
		return commentTime;
	}
	
	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}
	
	public int getArticleNo() {
		return articleNo;
	}
	
	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}
	
	@Override
	public String toString() {
		return "CommentDto [commentNo=" + commentNo + ", userId=" + userId + ", comment=" + comment + ", commentTime="
				+ commentTime + ", articleNo=" + articleNo + "]";
	}
	
}
