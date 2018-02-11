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

public class HabitsCriteriaDetails {
	public String getHabit() {
		return habit;
	}
	public void setHabit(String habit) {
		this.habit = habit;
	}
	public int getVariancePerct() {
		return variancePerct;
	}
	public void setVariancePerct(int variancePerct) {
		this.variancePerct = variancePerct;
	}
	@Id
	private String	habit;
	private int	variancePerct;
}
