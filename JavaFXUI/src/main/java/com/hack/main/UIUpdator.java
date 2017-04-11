package com.hack.main;

import java.util.Random;

import com.hack.bean.Tweet;

import javafx.collections.ObservableList;
import javafx.scene.Node;

public class UIUpdator {

	public ObservableList<Node> childs;
	
	public void updateUI(Tweet tweet) {
		Random random = new Random();
		int index = random.nextInt(90);
		
		System.out.println(index);
		
		CustomImage customImage = (CustomImage) childs.get(index);
		customImage.setTweet(tweet);
		
		
		
	}
	
	
	
	
}
