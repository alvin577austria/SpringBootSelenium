package com.example.servingwebcontent;

import static org.hamcrest.MatcherAssert.assertThat;

import org.springframework.http.HttpStatus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs extends SpringIntegrationTest {
	   
    @When("^the client calls /version$")
    public void the_client_issues_GET_version() throws Throwable {
        executeGet("http://localhost:8080/fixedversion");
    }
    
    @Then("^the client receives status code of (\\d+)$")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
        HttpStatus currentStatusCode = latestResponse.getStatusCode();
        assertThat("status code is incorrect : "+ 
        latestResponse.getBody(), currentStatusCode.value() == statusCode);
    }

    @And("^the client receives server version (.+)$")
    public void the_client_receives_server_version_body(String version) throws Throwable {
        String currentVersion = latestResponse.getBody();
        assertThat("version is incorrect : "+ 
                latestResponse.getBody(), currentVersion.equals(version));
    }
}