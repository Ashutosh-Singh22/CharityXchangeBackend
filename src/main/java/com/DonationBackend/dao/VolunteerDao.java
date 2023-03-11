package com.DonationBackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.DonationBackend.model.*;

@Repository
public interface VolunteerDao extends JpaRepository<Volunteer, Integer> {
	@Query(value="select v from Volunteer v where v.volunteerEmail = :volunteerEmail")
	public Volunteer selectByVolunteerEmail(@Param(value = "volunteerEmail") String volunteerEmail);
}
