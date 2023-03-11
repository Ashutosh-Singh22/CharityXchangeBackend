package com.DonationBackend.service;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DonationBackend.dao.DonorDao;
import com.DonationBackend.model.Donor;

@Service
public class DonorServiceImpl implements DonorService {
		
		@Autowired
		DonorDao donorDao;

		@Override
		public void add(Donor donor) {
			donor.setDonorPassword(hashPassword(donor.getDonorPassword()));
			donorDao.save(donor);
		}
		
		//to encrypt password
		private String hashPassword(String plainTextPassword){
			return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
		}
		
		@Override
		public void update(Donor donor) {
			
			donorDao.save(donor);
		}
		
		@Override
		public Donor getByEmail(String donorEmail) {
			Donor obj=donorDao.selectByDonorEmail(donorEmail);
			if(obj != null) {
				return obj;
			}
			return null;
		}
		
		@Override
		public Donor getById(int donorId) {
			Optional<Donor> opt = donorDao.findById(donorId);
			if(opt.isPresent()) {
				return opt.get();
			}
				
			return null;
		}

}
