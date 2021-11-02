package com.oracle.hr;

public class Employee {
	String id;
	String firstName;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	String lastName;
	String speciality;
	
	public Employee(String id, String firstName, String lastName, String speciality) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.speciality = speciality;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

}
