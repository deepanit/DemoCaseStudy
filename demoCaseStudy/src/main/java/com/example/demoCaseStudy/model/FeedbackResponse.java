package com.example.demoCaseStudy.model;

public class FeedbackResponse {
	
	private FeedbackRequest feedbackRequest;
	private String commentFeedback;
	private String status;
	public FeedbackRequest getFeedbackRequest() {
		return feedbackRequest;
	}
	public void setFeedbackRequest(FeedbackRequest feedbackRequest) {
		this.feedbackRequest = feedbackRequest;
	}
	public String getCommentFeedback() {
		return commentFeedback;
	}
	public void setCommentFeedback(String commentFeedback) {
		this.commentFeedback = commentFeedback;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
