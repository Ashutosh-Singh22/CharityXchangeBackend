package com.DonationBackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.DonationBackend.model.Donor;

@Repository
public interface DonorDao extends JpaRepository<Donor, Integer> {
	
	@Query(value = "select d from Donor d where d.donorEmail = :donorEmail")
	public Donor selectByDonorEmail(@Param(value = "donorEmail") String donorEmail);
}
