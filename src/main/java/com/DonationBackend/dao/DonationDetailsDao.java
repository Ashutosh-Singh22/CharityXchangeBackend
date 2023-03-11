package com.DonationBackend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.DonationBackend.model.DonationDetails;
import com.DonationBackend.model.Donor;
import com.DonationBackend.model.Volunteer;

@Repository
public interface DonationDetailsDao extends JpaRepository<DonationDetails, Integer>{

	@Query(value = "select p from DonationDetails p where p.donor = :donor")
	public List<DonationDetails> selectByDonor(@Param(value = "donor") Donor donor);
	
	@Query(value = "select p from DonationDetails p where p.volunteer = :volunteer")
	public List<DonationDetails> selectByVolunteer(@Param(value = "volunteer") Volunteer volunteer);
	
//	//not needed thiis method
//	@Query(value = "select p from DonationDetails p where p.recipient = :recipient")
//	public List<DonationDetails> selectByRecipient(@Param(value = "recipient") Recipient recipient);
	
	@Query(value = "select p from DonationDetails p where p.volunteer is NULL")
	public List<DonationDetails> selectNotAssignedDonations();
	
	@Query(value = "select p from DonationDetails p where p.volunteer is NOT NULL")
	public List<DonationDetails> selectAssignedDonations();
	
	
	@Query(value = "select p from DonationDetails p where p.volunteer = :volunteer and  p.donationStatus = 'toBeCollected'")
	public List<DonationDetails> selectByDonationToBeCollected(@Param(value = "volunteer") Volunteer volunteer);
	
	@Query(value = "select p from DonationDetails p where p.volunteer = :volunteer and  p.donationStatus = 'isCollected'")
	public List<DonationDetails> selectByDonationIsCollected(@Param(value = "volunteer") Volunteer volunteer);
	
}
