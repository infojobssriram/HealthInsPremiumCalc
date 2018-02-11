package com.emidstest.hicalc.util;

import org.springframework.stereotype.Component;

import com.emidstest.hicalc.model.HealthInsurancePremiumCalcInput;
@Component
public class HealthInsPremiumCalcInputValidator {
	public static boolean validateInput(HealthInsurancePremiumCalcInput input){
		
		//validate all the input here....use apache-commons-validator methods if reusable
		return true;
	}
}
