package com.DonationBackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DonationBackend.dao.DonationDetailsDao;
import com.DonationBackend.model.DonationDetails;
import com.DonationBackend.model.Donor;
import com.DonationBackend.model.Volunteer;

@Service
public class DonationDetailsServiceImpl implements DonationDetailsService{

	@Autowired
	DonationDetailsDao donationDetailsDao;
	
	@Override
	public void add(DonationDetails donorDetails) {
		// TODO Auto-generated method stub
		donationDetailsDao.save(donorDetails);
	}
	
	@Override
	public void update(DonationDetails donorDetails) {
		// TODO Auto-generated method stub
		donationDetailsDao.save(donorDetails);
	}

	@Override
	public List<DonationDetails> getByDonor(Donor donor) {
		// TODO Auto-generated method stub
		Iterable<DonationDetails> itr = donationDetailsDao.selectByDonor(donor);
		List<DonationDetails> lst = new ArrayList<DonationDetails>();
		itr.forEach(ele -> lst.add(ele));
		return lst;
	}

	@Override
	public List<DonationDetails> getByVolunteer(Volunteer volunteer) {
		Iterable<DonationDetails> itr = donationDetailsDao.selectByVolunteer(volunteer);
		List<DonationDetails> lst = new ArrayList<DonationDetails>();
		itr.forEach(ele -> lst.add(ele));
		return lst;
	}
	
	//not required
	//@Override
//	public List<DonationDetails> getByRecipient(Recipient recipient) {
//		Iterable<DonationDetails> itr = donationDetailsDao.selectByRecipient(recipient);
//		List<DonationDetails> lst = new ArrayList<DonationDetails>();
//		itr.forEach(ele -> lst.add(ele));
//		return lst;
//	}
	
	@Override
	public List<DonationDetails> getNotAssignedDonations() {
		// TODO Auto-generated method stub
		Iterable<DonationDetails> itr = donationDetailsDao.selectNotAssignedDonations();
		List<DonationDetails> lst = new ArrayList<DonationDetails>();
		itr.forEach(ele -> lst.add(ele));
		return lst;
	}

	@Override
	public List<DonationDetails> getAssignedDonations() {
		Iterable<DonationDetails> itr = donationDetailsDao.selectAssignedDonations();
		List<DonationDetails> lst = new ArrayList<DonationDetails>();
		itr.forEach(ele -> lst.add(ele));
		return lst;
	}
	
	@Override
	public List<DonationDetails> getByDonationToBeCollected(Volunteer volunteer) {
		Iterable<DonationDetails> itr = donationDetailsDao.selectByDonationToBeCollected(volunteer);
		List<DonationDetails> lst = new ArrayList<DonationDetails>();
		itr.forEach(ele -> lst.add(ele));
		return lst;
	}

	@Override
	public List<DonationDetails> getByDonationIsCollected(Volunteer volunteer) {
		Iterable<DonationDetails> itr = donationDetailsDao.selectByDonationIsCollected(volunteer);
		List<DonationDetails> lst = new ArrayList<DonationDetails>();
		itr.forEach(ele -> lst.add(ele));
		return lst;
	}
}
