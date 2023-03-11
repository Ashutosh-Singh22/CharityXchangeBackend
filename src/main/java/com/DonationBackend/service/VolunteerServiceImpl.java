
package com.DonationBackend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DonationBackend.dao.*;
import com.DonationBackend.model.*;

@Service
public class VolunteerServiceImpl implements VolunteerService{

	@Autowired
	VolunteerDao volunteerDao;
	
	@Override
	public void add(Volunteer volunteer) {
		
		volunteer.setVolunteerPassword(hashPassword(volunteer.getVolunteerPassword()));
		volunteerDao.save(volunteer);	
	}
	
	// encrypt the password
	static private String hashPassword(String plainTextPassword){
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}
	
	@Override
	public List<Volunteer> getAll() {
		Iterable<Volunteer> itr = volunteerDao.findAll();
		List<Volunteer> lst = new ArrayList<Volunteer>();
		itr.forEach(ele->lst.add(ele));
		return lst;
	}

	@Override
	public Volunteer getById(int volunteerId) {
		Optional<Volunteer> opt = volunteerDao.findById(volunteerId);
		if(opt.isPresent()) {
			return opt.get();
		}
			
		return null;
	}

	@Override
	public Volunteer getByEmail(String volunteerEmail) {
		// TODO Auto-generated method stub
		Volunteer obj=volunteerDao.selectByVolunteerEmail(volunteerEmail);
		if(obj != null) {
			return obj;
		}
		return null;
	}
}
