package com.akog02.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akog02.domain.User;
import com.akog02.repostories.IUserRepository;

@Service
@Transactional
public class UserServicesImpl implements IUserServies {

	@Autowired
	IUserRepository userrepo;
	
	@Override
	public Iterable<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userrepo.findAll();
	}

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return userrepo.findById(id).orElse(null);
	}

	@Override
	public User saveUser(User entity) {
		// TODO Auto-generated method stub
		return userrepo.save(entity);
	}

	@Override
	public void deleteUserById(Long id) {
		// TODO Auto-generated method stub
       userrepo.deleteById(id);
	}

}
