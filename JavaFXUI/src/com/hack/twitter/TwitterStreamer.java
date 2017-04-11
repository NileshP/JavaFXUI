package com.hack.twitter;

import com.hack.main.MainRunner;
import com.hack.main.UIUpdator;
import com.hack.nlpprocessor.Classify;
import com.hack.util.DBUtil;

import twitter4j.FilterQuery;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.Configuration;

public class TwitterStreamer {

	Classify classify;
	Configuration conf;
	UIUpdator mainRunner;
	CustomStatusListener customStatusListener;

	public CustomStatusListener getCustomStatusListener() {
		return customStatusListener;
	}

	public void setCustomStatusListener(CustomStatusListener customStatusListener) {
		this.customStatusListener = customStatusListener;
	}

	public TwitterStreamer(Classify classify,
			Configuration conf) {

		this.classify = classify;
		this.conf = conf;

		customStatusListener = new CustomStatusListener(this.classify);

		twitter4j.TwitterStream twitterStream = new TwitterStreamFactory(
				this.conf).getInstance();
		twitterStream.addListener(customStatusListener);

		FilterQuery filtre = new FilterQuery();
		String[] keywordsArray = { "@RailMinIndia" };
		filtre.track(keywordsArray);
		twitterStream.filter(filtre);

	}
	
	
	

}
