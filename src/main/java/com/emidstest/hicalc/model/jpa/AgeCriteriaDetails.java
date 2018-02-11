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

public class AgeCriteriaDetails {

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStartAge() {
		return startAge;
	}
	public void setStartAge(int startAge) {
		this.startAge = startAge;
	}
	public int getEndAge() {
		return endAge;
	}
	public void setEndAge(int endAge) {
		this.endAge = endAge;
	}
	public int getVariancePerct() {
		return variancePerct;
	}
	public void setVariancePerct(int variancePerct) {
		this.variancePerct = variancePerct;
	}
	@Id
	private int	id;
	private int	startAge;
	private int	endAge;
	private int	variancePerct;
}
