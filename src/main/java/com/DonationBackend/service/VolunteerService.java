package com.DonationBackend.service;

import java.util.List;

import com.DonationBackend.model.*;

public interface VolunteerService {
	
	Volunteer getById(int volunteerId);
	void add(Volunteer volunteer);
	List<Volunteer> getAll();
	Volunteer getByEmail(String volunteerEmail);
}
