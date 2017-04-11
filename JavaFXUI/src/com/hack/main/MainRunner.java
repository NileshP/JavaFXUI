package com.hack.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import opennlp.tools.util.InvalidFormatException;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.TilePane;
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
	UIUpdator uiUpdator;

	public boolean initialize() throws InvalidFormatException, IOException {
		try {
			uiUpdator = new UIUpdator();
			configuration = new TwitterConfiguration();

			classify = new Classify();

			streamer = new TwitterStreamer(classify,
					configuration.getTwitterStreamConf());

			System.out.println("Initialization completed");
			
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}

	public static void main(String[] args) throws FileNotFoundException,
			IOException {
	
			launch(args);
		

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		if (initialize()) {

	
		
		primaryStage.setTitle("Twitter Sentiment Grid ..");

		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

		// set Stage boundaries to visible bounds of the main screen
		primaryStage.setX(primaryScreenBounds.getMinX());
		primaryStage.setY(primaryScreenBounds.getMinY());
		primaryStage.setWidth(primaryScreenBounds.getWidth());
		primaryStage.setHeight(primaryScreenBounds.getHeight());

		TilePane tilePane = new TilePane();
		tilePane.setPadding(new Insets(5, 5, 5, 5));

		int numcol = (int) (primaryScreenBounds.getWidth() / 100);

		int numrow = (int) (primaryScreenBounds.getHeight() / 100);

		int num = numcol * numrow;

		
		
		for (int i = 0; i < num; i++) {

			Tweet tweet = new Tweet(i, "@A" + i, "POS", "Hello",
					"https://www.w3schools.com/css/img_lights.jpg");

			CustomImage customImage = new CustomImage("POS", tweet);

			tilePane.getChildren().add(customImage);

		}

		tilePane.setHgap(2);
		tilePane.setVgap(2);

		uiUpdator.childs = tilePane.getChildren();
		
		streamer.getCustomStatusListener().setUiUpdator(uiUpdator);

		tilePane.setTileAlignment(Pos.TOP_LEFT);
		tilePane.setStyle("-fx-background-color: #2C3E50;");

		Scene appScene = new Scene(tilePane, 500, 500);
		primaryStage.setScene(appScene);

		primaryStage.show();
		
		
		} else {
			
			System.out.println("initialization failed");
		}

	}

}
