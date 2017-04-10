package com.hack.bean;

public class Tweet {
	
	
	private long tweetId;
	private String tweetUserName;
	private String sentiment;
	private String tweetText;
	private String tweetImageURL;
	
	public Tweet(long tweetId, String tweetUserName, String sentiment,String tweetText,String tweetImageURL) {
		super();
		this.tweetId = tweetId;
		this.tweetUserName = tweetUserName;
		this.sentiment = sentiment;
		this.tweetText = tweetText;
		this.tweetImageURL = tweetImageURL;
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

	public String getTweetText() {
		return tweetText;
	}

	public void setTweetText(String tweetText) {
		this.tweetText = tweetText;
	}

	public String getTweetImageURL() {
		return tweetImageURL;
	}

	public void setTweetImageURL(String tweetImageURL) {
		this.tweetImageURL = tweetImageURL;
	}
	
	

}
