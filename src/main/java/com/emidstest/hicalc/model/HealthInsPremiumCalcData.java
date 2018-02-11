package com.emidstest.hicalc.model;
import java.util.List;

import org.springframework.stereotype.Component;

import com.emidstest.hicalc.model.jpa.*;
@Component
public class HealthInsPremiumCalcData {
	public double getBasePremium() {
		return basePremium;
	}
	public void setBasePremium(double basePremium) {
		this.basePremium = basePremium;
	}
	public List<AgeCriteriaDetails> getAgeCriteria() {
		return ageCriteria;
	}
	public void setAgeCriteria(List<AgeCriteriaDetails> ageCriteria) {
		this.ageCriteria = ageCriteria;
	}
	public List<GenderCriteriaDetails> getGenderCriteria() {
		return genderCriteria;
	}
	public void setGenderCriteria(List<GenderCriteriaDetails> genderCriteria) {
		this.genderCriteria = genderCriteria;
	}
	public List<HabitsCriteriaDetails> getHabitsCriteria() {
		return habitsCriteria;
	}
	public void setHabitsCriteria(List<HabitsCriteriaDetails> habitsCriteria) {
		this.habitsCriteria = habitsCriteria;
	}
	public List<PreexistingHealthCriteriaDetails> getPreexistingHealthCriteria() {
		return preexistingHealthCriteria;
	}
	public void setPreexistingHealthCriteria(List<PreexistingHealthCriteriaDetails> preexistingHealthCriteria) {
		this.preexistingHealthCriteria = preexistingHealthCriteria;
	}
	public List<PremiumCalcCriteria> getPremiumCalcCriteriaList() {
		return premiumCalcCriteriaList;
	}
	public void setPremiumCalcCriteriaList(List<PremiumCalcCriteria> premiumCalcCriteriaList) {
		this.premiumCalcCriteriaList = premiumCalcCriteriaList;
	}
	
	private double basePremium;
	private List<PremiumCalcCriteria> premiumCalcCriteriaList;
	private List<AgeCriteriaDetails> ageCriteria;
	private List<GenderCriteriaDetails> genderCriteria;
	private List<HabitsCriteriaDetails> habitsCriteria;
	private List<PreexistingHealthCriteriaDetails> preexistingHealthCriteria;

}
