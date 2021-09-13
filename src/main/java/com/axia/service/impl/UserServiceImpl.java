package com.axia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axia.model.User;
import com.axia.repository.UserRepository;
import com.axia.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	public UserRepository userRepository;

	@Override
	public User addUser(User user) {

		try {
			User result = userRepository.save(user);
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			
			return null;
		}
		
	}

	@Override
	public User fetchUserbyEmail(String tempEmailId) {
		return userRepository.findByEmail(tempEmailId);
	}

	@Override
	public User fetchUserByEmailAndPassword(String email, String password) {

		return userRepository.findByEmailAndPassword(email, password);
	}

}
