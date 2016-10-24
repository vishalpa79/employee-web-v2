package com.evoke.researchlabs.row.domain;



/**
 * 
 * @description EmployeeBean class act as a Pojo class
 * @author P A VISHAL
 * @version 1.0
 * 
 */

public class Employee { 
	 

	private String userName;

	private String emailId;

	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Employee [userName=" + userName + " emailId=" + emailId  +"]";
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	

}