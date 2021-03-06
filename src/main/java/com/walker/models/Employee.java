package com.walker.models;

public class Employee {
	private int id;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private int financeManager;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getFinanceManager() {
		return financeManager;
	}
	public void setFinanceManager(int financeManager) {
		this.financeManager = financeManager;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", username=" + username + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", financeManager=" + financeManager
				+ "]";
	}
	
}
