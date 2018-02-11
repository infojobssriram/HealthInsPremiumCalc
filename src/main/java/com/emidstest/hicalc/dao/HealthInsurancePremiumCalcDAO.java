package com.emidstest.hicalc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emidstest.hicalc.model.HealthInsPremiumCalcData;
import com.emidstest.hicalc.model.jpa.repo.*;

@Component
public class HealthInsurancePremiumCalcDAO {
	
	 @Autowired  private AgeCriteriaDetailsRepo ageCriteriaRepo;
	 @Autowired  private GenderCriteriaDetailsRepo genderCriteriaRepo;
	 @Autowired  private HabitsCriteriaDetailsRepo habitsCriteriaRepo;
	 @Autowired  private PreexisitingHealthCriteriaDetailsRepo preExistingHealthCriteriaRepo;
	 @Autowired  private PremiumDetailsRepo premiumDetailsRepo;
	 @Autowired  private PremiumCalcCriteriaRepo calcRepo;
	 public HealthInsPremiumCalcData getHealthInsPremiumCalcData() {
		 HealthInsPremiumCalcData retVal = new HealthInsPremiumCalcData();
		 retVal.setBasePremium((premiumDetailsRepo.findAll().get(0)).getBasePremium());
		 retVal.setAgeCriteria(ageCriteriaRepo.findAll());
		 retVal.setGenderCriteria(genderCriteriaRepo.findAll());
		 retVal.setHabitsCriteria(habitsCriteriaRepo.findAll());
		 retVal.setPremiumCalcCriteriaList(calcRepo.findAll());
		 retVal.setPreexistingHealthCriteria(preExistingHealthCriteriaRepo.findAll());
		 return retVal;
	}
}	
