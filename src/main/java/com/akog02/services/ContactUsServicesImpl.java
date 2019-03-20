package com.akog02.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akog02.domain.ContactUs;
import com.akog02.repostories.IContactUsRepository;
@Service
@Transactional
public class ContactUsServicesImpl implements IContactUsServices {

	@Autowired
	private IContactUsRepository repo;
	
	@Override
	public Iterable<ContactUs> getAllContactus() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public boolean Save(ContactUs c) {
		// TODO Auto-generated method stub
		try {
			repo.save(c);
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean DeleteById(Integer Id) {
		// TODO Auto-generated method stub
				try {
					repo.deleteById(Id);
					return true;
				}catch(Exception e) {
					return false;
				}
				
	}

	@Override
	public Optional<ContactUs> SelectById(Integer Id) {
		// TODO Auto-generated method stub
		return repo.findById(Id);
	}

	

}
