package com.example.demoCaseStudy.processor;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.example.demoCaseStudy.Constants.Constants;
import com.example.demoCaseStudy.model.FeedbackRequest;
import com.example.demoCaseStudy.model.FeedbackResponse;

@Component
public class TextCensorprocessor {
	static ArrayList<String> badwords = new ArrayList<String>();

	public  ArrayList<String> getBadWordsFromFile(FeedbackResponse response) {
		if(badwords.isEmpty()) {
			try {
		    ClassLoader classLoader = new TextCensorprocessor().getClass().getClassLoader();
			InputStream is = classLoader.getResourceAsStream("CensoredWordsByGoogle.csv");
			BufferedReader br =new BufferedReader(new InputStreamReader(is));

			String str ="";
			br.readLine();
			while(( str = br.readLine())!=null){
				if(!badwords.contains(str) && !str.equals(""))
					badwords.add(str);
			}
			}
			catch(IOException e) {
				response.setStatus(Constants.STATUS_PROCESS_FAILURE);
				response.setCommentFeedback(Constants.STATUS_EXCEPTION_FILEREAD);
				e.printStackTrace();
			}
			
		}
		return badwords;
	}
	
	public FeedbackResponse checkIfContentObjectionable(FeedbackRequest request) {
		FeedbackResponse response = new FeedbackResponse();
		response.setFeedbackRequest(request);
		String text = request.getCommentText().toLowerCase();
		for(String s : getBadWordsFromFile(response)) {
			if(text.indexOf(s.toLowerCase())!=-1) {
				response.setStatus(Constants.STATUS_PROCESS_SUCCESS);
				response.setCommentFeedback(Constants.STATUS_CONTENT_OBJECTED);
				return response;
			}
		}
		response.setStatus(Constants.STATUS_PROCESS_SUCCESS);
		response.setCommentFeedback(Constants.STATUS_CONTENT_OK);

		return response;
	}
}
