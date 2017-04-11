package com.hack.main;

import com.hack.bean.Tweet;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CustomImage extends StackPane {

	private ImageView imageView;
	private Tweet tweet;
	private Circle circle;

	public CustomImage(String sentiment, Tweet tweet) {

		this.tweet = tweet;

		Image image = new Image(tweet.getTweetImageURL());
		imageView = new ImageView(image);

		imageView.setFitHeight(95);
		imageView.setFitWidth(95);

		this.setHeight(95);
		this.setWidth(95);

		this.getChildren().add(imageView);

		HBox box = new HBox(95);

		circle = new Circle(5, 5, 5);

		circle.setFill(Color.GREY);
		
		circle.setLayoutX(50);
		circle.setLayoutY(10);

		box.setPadding(new Insets(10));
		box.getChildren().add(circle);

		this.getChildren().add(box);

		this.setAlignment(box, Pos.TOP_LEFT);

		this.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {

				
			}
		});

	}

	public Tweet getTweet() {
		return tweet;
	}

	public void setTweet(Tweet tweet) {
		this.tweet = tweet;
		Image image = new Image(tweet.getTweetImageURL());
		getImageView().setImage(image);
		if (tweet.getSentiment().equalsIgnoreCase("A")) {
			circle.setFill(Color.RED);
		} else if (tweet.getSentiment().equalsIgnoreCase("I")) {
			circle.setFill(Color.GREEN);
		} else if (tweet.getSentiment().equalsIgnoreCase("NEU")) {
			circle.setFill(Color.ORANGE);
		} else {
			circle.setFill(Color.GREY);
		}
		Tooltip.install(this,new Tooltip(tweet.getTweetUserName()+"  "+tweet.getTweetText()));
	}
	

	public ImageView getImageView() {
		return imageView;
	}

	public void setImageView(ImageView imageView) {
		this.imageView = imageView;
	}

}
