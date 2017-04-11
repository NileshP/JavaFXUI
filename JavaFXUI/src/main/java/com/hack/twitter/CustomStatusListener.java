package com.hack.twitter;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import com.hack.bean.Tweet;
import com.hack.main.UIUpdator;
import com.hack.nlpprocessor.Classify;

@SuppressWarnings("deprecation")
public class CustomStatusListener implements StatusListener {

	private Classify classify;
	private UIUpdator uiUpdator;
	

	public CustomStatusListener(Classify classify) {

		this.classify = classify;
	}

	
	@Override
	public void onStatus(Status status) {

		
		if(status.getInReplyToStatusId()==-1 && status.getLang().equalsIgnoreCase("en")){
		
		String sentiment = classify.test(status.getText());

		Tweet tweet = new Tweet(status.getId(), status.getUser().getName(), sentiment,status.getText(),status.getUser().getBiggerProfileImageURL());
		
		System.out.println(tweet.getTweetId()+"--"+tweet.getSentiment()+"--"+tweet.getTweetText()+"--"+tweet.getTweetUserName());
		
		if(uiUpdator==null){
			
			System.out.println("uiupdator is null");
		}else{
			
			uiUpdator.updateUI(tweet);
		}
		}
		
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


	public UIUpdator getUiUpdator() {
		return uiUpdator;
	}


	public void setUiUpdator(UIUpdator uiUpdator) {
		this.uiUpdator = uiUpdator;
	}
	
	
	

}
