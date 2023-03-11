package com.DonationBackend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.DonationBackend.dao.RecipientDao;
import com.DonationBackend.model.Recipient;

@Service
public class RecipientServiceImpl implements RecipientService{

	@Autowired
	RecipientDao recipientDao;
	
	@Override
	public Recipient getById(int recipientId) {
		// TODO Auto-generated method stub
		Optional<Recipient> opt = recipientDao.findById(recipientId);
		if(opt.isPresent()) {
			return opt.get();
		}
			
		return null;
	}
	
	@Override
	public void add(Recipient recipient) {
		
		recipient.setRecipientPassword(hashPassword(recipient.getRecipientPassword()));
		recipientDao.save(recipient);
	}
	
	//to encrypt the password
	static private String hashPassword(String plainTextPassword){
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}
	
	@Override
	public void update(Recipient recipient) {
		
		recipientDao.save(recipient);
	}
	
	@Override
	public Recipient getByEmail(String rEmail) {
		Recipient rec = recipientDao.selectByEmail(rEmail);
		if(rec != null)
		{
			return rec;
		}
		return null;
	}

	@Override
	public List<Recipient> getUnapprovedRecipients() {
		// TODO Auto-generated method stub
		Iterable<Recipient> itr = recipientDao.selectUnapprovedRecipients();
		List<Recipient> lst = new ArrayList<Recipient>();
		itr.forEach(ele -> lst.add(ele));
		return lst;
	}
	
	@Override
	public List<Recipient> getApprovedRecipients() {
		// TODO Auto-generated method stub
		Iterable<Recipient> itr = recipientDao.selectApprovedRecipients();
		List<Recipient> lst = new ArrayList<Recipient>();
		itr.forEach(ele -> lst.add(ele));
		return lst;
	}

	@Override
	public List<Recipient> getAll() {
		Iterable<Recipient> itr = recipientDao.findAll();
		List<Recipient> lst = new ArrayList<Recipient>();
		itr.forEach(ele->lst.add(ele));
		return lst;
	}
	
}
