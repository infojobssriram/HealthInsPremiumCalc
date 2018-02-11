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

public class GenderCriteriaDetails {
	@Id
	private String	gender;
	private int	variancePerct;
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getVariancePerct() {
		return variancePerct;
	}
	public void setVariancePerct(int variancePerct) {
		this.variancePerct = variancePerct;
	}
}
