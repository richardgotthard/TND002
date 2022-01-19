package PartA;

public class Person {
	
	private String givenName;
	private String surName;
	private int phoneNumber;
	
	public Person(String arg1, String arg2, int arg3) {
		givenName = arg1;
		surName = arg2;
		phoneNumber = arg3;
		
	}
	
	public String getSurname() {
		return surName;
		
	}
	
	public String getFullName() {
		return givenName + " " + surName;
	}
	
	public int getPhoneNumber() {
		return phoneNumber;
	}

}
