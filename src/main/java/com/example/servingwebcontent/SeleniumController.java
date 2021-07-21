package com.example.servingwebcontent;

import static org.junit.Assert.assertThat;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import okhttp3.Response;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@Controller
public class SeleniumController {

	@GetMapping("/selenium")
	public String getVersion(@RequestParam(name="browser", required=false, defaultValue="Chrome") String browser, Model model) throws InterruptedException {
		model.addAttribute("browser", browser);
		
//		WebDriver driver;
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\alvin\\Documents\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		
//		driver.get("http://localhost:8080/version");
//		 
//		driver.quit();
		
		 RestTemplate restTemplate = new RestTemplate();
		 ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/version", String.class);
		 System.out.println(response.getBody());
		 assertThat("Success", response.getStatusCode().equals(HttpStatus.OK));
		 
		return "browser";
	}

}
