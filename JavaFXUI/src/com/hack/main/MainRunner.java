package com.hack.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

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
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

import com.hack.bean.Tweet;
import com.hack.nlpprocessor.Classify;
import com.hack.twitter.TwitterConfiguration;
import com.hack.twitter.TwitterStreamer;
import com.hack.util.DBUtil;
import com.hack.util.PropertiesReader;

public class MainRunner extends Application {

	private TwitterStreamer streamer;
	private Classify classify;
	private TwitterConfiguration configuration;
	private ObservableList<Node> childs;
	
	public boolean Initialise() {

		try {

			classify = new Classify();
			configuration = new TwitterConfiguration();

			return true;
		} catch (Exception e) {

			e.printStackTrace();

			return false;
		}

	}

	public static void main(String[] args) throws FileNotFoundException,
			IOException {

		MainRunner mainRunner = new MainRunner();
		
		mainRunner.Initialise();
		
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
        
		
		
		
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
        	
        	Tweet tweet = new Tweet(i, "@A"+i, "POS", "Hello", "https://www.w3schools.com/css/img_lights.jpg");
        	
        	 CustomImage customImage = new CustomImage("POS", tweet);
             
        	 tilePane.getChildren().add(customImage);
        	 
		}
        
        tilePane.setHgap(2);
        tilePane.setVgap(2);
        
        childs =  tilePane.getChildren();
      
        tilePane.setTileAlignment(Pos.TOP_LEFT);
       
        
        Scene appScene = new Scene(tilePane,500,500);
        primaryStage.setScene(appScene);
        
        configuration = new TwitterConfiguration();
        
        streamer = new TwitterStreamer(classify, this, configuration.getTwitterStreamConf());
        
        primaryStage.show();
    }

	public void updateUI(Tweet tweet) {
		Random random = new Random(1);
		int index = random.nextInt(100);
		
		CustomImage customImage = (CustomImage) childs.get(index);
		customImage.setTweet(tweet);
	}

}
