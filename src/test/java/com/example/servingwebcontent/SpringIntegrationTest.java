package com.example.servingwebcontent;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest
public class SpringIntegrationTest {
	
	static ResponseEntity<String> latestResponse = null;
	
    // executeGet implementation
	public void executeGet(String string) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/fixedversion", String.class);
		latestResponse = response;
	}
}