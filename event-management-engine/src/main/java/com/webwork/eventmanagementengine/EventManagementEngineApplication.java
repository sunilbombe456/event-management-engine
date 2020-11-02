package com.webwork.eventmanagementengine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.webwork.eventmanagementengine.dto.StorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({StorageProperties.class})
public class EventManagementEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventManagementEngineApplication.class, args);
	}
	
}