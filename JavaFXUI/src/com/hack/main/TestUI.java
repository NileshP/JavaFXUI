package com.hack.main;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.TilePane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class TestUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("example Gui");
  
       
        
        
        
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        //set Stage boundaries to visible bounds of the main screen
        primaryStage.setX(primaryScreenBounds.getMinX());
        primaryStage.setY(primaryScreenBounds.getMinY());
        primaryStage.setWidth(primaryScreenBounds.getWidth());
        primaryStage.setHeight(primaryScreenBounds.getHeight());
        
        TilePane tilePane = new TilePane();
        tilePane.setPadding(new Insets(5,5,5,5));
        
        int numcol = (int) (primaryScreenBounds.getWidth()/100);

        int numrow = (int) (primaryScreenBounds.getHeight()/100);
        
        int num = numcol*numrow;
        
        
        for (int i = 0; i < num; i++) {
        	 CustomImage customImage = new CustomImage("https://www.w3schools.com/css/img_lights.jpg", "POS");
             
        	 tilePane.getChildren().add(customImage);
        	 
		}
        
        tilePane.setHgap(2);
        tilePane.setVgap(2);
        
        ObservableList<Node> childs =  tilePane.getChildren();
        
        tilePane.setOnMouseClicked(new EventHandler<Event>() {

			@Override
			public void handle(Event arg0) {

				CustomImage customImage = (CustomImage) childs.get(7);
				
				Image image = new Image("http://www.menucool.com/slider/jsImgSlider/images/image-slider-2.jpg");
				
				customImage.getImageView().setImage(image);
				
				
				
			}
		});
        
        
        
        
        
        tilePane.setTileAlignment(Pos.TOP_LEFT);
       
        
        Scene appScene = new Scene(tilePane,500,500);
        primaryStage.setScene(appScene);
        primaryStage.show();
    }
}
