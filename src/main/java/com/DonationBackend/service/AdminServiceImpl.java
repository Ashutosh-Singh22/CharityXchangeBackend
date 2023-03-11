package com.DonationBackend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DonationBackend.dao.AdminDao;
import com.DonationBackend.model.Admin;
import com.DonationBackend.model.Donor;
import com.DonationBackend.model.Recipient;
import com.DonationBackend.model.Volunteer;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao adminDao; 
	
//	@Autowired
//	private Donor donorDao; 
//	
//	@Autowired
//	private Recipient recipientDao; 
//	
//	@Autowired
//	private Volunteer volunteerDao; 
	
	@Override
	public Admin getById(String adminEmail) {
		
		Optional<Admin> opt = adminDao.findById(adminEmail);
		if(opt.isPresent())
			return opt.get();
		else
			return null;
	}
	
	
//	//all the below code is for email id for uniqueness across all tables
//	
//	//admin table check for registering email
//	public boolean adminCheckForEmail(String email) {
//		
//		Optional<Admin> admin = adminDao.findById(email);
//		if (admin.isPresent())
//			return true;
//		else
//			return false;
//	}
//	
//	//donor table check for registering email
//	public boolean donorCheckForEmail(String email) {
//		
//		Donor donor = donorDao.selectByDonorEmail(email);
//		if (donor != null)
//			return true;
//		else
//			return false;
//	}
//	
//	//recipient table check for registering email
//	public boolean recipientCheckForEmail(String email) {
//		
//		Recipient recipient = recipientDao.getByEmail(email);
//		if (recipient != null)
//			return true;
//		else
//			return false;
//	}
//	
//	//volunteer table check for registering email
//	public boolean volunteerCheckForEmail(String email) {
//		
//		Volunteer volunteer = volunteerDao.getByEmail(email);
//		if (volunteer != null)
//			return true;
//		else
//			return false;
//	}
	
}
