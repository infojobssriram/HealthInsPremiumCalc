package com.emidstest.hicalc.model;

import java.util.Map;

import org.springframework.stereotype.Component;
@Component
public class HealthInsurancePremiumCalcInput {
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Map<String, Boolean> getHabits() {
		return habits;
	}
	public void setHabits(Map<String, Boolean> habits) {
		this.habits = habits;
	}
	public Map<String, Boolean> getPreHealth() {
		return preHealth;
	}
	public void setPreHealth(Map<String, Boolean> preHealth) {
		this.preHealth = preHealth;
	}
	private String name;
	private int age;
	private String gender;
	private Map<String,Boolean> habits;
	private Map<String,Boolean> preHealth;
}
