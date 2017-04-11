package com.hack.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	
	public static String modelPath;
	public static String folderPath;
	public static String handlerFilePath;
	
	
	public static void readPropertiesReader() throws FileNotFoundException, IOException {
		
		Properties properties = new Properties();
		properties.load(new FileInputStream("application.properties"));
		
		modelPath=properties.getProperty("MODEL_PATH");
		folderPath=properties.getProperty("FOLDER_PATH");
		handlerFilePath=properties.getProperty("HADNDLE_PATH");
		
		
	}
	

}
