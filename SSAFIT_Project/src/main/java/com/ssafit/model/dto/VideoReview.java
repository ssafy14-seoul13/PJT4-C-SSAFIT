package com.ssafit.model.dto;

import java.util.Date;

public class VideoReview {
	
	private int videoId;
	private int reviewId;
	private String writer;
	private String title;
	private String content;
	private Date regDate;
	private Date modDate;
	private int viewCount;
	
	public VideoReview(int reviewId, int videoId, String writer, String title, String content, int viewCount) {
	    this.reviewId = reviewId;
	    this.videoId = videoId;
	    this.writer = writer;
	    this.title = title;
	    this.content = content;
	    this.viewCount = viewCount;
	}


	@Override
	public String toString() {
		return "VideoReview [videoId=" + videoId + ", reviewId=" + reviewId + ", writer=" + writer + ", content="
				+ content + ", regDate=" + regDate + ", modDate=" + modDate + ", viewCount=" + viewCount + "]";
	}
	public Date getRegDate() {
		return regDate;
	}
	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getModDate() {
		return modDate;
	}
	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	
}
