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
public class PremiumDetails {
	public Double getBasePremium() {
		return basePremium;
	}

	public void setBasePremium(Double basePremium) {
		this.basePremium = basePremium;
	}
	@Id
	private int id;
	private Double	basePremium;
}
