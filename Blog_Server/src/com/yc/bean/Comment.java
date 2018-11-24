package com.yc.bean;

import java.security.Timestamp;

public class Comment {
	private Long id;
	private Long titleI;
	private Long userId;
	private String  content;
	private Timestamp commentTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getTitleI() {
		return titleI;
	}
	public void setTitleI(Long titleI) {
		this.titleI = titleI;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Timestamp commentTime) {
		this.commentTime = commentTime;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", titleI=" + titleI + ", userId=" + userId + ", content=" + content
				+ ", commentTime=" + commentTime + "]";
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
