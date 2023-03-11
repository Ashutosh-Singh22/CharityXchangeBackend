package com.DonationBackend.service;

import com.DonationBackend.model.Admin;

public interface AdminService {
	
	public Admin  getById(String adminEmail);
}
