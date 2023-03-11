package com.DonationBackend.service;

import com.DonationBackend.model.Donor;


public interface DonorService {

	void add(Donor donor);
	void update(Donor donor);
	Donor getByEmail(String donorEmail);
	Donor getById(int donorId);
	
}
