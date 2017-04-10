package com.hack.bean;

public class Tweet {
	
	
	private long tweetId;
	private String tweetUserName;
	private String sentiment;
	private String tweetText;
	
	public Tweet(long tweetId, String tweetUserName, String sentiment) {
		super();
		this.tweetId = tweetId;
		this.tweetUserName = tweetUserName;
		this.sentiment = sentiment;
	}
	
	public long getTweetId() {
		return tweetId;
	}
	public void setTweetId(long tweetId) {
		this.tweetId = tweetId;
	}
	public String getTweetUserName() {
		return tweetUserName;
	}
	public void setTweetUserName(String tweetUserName) {
		this.tweetUserName = tweetUserName;
	}
	public String getSentiment() {
		return sentiment;
	}
	public void setSentiment(String sentiment) {
		this.sentiment = sentiment;
	}
	
	

}
