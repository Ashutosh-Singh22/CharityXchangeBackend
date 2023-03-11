package com.DonationBackend.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.springframework.lang.Nullable;

@Entity
public class Volunteer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int volunteerId;
	private String volunteerName;
	private int volunteerAge;
	private String volunteerPhone;
	@Nullable
	private String volunteerAlternatePhone;
	@NotBlank
	@Column(unique=true)
	private String volunteerEmail;
	private String volunteerPassword;
	private String volunteerZipCode;
	
	public int getVolunteerId() {
		return volunteerId;
	}
	public void setVolunteerId(int volunteerId) {
		this.volunteerId = volunteerId;
	}
	public String getVolunteerName() {
		return volunteerName;
	}
	public void setVolunteerName(String volunteerName) {
		this.volunteerName = volunteerName;
	}
	public int getVolunteerAge() {
		return volunteerAge;
	}
	public void setVolunteerAge(int volunteerAge) {
		this.volunteerAge = volunteerAge;
	}
	public String getVolunteerPhone() {
		return volunteerPhone;
	}
	public void setVolunteerPhone(String volunteerPhone) {
		this.volunteerPhone = volunteerPhone;
	}
	public String getVolunteerAlternatePhone() {
		return volunteerAlternatePhone;
	}
	public void setVolunteerAlternatePhone(String volunteerAlternatePhone) {
		this.volunteerAlternatePhone = volunteerAlternatePhone;
	}
	public String getVolunteerEmail() {
		return volunteerEmail;
	}
	public void setVolunteerEmail(String volunteerEmail) {
		this.volunteerEmail = volunteerEmail;
	}
	public String getVolunteerPassword() {
		return volunteerPassword;
	}
	public void setVolunteerPassword(String volunteerPassword) {
		this.volunteerPassword = volunteerPassword;
	}
	public String getVolunteerZipCode() {
		return volunteerZipCode;
	}
	public void setVolunteerZipCode(String volunteerZipCode) {
		this.volunteerZipCode = volunteerZipCode;
	}
}
