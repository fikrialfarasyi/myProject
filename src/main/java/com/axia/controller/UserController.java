package com.axia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axia.model.User;
import com.axia.service.UserService;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	public UserService userService;

	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmail();

		if (tempEmailId != null && !"".equals(tempEmailId)) {
			User userObj = userService.fetchUserbyEmail(tempEmailId);

			if (userObj != null) {
				throw new Exception("User with " + tempEmailId + " is already exist");
			}
		}

		User result = userService.addUser(user);

		return result;
	}
	
	@PostMapping("/login")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmail = user.getEmail();
		String tempPass = user.getPassword();
		User userObj = null;
		
		if (tempEmail != null && tempPass != null) {
			userObj = userService.fetchUserByEmailAndPassword(tempEmail, tempPass);		
		}
		
		if(userObj == null) {
			throw new Exception("Bad Credentials");
		}
		
		return userObj;
	}

}
