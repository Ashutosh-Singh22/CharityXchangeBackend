package com.DonationBackend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.DonationBackend.model.Recipient;

@Repository
public interface RecipientDao extends JpaRepository<Recipient, Integer> {
	
	@Query(value = "select p from Recipient p where p.recipientEmail = :recipientEmail")
	public Recipient selectByEmail(@Param(value = "recipientEmail") String recipientEmail);
	
	@Query(value = "select p from Recipient p where isKYCVerified = false")
	public List<Recipient> selectUnapprovedRecipients();	
	
	@Query(value = "select p from Recipient p where isKYCVerified = true")
	public List<Recipient> selectApprovedRecipients();	
	
}
