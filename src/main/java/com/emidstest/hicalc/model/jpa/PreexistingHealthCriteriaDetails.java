package com.emidstest.hicalc.model.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

/**
 * The Class PremiumDetails.
 */
/**
 * @author sriram
 */
@Component
@Entity

public class PreexistingHealthCriteriaDetails {

	public int getVariancePerct() {
		return variancePerct;
	}
	public void setVariancePerct(int variancePerct) {
		this.variancePerct = variancePerct;
	}
	public String getHealthCond() {
		return healthcond;
	}
	public void setHealthCond(String healthCond) {
		this.healthcond = healthCond;
	}
	
	@Id
	private String	healthcond;
	private int	variancePerct;
}
