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

public class PremiumCalcCriteria {
	public String getCriteriaName() {
		return criteriaName;
	}
	public void setCriteriaName(String criteriaName) {
		this.criteriaName = criteriaName;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	@Id
	private String	criteriaName;
	private int	isActive;
}
