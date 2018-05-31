package com.practice;

public class SuppliedTestClass {

	String name;
	String lastName;
	String middleName;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public SuppliedTestClass() {
		super();
	}
	@Override
	public String toString() {
		return "SuppliedTestClass [name=" + name + ", lastName=" + lastName + ", middleName=" + middleName + "]";
	}
	
	
	
}
