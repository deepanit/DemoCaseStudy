package com.example.demoCaseStudy.listener;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.example.demoCaseStudyAPIImpl.DemoCaseStudyAPIImpl;

@Component
public class ApplicationListener extends ResourceConfig{
	
	public ApplicationListener(){
		register(DemoCaseStudyAPIImpl.class);
	}

}
