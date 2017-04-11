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

	public TwitterStreamer(Classify classify, UIUpdator mainRunner,
			Configuration conf) {

		this.classify = classify;
		this.conf = conf;

		CustomStatusListener listener = new CustomStatusListener(this.classify,
				this.mainRunner);

		twitter4j.TwitterStream twitterStream = new TwitterStreamFactory(
				this.conf).getInstance();
		twitterStream.addListener(listener);

		FilterQuery filtre = new FilterQuery();
		String[] keywordsArray = { "@RailMinIndia" };
		filtre.track(keywordsArray);
		twitterStream.filter(filtre);

	}

}
