package com.DonationBackend.cntr;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.DonationBackend.model.DonationDetails;
import com.DonationBackend.model.Recipient;
import com.DonationBackend.service.RecipientService;

@RestController
@CrossOrigin
public class RecipientRestController {
	
	@Autowired
	private RecipientService recipientService;
	
	@PostMapping("/recipientRegister")
	public void reciepientPost(@RequestBody Recipient recipient) {
		System.out.println("recipientRegister");
		System.out.println(recipient);
		recipientService.add(recipient);
	}	
	
	//update the kyc status to true
	@PostMapping(value = {"/recipientApproval"})
	public void recipientKYCApproval(@RequestBody Recipient recipient) {
		
//		Recipient updateRecp = recipientService.getById(recipient.getRecipientId());
//		
//		System.out.println(updateRecp);
//		
//		updateRecp.setKYCVerified(recipient.isKYCVerified());
//		
//		System.out.println(updateRecp);
		
		recipientService.update(recipient);
	}
	
	//get single recipient based on login
	@GetMapping(value= {"/getRecipient/{recipientId}"})
	public Recipient recipientDetails(@PathVariable int recipientId){
		
		return recipientService.getById(recipientId);
	} 
	
	//get all recipients who have isKycVerified as false
	@GetMapping(value= {"/selectUnverifiedRecipients"})
	public List<Recipient> listOfUnverifiedRecipients(){
		
		return recipientService.getUnapprovedRecipients();
	} 
	
	//get all recipients who have isKycVerified as true
	@GetMapping(value= {"/selectVerifiedRecipients"})
	public List<Recipient> listOfVerifiedRecipients(){
		
		List<Recipient> list = recipientService.getApprovedRecipients();
		
		Collections.sort(list);
		
		return list;
	}
	
	@PostMapping(value = {"/updateDemands"})
	public void recipientUpdateDemands(@RequestBody Recipient recipient) {
		
		System.out.println(recipient);
		
		Recipient updateRecp = recipientService.getById(recipient.getRecipientId());	
		
		updateRecp.setRawFoodQuantityRequired(updateRecp.getRawFoodQuantityRequired() + recipient.getRawFoodQuantityRequired());
		updateRecp.setClothesQuantityRequired(updateRecp.getClothesQuantityRequired() + recipient.getClothesQuantityRequired());
		updateRecp.setStationaryQuantityRequired(updateRecp.getStationaryQuantityRequired()+ recipient.getStationaryQuantityRequired());
		
		System.out.println(updateRecp);
		
		recipientService.update(updateRecp);
	}
	
	//updateRecipientRecievedDonationDetails
	@PostMapping(value = {"/updateRecipientRecievedDonationDetails"})
	public void recipientUpdateDemands(@RequestBody DonationDetails donationDetails) {
		
		System.out.println(donationDetails);
		
		Recipient updateRecp  = donationDetails.getRecipient();	
		Recipient oldRecipient=recipientService.getById(updateRecp.getRecipientId());
		int updatedRawFood=updateRecp.getRawFoodQuantityRequired() + oldRecipient.getRawFoodQuantityReceived();
		updateRecp.setRawFoodQuantityReceived(updatedRawFood);
		updateRecp.setClothesQuantityReceived(updateRecp.getClothesQuantityRequired() + oldRecipient.getClothesQuantityReceived());
		updateRecp.setStationaryQuantityReceived(updateRecp.getStationaryQuantityRequired()+ oldRecipient.getStationaryQuantityReceived());
		
		System.out.println(updateRecp);
		
		recipientService.update(updateRecp);
	}
	
	//get all recipients 
	@GetMapping(value= {"/selectAllRecipients"})
	public List<Recipient> listOfAllRecipients(){
		
		return recipientService.getAll();
	} 
	
}
