package com.emidstest.hicalc.controller;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.emidstest.hicalc.model.HealthInsurancePremiumCalcInput;
import com.emidstest.hicalc.model.HealthInsurancePremiumResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HealthInsurancePremiumCalcControllerTest extends BaseIntegrationTest {

	@Autowired
	private RestTemplate restTemplate;

	private HealthInsurancePremiumResponse resp;
	private HealthInsurancePremiumCalcInput	input;
	
	@When("^I send post request to calculate premium for client details (.*)$")
	public void calculatePremium(String candidateName) throws JsonParseException, JsonMappingException, IOException {
		String url = "http://localhost:9999/rest/hicalculator";
		restTemplate = new RestTemplate();
		resp = restTemplate.postForObject( url, createInput(), HealthInsurancePremiumResponse.class);
		System.out.println("Post request sent to calculate premium details");
	}
	
	@Then("^I should get premium details for (.*)$")
	public void getPremiumDetails(String candidateName) {
		assertNotNull(resp);
		System.out.println("Job details received");
	}
	
	
	
	private HealthInsurancePremiumCalcInput createInput() {
		HealthInsurancePremiumCalcInput input = new HealthInsurancePremiumCalcInput();
		input.setName("Michel Jackson");
		input.setAge(38);
		input.setGender("male");
		Map<String,Boolean> habits = new HashMap<>();
		habits.put("smoking", true);
		habits.put("dailyexcercise", false);
		habits.put("alcohol", true);
		habits.put("drugs", false);
		
		input.setHabits(habits);
		
		Map<String,Boolean> prehealth = new HashMap<>();
		prehealth.put("diabetes", true);
		prehealth.put("blookpressure", false);
		prehealth.put("hypertension ", true);
		prehealth.put("overweight", false);
		
		input.setPreHealth(prehealth);
		return input;
	}	
	
	

}