package com.wnsdk.spring.model;

public class BoardDto {
	private int articleNo;	// 글 번호
	private String userId;	// 작성자 아이디
	private String userPwd;	// 작성자 비밀번호
	private String subject;	// 글 제목
	private String content;	// 글 내용
	private int hit;		// 조회수
	private String registerTime;	// 작성 시각
	
	public BoardDto() {
		super();
	}
	
	public BoardDto(int articleNo, String userId, String userPwd, String subject, String content, int hit,
			String registerTime) {
		super();
		this.articleNo = articleNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.subject = subject;
		this.content = content;
		this.hit = hit;
		this.registerTime = registerTime;
	}

	public int getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	@Override
	public String toString() {
		return "BoardDto [articleNo=" + articleNo + ", userId=" + userId + ", userPwd=" + userPwd + ", subject="
				+ subject + ", content=" + content + ", hit=" + hit + ", registerTime=" + registerTime + "]";
	}

}
