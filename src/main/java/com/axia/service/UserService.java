package com.axia.service;

import com.axia.model.User;

public interface UserService {

	User addUser(User user);

	User fetchUserbyEmail(String tempEmailId);
	
	User fetchUserByEmailAndPassword(String email, String password);

}
