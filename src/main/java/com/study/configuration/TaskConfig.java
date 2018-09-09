package com.study.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.study.service.TaskProcessor;

@Configuration
public class TaskConfig {
	
	@Bean
	public TaskProcessor taskProcessor() {
		return new TaskProcessor();
	}

}
