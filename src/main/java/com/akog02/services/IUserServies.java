package com.akog02.services;

import com.akog02.domain.User;

public interface IUserServies {
	 Iterable<User> getAllUsers();
	 User getUserById(Long id);
	 User saveUser(User entity);
	 void deleteUserById(Long id);
}
