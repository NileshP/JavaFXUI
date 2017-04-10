package com.hack.twitter;

import com.hack.main.MainRunner;
import com.hack.nlpprocessor.Classify;
import com.hack.util.DBUtil;

import twitter4j.FilterQuery;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.Configuration;


public class TwitterStreamer {

	Classify classify;
	Configuration conf;
	DBUtil dbUtil;
	MainRunner mainRunner;
	
	public TwitterStreamer(DBUtil dbUtil,Classify classify,MainRunner mainRunner, Configuration conf) {
		
		this.classify =  classify;
		this.conf = conf;
		this.dbUtil = dbUtil;
		  
		CustomStatusListener listener = new CustomStatusListener(this.classify,this.mainRunner);
		
		twitter4j.TwitterStream twitterStream = new TwitterStreamFactory(this.conf).getInstance();
		twitterStream.addListener(listener);
		
		FilterQuery filtre = new FilterQuery();
	    String[] keywordsArray = { "@IR_HelpDesk"};
	    filtre.track(keywordsArray);
	    twitterStream.filter(filtre);
		
	}
	
	
	
	
}
