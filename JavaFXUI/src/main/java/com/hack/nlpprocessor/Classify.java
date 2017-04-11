package com.hack.nlpprocessor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;



import opennlp.tools.doccat.DoccatModel;
import opennlp.tools.doccat.DocumentCategorizerEvaluator;
import opennlp.tools.doccat.DocumentCategorizerME;
import opennlp.tools.doccat.DocumentSample;
import opennlp.tools.util.InvalidFormatException; 

public class Classify {
	
	DocumentCategorizerME classificationME;
	DocumentCategorizerEvaluator modelEvaluator;
	
	public Classify() throws InvalidFormatException, IOException {
		String classificationModelFilePath = "/tweetsModelTwoCat";
		InputStream is = getClass().getResourceAsStream(classificationModelFilePath);
		DoccatModel classificationModel = new DoccatModel(is);
	    classificationME = new DocumentCategorizerME(
				classificationModel);
		modelEvaluator = new DocumentCategorizerEvaluator(
				classificationME);
		
	}

	public String test(String text){
		
		String expectedDocumentCategory = "";
		String documentContent = text;
		DocumentSample sample = new DocumentSample(expectedDocumentCategory,
				documentContent);
		double[] classDistribution = classificationME
				.categorize(documentContent);
		String predictedCategory = classificationME
				.getBestCategory(classDistribution);
		modelEvaluator.evaluateSample(sample);
		
		System.out.println(predictedCategory);
		return predictedCategory;
	}
	
}
