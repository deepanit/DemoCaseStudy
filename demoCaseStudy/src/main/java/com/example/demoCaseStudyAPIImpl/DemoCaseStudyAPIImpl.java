package com.example.demoCaseStudyAPIImpl;



import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demoCaseStudy.model.FeedbackRequest;
import com.example.demoCaseStudy.model.FeedbackResponse;
import com.example.demoCaseStudy.processor.TextCensorprocessor;
import com.example.demoCaseStudy.Constants.Constants;


@Component
@Path("/")
public class DemoCaseStudyAPIImpl {

	@Autowired
	TextCensorprocessor textCensorProcessor;
	
	@Path("/commentFeedback")
	@POST
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public FeedbackResponse getCommentFeedback(FeedbackRequest request) {
		FeedbackResponse response = new FeedbackResponse();
		if(request.getCommentText()==null || request.getUserName() == null || request.getEmailId() == null || request.getProductId()==null) {
			response.setStatus(Constants.STATUS_PROCESS_FAILURE);
			response.setCommentFeedback(Constants.STATUS_INVALID_INPUT);
			response.setFeedbackRequest(request);
		}
		else {
			response = textCensorProcessor.checkIfContentObjectionable(request); 
		}
		return response;
	}

}
