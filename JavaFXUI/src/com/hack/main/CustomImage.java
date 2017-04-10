package com.hack.main;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CustomImage extends StackPane {
	
	private ImageView imageView;
	

	public CustomImage(String URL, String sentiment) {

		Image image = new Image(URL);
		imageView = new ImageView(image);
		
		imageView.setFitHeight(95);
		imageView.setFitWidth(95);

		this.setHeight(95);
		this.setWidth(95);

		this.getChildren().add(imageView);
		
		HBox box = new HBox(95);
		
		
		Circle circle = new Circle(5,5,5);
		
		circle.setFill(Color.RED);
		
		circle.setLayoutX(50);
		circle.setLayoutY(10);
		
		box.setPadding(new Insets(10));
		box.getChildren().add(circle);
		
		
		this.getChildren().add(box);
		
		this.setAlignment(box, Pos.TOP_LEFT);
		
		 this.setOnMouseClicked(new EventHandler<Event>() {

				@Override
				public void handle(Event arg0) {
					
					Image image = new Image("http://www.menucool.com/slider/jsImgSlider/images/image-slider-2.jpg");

					imageView.setImage(image);
					
				}
		});
	        

	}


	public ImageView getImageView() {
		return imageView;
	}


	public void setImageView(ImageView imageView) {
		this.imageView = imageView;
	}

}
