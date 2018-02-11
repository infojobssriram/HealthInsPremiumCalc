package com.emidstest.hicalc.model;

import org.springframework.stereotype.Component;

@Component
public class HealthInsurancePremiumResponse {
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAge() {
		return age;
	}
	public void setAge(double age) {
		this.age = age;
	}
	public double getNetPremium() {
		return netPremium;
	}
	public void setNetPremium(double netPremium) {
		this.netPremium = netPremium;
	}
	private String name;
	private double age;
	private double netPremium;
}
