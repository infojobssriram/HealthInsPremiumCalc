package com.emidstest.hicalc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emidstest.hicalc.App;
import com.emidstest.hicalc.exception.PremiumCalculationException;
import com.emidstest.hicalc.model.HealthInsurancePremiumCalcInput;
import com.emidstest.hicalc.model.HealthInsurancePremiumResponse;
import com.emidstest.hicalc.processor.HealthInsurancePremiumCalculator;


/**
 * The Class HealthInsurancePremiumCalcController.
 */
/**
 * @author sriram
 */
@RestController
@RequestMapping("/rest")
public class HealthInsurancePremiumCalcController {
	private static final Logger log = LoggerFactory.getLogger(HealthInsurancePremiumCalcController.class);
    @Autowired
    private HealthInsurancePremiumCalculator calculator = null;
	/**
	 * Fetch all jobs.
	 *
	 * @return the response entity
	 */
    
	@RequestMapping(value = "/hicalculator", method = RequestMethod.POST)
	public ResponseEntity<HealthInsurancePremiumResponse> fetchPremium(@RequestBody HealthInsurancePremiumCalcInput input){
		HealthInsurancePremiumResponse response = null;
		try {
			response = calculator.fetchPremiumRepsonse(input);
		}catch(PremiumCalculationException prex) {
			log.error("PremiumCalculationException occurred in HealthInsurancePremiumCalcController");
		}catch(Exception ex) {
			log.error("General Exception occurred in HealthInsurancePremiumCalcController");
		}
				
		return new ResponseEntity<HealthInsurancePremiumResponse>(response, HttpStatus.OK);
	}

}
