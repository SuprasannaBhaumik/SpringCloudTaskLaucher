package com.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.service.TaskProcessor;

@RestController
public class TaskController {
	
	@Autowired
	TaskProcessor taskProcessor;

	@RequestMapping(value="/tasks", method=RequestMethod.POST)
	public @ResponseBody String launchTask(@RequestBody String requestPayload) {

		taskProcessor.publishRequest(requestPayload);

		System.out.println("request is made");

		return "success";
	}

}
