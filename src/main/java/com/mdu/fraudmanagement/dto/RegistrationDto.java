package com.mdu.fraudmanagement.dto;

import java.util.Date;

import javax.persistence.Entity;

public class RegistrationDto {
	
	private String userId;
	private String firstName;
	private String lastName;
	private Date   dob;
	private String gender;
	private String contactNo;
	private String email;
	private String password;
	private String ans1;
	private String ans2;
	private String ans3;
	
	
	public RegistrationDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RegistrationDto(String userId, String firstName, String lastName, Date dob, String gender, String contactNo,
			String email, String password, String ans1, String ans2,
			String ans3) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.contactNo = contactNo;
		this.email = email;
		this.password = password;
		this.ans1 = ans1;
		this.ans2 = ans2;
		this.ans3 = ans3;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
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


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getContactNo() {
		return contactNo;
	}
	
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public String getAns1() {
		return ans1;
	}
	public void setAns1(String ans1) {
		this.ans1 = ans1;
	}
	public String getAns2() {
		return ans2;
	}
	public void setAns2(String ans2) {
		this.ans2 = ans2;
	}
	public String getAns3() {
		return ans3;
	}

	public void setAns3(String ans3) {
		this.ans3 = ans3;
	}


	@Override
	public String toString() {
		return "RegistrationDto [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", dob="
				+ dob + ", gender=" + gender + ", contactNo=" + contactNo + ", email=" + email + ", password="
				+ password + ", ans1=" + ans1 + ", ans2=" + ans2 + ", ans3=" + ans3 + "]";
	}
	
	
	

}
