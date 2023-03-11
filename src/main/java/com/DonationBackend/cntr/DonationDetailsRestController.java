package com.DonationBackend.cntr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.DonationBackend.model.DonationDetails;
import com.DonationBackend.model.Donor;
import com.DonationBackend.model.Volunteer;
import com.DonationBackend.service.DonationDetailsService;
import com.DonationBackend.service.DonorService;
import com.DonationBackend.service.VolunteerService;

@RestController
@CrossOrigin
public class DonationDetailsRestController {

	@Autowired
	private DonationDetailsService donationDetailsService;
	
	@Autowired
	private DonorService donorService;
	
	@Autowired
	private VolunteerService volunteerService;
	
//	@Autowired
//	private RecipientService recipientService;
	
	//adding donor donations
	@PostMapping(value= {"/donationDetailsAdd"})
	public String donorDonationAdd(@RequestBody DonationDetails donationDetails) {
		
		//System.out.println(donationDetails.getDonor().getDonorId());
		Donor donor = donorService.getById(donationDetails.getDonor().getDonorId());
		
		if(donor!=null) {
			
			donationDetails.setDonor(donor);
			
			donationDetailsService.add(donationDetails);
			return "added success";
		}
		return "some issue occured";
	}
	
	//updating donor-donation-table for volunteers & recipients
	@PostMapping(value= {"/donationDetailsUpdate"})
	public void updateDonorDonation(@RequestBody DonationDetails donationDetails) {

		donationDetailsService.update(donationDetails);
	}
	
	//getting donation list for the logged in user
	@GetMapping(value = {"/donationDetailsOrderByDonor/{donorId}"})
	public List<DonationDetails> orderDetailsListbyDonorEmail(@PathVariable int donorId){

		Donor donor = donorService.getById(donorId);
		
		if(donor!=null)
			return donationDetailsService.getByDonor(donor);
		
		return null;
	}
	
	//getting donation list for the logged in Volunteer
	@GetMapping(value = {"/donationDetailsOrderByVolunteer/{volunteerId}"})
	public List<DonationDetails> orderDetailsListbyVolunteerEmail(@PathVariable int volunteerId){

		Volunteer volunteer = volunteerService.getById(volunteerId);
		
		if(volunteer!=null)
			return donationDetailsService.getByVolunteer(volunteer);
		
		return null;
	}
	
	//not required this method
	//getting donation list for the logged in Recipient
//		@GetMapping(value = {"/donationDetailsOrderByRecipient"})
//		public List<DonationDetails> orderDetailsListbyRecipientEmail(){
//
//			Recipient recipient = recipientService.getById(1);
//			
//			if(recipient!=null)
//				return donationDetailsService.getByRecipient(recipient);
//			
//			return null;
//		}
	
	//getting all donations list which are not assigned any volunteers
	@GetMapping(value = {"/donationsForNotAssignedVolunteers"})
	public List<DonationDetails> listOfDonationsForNotAssignedVolunteers(){

		return donationDetailsService.getNotAssignedDonations();
	}
	
	//getting all donations list which are assigned volunteers
	@GetMapping(value = {"/donationsForAssignedVolunteers"})
	public List<DonationDetails> listOfDonationsForAssignedVolunteers(){

		return donationDetailsService.getAssignedDonations();
	}
	
	//details on basis of ToBeCollected
	@GetMapping(value = {"/donationToBeCollected/{volunteerId}"})
	public List<DonationDetails> findByDonationToBeCollected(@PathVariable int volunteerId){
		Volunteer volunteer = volunteerService.getById(volunteerId);
		return donationDetailsService.getByDonationToBeCollected(volunteer);
	}
	
	//details on basis of IsCollected
	@GetMapping(value = {"/donationIsCollected/{volunteerId}"})
	public List<DonationDetails> findByDonationIsCollected(@PathVariable int volunteerId){
		Volunteer volunteer = volunteerService.getById(volunteerId);
		return donationDetailsService.getByDonationIsCollected(volunteer);
	}
	
}
