package com.hack.nlpprocessor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


import opennlp.tools.doccat.DoccatModel;
import opennlp.tools.doccat.DocumentCategorizerEvaluator;
import opennlp.tools.doccat.DocumentCategorizerME;
import opennlp.tools.doccat.DocumentSample;
import opennlp.tools.util.InvalidFormatException;

public class IssueClassifier {

	public String test(String text) throws InvalidFormatException, IOException {
		String classificationModelFilePath = "E:\\Research\\JAVA-Workspaces\\GIT Projects\\search\\search\\issuemodel";
		InputStream is = new FileInputStream(classificationModelFilePath);
		DoccatModel classificationModel = new DoccatModel(is);
		DocumentCategorizerME classificationME = new DocumentCategorizerME(
				classificationModel);
		DocumentCategorizerEvaluator modelEvaluator = new DocumentCategorizerEvaluator(
				classificationME);
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
