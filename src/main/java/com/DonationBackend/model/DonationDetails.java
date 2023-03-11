package com.DonationBackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;

@Entity
public class DonationDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int donationId;
	@ManyToOne
	@JoinColumn(name = "donorId")
	private Donor donor;
	private int rawFoodQuantity;
	private int clothesQuantity;
	private int stationaryQuantity;
	
	@ManyToOne
	@JoinColumn(name = "volunteerId")
	private Volunteer volunteer;
	
	@ManyToOne
	@JoinColumn(name = "recipientId")
	private Recipient recipient;
	
	@ColumnDefault("'toBeCollected'")
	private String donationStatus;
	
	public int getDonationId() {
		return donationId;
	}
	public void setDonationId(int donationId) {
		this.donationId = donationId;
	}
	public Donor getDonor() {
		return donor;
	}
	public void setDonor(Donor donor) {
		this.donor = donor;
	}
	public int getRawFoodQuantity() {
		return rawFoodQuantity;
	}
	public void setRawFoodQuantity(int rawFoodQuantity) {
		this.rawFoodQuantity = rawFoodQuantity;
	}
	public int getClothesQuantity() {
		return clothesQuantity;
	}
	public void setClothesQuantity(int clothesQuantity) {
		this.clothesQuantity = clothesQuantity;
	}
	public int getStationaryQuantity() {
		return stationaryQuantity;
	}
	public void setStationaryQuantity(int stationaryQuantity) {
		this.stationaryQuantity = stationaryQuantity;
	}
	public Volunteer getVolunteer() {
		return volunteer;
	}
	public void setVolunteer(Volunteer volunteer) {
		this.volunteer = volunteer;
	}
	public Recipient getRecipient() {
		return recipient;
	}
	public void setRecipient(Recipient recipient) {
		this.recipient = recipient;
	}
	public String getDonationStatus() {
		return donationStatus;
	}
	public void setDonationStatus(String donationStatus) {
		this.donationStatus = donationStatus;
	}
	
}
