package com.hack.twitter;

import com.hack.bean.Tweet;
import com.hack.main.MainRunner;
import com.hack.nlpprocessor.Classify;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.json.DataObjectFactory;

public class CustomStatusListener implements StatusListener {

	Classify classify;

	public CustomStatusListener(Classify classify,MainRunner mainRunner) {

		this.classify = classify;

	}

	
	@Override
	public void onStatus(Status status) {

		String jsonString = DataObjectFactory.getRawJSON(status);
		
		String sentiment = classify.test(status.getText());

		Tweet tweet = new Tweet(status.getId(), status.getUser().getName(), sentiment);
		
		
		
		
		
	}

	@Override
	public void onTrackLimitationNotice(int arg0) {
		// TODO Auto-generated method stub

		System.out.println("LIMIT");

	}
	@Override
	public void onException(Exception arg0) {
		// TODO Auto-generated method stub

		System.out.println("EXCEPTION" + arg0.getMessage());
		arg0.printStackTrace();
	}

	@Override
	public void onDeletionNotice(StatusDeletionNotice arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onScrubGeo(long arg0, long arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStallWarning(StallWarning arg0) {
		// TODO Auto-generated method stub

		System.out.println("STALL_WARNING");

	}

}
