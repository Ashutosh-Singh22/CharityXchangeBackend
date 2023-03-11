package com.DonationBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Recipient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int recipientId;
	@NotBlank
	@Column(unique=true)
	private String recipientEmail;
	private String recipientName;
	private String recipientPhone;
	private String recipientPassword;
	private String recipientRegistrationId;
	private boolean isKYCVerified;
	private String recipientAddress;
	private String recipientZipCode;
	
	private int rawFoodQuantityRequired;
	private int rawFoodQuantityReceived;
	private int clothesQuantityRequired;
	private int clothesQuantityReceived;
	private int stationaryQuantityRequired;
	private int stationaryQuantityReceived;
	
	public int getRecipientId() {
		return recipientId;
	}
	public void setRecipientId(int recipientId) {
		this.recipientId = recipientId;
	}
	public String getRecipientEmail() {
		return recipientEmail;
	}
	public void setRecipientEmail(String recipientEmail) {
		this.recipientEmail = recipientEmail;
	}
	public String getRecipientName() {
		return recipientName;
	}
	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}
	public String getRecipientPhone() {
		return recipientPhone;
	}
	public void setRecipientPhone(String recipientPhone) {
		this.recipientPhone = recipientPhone;
	}
	public String getRecipientPassword() {
		return recipientPassword;
	}
	public void setRecipientPassword(String recipientPassword) {
		this.recipientPassword = recipientPassword;
	}
	public String getRecipientRegistrationId() {
		return recipientRegistrationId;
	}
	public void setRecipientRegistrationId(String recipientRegistrationId) {
		this.recipientRegistrationId = recipientRegistrationId;
	}
	public boolean isKYCVerified() {
		return isKYCVerified;
	}
	public void setKYCVerified(boolean isKYCVerified) {
		this.isKYCVerified = isKYCVerified;
	}
	public String getRecipientAddress() {
		return recipientAddress;
	}
	public void setRecipientAddress(String recipientAddress) {
		this.recipientAddress = recipientAddress;
	}
	public String getRecipientZipCode() {
		return recipientZipCode;
	}
	public void setRecipientZipCode(String recipientZipCode) {
		this.recipientZipCode = recipientZipCode;
	}
	public int getRawFoodQuantityRequired() {
		return rawFoodQuantityRequired;
	}
	public void setRawFoodQuantityRequired(int rawFoodQuantityRequired) {
		this.rawFoodQuantityRequired = rawFoodQuantityRequired;
	}
	public int getRawFoodQuantityReceived() {
		return rawFoodQuantityReceived;
	}
	public void setRawFoodQuantityReceived(int rawFoodQuantityReceived) {
		this.rawFoodQuantityReceived = rawFoodQuantityReceived;
	}
	public int getClothesQuantityRequired() {
		return clothesQuantityRequired;
	}
	public void setClothesQuantityRequired(int clothesQuantityRequired) {
		this.clothesQuantityRequired = clothesQuantityRequired;
	}
	public int getClothesQuantityReceived() {
		return clothesQuantityReceived;
	}
	public void setClothesQuantityReceived(int clothesQuantityReceived) {
		this.clothesQuantityReceived = clothesQuantityReceived;
	}
	public int getStationaryQuantityRequired() {
		return stationaryQuantityRequired;
	}
	public void setStationaryQuantityRequired(int stationaryQuantityRequired) {
		this.stationaryQuantityRequired = stationaryQuantityRequired;
	}
	public int getStationaryQuantityReceived() {
		return stationaryQuantityReceived;
	}
	public void setStationaryQuantityReceived(int stationaryQuantityReceived) {
		this.stationaryQuantityReceived = stationaryQuantityReceived;
	}
	@Override
	public String toString() {
		return "Recipient [recipientId=" + recipientId + ", recipientEmail=" + recipientEmail + ", recipientName="
				+ recipientName + ", recipientPhone=" + recipientPhone + ", recipientPassword=" + recipientPassword
				+ ", recipientRegistrationId=" + recipientRegistrationId + ", isKYCVerified=" + isKYCVerified
				+ ", recipientAddress=" + recipientAddress + ", recipientZipCode=" + recipientZipCode
				+ ", rawFoodQuantityRequired=" + rawFoodQuantityRequired + ", rawFoodQuantityReceived="
				+ rawFoodQuantityReceived + ", clothesQuantityRequired=" + clothesQuantityRequired
				+ ", clothesQuantityReceived=" + clothesQuantityReceived + ", stationaryQuantityRequired="
				+ stationaryQuantityRequired + ", stationaryQuantityReceived=" + stationaryQuantityReceived + "]";
	}
}
