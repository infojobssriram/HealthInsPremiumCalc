package com.emidstest.hicalc.processor;

import java.util.Map;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emidstest.hicalc.dao.HealthInsurancePremiumCalcDAO;
import com.emidstest.hicalc.exception.PremiumCalculationException;
import com.emidstest.hicalc.model.HealthInsPremiumCalcData;
import com.emidstest.hicalc.model.HealthInsurancePremiumCalcInput;
import com.emidstest.hicalc.model.HealthInsurancePremiumResponse;
import com.emidstest.hicalc.model.jpa.AgeCriteriaDetails;
import com.emidstest.hicalc.model.jpa.GenderCriteriaDetails;
import com.emidstest.hicalc.model.jpa.HabitsCriteriaDetails;
import com.emidstest.hicalc.model.jpa.PreexistingHealthCriteriaDetails;
import com.emidstest.hicalc.model.jpa.PremiumCalcCriteria;
import com.emidstest.hicalc.util.HealthInsPremiumCalcInputValidator;

@Component
public class HealthInsurancePremiumCalculator {
	@Autowired
	private HealthInsurancePremiumCalcDAO	healthInsCalcDao;
	
	public HealthInsurancePremiumResponse fetchPremiumRepsonse(HealthInsurancePremiumCalcInput input) throws PremiumCalculationException {
		boolean validated = HealthInsPremiumCalcInputValidator.validateInput(input);
		if(!validated) return null;
		HealthInsurancePremiumResponse response = new HealthInsurancePremiumResponse();
		
		HealthInsPremiumCalcData hiPremiumCalcData = healthInsCalcDao.getHealthInsPremiumCalcData();
		double netPremium = calculateNetPremium(input,hiPremiumCalcData);
		response.setName(input.getName());
		response.setAge(input.getAge());
		response.setNetPremium(netPremium);
		return response;
	}
	
	private Double calculateNetPremium(HealthInsurancePremiumCalcInput input,HealthInsPremiumCalcData hiPremiumCalcData) throws PremiumCalculationException{
		double basePremium = hiPremiumCalcData.getBasePremium();
		double netPremium = hiPremiumCalcData.getBasePremium();
		boolean canAddGenderVariance = false;
		boolean canAddHabitVariance = false;
		boolean canAddPreHealthVariance = false;
		boolean canAddAgeVariance = false;
		try {
			for(PremiumCalcCriteria preCalcCriteria: hiPremiumCalcData.getPremiumCalcCriteriaList()) {
				if(preCalcCriteria.getCriteriaName().equals("gender")) {
					canAddGenderVariance = preCalcCriteria.getIsActive()==1;
				}
				if(preCalcCriteria.getCriteriaName().equals("preexistinghealth")) {
					canAddPreHealthVariance = preCalcCriteria.getIsActive()==1;
				}
				if(preCalcCriteria.getCriteriaName().equals("habit")) {
					canAddHabitVariance = preCalcCriteria.getIsActive()==1;
				}
				if(preCalcCriteria.getCriteriaName().equals("age")) {
					canAddAgeVariance = preCalcCriteria.getIsActive()==1;
				}
			}
			if(canAddGenderVariance) {
				for(GenderCriteriaDetails dtls: hiPremiumCalcData.getGenderCriteria()) {
					netPremium+=(dtls.getVariancePerct()*basePremium)/100;
				}
			}
			Map<String, Boolean> filteredMap = null;
			
			if(canAddHabitVariance) {
				filteredMap = input.getHabits().entrySet().stream().filter(m->m.getValue()==true)
						.collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
						
				for(String key:filteredMap.keySet()) {
					for(HabitsCriteriaDetails dtls:hiPremiumCalcData.getHabitsCriteria()) {
						if(dtls.getHabit().equals(key))
							netPremium+=(dtls.getVariancePerct()*basePremium)/100;
					}
				}		
			}
			if(canAddPreHealthVariance) {
				filteredMap = input.getPreHealth().entrySet().stream().filter(m->m.getValue()==true)
						.collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
						
						for(String key:filteredMap.keySet()) {
							for(PreexistingHealthCriteriaDetails dtls:hiPremiumCalcData.getPreexistingHealthCriteria()) {
								if(dtls.getHealthCond().equals(key))
									netPremium+=(dtls.getVariancePerct()*basePremium)/100;
							}
						}
			}

			if(canAddAgeVariance) {
				netPremium+=addAgePremium(basePremium,input.getAge(),hiPremiumCalcData);
			}
		}catch(Exception ex) {
			throw new PremiumCalculationException("01", "Error occurred while calculating net premium");
		}


		return netPremium;
	}
	
	private double addAgePremium(double basePremium,int age,HealthInsPremiumCalcData hiPremiumCalcData) {
		int addlPremiumPerct = 0;
		double agePremium = 0;
		for(AgeCriteriaDetails dtl: hiPremiumCalcData.getAgeCriteria()) {
			if(dtl.getEndAge()<age) {
				addlPremiumPerct+=dtl.getVariancePerct();
			}
			
		};
		agePremium+=(addlPremiumPerct*basePremium)/100;    
		return agePremium;   
	}
	
}
