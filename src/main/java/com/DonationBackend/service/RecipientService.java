package com.DonationBackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.DonationBackend.model.Recipient;

@Service
public interface RecipientService {
	
	Recipient getById(int recipientId);
	Recipient getByEmail(String rEmail);
	void add(Recipient recipient);
	void update(Recipient recipient);
	List<Recipient> getUnapprovedRecipients();
	List<Recipient> getApprovedRecipients();
	List<Recipient> getAll();
}
