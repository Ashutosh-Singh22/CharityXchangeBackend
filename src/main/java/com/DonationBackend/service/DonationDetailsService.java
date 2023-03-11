package com.DonationBackend.service;

import java.util.List;

import com.DonationBackend.model.DonationDetails;
import com.DonationBackend.model.Donor;
import com.DonationBackend.model.Volunteer;

public interface DonationDetailsService {
	
	public void add(DonationDetails donorDetails);
	public void update(DonationDetails donorDetails);
	public List<DonationDetails> getByDonor(Donor donor);
	public List<DonationDetails> getByVolunteer(Volunteer volunteer);
	//not required 
	//public List<DonationDetails> getByRecipient(Recipient recipient);
	public List<DonationDetails> getNotAssignedDonations();
	public List<DonationDetails> getAssignedDonations();
	public List<DonationDetails> getByDonationToBeCollected(Volunteer volunteer);
	public List<DonationDetails> getByDonationIsCollected(Volunteer volunteer);
}
