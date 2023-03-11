package com.DonationBackend.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.DonationBackend.model.Admin;

@Repository
public interface AdminDao extends CrudRepository<Admin, String>{
	
}
