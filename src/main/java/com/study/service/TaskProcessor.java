package com.study.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.task.launcher.TaskLaunchRequest;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Source.class)
public class TaskProcessor {
	
	@Autowired
	private Source source;
	
	public void publishRequest(String payload) {
		
		System.out.println("calling the publishRequest");
		
		//format for the url -> groupId:artifactId:packaging:version
		String url="maven://com.study:SpringCloudTask:jar:0.0.1-SNAPSHOT";
		
		List<String> inputList = new ArrayList<String>(Arrays.asList(payload.split(",")));

		//last parameter in the constructor is the application name, 
		//named the same in the SpringCloudTask application.
		TaskLaunchRequest request = new TaskLaunchRequest(url, inputList, null, null, "Custom Task");

		System.out.println("task launch request created");
		
		GenericMessage<TaskLaunchRequest> message = new GenericMessage<>(request);
		
		this.source.output().send(message);
		
	}
}
