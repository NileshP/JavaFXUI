package com.hack.twitter;

import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterConfiguration {

	private Configuration streamConf;
	private Configuration replyConf;
	
	 public TwitterConfiguration() {
		
		this.streamConf = getTwitterStreamConf();
		this.replyConf = getTwitterReplyConf();
		
		
	}
	
	
	public Configuration getTwitterStreamConf(){
		
		ConfigurationBuilder cb = new ConfigurationBuilder();

		cb.setDebugEnabled(true)
				.setOAuthConsumerKey("Tm0ba0XKruBjmiEtqucGDRyaP")
				.setOAuthConsumerSecret(
						"umU7giJcuvtZG1PXKpmBh1H3TCBWaTYZOgsgFrDOpIm5hjBcF2")
				.setOAuthAccessToken(
						"167811448-t0foEaTlKMaagRrOwtaqeTYZe1BzdCBtP2By6W3r")
				.setOAuthAccessTokenSecret(
						"VU8wKKoj7w5uFsF5gv8xW1i6uwMAanW0DtRpPfPUa5IMU")
				.setHttpRetryCount(2)
				.setJSONStoreEnabled(true);
		
		return cb.build();
		
		
	}
	
	public Configuration getTwitterReplyConf(){
		
		ConfigurationBuilder cb = new ConfigurationBuilder();

		cb.setDebugEnabled(true)
				.setOAuthConsumerKey("CeV7kJ5vwgSvdN2w36Obbrpiq")
				.setOAuthConsumerSecret(
						"zb5TYsS3EKEZGsie3euiUEE8lqdS4u4xTZ2ZTqz0wF7yW9IRBD")
				.setOAuthAccessToken(
						"703538767647277056-gIADw7kGkO4H0IgDZjTylYV21m2OsFv")
				.setOAuthAccessTokenSecret(
						"1cRTeVgnn4rxmvNkB3ohQOfTYSOO7P5Ph0KSoxQwarSaE")
				.setJSONStoreEnabled(true);
		
		return cb.build();
		
	}
	
	public Configuration getTwitterFinalReplyConf(){
		
		ConfigurationBuilder cb = new ConfigurationBuilder();

		cb.setDebugEnabled(true)
				.setOAuthConsumerKey("n2enyJDIuAA6M0f7QhIIV7p4S")
				.setOAuthConsumerSecret(
						"KmDNktJEK3CIkyuPWlO1v2vPpg2QBt1HAqOBqwfK44D7EQCsmW")
				.setOAuthAccessToken(
						"705917295894220801-0ajhTwecqZzOquqs556yq5IhwyNsnpt")
				.setOAuthAccessTokenSecret(
						"19wNx1mGbzTNdw7UoJhq2jSK1UN0VhmixmfZC0jiKHSl3")
				.setJSONStoreEnabled(true);
		
		return cb.build();
		
	}


	
	
	
	
	
	
}
