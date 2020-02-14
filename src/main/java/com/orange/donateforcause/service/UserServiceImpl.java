package com.orange.donateforcause.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orange.donateforcause.controller.UserController;
import com.orange.donateforcause.dto.LoginDto;
import com.orange.donateforcause.dto.LoginResponseDto;
import com.orange.donateforcause.repository.UserRepository;

/**
 * @author Shankar
 * 
 *         This class used to check login weather the user is patient or doctor
 * 
 */

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserRepository userRepository;

	@Override
	public LoginResponseDto usersLogin(LoginDto userDto) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
